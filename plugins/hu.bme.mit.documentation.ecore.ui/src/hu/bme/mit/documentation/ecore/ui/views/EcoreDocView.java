package hu.bme.mit.documentation.ecore.ui.views;

import hu.bme.mit.documentation.ecore.ui.internal.Activator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import ecoredocgen.incquery.ECoreDocumentationMatch;
import ecoredocgen.incquery.ECoreDocumentationMatcher;

public class EcoreDocView extends ViewPart {

	private Text text;
	private ENamedElement currentElement;
	private EAnnotation currentAnnotation;
	
	private void clearCurrentState() {
		text.setText("");
		currentElement=null;
		currentAnnotation=null;
		//text.setEnabled(false); // not a good idea as this disables mouse listeners
		text.setBackground(JFaceColors.getErrorBackground(Display.getCurrent()));
	}
	
	private void setCurrentState(String textContents, ENamedElement currE, EAnnotation currA) {
		//text.setEnabled(true); // not a good idea as this disables mouse listeners
		text.setText(textContents);
		this.currentElement = currE;
		this.currentAnnotation = currA;
		text.setBackground(JFaceColors.getBannerBackground(Display.getCurrent()));
	}
	
	private void updateStateAccordingToSelection(ISelection sel) {
		// clear current status
		clearCurrentState();
		if (sel instanceof IStructuredSelection) {
			Object _target = ((IStructuredSelection) sel).getFirstElement();
			if (_target instanceof ENamedElement) {
				ENamedElement target = (ENamedElement) _target;
				try {
					currentElement = target;
					IncQueryEngine engine = IncQueryEngine.on(target.eResource());
					ECoreDocumentationMatcher matcher = ECoreDocumentationMatcher.on(engine);
					for (ECoreDocumentationMatch m :matcher.getAllMatches(target, null, null)) {
						setCurrentState(m.getDoc(), m.getHost(), m.getAnn());
					}
				} catch (IncQueryException e) {
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
				}
			}
		}
	}
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		site.getWorkbenchWindow().getSelectionService().addSelectionListener(new ISelectionListener() {
			@Override
			public void selectionChanged(IWorkbenchPart part, ISelection sel) {
				updateStateAccordingToSelection(sel);
			}
		});
	}
	
	@Override
	public void createPartControl(Composite parent) {
		text = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.WRAP);
		text.setFont(JFaceResources.getTextFont());
				
		text.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (currentElement!=null && currentAnnotation!=null) {
					if (!currentAnnotation.getDetails().get("documentation").equals(text.getText())) {
						updateDocContentsInModel();
					}
				}
			}
			@Override
			public void keyPressed(KeyEvent e) { }
		});
		text.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				if (currentElement!=null && currentAnnotation==null) {
					// the element doesn't yet have a documentation annotation
					// so let's create one
					setCurrentState(newDocumentation, currentElement, createNewDocFieldInModel());
				}
			}
			
			@Override
			public void mouseDown(MouseEvent e) {}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {}
		});
	}
	
	@Override
	public void setFocus() { }

	//////////// model manipulation ///////////////
	
	// TODO these operations should be done through a TransactionalEditingDomain command
	// in order to trigger the dirty flag in the host editor
	
	private void updateDocContentsInModel() {
		currentAnnotation.getDetails().put("documentation", text.getText());
	}
	
	private static String newDocumentation = "Please write some documentation here.";
	
	private EAnnotation createNewDocFieldInModel() {
		EAnnotation newAnn = EcoreFactory.eINSTANCE.createEAnnotation();
		newAnn.setSource("http://www.eclipse.org/emf/2002/GenModel");
		newAnn.getDetails().put("documentation", ""); // create intentionally as empty, so that actual model contents are not cluttered
		currentElement.getEAnnotations().add(newAnn);
		return newAnn;
	}
}

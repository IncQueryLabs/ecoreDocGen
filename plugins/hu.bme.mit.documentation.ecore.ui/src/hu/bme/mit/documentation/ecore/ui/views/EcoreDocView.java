package hu.bme.mit.documentation.ecore.ui.views;

import hu.bme.mit.documentation.ecore.ui.internal.Activator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
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

	Text text;
	ENamedElement currentElement;
	EAnnotation currentAnnotation;
	
	private void clearCurrentState() {
		text.setText("");
		currentElement=null;
		currentAnnotation=null;
		text.setEnabled(false);
		text.setBackground(JFaceColors.getErrorBackground(Display.getCurrent()));
	}
	
	private void setCurrentState(ECoreDocumentationMatch m) {
		text.setEnabled(true);
		text.setText(m.getDoc());
		this.currentElement = m.getHost();
		this.currentAnnotation = m.getAnn();
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
						setCurrentState(m);
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
				if (currentAnnotation!=null) {
					if (!currentAnnotation.getDetails().get("documentation").equals(text.getText())) {
						currentAnnotation.getDetails().put("documentation", text.getText());
						// TODO this should be done through a TransactionalEditingDomain command
						// in order to trigger the dirty flag in the host editor
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		// TODO add support for the case when the element doesn't yet have a documentation annotation
		// which is probably indicated by the condition (currentElement: notNull AND currentAnnotation: null)
	}

	@Override
	public void setFocus() {
		updateStateAccordingToSelection(getSite().getWorkbenchWindow().getSelectionService().getSelection());
	}

}

package hu.bme.mit.documentation.ecore.ui.views;

import hu.bme.mit.documentation.ecore.ui.internal.Activator;

import java.util.EventObject;
import java.util.concurrent.Callable;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
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
	private ISelectionListener selectionListener;
	
	private void clearCurrentState() {
		text.setText("");
		currentElement=null;
		currentAnnotation=null;
		text.setEnabled(false); // not a good idea as this disables mouse listeners
		text.setBackground(JFaceColors.getErrorBackground(Display.getCurrent()));
	}
	
	private void setCurrentState(String textContents, ENamedElement currE, EAnnotation currA) {
		text.setEnabled(true); // not a good idea as this disables mouse listeners
		text.setText(textContents);
		this.currentElement = currE;
		this.currentAnnotation = currA;
		text.setBackground(JFaceColors.getBannerBackground(Display.getCurrent()));
	}
	
	private void updateStateAccordingToSelection(ISelection sel) {
		// clear current status
		clearCurrentState();
		setCurrentState(sel);
	}

	private void setCurrentState(ISelection sel) {
		if (sel instanceof IStructuredSelection) {
			Object _target = ((IStructuredSelection) sel).getFirstElement();
			if (_target instanceof ENamedElement) {
				ENamedElement target = (ENamedElement) _target;
				try {
					currentElement = target;
					text.setEnabled(true); // make sure the text can be used for adding a new doc field
					// through the mouse listener below
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
	
	private IEditingDomainProvider editingDomainProvider;
	
	/**
	 * Our custom command stack listener that listens to undo-redo operations and updates the view's
	 * state accordingly.
	 */
	private CommandStackListener commandStackListener = new CommandStackListener() {
		
		@Override
		public void commandStackChanged(EventObject event) {
			setCurrentState(getSite().getWorkbenchWindow().getSelectionService().getSelection());
		}
	};
	
	private void setEditingDomainProvider(IWorkbenchPart part) {
		
		removeCommandStackListener();
		
		if (part instanceof IEditingDomainProvider) {
			this.editingDomainProvider =(IEditingDomainProvider)part; 
			// also register command stack listener
			this.editingDomainProvider.getEditingDomain().getCommandStack().addCommandStackListener(commandStackListener);
		} else {
			this.editingDomainProvider = null;
		}
	}

	private void removeCommandStackListener() {
		if (this.editingDomainProvider!=null) {
			// de-register command stack listener
			this.editingDomainProvider.getEditingDomain().getCommandStack().removeCommandStackListener(commandStackListener);
		}
	}
	
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		this.selectionListener = new ISelectionListener() {

			@Override
			public void selectionChanged(IWorkbenchPart part, ISelection sel) {
				setEditingDomainProvider(part);
				updateStateAccordingToSelection(sel);
			}
		};
		site.getWorkbenchWindow().getSelectionService().addSelectionListener(selectionListener);
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
	
	private void updateDocContentsInModel() {
		Callable<Object> c = new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				currentAnnotation.getDetails().put("documentation", text.getText());
				return null;
			}
		};
		executeAsCommand(c,currentAnnotation);
	}
	
	private static String newDocumentation = "Please write some documentation here.";
	
	private EAnnotation createNewDocFieldInModel() {
		Callable<EAnnotation> c = new Callable<EAnnotation>() {

			@Override
			public EAnnotation call() throws Exception {
				EAnnotation newAnn = EcoreFactory.eINSTANCE.createEAnnotation();
				newAnn.setSource("http://www.eclipse.org/emf/2002/GenModel");
				newAnn.getDetails().put("documentation", ""); // create intentionally as empty, so that actual model contents are not cluttered
				currentElement.getEAnnotations().add(newAnn);
				return newAnn;
			}
		};
		return executeAsCommand(c,currentElement);
	}
	
	@Override
	public void dispose() {
		removeCommandStackListener();
		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(selectionListener);
		this.currentAnnotation=null;
		this.currentElement=null;
		super.dispose();
	}
	
	/**
	 * Run the given {@link Callable} as a special {@link ChangeCommand}. 
	 * @param r
	 * @return
	 */
	private <T> T executeAsCommand(final Callable<T> callable,Notifier n){
		if(this.editingDomainProvider!=null && currentElement!=null){
			EditingDomain ed = this.editingDomainProvider.getEditingDomain();
			ChangeCommandWithResult<T> rc = new ChangeCommandWithResult<T>(callable,currentElement.eResource());
			ed.getCommandStack().execute(rc);
			return rc.getReturnValue();
		}
		return null;
	}
	

	
}

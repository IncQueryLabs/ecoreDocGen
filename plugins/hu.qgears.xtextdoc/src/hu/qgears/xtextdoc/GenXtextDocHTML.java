package hu.qgears.xtextdoc;

import hu.qgears.commons.UtilFile;

import java.io.InputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;

/**
 * Eclipse entry point for generating HTML documentation of Xtext grammar.
 * 
 * @author rizsi
 *
 */
public class GenXtextDocHTML extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (selection instanceof IStructuredSelection) {

			for (Object element : ((IStructuredSelection) selection).toList()) {
				if (element instanceof IFile) {
					IFile file = (IFile) element;
					if (file.getFileExtension().equals("xtext")) {
						try {
							SynchronizedXtextResourceSet set = new SynchronizedXtextResourceSet();
							URI uri = URI.createPlatformResourceURI(
									"" + file.getFullPath(), true);
							set.getResource(uri, true);
							GeneratorContext gc = new GeneratorContext(set,
									file);
							gc.src = loadSource(gc, file);
							try {
								new XtextDocumentationGenerator(gc).generate();
							} finally {
								if (gc.errors.size() > 0) {
									for (Throwable e : gc.errors) {
										Activator
												.getDefault()
												.getLog()
												.log(new Status(
														Status.ERROR,
														Activator.PLUGIN_ID,
														"Xtext to HTML documentation error",
														e));
									}
									Status status = new Status(IStatus.ERROR,
											Activator.PLUGIN_ID,
											"Xtext to HTML documentation converter error. See Log View for details!");
									ErrorDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "Xtext to HTML error",
											status.getMessage(), status);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							Status s=new Status(
									Status.ERROR,
									Activator.PLUGIN_ID,
									"Xtext to HTML documentation error",
									e);
							Activator
									.getDefault()
									.getLog()
									.log(s);
							ErrorDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "Xtext to HTML error",
									s.getMessage(), s);
						}
					}
				}
			}
		}
		return null;
	}

	private String loadSource(GeneratorContext gc, IFile file) {
		String src = "";
		try {
			InputStream is = file.getContents();
			try {
				src = UtilFile.loadAsString(is);
			} finally {
				is.close();
			}
		} catch (Exception e) {
			gc.addError(e);
		}
		return src;
	}
}

package hu.qgears.xtextdoc;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

import hu.qgears.xtextdoc.util.UtilDoc;

/**
 * This class is for adding own documentations to mouse hover and content assist.
 * 
 * Bind with Abstract[LanguageName]UiModule.bindIEObjectDocumentationProviderr().
 * 
 * @author glaseradam
 *
 */
public class MyEObjectDocumentationProvider implements IEObjectDocumentationProvider {

	@Override
	public String getDocumentation(EObject o) {
		if (o instanceof EStructuralFeature || o instanceof EClass) {
			return UtilDoc.getEMFDocumentation(o);
		}
		EClass eClass = o.eClass();
		return UtilDoc.getCommentDocumentation(o)+"<br/><br/>" + eClass.getName() + ": " +UtilDoc.getEMFDocumentation(eClass);
	}

}

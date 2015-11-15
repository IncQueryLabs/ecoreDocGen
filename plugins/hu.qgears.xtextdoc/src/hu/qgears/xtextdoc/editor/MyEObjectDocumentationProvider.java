package hu.qgears.xtextdoc.editor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

import hu.qgears.xtextdoc.util.UtilDoc;

/**
 * This class is for adding own documentations to mouse hover and content assist.
 * 
 * Bind with [LanguageName]UiModule.bindIEObjectDocumentationProvider().
 * 
 * @author glaseradam
 *
 */
public class MyEObjectDocumentationProvider implements IEObjectDocumentationProvider {

	@Override
	public String getDocumentation(EObject o) {
		if (o instanceof EObjectWrapper) {
			EObjectWrapper eObjectWrapper = (EObjectWrapper) o;
			EClass eClass = eObjectWrapper.geteClass();
			EStructuralFeature eFeature = eObjectWrapper.geteFeature();
			EClass geteClassFeatureType = eObjectWrapper.geteClassFeatureType();
			StringBuilder sb = new StringBuilder();
			UtilDoc.getEMFDocumentation(sb, eClass, eFeature, geteClassFeatureType);
			return sb.toString();
			
		} 
		StringBuilder sb = new StringBuilder();
		EClass eClass = o.eClass();
		sb.append(UtilDoc.getCommentDocumentation(o));
		UtilDoc.getEMFDocumentation(sb, eClass, null, null);
		return sb.toString();
	}

}

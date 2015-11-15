package hu.qgears.documentation;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xcore.resource.XcoreResource;

/**
 * Utility class for reading {@link DocumentationField} from a model element using reflection.
 * @author Adam
 *
 */
public class DocumentationFieldUtils {

	public static final String GEN_MODEL_PACKAGE_NS_URI = "http://www.eclipse.org/emf/2002/GenModel";

	/**
	 * Gets a value stored in the genmodel annotation.
	 * 
	 * @param eModelElement
	 * @param key
	 * @return
	 */
	public static String getAnnotation(EModelElement eModelElement, String key) {
		EAnnotation eAnnotation = eModelElement.getEAnnotation(GEN_MODEL_PACKAGE_NS_URI);
		return eAnnotation == null ? null : (String) eAnnotation.getDetails().get(key);
	}

	/**
	 * Gets the existing documentation fields from the class named 'Documentation' in package 'doc'.
	 * @param eModelElement
	 * @return
	 */
	public static List<DocumentationField> getDocumentationFields(EModelElement eModelElement) {
		List<DocumentationField> list = new ArrayList<>();	

		EObject container = eModelElement;
		while (container.eContainer() != null) {
			container = container.eContainer();
		}
		try {
			String annotation = DocumentationFieldUtils.getAnnotation((EModelElement) container, "docPath");
			if (annotation != null) {
				URI uri = URI.createPlatformResourceURI("" + annotation, true);
				ResourceSet set = new ResourceSetImpl();
				Resource resource = set.createResource(uri);
				resource.load(null);
				EcoreUtil.resolveAll(resource);
				if (resource instanceof XcoreResource) {
					uri = resource.getURI();
					List<String> segmentsList = uri.segmentsList();
					String s = segmentsList.get(segmentsList.size()-1);
					if (s.equals("Documentation.xcore")) {
						EList<EObject> contents = resource.getContents();
						for (EObject content : contents) {
							if (content instanceof EPackage) {
								EPackage ePackage = (EPackage) content;
								EClassifier eClassifier = ePackage.getEClassifier("Documentation");
								if (eClassifier != null) {
									if (eClassifier instanceof EClass) {
										EClass eClass = (EClass) eClassifier;
										EList<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
										for (EStructuralFeature f : eStructuralFeatures) {
											String name = f.getName();
											String type = f.getEType().getInstanceClassName();
											String annotationValue = getAnnotation(eModelElement, name);
											DocumentationField docField = new DocumentationField(name, type, annotationValue);
											list.add(docField);
										}
									}
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

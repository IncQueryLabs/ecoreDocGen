package hu.qgears.documentation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xcore.XAttribute;
import org.eclipse.emf.ecore.xcore.XClassifier;
import org.eclipse.emf.ecore.xcore.XGenericType;
import org.eclipse.emf.ecore.xcore.XPackage;
import org.eclipse.emf.ecore.xcore.resource.XcoreResource;

/**
 * Utility class for reading all {@link DocumentationField} from a model element.
 * 
 * @author glaseradam
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
	 * Gets the existing documentation fields for the element from the class
	 * named 'Documentation' in package 'doc' in the xcore model
	 * 'Documentation.xcore'.
	 * 
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
				if (resource instanceof XcoreResource) {
					uri = resource.getURI();
					List<String> segmentsList = uri.segmentsList();
					String s = segmentsList.get(segmentsList.size() - 1);
					if (s.equals("Documentation.xcore")) {
						EList<EObject> contents = resource.getContents();
						for (EObject content : contents) {
							if (content instanceof XPackage) {
								XPackage xPackage = (XPackage) content;
								if (xPackage.getName().equals("doc")) {
									for (XClassifier xClassifier : xPackage.getClassifiers()) {
										if (xClassifier.getName().equals("Documentation")) {
											for (EObject eObject : xClassifier.eContents()) {
												if (eObject instanceof XAttribute) {
													XAttribute xAttribute = (XAttribute) eObject;
													String name = xAttribute.getName();
													String type = "";
													XGenericType xGenericType = xAttribute.getType();
													GenBase genBase = xGenericType.getType();
													if (genBase instanceof BasicEObjectImpl) {
														BasicEObjectImpl basicEObjectImpl = (BasicEObjectImpl) genBase;
														URI eProxyURI = basicEObjectImpl.eProxyURI();
														String fragment = eProxyURI.fragment();
														String[] splits = fragment.split("/");
														if (splits.length > 1) {
															type = splits[splits.length - 1];
														}
													}
													String annotationValue = getAnnotation(eModelElement, name);
													DocumentationField docField = new DocumentationField(name, type,
															annotationValue);
													list.add(docField);
												}
											}
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

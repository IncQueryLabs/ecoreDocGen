package hu.qgears.documentation;

import java.beans.Introspector;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;

import doc.Documentation;
import doc.impl.DocFactoryImpl;


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
	 * Gets the existing documentation fields. For each field a getter method is generated that starts with "is" or "get". 
	 * The name and type of the field is read from this method signature.
	 * 
	 * @param eModelElement
	 * @return
	 */
	public static List<DocumentationField> getDocumentationFields(EModelElement eModelElement) {
		List<DocumentationField> list = new ArrayList<>();		
		Documentation doc = DocFactoryImpl.eINSTANCE.createDocumentation();
		Class<?> cls = doc.getClass();
		Class<?>[] interfaces = cls.getInterfaces();
		for (Class<?> interf : interfaces) {
			if (interf.getName().equals("doc.Documentation")) {
				Method[] declaredMethods = interf.getDeclaredMethods();
				for (Method method : declaredMethods) {
					if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
						String key = null;
						if (method.getName().startsWith("get")) {
							key = Introspector.decapitalize(method.getName().replaceFirst("get", ""));
						} else if (method.getName().startsWith("is")) {
							key = Introspector.decapitalize(method.getName().replaceFirst("is", ""));
						}
						Class<?> type = method.getReturnType();
						String annotationValue = getAnnotation(eModelElement, key);
						DocumentationField docField = new DocumentationField(key, type, annotationValue);
						list.add(docField);
					}
				}
			}
		}
		return list;
	}

}

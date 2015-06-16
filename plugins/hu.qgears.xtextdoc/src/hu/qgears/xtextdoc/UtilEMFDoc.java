package hu.qgears.xtextdoc;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;

/**
 * Helper class for reading documentation annotations from an ecore model.
 * @author rizsi
 *
 */
public class UtilEMFDoc {
	/**
	 * Get the documentation field of an element.
	 * @param element
	 * @return null in case there is no documentation annotation in the model
	 */
	public static final String getDocumentation(GeneratorContext gc, EModelElement element)
	{
		return findAnnotation(gc, element, "http://www.eclipse.org/emf/2002/GenModel", "documentation");
	}

	private static String findAnnotation(GeneratorContext gc, EModelElement element, String source,
			String key) {
		try {
			for(EAnnotation ea: element.getEAnnotations())
			{
				if(source.equals(ea.getSource()))
				{
					if(ea.getDetails()!=null)
					{
						String ret=ea.getDetails().get(key);
						if(ret!=null)
						{
							return ret;
						}
					}
				}
			}
		} catch (Exception e) {
			gc.addError(e);
		}
		return null;
	}
}

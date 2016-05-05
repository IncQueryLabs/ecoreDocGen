package hu.qgears.xtextdoc.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

/**
 * This class is for adding mouse hover for keywords.
 * 
 * Bind with [LanguageName]UiModule.bindIEObjectHoverProvider().
 * 
 * @author glaseradam
 *
 */
public class MyEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Override
	protected String getHoverInfoAsHtml(EObject o) {
		if (!hasHover(o))
			return null;
		StringBuffer buffer = new StringBuffer();
		if (o instanceof EObjectWrapper) { 
			String documentation = getDocumentation(o);
			if (documentation!=null && documentation.length()>0) {
				buffer.append(documentation);
			}
		} else {
			buffer.append (getFirstLine(o));
			String documentation = getDocumentation(o);
			if (documentation!=null && documentation.length()>0) {
				buffer.append("<p>");
				buffer.append(documentation);
				buffer.append("</p>");
			}
		}
		return buffer.toString();
	}

}

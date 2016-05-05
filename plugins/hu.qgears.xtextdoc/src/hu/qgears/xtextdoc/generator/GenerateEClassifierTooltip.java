package hu.qgears.xtextdoc.generator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.util.EcoreUtil;

import hu.qgears.xtextdoc.util.UtilComma;

/**
 * Generate the contents of the tooltip box for an EMF class.
 * @author rizsi
 *
 */
public class GenerateEClassifierTooltip extends AbstractHTMLTemplate
{
	private EClassifier cla;
	public GenerateEClassifierTooltip(GeneratorContext gc, EClassifier cla) {
		super(gc);
		this.cla=cla;
	}

	@Override
	protected void doGenerate() throws Exception {
		UtilComma separator=new UtilComma("<hr/>Supertype: ");
		for(EClassifier cla: getAllSuperClasses(cla))
		{
			rtcout.write(separator.getSeparator());
			rtout.write("<a href=#" + cla.getEPackage().getNsPrefix() + cla.getName() + ">");
			writeHtml(cla.getName());
			rtout.write("</a>\n<br/><br/>\n");
			writeHtml(handleMissing(EcoreUtil.getDocumentation(cla)));
			rtout.write("<br/>\n");
		}
	}
}

package hu.qgears.xtextdoc;

import hu.qgears.commons.UtilComma;

import org.eclipse.emf.ecore.EClassifier;

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
		for(EClassifier type: getAllSuperClasses(cla))
		{
			rtcout.write(separator.getSeparator());
			writeHtml(type.getName());
			rtout.write("\n<br/>\n");
			writeHtml(handleMissing(UtilEMFDoc.getDocumentation(gc, type)));
			rtout.write("<br/>\n");
		}
	}
}

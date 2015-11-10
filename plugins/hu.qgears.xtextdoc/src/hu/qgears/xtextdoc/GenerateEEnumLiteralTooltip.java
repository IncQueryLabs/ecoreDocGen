package hu.qgears.xtextdoc;

import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * Generates the contents of the tooltip box for an EMF enum literal.
 * 
 * @author glaseradam
 */
public class GenerateEEnumLiteralTooltip extends AbstractHTMLTemplate {

	private EEnumLiteral eEnumLiteral;

	public GenerateEEnumLiteralTooltip(GeneratorContext gc, EEnumLiteral eEnumLiteral) {
		super(gc);
		this.eEnumLiteral = eEnumLiteral;
	}

	@Override
	protected void doGenerate() throws Exception {
		writeHtml(eEnumLiteral.getName());
		rtout.write("\n<br/><br/>\n");
		writeHtml(handleMissing(UtilEMFDoc.getDocumentation(gc, eEnumLiteral)));
		rtout.write("<br/>\n");
	}

}

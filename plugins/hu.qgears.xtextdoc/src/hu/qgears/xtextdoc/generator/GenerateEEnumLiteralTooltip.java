package hu.qgears.xtextdoc.generator;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
		
		EEnum eEnum = eEnumLiteral.getEEnum();
		rtout.write("<a href=#" + eEnum.getEPackage().getNsPrefix() + eEnum.getName() + ">");
		writeHtml(eEnumLiteral.getName());
		rtout.write("</a>\n<br/><br/>\n");
		writeHtml(handleMissing(EcoreUtil.getDocumentation(eEnumLiteral)));
		rtout.write("<br/>\n");
	}

}

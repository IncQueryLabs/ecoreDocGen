package hu.qgears.xtextdoc.generator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Generates the contents of the tooltip box for an EMF enum.
 * 
 * @author glaseradam
 */
public class GenerateEEnumTooltip extends AbstractHTMLTemplate {
	
	private EClassifier cla;

	public GenerateEEnumTooltip(GeneratorContext gc, EClassifier cla) {
		super(gc);
		this.cla = cla;
	}

	@Override
	protected void doGenerate() throws Exception {
		rtout.write("<a href=#" + cla.getEPackage().getNsPrefix() + cla.getName() + ">");
		writeHtml(cla.getName());
		rtout.write("</a>\n<br/><br/>\n");
		writeHtml(handleMissing(EcoreUtil.getDocumentation(cla)));
		rtout.write("<br/>\n");
		EEnum eEnum = (EEnum) cla;
		for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {
			rtcout.write("<hr/>Literal: ");
			rtout.write("<a href=#" + eEnum.getEPackage().getNsPrefix() + eEnum.getName() + ">");
			writeHtml(eEnumLiteral.getName());
			rtout.write("</a>");
			if (eEnumLiteral.equals(eEnum.getDefaultValue())) {
				rtout.write(" (default)");
			}
			rtout.write("\n<br/><br/>\n");
			writeHtml(handleMissing(EcoreUtil.getDocumentation(eEnumLiteral)));
			rtout.write("<br/>\n");
		}
	}

}

package hu.qgears.xtextdoc;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

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
		writeHtml(cla.getName());
		rtout.write("\n<br/><br/>\n");
		writeHtml(handleMissing(UtilEMFDoc.getDocumentation(gc, cla)));
		rtout.write("<br/>\n");
		EEnum eEnum = (EEnum) cla;
		for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {
			rtcout.write("<hr/>Literal: ");
			writeHtml(eEnumLiteral.getName());
			rtout.write("\n<br/><br/>\n");
			writeHtml(handleMissing(UtilEMFDoc.getDocumentation(gc, eEnumLiteral)));
			rtout.write("<br/>\n");
		}
	}

}

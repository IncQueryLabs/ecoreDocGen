package hu.bme.mit.documentation.ecore.ui.handlers;

import hu.bme.mit.documentation.generator.ecore.EPackageDocGenHtml;
import hu.bme.mit.documentation.generator.ecore.IDocGenerator;

/**
 * 
 * Generates HTML documentation from the supplied .ecore file. 
 * 
 * @author adam
 *
 */
public class GenerateEcoreDocHTML extends AbstractGenerateEcoreDoc {
	@Override
	protected IDocGenerator getCodeGenerator() {
		return new EPackageDocGenHtml();
	}

    @Override
    protected String getFileExtension() {
        return "html";
    }
}

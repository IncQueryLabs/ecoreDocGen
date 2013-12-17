package hu.bme.mit.documentation.ecore.ui.handlers;

import hu.bme.mit.documentation.generator.ecore.EPackageDocGen;
import hu.bme.mit.documentation.generator.ecore.IDocGenerator;

/**
 * Generates LaTeX documentation from the given .ecore file. 
 * 
 * @author adam
 *
 */
public class GenerateEcoreDocLatex extends AbstractGenerateEcoreDoc {

	@Override
	protected IDocGenerator getCodeGenerator() {
		return new EPackageDocGen();
	}

    @Override
    protected String getFileExtension() {
        return "tex";
    }

}

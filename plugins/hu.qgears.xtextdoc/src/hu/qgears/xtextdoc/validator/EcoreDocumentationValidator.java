package hu.qgears.xtextdoc.validator;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreValidator;

/**
 * Custom subclass of {@link EcoreValidator} for registering further validation
 * rules.
 * 
 * @author agostoni 
 * @author glaseradam - Missing documentation validator
 *
 */
public class EcoreDocumentationValidator extends EcoreValidator {

	public static EcoreDocumentationValidator INSTANCE = new EcoreDocumentationValidator();
	
	private EcoreDocumentationValidator() {
	}
	
	@Override
	public boolean validateEReference(EReference eReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		validateDocumentation(eReference,diagnostics);
		return super.validateEReference(eReference, diagnostics, context);
	}
	
	@Override
	public boolean validateEAttribute(EAttribute eAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		validateDocumentation(eAttribute,diagnostics);
		return super.validateEAttribute(eAttribute, diagnostics, context);
	}
	
	@Override
	public boolean validateEClass(EClass eClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		validateDocumentation(eClass,diagnostics);
		return super.validateEClass(eClass, diagnostics, context);
	}
	
	private void validateDocumentation(EModelElement value, DiagnosticChain diagnostics) {
		String documentation = EcoreUtil.getDocumentation( value);
		if (documentation == null) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, -1, "Missing documentation",
					new Object[] { value }));
		}
	}

}

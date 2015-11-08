package hu.qgears.xtextdoc.validator;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreValidator;

import hu.qgears.documentation.DocumentationField;
import hu.qgears.documentation.DocumentationFieldUtils;

/**
 * Custom subclass of {@link EcoreValidator} for registering further validation
 * rules.
 * 
 * @author agostoni
 * @author glaseradam - Missing documentation validator/type validator
 *
 */
public class EcoreDocumentationValidator extends EcoreValidator {

	public static EcoreDocumentationValidator INSTANCE = new EcoreDocumentationValidator();

	private EcoreDocumentationValidator() {
	}

	@Override
	public boolean validateEReference(EReference eReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		validateDocumentation(eReference, diagnostics);
		return super.validateEReference(eReference, diagnostics, context);
	}

	@Override
	public boolean validateEAttribute(EAttribute eAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		validateDocumentation(eAttribute, diagnostics);
		return super.validateEAttribute(eAttribute, diagnostics, context);
	}

	@Override
	public boolean validateEClass(EClass eClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		validateDocumentation(eClass, diagnostics);
		return super.validateEClass(eClass, diagnostics, context);
	}

	@Override
	public boolean validateEEnum(EEnum eEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
		validateDocumentation(eEnum, diagnostics);
		return super.validateEEnum(eEnum, diagnostics, context);
	}
	
	@Override
	public boolean validateEDataType(EDataType eDataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		validateDocumentation(eDataType, diagnostics);
		return super.validateEDataType(eDataType, diagnostics, context);
	}
	
	@Override
	public boolean validateEEnumLiteral(EEnumLiteral eEnumLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		validateDocumentation(eEnumLiteral, diagnostics);
		return super.validateEEnumLiteral(eEnumLiteral, diagnostics, context);
	}
	
	private void validateDocumentation(EModelElement value, DiagnosticChain diagnostics) {
		String documentation = EcoreUtil.getDocumentation(value);
		if (documentation == null) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, -1, "Missing documentation",
					new Object[] { value }));
		}
		
		List<DocumentationField> documentationFields = DocumentationFieldUtils.getDocumentationFields(value);
		for (DocumentationField documentationField : documentationFields) {
			String annotationValue = documentationField.getValue();
			String key = documentationField.getKey();
			if (annotationValue == null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, -1,
						String.format("Missing %s", key), new Object[] { value }));
			} else {
				Class<?> type = documentationField.getType();
				validateType(value, diagnostics, key, type, annotationValue);
			}
		}	
	}

	private void validateType(EModelElement value, DiagnosticChain diagnostics, String name, Class<?> type,
			String annotationValue) {
		String typeName = type.getName();
		try {
			switch (typeName) {
			case "int":
				Integer.parseInt(annotationValue);
				break;
			case "long":
				Long.parseLong(annotationValue);
				break;
			case "short":
				Short.parseShort(annotationValue);
				break;
			case "float":
				Float.parseFloat(annotationValue);
				break;
			case "double":
				Double.parseDouble(annotationValue);
				break;
			case "byte":
				Byte.parseByte(annotationValue);
				break;
			case "char":
				if (annotationValue.length() > 1) {
					throw new Exception();
				}
				break;
			case "boolean":
				if (!(annotationValue.equals("true") || annotationValue.equals("false"))) {
					throw new Exception();
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, -1,
					String.format("%s: invalid type, expected is: %s", name, typeName),
					new Object[] { value }));
		}
	}

}

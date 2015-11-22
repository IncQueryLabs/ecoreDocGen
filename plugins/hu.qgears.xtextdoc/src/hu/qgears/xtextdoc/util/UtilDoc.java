package hu.qgears.xtextdoc.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import hu.qgears.documentation.DocumentationField;
import hu.qgears.documentation.DocumentationFieldUtils;

/**
 * Helper class for reading documentation from xtext comments or from EMF
 * gendocs.
 * 
 * @author glaseradam
 *
 */
public class UtilDoc {

	public static final String BR = "<br>";
	public static final String BRBR = "<br><br>";
	public static String ruleName = "ML_COMMENT";
	public static String startTag = "/\\*\\*?";

	/**
	 * Returns the comment above the object in xtext.
	 * 
	 * @param o
	 * @return
	 */
	private static String findComment(EObject o) {
		String returnValue = null;
		ICompositeNode node = NodeModelUtils.getNode(o);
		if (node != null) {
			INode parent = node.getParent();
			ILeafNode last = null;
			for (ILeafNode leaf : parent.getLeafNodes()) {
				int totalOffset = leaf.getTotalOffset();
				int nodeTotalOffset = node.getTotalEndOffset() - node.getLength();
				if (totalOffset >= nodeTotalOffset) {
					break;
				}
				if (leaf.getGrammarElement() instanceof TerminalRule) {
					TerminalRule terminalRule = (TerminalRule) leaf.getGrammarElement();
					String ruleN = terminalRule.getName();
					if (leaf.isHidden() && ruleN.equalsIgnoreCase(ruleName)) {
						last = leaf;
					}
				}
			}
			if (last != null) {
				String comment = last.getText();
				if (comment.matches("(?s)" + startTag + ".*")) {
					returnValue = comment.replace("/*", "").replace("*/", "").replace("*", "");
				}
			}
		}
		return returnValue;
	}

	/**
	 * Reads the comment documentation for the EObject.
	 * 
	 * @param o
	 * @return
	 */
	public static String getCommentDocumentation(EObject o) {
		String doc = findComment(o);
		if (doc == null) {
			doc = "No documentation";
		}
		return doc;
	}

	public static void getEMFDocumentation(StringBuilder sb, EClass eClass, EStructuralFeature eFeature,
			EClass eClassFeatureType) {
		if (eClass != null) {
			if (eFeature == null && eClassFeatureType == null) {
				if (sb.length() > 0) {
					sb.append("<hr>");
				}
				sb.append("Type: ");
				sb.append(eClass.getName());
				sb.append(BRBR);
				sb.append(DocumentationFieldUtils.getAnnotation(eClass, "documentation"));
				for (DocumentationField documentationField : DocumentationFieldUtils.getDocumentationFields(eClass)) {
					if (documentationField.getValue() != null) {
						sb.append(BR);
						sb.append(documentationField.getKey() + ": " + documentationField.getValue());
					}
				}
				for (EClass superEClass : eClass.getESuperTypes()) {
					sb.append("<hr>Supertype: ");
					sb.append(superEClass.getName());
					sb.append(BRBR);
					sb.append(DocumentationFieldUtils.getAnnotation(superEClass, "documentation"));
					for (DocumentationField documentationField : DocumentationFieldUtils.getDocumentationFields(superEClass)) {
						if (documentationField.getValue() != null) {
							sb.append(BR);
							sb.append(documentationField.getKey() + ": " + documentationField.getValue());
						}
					}
				}
			} else {
				sb.append(eClass.getName() + "." + eFeature.getName() + ": ");
				sb.append(DocumentationFieldUtils.getAnnotation(eFeature, "documentation"));
				for (DocumentationField documentationField : DocumentationFieldUtils.getDocumentationFields(eFeature)) {
					if (documentationField.getValue() != null) {
						sb.append(BR);
						sb.append(documentationField.getKey() + ": " + documentationField.getValue());
					}
				}
				if (eFeature instanceof EAttribute) {
					EAttribute eAttribute = (EAttribute) eFeature;
					String typeName = eAttribute.getEAttributeType().getName();
					sb.append("<hr>");
					sb.append("Type: ");
					sb.append(typeName);
					sb.append(BRBR);
					sb.append(getBuiltInTypeDocumentation(eAttribute.getEAttributeType()));
				} else {
					if (eClassFeatureType != null) {
						getEMFDocumentation(sb, eClassFeatureType, null, null);
					}
				}
			}
		}
	}

	private static String getBuiltInTypeDocumentation(EDataType eDataType) {
		StringBuilder sb = new StringBuilder();
		switch (eDataType.getName()) {
		case "EString":
			sb.append("The string data type represents character strings.");
			break;
		case "EInt":
			sb.append(
					"The int data type is a 32-bit signed two's complement integer, which has a minimum value of -2^31 and a maximum value of 2^31-1.");
			break;
		case "EBoolean":
			sb.append("The boolean data type has only two possible values: true and false.");
			break;

		default:
			break;
		}
		Object defaultValue = eDataType.getDefaultValue();
		if (defaultValue != null) {
			sb.append(BRBR);
			sb.append("Default value: " + defaultValue + ".");
		}
		return sb.toString();
	}

}
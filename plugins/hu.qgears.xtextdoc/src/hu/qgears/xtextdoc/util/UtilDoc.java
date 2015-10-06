package hu.qgears.xtextdoc.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * Helper class for reading documentation from xtext comments or from EMF gendocs.
 * @author glaseradam
 *
 */
public class UtilDoc {

	public static final String BREAK = "<br></br>";
	private static String ruleName = "ML_COMMENT";
	private static String startTag = "/\\*\\*?"; 

	/**
	 * Returns the comment above the object in xtext.
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

	public static void getEMFDocumentation(StringBuilder sb, EClass eClass, EStructuralFeature eFeature, EClass eClassFeatureType) {
		if (eClass != null) {
			if (eFeature == null && eClassFeatureType == null) {
				if (sb.length() > 0) {
					sb.append("<hr>");
				}
				sb.append("Type: ");
				sb.append(eClass.getName());
				sb.append(BREAK);
				sb.append(EcoreUtil.getDocumentation(eClass));
				for (EClass superEClass : eClass.getESuperTypes()) {
					sb.append("<hr>Supertype: ");
					sb.append(superEClass.getName());
					sb.append(BREAK);
					sb.append(EcoreUtil.getDocumentation(superEClass));
				}

			} else {
				sb.append(eClass.getName() + "." + eFeature.getName() + ": ");
				sb.append(EcoreUtil.getDocumentation(eFeature));
				sb.append(BREAK);
				if (eFeature instanceof EAttribute) {
					EAttribute eAttribute = (EAttribute) eFeature;
					String typeName = eAttribute.getEAttributeType().getName();
					sb.append("<hr>");
					sb.append("Type: ");
					sb.append(typeName);
					sb.append(BREAK);
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
			sb.append("The int data type is a 32-bit signed two's complement integer, which has a minimum value of -2^31 and a maximum value of 2^31-1.");
			break;
		case "EBoolean":
			sb.append("The boolean data type has only two possible values: true and false.");
			break;
			
		default:
			break;
		}
		Object defaultValue = eDataType.getDefaultValue();
		if (defaultValue != null) {
			sb.append(BREAK);
			sb.append("Default value: " + defaultValue + ".");
		}
		return sb.toString();
	}

}
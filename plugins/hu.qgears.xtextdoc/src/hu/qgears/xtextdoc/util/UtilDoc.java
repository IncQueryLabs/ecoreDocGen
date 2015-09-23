package hu.qgears.xtextdoc.util;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
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

	private static String ruleName = "ML_COMMENT";
	private static String startTag = "/\\*\\*?"; // regular expression

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

	/**
	 * Reads the gendoc documentation for the EObject.
	 * @param o
	 * @return
	 */
	public static String getEMFDocumentation(EObject o) {
		if (o instanceof EModelElement) {
			return EcoreUtil.getDocumentation((EModelElement) o);
		}
		return EcoreUtil.getDocumentation(o.eClass());
	}

}
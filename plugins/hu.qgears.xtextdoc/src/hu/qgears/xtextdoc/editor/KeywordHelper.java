package hu.qgears.xtextdoc.editor;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Helper class to obtain the EObject element of a keyword in xtext.
 * @author glaseradam
 *
 */
public class KeywordHelper {

	/**
	 * Gets the leaf node at the given offset in the resource.
	 * @param resource
	 * @param offset
	 * @return
	 */
	public ILeafNode getLeafNodeAt(XtextResource resource, int offset) {
		IParseResult parseResult = resource.getParseResult();
		ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
		if (leaf != null && leaf.isHidden() && leaf.getOffset() == offset) {
			leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
		}
		return leaf;
	}
	
	/**
	 * Gets the EObject for a leaf - this is needed for getting documentation for a hover.
	 * If the leaf is direct child of a ParserRule it will return that type otherwise it returns
	 * the next Assignment in that subtree. If the returned type is not root element it will be returned 
	 * as a reference of its parent type.
	 * @param leaf
	 * @return
	 */
	public EObject getEObjectAt(ILeafNode leaf) {
		
		if (leaf != null && leaf.getGrammarElement() instanceof Keyword) {

			Keyword keyword = (Keyword) leaf.getGrammarElement();
			EObject semantic = NodeModelUtils.findActualSemanticObjectFor(leaf);

			//if child of a ParserRule
			if (keywordIsType(keyword)) { 
				EObject semanticParent = semantic.eContainer();
				if (semanticParent.eContainer() == null) { 
					//if root element then return the class type

					//return (EObject) semantic.eClass();
					return new EObjectWrapper(semantic.eClass(), null, null);

				} else {	
					//else return the element as a feature of its parent
					EClass parentSemanticElementEClass = semanticParent.eClass();
					for (EStructuralFeature f : parentSemanticElementEClass.getEAllStructuralFeatures()) {
						if (f instanceof EReference) {
							EReference reference = (EReference) f;
							List<EObject> allReferencedObjects = EcoreUtil2.getAllReferencedObjects(semanticParent, reference);
							if (!allReferencedObjects.isEmpty()) {
								for (EObject eObject : allReferencedObjects) {
									if (eObject.equals(semantic)) {
										//return (EObject) f;
										return new EObjectWrapper(parentSemanticElementEClass, f, eObject.eClass());
									}
								}
							}
						}
					}
				}
			}

			//return the next assignment as feature
			Assignment assignment = getNextAssignment(keyword.eContainer());
			if (assignment != null) {
				EStructuralFeature feature = getFeature(assignment, semantic.eClass());
				if (feature != null) {
					//return feature;
					Object object = semantic.eGet(feature);
					if (object instanceof EObject) {
						return new EObjectWrapper(semantic.eClass(), feature, ((EObject) object).eClass());
					} else if (object instanceof EObjectResolvingEList<?>) {
						EObjectResolvingEList<?> eObjectResolvingEList = (EObjectResolvingEList<?>) object;
						EObject eo = (EObject) eObjectResolvingEList.get(0);
						return new EObjectWrapper(semantic.eClass(), feature, eo.eClass());
						
					} else {
						return new EObjectWrapper(semantic.eClass(), feature, feature.getEType().eClass());
					}
				}
			}
		}
		return null;
	}

	/**
	 * If count of steps upward till reaching ParserRule equals or is less than 1 
	 * then it is considered as a type not a reference/attribute.
	 * @param keyword
	 * @return
	 */
	public boolean keywordIsType(Keyword keyword) {
		int count=0; 
		EObject parserRule = keyword.eContainer();
		while (parserRule!=null && !(parserRule instanceof ParserRule)) {
			count++;
			parserRule = parserRule.eContainer();
		}
		return count <= 1;
	}

	public EStructuralFeature getFeature(Assignment assignment) {
		return getFeature(assignment, getEClass(assignment));
	}

	/**
	 * Gets the feature of an assignment which has the feature field only as a string.
	 * @param assignment
	 * @param c
	 * @return
	 */
	public EStructuralFeature getFeature(Assignment assignment, EClass c) {
		String feature = assignment.getFeature();
		List<EStructuralFeature> l = c.getEAllStructuralFeatures();
		for (EStructuralFeature f : l) {
			if (f.getName().equals(feature)) {
				return f;
			}
		}
		return null;
	}

	/**
	 * Finds the ParserRule parent for an element and returns its EClass.
	 * @param element
	 * @return
	 */
	public EClass getEClass(AbstractElement element) {
		EObject parserRule = element;
		while (parserRule != null & !(parserRule instanceof ParserRule)) {
			parserRule = parserRule.eContainer();
		}
		if (parserRule == null) {
			return null;
		}
		ParserRule rule = (ParserRule) parserRule;
		if (rule.getType() != null) {
			EClassifier clif = rule.getType().getClassifier();
			if (clif != null) {
				if (clif instanceof EClass) {
					return (EClass) clif;
				}
			}
		}
		return null;
	}

	/**
	 * Recursive function which finds the next assignment grammar element in the tree  and return its feature.
	 * @param keyword
	 * @param semantic
	 * @return
	 */
	public Assignment getNextAssignment(EObject keyword) {
		if (keyword instanceof Assignment) {
			return (Assignment) keyword;
		} else if (keyword instanceof CompoundElement) {
			CompoundElement compoundElement = (CompoundElement) keyword;
			for (int j=0; j<compoundElement.getElements().size(); j++) {
				EObject sibling = compoundElement.getElements().get(j);
				Assignment ret = getNextAssignment(sibling);
				if (ret != null) {
					return ret;
				}
			}
		}
		return null;
	}
}
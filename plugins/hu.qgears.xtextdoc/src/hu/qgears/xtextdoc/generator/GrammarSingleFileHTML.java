package hu.qgears.xtextdoc.generator;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;

import hu.bme.mit.documentation.generator.ecore.EPackageDocGenHtml;

/**
 * Generates a single HTML file with the following content:
 *  * Xtext grammar source code annotated with links to metamodel and popups with metamodel documentation
 *  * EMF metamodel documentation of the referenced metamodel packages
 * @author rizsi
 *
 */
public class GrammarSingleFileHTML extends AbstractHTMLTemplate
{
	private static final String ECORE_NSURI = "http://www.eclipse.org/emf/2002/Ecore";
	private Grammar g;
	public Set<EPackage> packages=new HashSet<>();
	private TextWithTooltipLinks text;
	public GrammarSingleFileHTML(GeneratorContext gc, Grammar g) {
		super(gc);
		this.g=g;
	}
	@Override
	protected void doGenerate() throws Exception {
		text=new TextWithTooltipLinks(gc.src);
		addTooltipsAndLinks();
		generateOutput();
	}
	private void generateOutput() throws IOException {
		rtout.write("<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"UTF-8\">\n");
		TextWithTooltipLinks.generateCSS(rtout);
		TextWithTooltipLinks.generateScripts(rtout);
		rtout.write("<title>");
		writeHtml(getTitle());
		rtout.write("</title>\n</head>\n<body>\n<h1>");
		writeHtml(getTitle());
		rtout.write("</h1>\n");
		text.generateString(out);
		rtout.write("<hr/>\n");
		generateMetaModel();
		rtout.write("</body>\n</html>\n");
	}
	private void generateMetaModel()
	{
		for(EPackage p:packages)
		{
			EPackageDocGenHtml h=new EPackageDocGenHtml();
			StringBuilder sb=new StringBuilder();
			h.documentEPackage(sb, p, Collections.<String>emptyList(), false);
			rtcout.write(sb.toString());
			System.out.println(""+p);
		}
	}
	private EClassifier currentRule;
	private void addTooltipsAndLinks() throws Exception
	{
		XtextResource xres=(XtextResource)g.eResource();
		IParseResult pr=xres.getParseResult();
		ICompositeNode icn=pr.getRootNode();
		BidiTreeIterable<INode> a=icn.getAsTreeIterable();
		BidiTreeIterator<INode> i=a.iterator();
		while(i.hasNext())
		{
			INode n=i.next();
			EObject semanticElement = n.getSemanticElement();
			if(semanticElement!=null)
			{
				if(semanticElement instanceof ParserRule)
				{
					addTooltipForParserRule(n);
				} 
				else if (semanticElement instanceof EnumRule) 
				{
					addTooltipForEnumRule(n) ;
				}
				else if (semanticElement instanceof EnumLiteralDeclaration) {
					addTooltipForEnumLiteral(n);
				}
				else if (semanticElement instanceof Assignment)
				{
					if(n instanceof LeafNode)
					{
						if(n.getGrammarElement() instanceof RuleCall)
						{
							addTooltipForAssignment(n);
						}
					}
				}			
				else /*if (semanticElement instanceof RuleCall || semanticElement instanceof TypeRef) {*/
					if (n.getGrammarElement() instanceof CrossReference) {
						addToolTipForCrossReference(n);							
					}
				//}
			}
		}
	}
	private void addTooltipForEnumLiteral(INode n) throws Exception {
		if (currentRule != null) {
			EnumLiteralDeclaration eld = (EnumLiteralDeclaration) n.getSemanticElement();
			if(n.getGrammarElement() instanceof RuleCall) {
				text.addDecoration(new DecorationData(n.getOffset(), n.getLength(), 
						getReference(currentRule),
						new GenerateEEnumLiteralTooltip(gc, eld.getEnumLiteral()).generate()));
			}
		}
	}

	private void addTooltipForEnumRule(INode n) throws Exception {
		EnumRule eru = (EnumRule) n.getSemanticElement();
		if (n instanceof LeafNode) {
			if(n.getGrammarElement() instanceof RuleCall) {
				TypeRef tr = eru.getType();
				if (tr != null) {
					EClassifier cla = tr.getClassifier();
					if (cla != null) {
						currentRule=cla;
						EPackage ePackage = cla.getEPackage();
						if(ePackage!=null && !ECORE_NSURI.equals(ePackage.getNsURI()))
						{
							packages.add(ePackage);
							text.addDecoration(new DecorationData(n.getOffset(), n.getLength(), 
									getReference(cla),
									new GenerateEEnumTooltip(gc, cla).generate()));
						}
					}
				}
			}
		}
	}
	private void addToolTipForCrossReference(INode n) throws Exception {
		EObject semanticElement = n.getSemanticElement();
		if (semanticElement instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) semanticElement;
			if (ruleCall.getRule() instanceof ParserRule) {
				ParserRule parserRule = (ParserRule) ruleCall.getRule();
				TypeRef typeRef = parserRule.getType();
				EClassifier cla = typeRef.getClassifier();
				EPackage ePackage = cla.getEPackage();
				if(ePackage!=null && !ECORE_NSURI.equals(ePackage.getNsURI())) {
					text.addDecoration(new DecorationData(n.getOffset(), n.getLength(), 
							getReference(currentRule), 
							new GenerateEClassifierTooltip(gc, cla).generate()));
				}
			} else if (ruleCall.getRule() instanceof EnumRule) {
				EnumRule enumRule = (EnumRule) ruleCall.getRule(); 
				TypeRef typeRef = enumRule.getType();
				EClassifier cla = typeRef.getClassifier();
				text.addDecoration(new DecorationData(n.getOffset(), n.getLength(), 
						getReference(currentRule), 
						new GenerateEEnumTooltip(gc, cla).generate()));
			}
		}
		else if (semanticElement instanceof TypeRef) {
			TypeRef typeRef = (TypeRef) semanticElement;
			EClassifier cla = typeRef.getClassifier();
			EPackage ePackage = cla.getEPackage();
			if(ePackage!=null && !ECORE_NSURI.equals(ePackage.getNsURI())) {
				text.addDecoration(new DecorationData(n.getOffset(), n.getLength(), 
						getReference(currentRule), 
						new GenerateEClassifierTooltip(gc, cla).generate()));
			}
		} 
	}
	private void addTooltipForAssignment(INode n) throws Exception {
		Assignment assignment=(Assignment) n.getSemanticElement();
		String feature=assignment.getFeature();
		if(currentRule!=null)
		{
			text.addDecoration(new DecorationData(n.getOffset(), n.getLength(),
					getReference(currentRule),
					new GenerateEFeatureTooltip(gc, currentRule, feature).generate()));
		}
	}
	private void addTooltipForParserRule(INode n) throws Exception {
		ParserRule pru=(ParserRule) n.getSemanticElement();
		if(n instanceof LeafNode)
		{
			if(n.getGrammarElement() instanceof RuleCall)
			{
				LeafNode ln=(LeafNode) n;
				TypeRef tr=pru.getType();
				if(tr!=null)
				{
					EClassifier cla=tr.getClassifier();
					if(cla!=null)
					{
						currentRule=cla;
						EPackage ePackage = cla.getEPackage();
						if(ePackage!=null && !ECORE_NSURI.equals(ePackage.getNsURI()))
						{
							packages.add(ePackage);
							text.addDecoration(new DecorationData(ln.getOffset(), ln.getLength(), 
									getReference(cla),
									new GenerateEClassifierTooltip(gc, cla).generate()));
						}
					}
				}
			}
		}
	}
	private String getReference(EClassifier cla) {
		if(cla.getEPackage()!=null)
		{
			return "#"+cla.getEPackage().getNsPrefix()+cla.getName();
		}else
		{
			gc.addError(new RuntimeException("EPackage not defined for class: "+cla));
			return "#";
		}
	}
	private String getTitle() {
		return ""+g.getName()+" language documentation";
	}

}

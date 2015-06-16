package hu.qgears.xtextdoc;

import hu.bme.mit.documentation.generator.ecore.EPackageDocGenHtml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Assignment;
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

/**
 * Generates a single HTML file with the following content:
 *  * Xtext grammar source code annotated with links to metamodel and popups with metamodel documentation
 *  * EMF metamodel documentation of the referenced metamodel packages
 * @author rizsi
 *
 */
public class GrammarSingleFileHTML extends AbstractHTMLTemplate
{
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
		rtout.write("<meta charset=\"UTF-8\">\n<html>\n<style>\n");
		TextWithTooltipLinks.generateCSS(rtout);
		rtout.write("</style>\n<title>");
		writeHtml(getTitle());
		rtout.write("</title>\n<body>\n<h1>");
		writeHtml(getTitle());
		rtout.write("</h2>\n");
		text.generateString(out);
		rtout.write("<hr/>\n");
		generateMetaModel();
		rtout.write("</body>\n</html>\n");
	}
	private void generateMetaModel()
	{
		for(EPackage p:packages)
		{
			if("http://www.eclipse.org/emf/2002/Ecore".equals(p.getNsURI()))
			{
				continue;
			}
			EPackageDocGenHtml h=new EPackageDocGenHtml();
			StringBuilder sb=new StringBuilder();
			h.documentEPackage(sb, p, new ArrayList<>(), false);
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
			if(n.getSemanticElement()!=null)
			{
				if(n.getSemanticElement() instanceof ParserRule)
				{
					addTooltipForParserRule(n);
				}else if (n.getSemanticElement() instanceof Assignment)
				{
					if(n instanceof LeafNode)
					{
						if(n.getGrammarElement() instanceof RuleCall)
						{
							addTooltipForAssignment(n);
						}
					}
				}
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
						if(cla.getEPackage()!=null)
						{
							packages.add(cla.getEPackage());
						}
						text.addDecoration(new DecorationData(ln.getOffset(), ln.getLength(), 
								getReference(cla),
								new GenerateEClassifierTooltip(gc, cla).generate()));
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

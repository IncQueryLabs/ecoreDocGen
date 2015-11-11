package hu.qgears.xtextdoc.generator;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Generate the contents of the tooltip box for an EMF feature.
 * @author rizsi
 *
 */
public class GenerateEFeatureTooltip extends AbstractHTMLTemplate
{
	private EClassifier cla;
	private String feature;
	public GenerateEFeatureTooltip(GeneratorContext gc, EClassifier cla, String feature) {
		super(gc);
		this.cla=cla;
		this.feature=""+feature;
	}

	@Override
	protected void doGenerate() throws Exception {
		if(cla instanceof EClass)
		{
			EClass c=(EClass) cla;
			List<EStructuralFeature> l=c.getEAllStructuralFeatures();
			for(EStructuralFeature f: l)
			{
				if(f.getName().equals(feature))
				{
					EClass eContainingClass = f.getEContainingClass();
					rtout.write("\t\t\t<a href=#" + eContainingClass.getEPackage().getNsPrefix() + eContainingClass.getName() + ">");
					writeHtml(f.getName());
					rtout.write("</a>\n\t\t\t<br/><br/>\n\t\t\t");
					writeHtml(handleMissing(EcoreUtil.getDocumentation(f)));
					rtout.write("\n");
				}
			}
		}
	}
	
}

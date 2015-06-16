package hu.qgears.xtextdoc;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

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
					rtout.write("\t\t\t");
					writeHtml(f.getName());
					rtout.write("\n\t\t\t<br/>\n\t\t\t");
					writeHtml(handleMissing(UtilEMFDoc.getDocumentation(gc, f)));
					rtout.write("\n");
				}
			}
		}
	}
}

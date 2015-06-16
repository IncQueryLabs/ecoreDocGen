package hu.qgears.xtextdoc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;

/**
 * Given the input EMF resource find the grammar entry point and 
 * call the single file documentation generator with this input model as parameter.
 * Also saves the generated result into an HTML file.
 * @author rizsi
 *
 */
public class XtextDocumentationGenerator {
	protected GeneratorContext gc;

	public XtextDocumentationGenerator(GeneratorContext gc) {
		super();
		this.gc = gc;
	}

	public void generate() {
		try
		{
			// Copy the list of resources this way iteration of resources will not cause concurrentmodificationexc in case a dependant resource is loaded while iterating
			List<Resource> resources=new ArrayList<Resource>(gc.set.getResources());
			for(Resource res: resources)
			{
				for(EObject e: res.getContents())
				{
					if(e instanceof Grammar)
					{
						Grammar g=(Grammar) e;
						GrammarSingleFileHTML t=new GrammarSingleFileHTML(gc, g);
						gc.saveSingleOutputFile(t.generate());
					}
				}
			}
		}catch(Exception e)
		{
			gc.addError(e);
		}
	}
}

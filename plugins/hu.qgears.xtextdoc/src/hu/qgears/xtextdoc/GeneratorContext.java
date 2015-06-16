package hu.qgears.xtextdoc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.StringInputStream;

/**
 * All input to the generator component aggregated into a single object that is accessible
 * throughout code generation.
 * 
 * @author rizsi
 *
 */
public class GeneratorContext {
	public ResourceSet set;
	public String src;
	private IFile source;
	public List<Throwable> errors=new ArrayList<Throwable>();

	public GeneratorContext(ResourceSet set, IFile source) {
		super();
		this.set = set;
		this.source=source;
	}

	public void addError(Exception e) {
		e.printStackTrace();
		errors.add(e);
	}

	public void saveSingleOutputFile(String generate) throws UnsupportedEncodingException, CoreException {
		IContainer c=source.getParent();
		IFile f=c.getFile(new Path(""+source.getName()+".html"));
		StringInputStream sis=new StringInputStream(generate, "UTF-8");
		if(!f.exists())
		{
			f.create(sis, true, null);
		}else
		{
			f.setContents(sis, true, false, null);
		}
	}	
}

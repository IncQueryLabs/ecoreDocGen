package hu.bme.mit.documentation.generator.ecore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * Utility class for generating documentation.
 * 
 * @author adam
 *
 */
public class UtilDocGenerator extends DocGenUtil {
	/**
	 * Generate documentation for the .ecore or .genmodel file located at modelPath, to the
	 * given output file, using the given filter file, and {@link IDocGenerator}
	 * 
	 * 
	 * @param modelPath
	 * @param outputFile
	 * @param optionFile
	 * @param docGen
	 * @throws IOException 
	 */
	public static void generateDocForModel(URI modelPath, File outputFile, File optionFile, IDocGenerator docGen) throws IOException {
		EObject root = getRootEObject(modelPath);

        if (root != null) {
			try (FileOutputStream fos = new FileOutputStream(outputFile, false)) { 
            	Properties options = getProperties(optionFile);
                List<String> filter = getFilters(options);
                StringBuilder sb = new StringBuilder();
                docGen.generateDocument(sb, root, filter, options);
            	fos.write(sb.toString().getBytes());
            } 
            catch (IOException e) {
                Logger.getLogger(UtilDocGenerator.class).error("Exception occurred when generating genmodel doc",e);
            } 
        }
    }
	
	private static EObject getRootEObject(URI modelPath) throws IOException {
        ResourceSet rs = new ResourceSetImpl();
        rs.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformPluginToPlatformResourceMap());
        Resource resource = rs.getResource(modelPath, true);

        if (resource.getContents() != null && resource.getContents().size() > 0) {
            return resource.getContents().get(0);
        }
        return null;
    }

	private static Properties getProperties(File filterFile) {
		if(filterFile!=null && filterFile.exists()){
			try (InputStream fis = new FileInputStream(filterFile)) { 
				Properties bundle = new Properties();
				bundle.load(fis);
				return bundle; 
			} 
			catch (IOException e) {
				Logger.getLogger(UtilDocGenerator.class).error("Exception occurred when generating genmodel doc",e);
			} 
		}                    

		return null;
	}
	
	private static List<String> getFilters(Properties bundle) {
	    List<String> filter = getOptionValues(bundle != null ? bundle.getProperty("filters") :  null);
	    filter.add("http://www.eclipse.org/emf/2002/Ecore");
	    return filter;
    }
}

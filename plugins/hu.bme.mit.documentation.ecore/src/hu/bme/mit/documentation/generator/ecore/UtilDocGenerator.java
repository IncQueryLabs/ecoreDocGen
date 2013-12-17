package hu.bme.mit.documentation.generator.ecore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.PropertyResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * Utility class for generating documentation.
 * 
 * @author adam
 *
 */
public class UtilDocGenerator {

	/**
	 * Generate documentation for the .ecore file located at ecorePath, to the
	 * given output file, using the given filter file, and {@link IDocGenerator}
	 * 
	 * 
	 * @param ecorePath
	 * @param outputFile
	 * @param filterFile
	 * @param docGen
	 */
	public static void generateDocForEPackage(URI ecorePath, File outputFile, File filterFile, IDocGenerator docGen) {
        ResourceSet rs = new ResourceSetImpl();
        Resource resource = rs.getResource(ecorePath, true);

        if (resource.getContents() != null) {
            if (resource.getContents().size() > 0) {
                StringBuilder sb = new StringBuilder();

                try {
                    ArrayList<String> filter = new ArrayList<String>();
                    if(filterFile!=null && filterFile.exists()){
                        // Reading the configuration file
                        PropertyResourceBundle bundle = null;
                        InputStream fis = new FileInputStream(filterFile);
                        bundle = new PropertyResourceBundle(fis);
                        fis.close();
                        
                        // Additional filters
                        String [] filterArray = bundle.getString("filters").split("\\|");
                        for (int i = 0; i < filterArray.length; i++) {
                            String filterEntry = filterArray[i];
                            if(filterEntry != null && !filterEntry.isEmpty()){
                                filter.add(filterEntry);
                            }
                        }
                    }
                    filter.add("http://www.eclipse.org/emf/2002/Ecore");
                    EPackage pckg = (EPackage) resource.getContents().get(0);
                    new DocGenerationInstance().doGenerateAllSubpackages(docGen,sb,pckg,filter);
                    
                    
                	FileOutputStream fos = new FileOutputStream(outputFile,false);
                	fos.write(sb.toString().getBytes());
                	fos.close();
                } catch (IOException e) {
                    Logger.getLogger(UtilDocGenerator.class).error("Exception occurred when generating ecore doc",e);
                }
            }
        }
    }
	
	
}

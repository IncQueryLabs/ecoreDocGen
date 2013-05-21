package hu.qgears.gendoc.app;

import hu.bme.mit.documentation.generator.ecore.EPackageDocGen;
import hu.bme.mit.documentation.generator.ecore.EPackageDocGenHtml;
import hu.bme.mit.documentation.generator.ecore.IDocGenerator;
import hu.bme.mit.documentation.generator.ecore.UnsupportedTypeException;
import hu.bme.mit.documentation.generator.ecore.UtilDocGenerator;

import java.io.File;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

/**
 * Command-line application for generating documentation.
 * 
 * @author adam
 *
 */
public class GenerateDocApplication implements IApplication {

	private static final String ARG_FORMAT = "format";
	private static final String ARG_FILTER_FILE = "filterFile";
	private static final String ARG_OUTPUT_FILE = "outputFile";
	private static final String ARG_METAMODEL_FILE = "metamodelFile";

	private static IDocGenerator getDocGenerator(String format) throws UnsupportedTypeException{
		if("html".contentEquals(format)){
			return new EPackageDocGenHtml();
		}
		if("latex".contentEquals(format)){
			return new EPackageDocGen();
		}
		throw new UnsupportedTypeException(format);
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		String[] arguments = (String[])context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
		Options opts = new Options();
		
		opts.addOption(ARG_METAMODEL_FILE, true, "Path to the .ecore file that is the source of documentation.");
		opts.addOption(ARG_OUTPUT_FILE,true,"File where the documentation should be generated.");
		opts.addOption(ARG_FORMAT,true,"Documentation format. Currently, html and latex are supported.");
		opts.addOption(ARG_FILTER_FILE,true,"Optional .properties file where filtered packages are described - no anchors are generated for elements in these packages.");

		CommandLineParser parser = new BasicParser();
		CommandLine cli = parser.parse(opts, arguments);
		HelpFormatter hf = new HelpFormatter();
		
		
		if(cli.hasOption(ARG_METAMODEL_FILE) && cli.hasOption(ARG_OUTPUT_FILE) && cli.hasOption(ARG_FORMAT)){
			String metamodelFile = cli.getOptionValue(ARG_METAMODEL_FILE);
			String outputFile = cli.getOptionValue(ARG_OUTPUT_FILE);
			String format = cli.getOptionValue(ARG_FORMAT);
			String filterFile = null;
			if(cli.hasOption(ARG_FILTER_FILE)){
				filterFile = cli.getOptionValue(ARG_FILTER_FILE);
			}
			URI metamodelUri = URI.createFileURI(metamodelFile);
			File output = new File(outputFile);
			IDocGenerator docGen = getDocGenerator(format);
			File filter = null;
			if(filterFile!=null){
				filter = new File(filterFile);
			}
			System.out.println("Generating documentation from "+metamodelUri.toString() + " to "+output.toString()+" in format "+format);
			UtilDocGenerator.generateDocForEPackage(metamodelUri, output, filter, docGen);
			System.out.println("Documentation generation finished without errors.");
		}
		else{
			hf.printHelp("GenerateDocApplication", opts);
			throw new RuntimeException(
					"At least the following argumens must be specified: -format, -outputFile, -metamodelFile");
		}
		return EXIT_OK;
	}

	@Override
	public void stop() {
		
	}

}

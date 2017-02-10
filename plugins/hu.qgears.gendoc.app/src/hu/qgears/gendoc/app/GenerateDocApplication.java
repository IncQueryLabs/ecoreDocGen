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
	private static final String ARG_OPTION_FILE = "optionFile";
	private static final String ARG_OUTPUT_FILE = "outputFile";
	private static final String ARG_METAMODEL_FILE = "metamodelFile";
	private static final String ARG_NO_CONFIG = "noConfig";

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
		
		String options = "\nOptions (All defaults to false or unspecified):\n" +
				"\tincludeGenericTypes= boolean whether to inclue generic information for types\n" +
				"\tincludeSubtypes= boolean whether to inclue a section for subtypes\n" +
				"\tincludeRecursiveSupertypes = boolean whether to recursively look for supertypes\n" +
				"\tincludeUsedPackages= boolean whether to process used packages (when processing genmodel only)\n" +
				"\tfullLatexDocument = boolean whether to create a full Latex document with packages and document tags\n" +
				"\tauthorName = name of the author to insert in Latex document (when producing full Latex document)\n" +
				"\tfilters = list of | separated packages to filter - no anchors are generated for elements in these packages. Supports regex\n" +
				"\tfitleredTypes= list of | separated types (classes) to filter out. Supports regex\n" +
				"\tfitleredSubtypes= list of | separated types (classes) to filter out from subtype section. Supports regex\n" +
				"\tfitleredUsedPackages= list of | separated packages to filter out from used package processin. Supports regex\n" +
				"\tskipOperations = boolean whether to skip the EOperation section\n" +
				"\tshowMissingDoc = boolean whether to show tag when encountering missing documentation\n";
		
		opts.addOption(ARG_METAMODEL_FILE, true, "Path to the .ecore or .genmodel file that is the source of documentation.");
		opts.addOption(ARG_OUTPUT_FILE,true,"File where the documentation should be generated.");
		opts.addOption(ARG_FORMAT,true,"Documentation format. Currently, html and latex are supported.");
		opts.addOption(ARG_OPTION_FILE,true,"Alternate .properties file where various processing options are described. Default is gendoc.config in same folder as metamodel file" + options);
		opts.addOption(ARG_NO_CONFIG,false,"Specify if default config file should be ignored.");

		CommandLineParser parser = new BasicParser();
		CommandLine cli = parser.parse(opts, arguments);
		HelpFormatter hf = new HelpFormatter();
		
		if(cli.hasOption(ARG_METAMODEL_FILE) && cli.hasOption(ARG_OUTPUT_FILE) && cli.hasOption(ARG_FORMAT)){
			File metamodelFile = new File(cli.getOptionValue(ARG_METAMODEL_FILE));
			String metamodelFileName = metamodelFile.getAbsolutePath();
			String outputFile = cli.getOptionValue(ARG_OUTPUT_FILE);
			String format = cli.getOptionValue(ARG_FORMAT);
			File optionFile = null;

			if(cli.hasOption(ARG_OPTION_FILE)){
				String optionFileName = cli.getOptionValue(ARG_OPTION_FILE);
				if(optionFileName!=null){
					optionFile = new File(optionFileName);
				}
			}
			else if (!cli.hasOption(ARG_NO_CONFIG)) {
				File opfile = new File(metamodelFile.getParentFile().getAbsolutePath() + File.separatorChar + "ba.docgen");
	            if (opfile.exists()) {
	            	optionFile = opfile;
	            }
			}
			
			URI metamodelUri = URI.createFileURI(metamodelFileName);
			File output = new File(outputFile);
			IDocGenerator docGen = getDocGenerator(format);
			System.out.println("Generating documentation from "+metamodelUri.toString() + " to "+output.toString()+" in format "+format);
			UtilDocGenerator.generateDocForModel(metamodelUri, output, optionFile, docGen);
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

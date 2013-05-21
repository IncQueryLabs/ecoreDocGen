package hu.bme.mit.documentation.generator.ecore;

/**
 * Exception that is thrown if an unsupported document format is encountered
 * when using the command-line tool to generate documentation.
 * 
 * @author adam
 * 
 */
public class UnsupportedTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7927486612303706772L;

	public UnsupportedTypeException(String type) {
		super("Unsupported document format: "+type+". Supported types are latex and html.");
	}
	
}

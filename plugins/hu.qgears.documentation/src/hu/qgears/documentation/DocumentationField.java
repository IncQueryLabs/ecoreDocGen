package hu.qgears.documentation;

/**
 * Documentation field that can be added in the Documentation.xcore metamodel.
 * @author glaseradam
 *
 */
public class DocumentationField {

	private String key;
	private Class<?> type;
	private String value;
	
	public DocumentationField(String key, Class<?> type, String value) {
		this.key = key;
		this.type = type;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public Class<?> getType() {
		return type;
	}
	
	public String getKey() {
		return key;
	}

}

package hu.qgears.xtextdoc.util;

/**
 * Class that can be used to write a separator when iterating
 * over lists.
 * 
 * Also supports prefix and postfix
 * @author rizsi
 *
 */
public class UtilComma {
	boolean first=true;
	private String pre="";
	private String separator;
	private String post="";
	public UtilComma(String pre, String separator, String post) {
		super();
		this.pre = pre;
		this.separator = separator;
		this.post = post;
	}
	public UtilComma(String separator) {
		super();
		this.separator = separator;
	}
	public String getSeparator()
	{
		if(!first)
		{
			return separator;
		}else
		{
			first=false;
			return pre;
		}
	}
	/**
	 * Returns the post tag or empty string if getSeparator was never called.
	 * @return
	 */
	public String getPost()
	{
		if(!first)
		{
			return post;
		}
		return "";
	}
}

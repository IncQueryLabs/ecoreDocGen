package hu.qgears.xtextdoc.util;

import java.io.StringWriter;

/**
 * Abstract base for rTemplate template files.
 * @author rizsi
 *
 */
abstract public class AbstractTemplate implements ITemplate {
	protected StringWriter out, rtout, rtcout;
	public AbstractTemplate() {
		out=rtout=rtcout=new StringWriter();
	}
	final public String generate() throws Exception
	{
		doGenerate();
		return out.toString();
	}
	abstract  protected void doGenerate() throws Exception;
	@Override
	public StringWriter getWriter() {
		return out;
	}
}

package hu.bme.mit.documentation.generator.ecore;

import java.io.IOException;

import org.tautua.markdownpapers.HtmlEmitter;
import org.tautua.markdownpapers.ast.Emphasis;
import org.tautua.markdownpapers.util.Utils;

/**
 * Subclass off {@link HtmlEmitter}, containing a fix of an escaping issue (if
 * emphasized HTML content is printed).
 * 
 * @author agostoni
 *
 */
public class FixedHtmlEmitter extends HtmlEmitter{

	private Appendable buffer2;

	public FixedHtmlEmitter(Appendable buffer) {
		super(buffer);
		buffer2 = buffer;
	}

	@Override
	public void visit(Emphasis node) {
		switch (node.getType()) {
		case ITALIC:
			myappend("<em>");
			myappend(node.getText(),true);
			myappend("</em>");
			break;
		case BOLD:
			myappend("<strong>");
			myappend(node.getText(),true);
			myappend("</strong>");
			break;
		case ITALIC_AND_BOLD:
			myappend("<strong><em>");
			myappend(node.getText(),true);
			myappend("</em></strong>");
		}
	}
	
	protected void myappend(String s){
		myappend(s,false);
	}

	/**
	 * Prints the specified string to target buffer. Sadly the append and
	 * escapeAndAppend methods are package protected, and cannot be called from
	 * this class...
	 * 
	 * @param s
	 *            The string to write
	 * @param escape
	 *            If <code>true</code>, then invalid HTML characters in String
	 *            content will be escaped
	 */
	protected void myappend(String s,boolean escape){
		try {
			if (escape){
				for (char c : s.toCharArray()){
					buffer2.append(Utils.escape(c));
				}
			} else {
				buffer2.append(s);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}

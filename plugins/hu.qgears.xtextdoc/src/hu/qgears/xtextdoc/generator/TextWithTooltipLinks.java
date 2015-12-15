package hu.qgears.xtextdoc.generator;

import hu.qgears.xtextdoc.util.EscapeString;
import hu.qgears.xtextdoc.util.MultiMapTreeImpl;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Decorate source code with links and tooltip (that is shown when mouse is clicked over the link).
 * The tooltip contains metamodel documentations and links.
 * Input is source file as string and ranges with links.
 * Output is preformatted HTML.
 * @author rizsi
 *
 */
public class TextWithTooltipLinks {
	protected Writer out, rtout,rtcout;
	private String src;
	private MultiMapTreeImpl<Integer, DecorationData> decorations=new MultiMapTreeImpl<>();
	private MultiMapTreeImpl<Integer, DecorationData> endings=new MultiMapTreeImpl<>();
	/**
	 * Create a new HTML text decorator for the give source code.
	 * This source will be shown in the generated HTML as preformatted text.
	 * @param src
	 */
	public TextWithTooltipLinks(String src) {
		super();
		this.src = src;
	}
	/**
	 * Add a decoration to the source code.
	 * @param decoration
	 */
	public void addDecoration(DecorationData decoration)
	{
		decorations.putSingle(decoration.offset, decoration);
	}
	/**
	 * Generate the JavaScript scripts that drive the popup window implementation of the
	 * generated HTML.
	 * This must be included into the generated HTML in the head part.
	 * @param output
	 * @throws IOException
	 */
	public static void generateScripts(Writer output) throws IOException
	{
		new TextWithTooltipLinks("").generateScripts_(output);
	}
	private void generateScripts_(Writer output) throws IOException {
		setWriter(output);
		rtout.write(
				"<script>\n" +
				"function toggle(elementId, toggleButtonId) {\n" +
				"	var ele = document.getElementById(elementId);\n" +
				"	if(ele.style.display == \"block\") {\n" +
				"		ele.style.display = \"none\";\n" +
				"	}\n" +
				"	else {\n" +
				"		ele.style.display = \"block\";\n" +
				"	}\n" +
				"	var s = document.getElementById(toggleButtonId).innerHTML;\n" +
				"	if (s.search(\"show\") > 0) {\n" + 
				"		s = s.replace(\"show\",\"hide\");\n" +
				"	} else {\n" +
				"		s = s.replace(\"hide\",\"show\");\n" + 
				"	}\n" +
				"	document.getElementById(toggleButtonId).innerHTML = s;\n" +
				"}\n" + 
				"</script>\n"	
		);
		rtout.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>");
		rtout.write(
				"<script>" +
				"	$(function() {" +
				"		$('.tooltipButton').click(function(){" +
				"			var visible = $(this).next().is(':visible');" +
				"			$('.tooltipContent').hide();" +
				"			if (visible) {" +
				"		  		$(this).next().hide();" +		
				"			} else {" +
				"				$(this).next().show();" +
				"			}" +		
				"		});" +
				"		$('.tooltipClose').click(function(){" +
				"			$(this).parent().hide();" +
				"		});" +
				"	});" +
				"</script>"
		);
	}
	/**
	 * Generate the CSS scripts that drive the popup window implementation of the
	 * generated HTML.
	 * This must be included into the generated HTML in the head part.
	 * @param output
	 * @throws IOException
	 */
	public static void generateCSS(Writer output) throws IOException
	{
		new TextWithTooltipLinks("").generateCSS_(output);
	}
	private void generateCSS_(Writer output) throws IOException
	{
		setWriter(output);
		rtout.write("<style>\n");
		rtout.write(
				"a {\n" +
				"    color: #005B81;\n" +
				"    text-decoration: none;\n" +
				"}\n" +
				"a:hover {\n" +
				"    color: #E32E00;\n" +
				"    text-decoration: underline;\n" +
				"    cursor: pointer;\n" +
				"}\n" +
				".tooltip {\n" +
				"	white-space:pre;\n" + 
				"	outline:none;\n" +
				"}\n" +
				".tooltipContent {\n" +
				"	white-space: normal;\n" +
				"   z-index:10;\n" +
				"  	line-height:16px;\n" +
				"	display:inline;\n" +
				"	padding:14px 20px;\n" +
				"	width: auto;\n" +
				"	position:absolute;\n" + 
				"	color:#111;\n" +
				"	border:1px solid #DCA;\n" +
				"	background:#fffAF0;\n" +
				"}\n"
		);
		rtout.write("</style>\n");
		rtout.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/>\n");
	}
	/**
	 * Generate the HTML output. Weaves all decorations into the source code and writes it into the given
	 * writer object.
	 * @param output
	 * @throws IOException
	 */
	public void generateString(Writer output) throws IOException
	{
		setWriter(output);
		rtout.write("<pre>");
		for(int i=0;i<src.length();++i)
		{
			doEnding(i);
			endings.remove(i);
			List<DecorationData> decs=decorations.get(i);
			for(DecorationData dec:decs)
			{
				rtout.write("<span class=\"tooltip\"><a class=\"tooltipButton\">");
				
				if(dec.length==0)
				{
					doEnding(dec);
				}else
				{
					int endat=dec.length+i;
					endings.putSingle(endat, dec);
				}
			}
			decorations.remove(i);
			char c=src.charAt(i);
			EscapeString.escapeHtml(output, ""+c);
		}
		// Finish unclosed tags
		for(Integer key:endings.keySet())
		{
			doEnding(key);
		}
		rtout.write("</pre>");
	}
	private void doEnding(int i) throws IOException {
		List<DecorationData> l=endings.get(i);
		for(DecorationData d: l)
		{
			doEnding(d);
		}
	}
	private void doEnding(DecorationData d) throws IOException {
		rtout.write("</a><div class=\"tooltipContent\" style=\"display: none\">");
		
		rtcout.write(""+d.html);
		
		rtout.write("<br/><br/><a class=\"tooltipClose\">Close</a></div></span>");
	}
	private void setWriter(Writer output) {
		out=this.rtout=rtcout=output;
	}
}

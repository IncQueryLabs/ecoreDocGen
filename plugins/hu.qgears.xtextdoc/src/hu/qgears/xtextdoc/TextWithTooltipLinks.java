package hu.qgears.xtextdoc;

import hu.qgears.xtextdoc.util.EscapeString;
import hu.qgears.xtextdoc.util.MultiMapTreeImpl;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Decorate source code with links and tooltip (that is shown when mouse is hovered over the link)
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
	public TextWithTooltipLinks(String src) {
		super();
		this.src = src;
	}
	public void addDecoration(DecorationData decoration)
	{
		decorations.putSingle(decoration.offset, decoration);
	}
	public static void generateCSS(Writer output, int tooltipWidth) throws IOException
	{
		new TextWithTooltipLinks("").generateCSS_(output, tooltipWidth);
	}
	private void generateCSS_(Writer output, int tooltipWidth) throws IOException
	{
		setWriter(output);
		rtout.write("a.tooltip {outline:none; }\na.tooltip strong {line-height:30px;}\na.tooltip:hover {text-decoration:none;} \na.tooltip span.tooltip {\n    z-index:10;display:none; padding:14px 20px;\n    margin-top:-30px; margin-left:28px;\n    width:");
		rtcout.write(""+tooltipWidth);
		rtout.write("px; line-height:16px;\n}\na.tooltip:hover span.tooltip{\n\twhite-space: normal; display:inline; position:absolute; color:#111; border:1px solid #DCA; background:#fffAF0;}\n.callout {z-index:20;position:absolute;top:30px;border:0;left:-12px;}\n    \n/*CSS3 extras*/\na.tooltip span\n{\n    border-radius:4px;\n    box-shadow: 5px 5px 8px #CCC;\n}\n");
	}
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
				rtout.write("<a href=\"");
				rtcout.write(EscapeString.escapeHtml(""+dec.referenceLink));
				rtout.write("\" class=\"tooltip\">");
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
			EscapeString.escapeHtml(output, ""+src.charAt(i));
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
		rtout.write("<span class=\"tooltip\">");
		rtcout.write(""+d.html);
		rtout.write("</span></a>");
	}
	private void setWriter(Writer output) {
		out=this.rtout=rtcout=output;
	}
}

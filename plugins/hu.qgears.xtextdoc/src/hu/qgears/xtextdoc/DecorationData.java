package hu.qgears.xtextdoc;

/**
 * DTO to store a HTML reference and popup window data.
 * @author rizsi
 *
 */
public class DecorationData {
	public int offset;
	public int length;
	public String html;
	public String referenceLink;

	public DecorationData(int offset, int length, String referenceLink, String html) {
		this.offset=offset;
		this.length = length;
		this.html = html;
		this.referenceLink=referenceLink;
	}
}
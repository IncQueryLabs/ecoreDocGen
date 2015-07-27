/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hu.qgears.xtextdoc.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Escapes and unescapes <code>String</code>s for Java, Java Script, HTML, XML,
 * and SQL.
 * </p>
 * <p>It is copied from org.apache.commons.lang package. Escaping / bug is fixed, not wanted features are deleted. - SA</p>
 * 
 * @author Apache Jakarta Turbine
 * @author Purple Technology
 * @author <a href="mailto:alex@purpletech.com">Alexander Day Chaffee</a>
 * @author Antony Riley
 * @author Helge Tesgaard
 * @author <a href="sean@boohai.com">Sean Brown</a>
 * @author <a href="mailto:ggregory@seagullsw.com">Gary Gregory</a>
 * @author Phil Steitz
 * @author Pete Gieser
 * @since 2.0
 * @version $Id: StringEscapeUtils.java 612880 2008-01-17 17:34:43Z ggregory $
 */
public class EscapeString {

	/**
	 * <p>
	 * <code>StringEscapeUtils</code> instances should NOT be constructed in
	 * standard programming.
	 * </p>
	 * 
	 * <p>
	 * Instead, the class should be used as:
	 * 
	 * <pre>
	 * StringEscapeUtils.escapeJava(&quot;foo&quot;);
	 * </pre>
	 * 
	 * </p>
	 * 
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean
	 * instance to operate.
	 * </p>
	 */
	public EscapeString() {
		super();
	}

	// Java and JavaScript
	//--------------------------------------------------------------------------
	/**
	 * <p>
	 * Escapes the characters in a <code>String</code> using Java String rules.
	 * </p>
	 * 
	 * <p>
	 * Deals correctly with quotes and control-chars (tab, backslash, cr, ff,
	 * etc.)
	 * </p>
	 * 
	 * <p>
	 * So a tab becomes the characters <code>'\\'</code> and <code>'t'</code>.
	 * </p>
	 * 
	 * <p>
	 * The only difference between Java strings and JavaScript strings is that
	 * in JavaScript, a single quote must be escaped.
	 * </p>
	 * 
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * input string: He didn't say, &quot;Stop!&quot;
	 * output string: He didn't say, \&quot;Stop!\&quot;
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            String to escape values in, may be null
	 * @return String with escaped values, <code>null</code> if null string
	 *         input
	 */
	public static String escapeJava(String str) {
		return escapeJavaStyleString(str, false);
	}

	/**
	 * <p>
	 * Escapes the characters in a <code>String</code> using Java String rules
	 * to a <code>Writer</code>.
	 * </p>
	 * 
	 * <p>
	 * A <code>null</code> string input has no effect.
	 * </p>
	 * 
	 * @see #escapeJava(java.lang.String)
	 * @param out
	 *            Writer to write escaped string into
	 * @param str
	 *            String to escape values in, may be null
	 * @throws IllegalArgumentException
	 *             if the Writer is <code>null</code>
	 * @throws IOException
	 *             if error occurs on underlying Writer
	 */
	public static void escapeJava(Writer out, String str) throws IOException {
		escapeJavaStyleString(out, str, false);
	}

	/**
	 * <p>
	 * Escapes the characters in a <code>String</code> using JavaScript String
	 * rules.
	 * </p>
	 * <p>
	 * Escapes any values it finds into their JavaScript String form. Deals
	 * correctly with quotes and control-chars (tab, backslash, cr, ff, etc.)
	 * </p>
	 * 
	 * <p>
	 * So a tab becomes the characters <code>'\\'</code> and <code>'t'</code>.
	 * </p>
	 * 
	 * <p>
	 * The only difference between Java strings and JavaScript strings is that
	 * in JavaScript, a single quote must be escaped.
	 * </p>
	 * 
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * input string: He didn't say, &quot;Stop!&quot;
	 * output string: He didn\'t say, \&quot;Stop!\&quot;
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            String to escape values in, may be null
	 * @return String with escaped values, <code>null</code> if null string
	 *         input
	 */
	public static String escapeJavaScript(String str) {
		return escapeJavaStyleString(str, true);
	}

	/**
	 * <p>
	 * Escapes the characters in a <code>String</code> using JavaScript String
	 * rules to a <code>Writer</code>.
	 * </p>
	 * 
	 * <p>
	 * A <code>null</code> string input has no effect.
	 * </p>
	 * 
	 * @see #escapeJavaScript(java.lang.String)
	 * @param out
	 *            Writer to write escaped string into
	 * @param str
	 *            String to escape values in, may be null
	 * @throws IllegalArgumentException
	 *             if the Writer is <code>null</code>
	 * @throws IOException
	 *             if error occurs on underlying Writer
	 **/
	public static void escapeJavaScript(Writer out, String str)
			throws IOException {
		escapeJavaStyleString(out, str, true);
	}

	/**
	 * <p>
	 * Worker method for the {@link #escapeJavaScript(String)} method.
	 * </p>
	 * 
	 * @param str
	 *            String to escape values in, may be null
	 * @param escapeSingleQuotes
	 *            escapes single quotes if <code>true</code>
	 * @return the escaped string
	 */
	private static String escapeJavaStyleString(String str,
			boolean escapeSingleQuotes) {
		if (str == null) {
			return null;
		}
		try {
			StringWriter writer = new StringWriter(str.length() * 2);
			escapeJavaStyleString(writer, str, escapeSingleQuotes);
			return writer.toString();
		} catch (IOException ioe) {
			// this should never ever happen while writing to a StringWriter
			ioe.printStackTrace();
			return null;
		}
	}

	/**
	 * <p>
	 * Worker method for the {@link #escapeJavaScript(String)} method.
	 * </p>
	 * 
	 * @param out
	 *            write to receieve the escaped string
	 * @param str
	 *            String to escape values in, may be null
	 * @param escapeSingleQuote
	 *            escapes single quotes if <code>true</code>
	 * @throws IOException
	 *             if an IOException occurs
	 */
	private static void escapeJavaStyleString(Writer out, String str,
			boolean escapeSingleQuote) throws IOException {
		if (out == null) {
			throw new IllegalArgumentException("The Writer must not be null");
		}
		if (str == null) {
			return;
		}
		int sz;
		sz = str.length();
		for (int i = 0; i < sz; i++) {
			char ch = str.charAt(i);

			// handle unicode
			if (ch > 0xfff) {
				out.write("\\u" + hex(ch));
			} else if (ch > 0xff) {
				out.write("\\u0" + hex(ch));
			} else if (ch > 0x7f) {
				out.write("\\u00" + hex(ch));
			} else if (ch < 32) {
				switch (ch) {
				case '\b':
					out.write('\\');
					out.write('b');
					break;
				case '\n':
					out.write('\\');
					out.write('n');
					break;
				case '\t':
					out.write('\\');
					out.write('t');
					break;
				case '\f':
					out.write('\\');
					out.write('f');
					break;
				case '\r':
					out.write('\\');
					out.write('r');
					break;
				default:
					if (ch > 0xf) {
						out.write("\\u00" + hex(ch));
					} else {
						out.write("\\u000" + hex(ch));
					}
					break;
				}
			} else {
				switch (ch) {
				case '\'':
					if (escapeSingleQuote) {
						out.write('\\');
					}
					out.write('\'');
					break;
				case '"':
					out.write('\\');
					out.write('"');
					break;
				case '\\':
					out.write('\\');
					out.write('\\');
					break;
					// Fixed by SA
				// case '/':
				// out.write('\\');
				// out.write('/');
				// break;
				default:
					out.write(ch);
					break;
				}
			}
		}
	}

	/**
	 * <p>
	 * Returns an upper case hexadecimal <code>String</code> for the given
	 * character.
	 * </p>
	 * 
	 * @param ch
	 *            The character to convert.
	 * @return An upper case hexadecimal <code>String</code>
	 */
	private static String hex(char ch) {
		return Integer.toHexString(ch).toUpperCase();
	}

	/**
	 * <p>
	 * Unescapes any Java literals found in the <code>String</code>. For
	 * example, it will turn a sequence of <code>'\'</code> and <code>'n'</code> into a
	 * newline character, unless the <code>'\'</code> is preceded by another <code>'\'</code>.
	 * </p>
	 * 
	 * @param str
	 *            the <code>String</code> to unescape, may be null
	 * @return a new unescaped <code>String</code>, <code>null</code> if null
	 *         string input
	 */
	public static String unescapeJava(String str) {
		if (str == null) {
			return null;
		}
		try {
			StringWriter writer = new StringWriter(str.length());
			unescapeJava(writer, str);
			return writer.toString();
		} catch (IOException ioe) {
			// this should never ever happen while writing to a StringWriter
			ioe.printStackTrace();
			return null;
		}
	}

	/**
	 * <p>
	 * Unescapes any Java literals found in the <code>String</code> to a
	 * <code>Writer</code>.
	 * </p>
	 * 
	 * <p>
	 * For example, it will turn a sequence of <code>'\'</code> and <code>'n'</code> into
	 * a newline character, unless the <code>'\'</code> is preceded by another <code>'\'</code>.
	 * </p>
	 * 
	 * <p>
	 * A <code>null</code> string input has no effect.
	 * </p>
	 * 
	 * @param out
	 *            the <code>Writer</code> used to output unescaped characters
	 * @param str
	 *            the <code>String</code> to unescape, may be null
	 * @throws IllegalArgumentException
	 *             if the Writer is <code>null</code>
	 * @throws IOException
	 *             if error occurs on underlying Writer
	 */
	public static void unescapeJava(Writer out, String str) throws IOException {
		if (out == null) {
			throw new IllegalArgumentException("The Writer must not be null");
		}
		if (str == null) {
			return;
		}
		int sz = str.length();
		StringBuffer unicode = new StringBuffer(4);
		boolean hadSlash = false;
		boolean inUnicode = false;
		for (int i = 0; i < sz; i++) {
			char ch = str.charAt(i);
			if (inUnicode) {
				// if in unicode, then we're reading unicode
				// values in somehow
				unicode.append(ch);
				if (unicode.length() == 4) {
					// unicode now contains the four hex digits
					// which represents our unicode character
					try {
						int value = Integer.parseInt(unicode.toString(), 16);
						out.write((char) value);
						unicode.setLength(0);
						inUnicode = false;
						hadSlash = false;
					} catch (NumberFormatException nfe) {
						throw new RuntimeException(
								"Unable to parse unicode value: " + unicode,
								nfe);
					}
				}
				continue;
			}
			if (hadSlash) {
				// handle an escaped value
				hadSlash = false;
				switch (ch) {
				case '\\':
					out.write('\\');
					break;
				case '\'':
					out.write('\'');
					break;
				case '\"':
					out.write('"');
					break;
				case 'r':
					out.write('\r');
					break;
				case 'f':
					out.write('\f');
					break;
				case 't':
					out.write('\t');
					break;
				case 'n':
					out.write('\n');
					break;
				case 'b':
					out.write('\b');
					break;
				case 'u': {
					// uh-oh, we're in unicode country....
					inUnicode = true;
					break;
				}
				default:
					out.write(ch);
					break;
				}
				continue;
			} else if (ch == '\\') {
				hadSlash = true;
				continue;
			}
			out.write(ch);
		}
		if (hadSlash) {
			// then we're in the weird case of a \ at the end of the
			// string, let's output it anyway.
			out.write('\\');
		}
	}

	/**
	 * <p>
	 * Unescapes any JavaScript literals found in the <code>String</code>.
	 * </p>
	 * 
	 * <p>
	 * For example, it will turn a sequence of <code>'\'</code> and <code>'n'</code> into
	 * a newline character, unless the <code>'\'</code> is preceded by another <code>'\'</code>.
	 * </p>
	 * 
	 * @see #unescapeJava(String)
	 * @param str
	 *            the <code>String</code> to unescape, may be null
	 * @return A new unescaped <code>String</code>, <code>null</code> if null
	 *         string input
	 */
	public static String unescapeJavaScript(String str) {
		return unescapeJava(str);
	}

	/**
	 * <p>
	 * Unescapes any JavaScript literals found in the <code>String</code> to a
	 * <code>Writer</code>.
	 * </p>
	 * 
	 * <p>
	 * For example, it will turn a sequence of <code>'\'</code> and <code>'n'</code> into
	 * a newline character, unless the <code>'\'</code> is preceded by another <code>'\'</code>.
	 * </p>
	 * 
	 * <p>
	 * A <code>null</code> string input has no effect.
	 * </p>
	 * 
	 * @see #unescapeJava(Writer,String)
	 * @param out
	 *            the <code>Writer</code> used to output unescaped characters
	 * @param str
	 *            the <code>String</code> to unescape, may be null
	 * @throws IllegalArgumentException
	 *             if the Writer is <code>null</code>
	 * @throws IOException
	 *             if error occurs on underlying Writer
	 */
	public static void unescapeJavaScript(Writer out, String str)
			throws IOException {
		unescapeJava(out, str);
	}
	public static String escapeHtml(String str)
	{
		StringWriter sw=new StringWriter();
		try {
			escapeHtml(sw, str);
		} catch (IOException e) {
			// Exception is never thrown
			e.printStackTrace();
		}
		return sw.toString();
	}
	public static void escapeHtml(Writer out, String str) throws IOException
	{
		for(int i=0;i<str.length();++i)
		{
			char ch=str.charAt(i);
			switch (ch) {
			case '<':
				out.append("&lt;");
				break;
			case '>':
				out.append("&gt;");
				break;
			case '&':
				out.append("&amp;");
				break;
			case '"':
				out.append("&quot;");
				break;
			default:
				out.append(ch);
				break;
			}
		}
	}
	
	private static Map<String,Character> htmlEscapeChars;
	static {
		htmlEscapeChars = new HashMap<String, Character>();
		htmlEscapeChars.put("&lt;",'<');
		htmlEscapeChars.put("&gt;",'>');
		htmlEscapeChars.put("&amp;",'&');
		htmlEscapeChars.put("&quot;",'"');
	}
	
	public static String unEscapeHtml(String str)
	{
		StringBuilder w = new StringBuilder();
		String mem= "";
		int lastAmpIndex=-1;
		for(int i=0;i<str.length();++i)
		{
			char ch=str.charAt(i);
			w.append(ch);
			switch (ch) {
				case '&' : lastAmpIndex = w.length()-1; break;
				case ';': {
					if (lastAmpIndex >= 0){
						mem = w.substring(lastAmpIndex, w.length());
						if (htmlEscapeChars.containsKey(mem)){
							w.replace(lastAmpIndex, w.length(), ""+htmlEscapeChars.get(mem));
							lastAmpIndex = -1;
						}
					}
					break;
				}
				
			}
		}
		return w.toString();
	}
}
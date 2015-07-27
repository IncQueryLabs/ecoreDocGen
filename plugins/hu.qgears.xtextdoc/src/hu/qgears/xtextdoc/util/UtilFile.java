package hu.qgears.xtextdoc.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.Manifest;

/**
 * Static methods for handling files.
 * 
 * @author rizsi
 * 
 */
public class UtilFile {

	/**
	 * Create the parent directories of the file. Then create the file and fill
	 * its content from the given URL.
	 * 
	 * @param trg
	 * @param url
	 * @throws IOException
	 */
	public static void copyFileFromUrl(File trg, URL url) throws IOException {
		trg.getParentFile().mkdirs();
		InputStream is = url.openStream();
		try {
			FileOutputStream fos = new FileOutputStream(trg);
			try {
				BufferedInputStream bis = new BufferedInputStream(is, 16384);
				BufferedOutputStream bos = new BufferedOutputStream(fos, 16384);
				int c;
				while ((c = bis.read()) >= 0) {
					bos.write(c);
				}
				bos.close();
			} finally {
				fos.close();
			}
		} finally {
			is.close();
		}
	}

	/**
	 * Save the string into the file. The created file is UTF-8 encoded.
	 * 
	 * @param targetFile
	 * @param s
	 * @throws IOException
	 */
	public static void saveAsFile(File targetFile, String s) throws IOException {
		FileOutputStream fos = new FileOutputStream(targetFile);
		try {
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			osw.write(s);
			osw.close();
		} finally {
			fos.close();
		}
	}

	/**
	 * Save the given content into the given file.
	 * 
	 * @param targetFile
	 * @param s
	 * @throws IOException
	 */
	public static void saveAsFile(File targetFile, byte[] s) throws IOException {
		FileOutputStream fos = new FileOutputStream(targetFile);
		try {
			fos.write(s);
		} finally {
			fos.close();
		}
	}

	/**
	 * Delete the given file or directory. If it is a directory then delete all
	 * its content recursively. ("rm -rf")
	 * 
	 * @param dir
	 */
	public static void deleteRecursive(File dir) {
		if (dir.exists()) {
			if (dir.isDirectory()) {
				for (File f : dir.listFiles()) {
					deleteRecursive(f);
				}
			}
			dir.delete();
		}
	}

	/**
	 * Get the MD5 hash of the byte array. The hash is returned in a string
	 * containing a hexadecimal number
	 * 
	 * @param bytes
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String getMd5(byte[] bytes) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(bytes);
			return "" + new BigInteger(1, m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Load the content from the URL into a byte array.
	 * 
	 * @param resource
	 * @return
	 * @throws IOException
	 */
	public static byte[] loadFile(URL resource) throws IOException {
		InputStream is = resource.openStream();
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int n;
			while ((n = is.read(buffer)) > 0) {
				bos.write(buffer, 0, n);
			}
			return bos.toByteArray();
		} finally {
			is.close();
		}
	}

	public static byte[] loadFile(File f) throws IOException {
		FileInputStream fis = new FileInputStream(f);
		try {
			return loadFile(fis);
		} finally {
			fis.close();
		}
	}

	/**
	 * Load the content from the <code>InputStream</code> into a byte array.
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static byte[] loadFile(InputStream is) throws IOException {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int n;
			while ((n = is.read(buffer)) > 0) {
				bos.write(buffer, 0, n);
			}
			return bos.toByteArray();
		} finally {
			is.close();
		}
	}

	/**
	 * Load the content of <code>InputStream</code> into a string. The input
	 * must be UTF-8 encoded. The method automatically closes the stream after
	 * operation is finished.
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 * @throws NullPointerException if is is <code>null</code>
	 */
	public static String loadAsString(InputStream is) throws IOException {
		try {
			InputStreamReader reader = new InputStreamReader(is, "UTF-8");
			char[] chars = new char[1024];
			StringBuilder ret = new StringBuilder();
			int count;
			while ((count = reader.read(chars)) > 0) {
				ret.append(chars, 0, count);
			}
			return ret.toString();
		} finally {
			is.close();
		}
	}

	/**
	 * Load the content of <code>File</code> into a string. The input file must
	 * be UTF-8 encoded.
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String loadAsString(File f) throws IOException {
		FileInputStream fis = new FileInputStream(f);
		try {
			return loadAsString(fis);
		} finally {
			fis.close();
		}
	}

	/**
	 * Load the content from the <code>URL</code> into a string. The input must
	 * be UTF-8 encoded.
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String loadAsString(URL url) throws IOException {
		if (url == null) {
			throw new IllegalArgumentException("URL must not be null");
		}
		InputStream is = url.openStream();
		try {
			return loadAsString(is);
		} finally {
			is.close();
		}
	}

	/**
	 * Load a java manifest file.
	 * 
	 * @param bytes
	 *            The manifest file's content
	 * @return The manifest in object oriented model.
	 * @throws IOException
	 */
	public static Manifest loadManifest(byte[] bytes) throws IOException {
		ByteArrayInputStream fis = new ByteArrayInputStream(bytes);
		try {
			Manifest mf = new Manifest(fis);
			return mf;
		} finally {
			fis.close();
		}

	}

	/**
	 * Serialise the given manifest into a byte array. The byte array can then
	 * be saved into a file.
	 * 
	 * @param mf
	 *            manifest model to be serialised
	 * @return the manifest file's content
	 * @throws IOException
	 */
	public static byte[] saveManifest(Manifest mf) throws IOException {
		ByteArrayOutputStream fos = new ByteArrayOutputStream();
		try {
			mf.write(fos);
		} finally {
			fos.close();
		}
		return fos.toByteArray();
	}

	/**
	 * List all files in a directory recursively.
	 * 
	 * @param dir
	 *            the input directory
	 * @return a new {@link List} containing the files within directory.
	 */
	public static List<File> listAllFiles(File dir) {
		List<File> ret = new ArrayList<File>();
		listAllFiles(dir, ret, new HashSet<String>());
		return ret;
	}

	/**
	 * Lists all files and subdirectories defined directly in specified input
	 * directory.
	 * 
	 * @param dir The input directory
	 * @return A {@link List} containing the files, or an empty list, if the
	 *         directory doesn't have any child entry. Never returns
	 *         <code>null</code>.
	 */
	public static List<File> listFiles(File dir) {
		List<File> ret = new ArrayList<File>();
		File[] fs = dir.listFiles();
		if (fs != null) {
			for (File f : fs) {
				ret.add(f);
			}
		}
		return ret;
	}

	/**
	 * List all files in a directory recursively
	 * 
	 * @param dir
	 *            the root direcory to collect files in
	 * @param files
	 *            collect files into this list (directories are not added)
	 * @param exceptions
	 *            file names (no path, just simple name) that are not listed
	 *            (neither itself, nor its children)
	 */
	public static void listAllFiles(File dir, List<File> files,
			Set<String> exceptions) {
		File[] fs = dir.listFiles();
		if (fs != null) {
			for (File f : fs) {
				if (!exceptions.contains(f.getName())) {
					if (f.isFile()) {
						files.add(f);
					} else if (f.isDirectory()) {
						listAllFiles(f, files, exceptions);
					}
				}
			}
		}
	}

	public static void checkSaveAsFile(File targetFile, byte[] bs)
			throws IOException {
		if (targetFile.exists()) {
			byte[] original = UtilFile.loadFile(targetFile);
			if (Arrays.equals(bs, original)) {
				return;
			}
		}
		saveAsFile(targetFile, bs);
	}

	/**
	 * Create all parent directories of the file f.
	 * 
	 * @param f
	 *            is a file path
	 */
	public static void mkdirParents(File f) {
		f.getParentFile().mkdirs();
	}

	public static void saveAsFile(File targetFile, ByteBuffer bb) throws IOException {
		FileOutputStream fos=new FileOutputStream(targetFile);
		try {
		    FileChannel wChannel = fos.getChannel();
		    while(bb.hasRemaining())
		    {
		    	wChannel.write(bb);
		    }
		    wChannel.close();
		} finally {
			fos.close();
		}
	}

	public static File getUserHome() {
		return new File(System.getProperty("user.home"));
	}
}

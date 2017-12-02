package org.to2mbn.authlibinjector.util;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public final class IOUtils {

	public static String asString(InputStream in) throws IOException {
		CharArrayWriter w = new CharArrayWriter();
		Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
		char[] buf = new char[4096]; // 8192 bytes
		int read;
		while ((read = reader.read(buf)) != -1) {
			w.write(buf, 0, read);
		}
		return new String(w.toCharArray());
	}

	private IOUtils() {}

}

package org.to2mbn.authlibinjector.login.yggdrasil.core.texture;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public final class Textures {

	public static Texture createTexture(String url, Map<String, String> metadata) throws MalformedURLException {
		return createTexture(new URL(url), metadata);
	}

	public static Texture createTexture(URL url, Map<String, String> metadata) {
		return new URLTexture(url, metadata);
	}

	private Textures() {}

}

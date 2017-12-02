package org.to2mbn.authlibinjector.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public final class KeyUtils {

	public static byte[] decodePublicKey(String pem) throws IllegalArgumentException {
		final String header = "-----BEGIN PUBLIC KEY-----\n";
		final String end = "-----END PUBLIC KEY-----";
		if (pem.startsWith(header) && pem.endsWith(end)) {
			return Base64.getDecoder()
					.decode(pem.substring(header.length(), pem.length() - end.length()).replace("\n", ""));
		} else {
			throw new IllegalArgumentException("Bad key format");
		}
	}

	public static PublicKey loadX509PublicKey(byte[] encodedKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
		X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedKey);
		KeyFactory keyFactory;

		keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(spec);
	}

	private KeyUtils() {}

}

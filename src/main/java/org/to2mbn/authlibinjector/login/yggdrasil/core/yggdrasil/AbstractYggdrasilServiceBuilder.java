package org.to2mbn.authlibinjector.login.yggdrasil.core.yggdrasil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;
import org.to2mbn.authlibinjector.util.HttpRequester;

abstract public class AbstractYggdrasilServiceBuilder<T> {

	protected YggdrasilAPIProvider apiProvider;
	protected PublicKey sessionPublicKey;
	protected boolean useDefaultSessionPublicKey = true;
	protected Proxy proxy;

	protected AbstractYggdrasilServiceBuilder() {}

	public AbstractYggdrasilServiceBuilder<T> apiProvider(YggdrasilAPIProvider provider) {
		this.apiProvider = provider;
		return this;
	}

	public AbstractYggdrasilServiceBuilder<T> sessionPublicKey(PublicKey sessionPublicKey) {
		this.sessionPublicKey = sessionPublicKey;
		useDefaultSessionPublicKey = false;
		return this;
	}

	public AbstractYggdrasilServiceBuilder<T> loadSessionPublicKey(byte[] encodedKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return sessionPublicKey(loadX509PublicKey(Objects.requireNonNull(encodedKey)));
	}

	public AbstractYggdrasilServiceBuilder<T> loadSessionPublicKey(InputStream in) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		return sessionPublicKey(loadX509PublicKey(Objects.requireNonNull(in)));
	}

	public AbstractYggdrasilServiceBuilder<T> loadSessionPublicKey(File keyFile) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		try (InputStream in = new FileInputStream(Objects.requireNonNull(keyFile))) {
			return sessionPublicKey(loadX509PublicKey(in));
		}
	}

	public AbstractYggdrasilServiceBuilder<T> loadSessionPublicKey(String keyFile) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		return loadSessionPublicKey(new File(Objects.requireNonNull(keyFile)));
	}

	public AbstractYggdrasilServiceBuilder<T> proxy(Proxy proxy) {
		this.proxy = proxy;
		return this;
	}

	protected YggdrasilAPIProvider buildAPIProvider() {
		if (apiProvider == null)
			throw new IllegalArgumentException("No apiProvider is specified");
		return apiProvider;
	}

	protected HttpRequester buildHttpRequester() {
		HttpRequester requester = new HttpRequester();
		requester.setProxy(proxy);
		return requester;
	}

	protected PropertiesDeserializer buildPropertiesDeserializer() {
		return new PropertiesDeserializer(useDefaultSessionPublicKey
				? null
				: sessionPublicKey);
	}

	private static PublicKey loadX509PublicKey(InputStream in) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		ByteArrayOutputStream byteout = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int read;
		while ((read = in.read(buffer)) != -1) {
			byteout.write(buffer, 0, read);
		}
		return loadX509PublicKey(byteout.toByteArray());
	}

	private static PublicKey loadX509PublicKey(byte[] encodedKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
		X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedKey);
		KeyFactory keyFactory;

		keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(spec);
	}
}

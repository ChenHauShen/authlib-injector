package org.to2mbn.authlibinjector.login.yggdrasil.core.yggdrasil;

import java.net.Proxy;
import java.security.PublicKey;
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

	abstract public T build();
}

package org.to2mbn.authlibinjector.login;

import org.to2mbn.authlibinjector.login.yggdrasil.core.Session;

public class SavedAuthenticationInfo {

	private String apiRoot;
	private Session session;

	public String getApiRoot() {
		return apiRoot;
	}

	public void setApiRoot(String apiRoot) {
		this.apiRoot = apiRoot;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}

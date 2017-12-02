package org.to2mbn.authlibinjector.login;

import static java.util.Objects.requireNonNull;
import org.to2mbn.authlibinjector.RemoteConfiguration;
import org.to2mbn.authlibinjector.login.yggdrasil.AuthInfo;

public class LoginResult {

	private RemoteConfiguration remote;
	private AuthInfo authInfo;

	public LoginResult(RemoteConfiguration remote, AuthInfo authInfo) {
		this.remote = requireNonNull(remote);
		this.authInfo = requireNonNull(authInfo);
	}

	public RemoteConfiguration getRemote() {
		return remote;
	}

	public AuthInfo getAuthInfo() {
		return authInfo;
	}
}

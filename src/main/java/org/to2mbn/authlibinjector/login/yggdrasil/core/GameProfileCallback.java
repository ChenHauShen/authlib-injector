package org.to2mbn.authlibinjector.login.yggdrasil.core;

import org.to2mbn.authlibinjector.login.yggdrasil.AuthenticationException;

public interface GameProfileCallback {

	void completed(GameProfile profile);

	void failed(String name, AuthenticationException e);

}

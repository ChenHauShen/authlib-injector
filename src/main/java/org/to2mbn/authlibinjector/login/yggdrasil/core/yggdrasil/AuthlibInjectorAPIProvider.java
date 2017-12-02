package org.to2mbn.authlibinjector.login.yggdrasil.core.yggdrasil;

import static java.util.Objects.requireNonNull;
import java.util.UUID;
import org.to2mbn.authlibinjector.util.UUIDUtils;

public class AuthlibInjectorAPIProvider implements YggdrasilAPIProvider {

	private String apiRoot;

	public AuthlibInjectorAPIProvider(String apiRoot) {
		this.apiRoot = requireNonNull(apiRoot);
	}

	@Override
	public String authenticate() {
		return apiRoot + "authserver/authenticate";
	}

	@Override
	public String refresh() {
		return apiRoot + "authserver/refresh";
	}

	@Override
	public String validate() {
		return apiRoot + "authserver/validate";
	}

	@Override
	public String invalidate() {
		return apiRoot + "authserver/invalidate";
	}

	@Override
	public String signout() {
		return apiRoot + "authserver/signout";
	}

	@Override
	public String profile(UUID profileUUID) {
		return apiRoot + "sessionserver/session/minecraft/profile/" + UUIDUtils.unsign(profileUUID);
	}

	@Override
	public String profileByUsername(String username) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String profilesLookup() {
		return apiRoot + "api/profiles/minecraft";
	}

}

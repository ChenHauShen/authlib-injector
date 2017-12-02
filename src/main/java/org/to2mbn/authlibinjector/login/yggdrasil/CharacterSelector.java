package org.to2mbn.authlibinjector.login.yggdrasil;

import org.to2mbn.authlibinjector.login.yggdrasil.core.GameProfile;

public interface CharacterSelector {

	/**
	 * Selects one of the given characters to login.
	 * <p>
	 * This method may be called during the authentication if no character is
	 * selected.
	 *
	 * @param availableProfiles
	 *            the available characters
	 * @return the character to login
	 * @throws AuthenticationException
	 *             if an authentication error occurs
	 */
	GameProfile select(GameProfile[] availableProfiles) throws AuthenticationException;

}

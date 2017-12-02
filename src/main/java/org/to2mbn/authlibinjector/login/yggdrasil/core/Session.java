package org.to2mbn.authlibinjector.login.yggdrasil.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class Session implements Serializable {

	private static final long serialVersionUID = 1L;

	private String clientToken;
	private String accessToken;
	private GameProfile selectedProfile;
	private GameProfile[] profiles;
	private String userId;
	private Map<String, String> properties;
	private UserType userType;

	public Session(String clientToken, String accessToken, GameProfile selectedProfile, GameProfile[] profiles, String userId, Map<String, String> properties, UserType userType) {
		this.clientToken = clientToken;
		this.accessToken = accessToken;
		this.selectedProfile = selectedProfile;
		this.profiles = profiles;
		this.userId = userId;
		this.properties = properties;
		this.userType = userType;
	}

	public String getClientToken() {
		return clientToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public GameProfile getSelectedProfile() {
		return selectedProfile;
	}

	public GameProfile[] getProfiles() {
		return profiles;
	}

	public String getUserId() {
		return userId;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public UserType getUserType() {
		return userType;
	}

	@Override
	public String toString() {
		return String.format("Session [clientToken=%s, accessToken=%s, selectedProfile=%s, profiles=%s, userId=%s, properties=%s, userType=%s]", clientToken, accessToken, selectedProfile, Arrays.toString(profiles), userId, properties, userType);
	}

}

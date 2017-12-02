package org.to2mbn.authlibinjector.login.yggdrasil;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Describes the result of authentication.
 *
 * @author yushijinhun
 */
public class AuthInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String token;
	private UUID uuid;
	private Map<String, String> properties;
	private String userType;

	public AuthInfo(String username, String token, UUID uuid, Map<String, String> properties, String userType) {
		Objects.requireNonNull(username);
		Objects.requireNonNull(token);
		Objects.requireNonNull(uuid);
		Objects.requireNonNull(properties);
		Objects.requireNonNull(userType);

		this.username = username;
		this.token = token;
		this.uuid = uuid;
		this.properties = properties;
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public String getToken() {
		return token;
	}

	public UUID getUUID() {
		return uuid;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public String getUserType() {
		return userType;
	}

	@Override
	public String toString() {
		return String.format("AuthInfo [username=%s, token=%s, uuid=%s, properties=%s, userType=%s]", username, token, uuid, properties, userType);
	}
}

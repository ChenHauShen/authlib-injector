package org.to2mbn.authlibinjector.login.yggdrasil.core;

import java.util.Map;
import java.util.UUID;

public class PropertiesGameProfile extends GameProfile {

	private static final long serialVersionUID = 1L;

	private Map<String, String> properties;

	public PropertiesGameProfile(UUID uuid, String name, Map<String, String> properties) {
		super(uuid, name);
		this.properties = properties;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	@Override
	public String toString() {
		return "GameProfile [uuid=" + getUUID() + ", name=" + getName() + ", properties=" + getProperties() + "]";
	}

}

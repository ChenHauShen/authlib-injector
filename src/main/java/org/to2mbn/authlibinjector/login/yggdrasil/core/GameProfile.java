package org.to2mbn.authlibinjector.login.yggdrasil.core;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class GameProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID uuid;
	private String name;

	public GameProfile(UUID uuid, String name) {
		this.uuid = Objects.requireNonNull(uuid);
		this.name = Objects.requireNonNull(name);
	}

	public UUID getUUID() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "GameProfile [uuid=" + uuid + ", name=" + name + "]";
	}
}

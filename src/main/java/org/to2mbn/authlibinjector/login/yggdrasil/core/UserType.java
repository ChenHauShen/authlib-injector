package org.to2mbn.authlibinjector.login.yggdrasil.core;

public enum UserType {
	LEGACY("legacy"),
	MOJANG("mojang");

	private final String name;

	private UserType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static UserType getUserType(String type) {
		switch (type.toLowerCase()) {
			case "legacy":
				return UserType.LEGACY;

			case "mojang":
				return UserType.MOJANG;

			default:
				return null;
		}
	}
}

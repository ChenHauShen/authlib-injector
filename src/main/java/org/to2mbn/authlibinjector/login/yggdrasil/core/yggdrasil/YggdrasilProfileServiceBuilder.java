package org.to2mbn.authlibinjector.login.yggdrasil.core.yggdrasil;

import org.to2mbn.authlibinjector.login.yggdrasil.core.ProfileService;

public class YggdrasilProfileServiceBuilder extends AbstractYggdrasilServiceBuilder<ProfileService> {

	public static YggdrasilProfileServiceBuilder create() {
		return new YggdrasilProfileServiceBuilder();
	}

	public static ProfileService buildDefault() {
		return create().build();
	}

	@Override
	public ProfileService build() {
		return new YggdrasilProfileService(buildHttpRequester(), buildPropertiesDeserializer(), buildAPIProvider());
	}

}

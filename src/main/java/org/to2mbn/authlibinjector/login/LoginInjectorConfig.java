package org.to2mbn.authlibinjector.login;

import java.util.List;
import org.to2mbn.authlibinjector.InjectorConfig;
import org.to2mbn.authlibinjector.transform.AuthenticationArgumentsTransformUnit;
import org.to2mbn.authlibinjector.transform.TransformUnit;

public class LoginInjectorConfig extends InjectorConfig {

	@Override
	public void applyTransformers(List<TransformUnit> units) {
		super.applyTransformers(units);
		units.add(new AuthenticationArgumentsTransformUnit());
	}
}

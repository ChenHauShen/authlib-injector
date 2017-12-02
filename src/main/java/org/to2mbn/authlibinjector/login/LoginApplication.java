package org.to2mbn.authlibinjector.login;

import static java.util.Optional.empty;
import static org.to2mbn.authlibinjector.AuthlibInjector.log;
import java.awt.GraphicsEnvironment;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.to2mbn.authlibinjector.InjectorConfig;
import org.to2mbn.authlibinjector.transform.AuthenticationArgumentsTransformUnit;
import javafx.embed.swing.JFXPanel;

public class LoginApplication {

	public static boolean isClientSide() {
		if (GraphicsEnvironment.isHeadless())
			return false;

		// TODO: maybe we'd better have more methods to test if it's server/client side?

		return true;
	}

	public static Optional<InjectorConfig> launchAndBlock() {
		try {
			return launchApplication().get().map(result -> {
				InjectorConfig config = new LoginInjectorConfig();
				result.getRemote().applyToInjectorConfig(config);
				AuthenticationArgumentsTransformUnit.authInfo = result.getAuthInfo();
				return config;
			});
		} catch (InterruptedException | ExecutionException e) {
			log("caught exception from gui login", e);
			return empty();
		}
	}

	public static CompletableFuture<Optional<LoginResult>> launchApplication() {
		new JFXPanel(); // init JavaFX
		// TODO
		return CompletableFuture.completedFuture(empty());
	}

}

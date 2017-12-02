package org.to2mbn.authlibinjector.login;

import static java.util.Optional.empty;
import java.awt.GraphicsEnvironment;
import java.util.Optional;
import org.to2mbn.authlibinjector.InjectorConfig;
import javafx.embed.swing.JFXPanel;

public class LoginApplication {

	public static boolean isClientSide() {
		if (GraphicsEnvironment.isHeadless())
			return false;

		// TODO: maybe we'd better have more methods to test if it's server/client side?

		return true;
	}

	public static Optional<InjectorConfig> launchAndBlock() {
		new JFXPanel(); // init JavaFX

		// TODO
		return empty();
	}

}

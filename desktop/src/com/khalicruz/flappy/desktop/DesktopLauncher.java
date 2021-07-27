package com.khalicruz.flappy.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.khalicruz.flappy.flappygame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = flappygame.WIDTH;
		config.height = flappygame.HEIGHT;
		config.title = flappygame.TITLE;
		new LwjglApplication(new flappygame(), config);
	}
}

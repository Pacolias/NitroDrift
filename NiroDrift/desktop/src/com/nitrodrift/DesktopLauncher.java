package com.nitrodrift;


import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;


// Mac: ejecutar con -XstartOnFirstThread
public class DesktopLauncher {
	public static void main (String[] arg) {
		System.out.printf(com.badlogic.gdx.Version.VERSION);

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1024, 900);
		config.useVsync(true);
		config.setForegroundFPS(60);
		config.setTitle("NitroDrift");
		new Lwjgl3Application(new NitroDrift(), config);
	}
}
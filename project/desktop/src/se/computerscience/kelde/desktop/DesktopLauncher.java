package se.computerscience.kelde.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import se.computerscience.kelde.KeldeGame;


public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 540;
        config.width = 960;

        new LwjglApplication(new KeldeGame(), config);
    }
}

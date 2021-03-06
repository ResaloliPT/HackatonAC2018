package org.academiadecodigo.hashtronauts.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.hashtronauts.KillerQueen;
import org.academiadecodigo.hashtronauts.configs.GameSettings;

public class DesktopLauncher {


    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = GameSettings.WIDTH;
        config.height = GameSettings.HEIGHT;
        new LwjglApplication(new KillerQueen(), config);
    }
}

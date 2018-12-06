package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.menu.MainMenu;
import org.academiadecodigo.hashtronauts.screens.GameScreen;

public class KillerQueen extends Game {

    SpriteBatch batch;
    OrthographicCamera camera;


    /**
     * Creates resources to start the came
     */
    @Override
    public void create() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Sets screen
        this.setScreen(new MainMenu(this));

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }


    public OrthographicCamera getCamera() {
        return camera;
    }
}

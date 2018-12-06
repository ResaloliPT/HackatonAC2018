package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.screens.GameScreen;

public class KillerQueen extends Game {

    private SpriteBatch batch;

    private OrthographicCamera camera;

    private GameScreen gameScreen;


    /**
     * Creates resources to start the came
     */
    @Override
    public void create() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Sets screen
        gameScreen = new GameScreen(this);
        this.setScreen(gameScreen);

    }

    @Override
    public void render() {

        batch.setProjectionMatrix(camera.combined);

        super.render();
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

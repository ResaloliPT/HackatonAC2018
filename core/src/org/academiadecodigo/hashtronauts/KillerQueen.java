package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.screens.GameScreen;

public class KillerQueen extends Game {
    SpriteBatch batch;
    Texture background;

    private OrthographicCamera camera;

    private GameScreen gameScreen;


    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("badlogic.jpg");
        gameScreen = new GameScreen(this);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public Texture getBackground() {
        return background;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}

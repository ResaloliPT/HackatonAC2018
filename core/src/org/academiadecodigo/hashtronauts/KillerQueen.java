package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.menu.MainMenu;

public class KillerQueen extends Game {

    SpriteBatch batch;
    Texture img;
    OrthographicCamera camera;

    @Override
    public void create() {

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        img = new Texture("badlogic.jpg");
        this.setScreen(new MainMenu(this));

    }



    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}

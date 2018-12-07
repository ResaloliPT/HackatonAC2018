package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.menu.MainMenu;

public class KillerQueen extends Game {

    SpriteBatch batch;
    OrthographicCamera camera;

    private Music bkgMusic;


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

        this.bkgMusic = Gdx.audio.newMusic(Gdx.files.internal(GameSettings.BCKG_MUSIC));
        bkgMusic.setLooping(true);
        bkgMusic.play();
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

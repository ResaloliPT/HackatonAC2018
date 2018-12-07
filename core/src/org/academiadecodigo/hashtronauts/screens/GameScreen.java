package org.academiadecodigo.hashtronauts.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.academiadecodigo.hashtronauts.KillerQueen;
import org.academiadecodigo.hashtronauts.MainGame;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Player;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Soldier;
import org.academiadecodigo.hashtronauts.utils.Position;

/**
 *
 */
public class GameScreen extends ScreenAdapter {


    private MainGame game;

    private SpriteBatch batch;
    private OrthographicCamera camera;

    private Music music;
    private Texture bkgImage;


    // private Score score;


    /**
     * @param mainClass
     */
    public GameScreen(KillerQueen mainClass) {
        this.batch = mainClass.getBatch();
        this.camera = mainClass.getCamera();
        this.bkgImage = new Texture("background/background_test.png");

        this.game = new MainGame();
        
        setupEvents();
    }


    /**
     * @param delta
     *
     * Renders the game screen and updates view
     *
     */
    @Override
    public void render(float delta) {

        //fill the screen with black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        //Begin SpriteBatch
        batch.begin();


        //Draw sprites
        game.render(batch);

        //End SpriteBatch
        batch.end();

        game.update(camera);


    }

    @Override
    public void resize(int width, int height) {

    }


    /**
     * Disposes of libGDX objects
     */
    @Override
    public void dispose() {
        batch.dispose();
        bkgImage.dispose();
    }

    public void setupEvents() {
        //input handling
        Player.getInstance().setEvents();
    }

}

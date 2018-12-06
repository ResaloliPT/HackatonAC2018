package org.academiadecodigo.hashtronauts.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.academiadecodigo.hashtronauts.KillerQueen;

/**
 *
 */
public class GameScreen extends ScreenAdapter {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    //Testing purposes
    private ShapeRenderer shapeRenderer;

    private Music music;
    private Texture bkgImage;


    // private Score score;


    public GameScreen(KillerQueen mainClass) {
        this.batch = mainClass.getBatch();
        this.camera = mainClass.getCamera();

        this.shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        setupEvents();
    }


    /**
     *
     */
    @Override
    public void show() {
        Gdx.gl.glClearColor(40f, 40f, 40f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    /**
     * @param delta
     */
    @Override
    public void render(float delta) {

        //game.update();

        //fill the screen with black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        //Begin ShapeRenderer
        shapeRenderer.begin();

        //Draw Background Color
        shapeRenderer.setColor(Color.BROWN);
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        shapeRenderer.end();


        /*
        //Begin SpriteBatch
        batch.begin();

        //Disable Transparency
        batch.disableBlending();

        //Draw sprites
        batch.draw()

        //End SpriteBatch
        batch.end();
        */


    }

    @Override
    public void resize(int width, int height) {

    }


    @Override
    public void dispose() {
        shapeRenderer.dispose();
        batch.dispose();
    }

    public void setupEvents() {
        //input handling
    }

}

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


    /**
     * @param mainClass
     */
    public GameScreen(KillerQueen mainClass) {
        this.batch = mainClass.getBatch();
        this.camera = mainClass.getCamera();

        this.shapeRenderer = new ShapeRenderer();

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

        //game.update();

        //fill the screen with black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        //Begin ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        //Draw Background Color
        shapeRenderer.setColor(Color.BROWN);
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Test
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f, 40f, 40f);

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


    /**
     * Disposes of libGDX objects
     */
    @Override
    public void dispose() {
        shapeRenderer.dispose();
        batch.dispose();
    }

    public void setupEvents() {
        //input handling
    }

}

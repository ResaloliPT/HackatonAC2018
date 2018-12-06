package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.characters.Soldier;
import org.academiadecodigo.hashtronauts.utils.Position;

public class KillerQueen extends Game {

    SpriteBatch batch;
    OrthographicCamera camera;
    Soldier enemy;


    /**
     * Creates resources to start the came
     */
    @Override
    public void create() {
        batch = new SpriteBatch();
        Position position = new Position(4, 1);
        enemy = new Soldier(position);


        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Sets screen
        // this.setScreen(new MainMenu(this));

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        enemy.render(batch);
        batch.end();
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

package org.academiadecodigo.hashtronauts.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.KillerQueen;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.configs.GameStrings;

public class GameOverScreen extends ScreenAdapter {

    private KillerQueen mainClass;
    private Texture gameOverImage;
    private SpriteBatch batch;

    public GameOverScreen(KillerQueen mainClass) {
        this.mainClass = mainClass;
        this.batch = mainClass.getBatch();
        this.gameOverImage = new Texture("background/game_over.png");
    }


    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

        batch.begin();
        batch.draw(gameOverImage, 0,0, GameSettings.WIDTH, GameSettings.HEIGHT);

        if (Gdx.input.isKeyPressed(Input.Keys.R)) {
            mainClass.setScreen(new MainMenu(mainClass));
        }

        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            Gdx.app.exit();
        }

        batch.end();
    }

    @Override
    public void dispose() {

        batch.dispose();
        gameOverImage.dispose();
    }
}

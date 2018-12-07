package org.academiadecodigo.hashtronauts.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import org.academiadecodigo.hashtronauts.KillerQueen;
import org.academiadecodigo.hashtronauts.configs.GameStrings;
import org.academiadecodigo.hashtronauts.screens.GameScreen;
import org.academiadecodigo.hashtronauts.utils.Fonts;
import org.academiadecodigo.hashtronauts.utils.Utils;


public class MainMenu extends ScreenAdapter {

    private KillerQueen game;
    private SpriteBatch batch;
    private OrthographicCamera camera;

    /* Screen Texts */
    private BitmapFont welcomeText;
    private BitmapFont pressToStart;

    private Vector2 welcomeTextSize;
    private Vector2 pressToStartSize;

    /* Screen Components */
    private Texture backgroundImage;

    public MainMenu(KillerQueen game) {
        this.game = game;
        this.batch = game.getBatch();
        this.camera = game.getCamera();
        this.welcomeText = Fonts.PRESS_START.getFont();
        this.pressToStart = Fonts.PRESS_START.getFont();

        //Adding a background image
        this.backgroundImage = new Texture("background/main_menu_bg1.png");

    }

    @Override
    public void show() {
        welcomeTextSize = Utils.getStringSize(welcomeText, GameStrings.WELCOME_MESSAGE);
        pressToStartSize = Utils.getStringSize(pressToStart, GameStrings.START_GAME_MESSAGE);
    }

    @Override
    public void render(float delta) {

        batch.begin();
        batch.draw(backgroundImage, 0, 0);

        //Draw the MAIN MENU text options
        welcomeText.draw(batch, GameStrings.WELCOME_MESSAGE, Gdx.graphics.getWidth() / 2 - welcomeTextSize.x / 2,
                Gdx.graphics.getHeight() / 2 - welcomeTextSize.y / 2);


        pressToStart.draw(batch, GameStrings.START_GAME_MESSAGE, Gdx.graphics.getWidth() / 2 - pressToStartSize.x / 2,
                Gdx.graphics.getHeight() / 2 - pressToStartSize.y / 2 - (welcomeTextSize.y + 10));


        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
        }

        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {

            Gdx.app.exit();
        }

        batch.end();
    }

    @Override
    public void dispose() {

        welcomeText.dispose();
        pressToStart.dispose();

        backgroundImage.dispose();
    }
}

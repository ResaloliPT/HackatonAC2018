
package org.academiadecodigo.hashtronauts.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import org.academiadecodigo.hashtronauts.KillerQueen;
import org.academiadecodigo.hashtronauts.utils.Fonts;


public class MainMenu extends ScreenAdapter {

    private KillerQueen game;
    private  SpriteBatch batch;
    private OrthographicCamera camera;

    /* Screen Texts */
    private BitmapFont welcomeText;
    private BitmapFont pressToStart;

    private Vector2 welcomeTextSize;
    private Vector2 pressToStartSize;

    /* Screen Components */
    private Sound startSound;
    private Texture backgroundImage;


    public MainMenu() {


        welcomeText = Fonts.PRESS_START.getFont();
        pressToStart = Fonts.PRESS_START.getFont();

        //startSound = Gdx.audio.newSound()

        this.backgroundImage = new Texture("background/background_test.png");
    }

    @Override
    public void show() {

       // Gdx.audio

       // welcomeTextSize = U
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

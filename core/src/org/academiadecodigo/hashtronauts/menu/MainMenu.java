
package org.academiadecodigo.hashtronauts.menu;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.KillerQueen;


public class MainMenu extends ScreenAdapter {

    private KillerQueen game;
    private  SpriteBatch batch;
    private OrthographicCamera camera;

    /* Screen Texts */
    private BitmapFont welcomeText;




    public MainMenu(KillerQueen game) {

    }

    @Override
    public void show() {
        super.show();
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

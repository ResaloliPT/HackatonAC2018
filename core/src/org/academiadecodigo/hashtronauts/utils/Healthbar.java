package org.academiadecodigo.hashtronauts.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Player;

public class Healthbar {

    private Texture health;

    public Healthbar() {
        this.health = new Texture("images/player/heart.png");
    }

    public void draw(SpriteBatch batch) {

        for (int i = 0; i < Player.getInstance().getHealth(); i++) {
            batch.draw(health, (GameSettings.WIDTH - health.getWidth() * i) - 50, GameSettings.HEIGHT - 50);
        }
    }

}

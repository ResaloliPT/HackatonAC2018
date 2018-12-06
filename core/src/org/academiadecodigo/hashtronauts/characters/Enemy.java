package org.academiadecodigo.hashtronauts.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Enemy extends Characters {
    private Texture sprite;
    private Rectangle hitbox;
    private int health;

}

    public void move(Position targetPosition) {

        int x = ((int) Math.random() + 1) * 10;
        if (x <= 5) {
            hitbox.x = 200 *(hitbox.x + targetPosition.getX) * 2;
            hitbox.y = 200 *(hitbox.y + targetPosition.getY) * 2;
        }
    }

    @Override
    public void render(SpriteBatch b) {

    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {

    }
}
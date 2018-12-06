package org.academiadecodigo.hashtronauts.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Characters {

    private static  Player player = new Player();
    private int health;
    private int score;
    private Weapon weapon;
    private Texture sprite;
    private Rectangle hitbox;

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    public static Player getInstance() {
        return player;

    }

    public void shoot() {

    }

    public void move() {

    }


    /**
     * Renders the Player
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite,hitbox.x,hitbox.y,hitbox.width,hitbox.height);

    }

    /**
     * Updates the Player position
     */
    @Override
    public void update() {

    }

    /**
     * Disposes the Player
     */
    @Override
    public void dispose() {

    }

}

    public Texture getSprite() {
        return sprite;
    }

    public void setSprite(Texture sprite) {
        this.sprite = sprite;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

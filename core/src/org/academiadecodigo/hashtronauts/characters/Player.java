package org.academiadecodigo.hashtronauts.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.hashtronauts.utils.Position;

public class Player extends Characters {

    private static Player player = new Player();

    private Position position;

    private int score;
    //private Weapon weapon;
    private Rectangle hitbox;
    private PlayerEvents playerEvents;



    private Sprite sprite;



    private Player() {
        super();
        this.score = 0;
        //this.weapon = null;
        //this.playerRender = null;
        this.sprite = new Sprite(new Texture("images/player/queen.png"));
        this.playerEvents = new PlayerEvents();
    }


    public static Player getInstance() {
        return player;

    }

    public void shoot(Position touchedPos) {
        //weapon.shoot(touchedPos, position);

    }

    @Override
    public void hit(int damage) {
        if (health - damage < 0) {
            health = 0;
        }
        health -= damage;
    }


    /**
     * Renders the Player
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite, hitbox.x, hitbox.y, hitbox.width, hitbox.height);


    }

    public void setEvents() {
        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.RIGHT) {
                    player.getHitbox().setX(player.getHitbox().getX() + 200 * Gdx.graphics.getDeltaTime() * 2);
                    return true;
                }
                return super.keyDown(keycode);
            }
        });
    }


    /**
     * Updates the Player position
     */
    @Override
    public void update() {
        Position mousePos = playerEvents.getMousePos();

        int dX = mousePos.getX() - position.getX();
        int dY = mousePos.getY() - position.getY();

        float angle = (float) Math.atan(dX/dY);

        sprite.rotate(angle);


    }

    /**
     * Disposes the Player
     */
    @Override
    public void dispose() {



}

    public Sprite getSprite() {
        return sprite;
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

    /*public Weapon getWeapon() {
        return weapon;
    }*/

    /*public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }*/
}

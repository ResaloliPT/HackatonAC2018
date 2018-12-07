package org.academiadecodigo.hashtronauts.gameobjects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.hashtronauts.utils.Position;

public class Player extends Characters {

    private static Player player = new Player();

    private int score;
    //private Weapon weapon;
    private Rectangle hitbox;
    private PlayerEvents playerEvents;



    private Sprite sprite;
    private boolean movingRight;

    private Player() {
        super(new Position(100, 100));
        this.score = 0;
        //this.weapon = null;
        //this.playerRender = null;
        this.hitbox = new Rectangle(100f, 100f, 20f, 20f);
        this.playerEvents = new PlayerEvents();
        this.sprite = new Sprite(new Texture("images/player/queen.png"));
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
                    movingRight = true;
                    return true;
                }
                return super.keyDown(keycode);
            }

            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.RIGHT) {
                    movingRight = false;
                    return true;
                }
                return super.keyUp(keycode);
            }
        });
    }


    /**
     * Updates the Player position
     */
    @Override
    public void update(Camera camera) {
        Position mousePos = playerEvents.getMousePos();

        int dX = mousePos.getX() - getPosition().getX();
        int dY = mousePos.getY() - getPosition().getY();

        float angle = (float) Math.atan(dX/dY);

        sprite.rotate(angle);

        if (movingRight) {
            player.getPosition().setX((int) (player.getPosition().getX() + 200 * Gdx.graphics.getDeltaTime()));
            player.getHitbox().setX(player.getHitbox().getX() + 200 * Gdx.graphics.getDeltaTime() * 2);
        }

    }

    /**
     * Disposes the Player
     */
    @Override
    public void dispose() {
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
}

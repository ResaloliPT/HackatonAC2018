package org.academiadecodigo.hashtronauts.gameobjects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.utils.Position;

public class Player extends Characters {

    private static Player player = new Player();

    private int score;
    //private Weapon weapon;
    private Rectangle hitbox;
    private PlayerEvents playerEvents;


    private Sprite sprite;
    private boolean movingRight;
    private boolean movingLeft;
    private boolean movingUp;
    private boolean movingDown;
    private float angle;


    private Player() {
        super(new Position(100, 100));
        this.score = 0;
        //this.weapon = null;
        //this.playerRender = null;

        this.sprite = new Sprite(new Texture("images/player/queen.png"));
        this.hitbox = new Rectangle(getPosition().getX(), getPosition().getY(), GameSettings.PLAYER_WIDTH, GameSettings.PLAYER_HEIGHT);
        this.playerEvents = new PlayerEvents();
        this.angle = 0;

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

                if (keycode == Input.Keys.LEFT) {
                    movingLeft = true;
                    return true;
                }

                if (keycode == Input.Keys.UP) {
                    movingUp = true;
                    return true;
                }

                if (keycode == Input.Keys.DOWN) {
                    movingDown = true;
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

                if (keycode == Input.Keys.LEFT) {
                    movingLeft = false;
                    return true;
                }

                if (keycode == Input.Keys.UP) {
                    movingUp = false;
                    return true;
                }

                if (keycode == Input.Keys.DOWN) {
                    movingDown = false;
                    return true;
                }


                return super.keyUp(keycode);
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                float dX = screenX - (getPosition().getX() + GameSettings.PLAYER_WIDTH / 2);
                float dY = (getPosition().getY() + GameSettings.PLAYER_HEIGHT / 2) - screenY;
                if ((dX != 0 && dY != 0)) {

                    if (dX >= 0 && dY >= 0) {
                        angle = (float) Math.toDegrees(Math.atan(dY / dX));
                    }

                    if (dX < 0 && dY >= 0) {
                        angle = (float) (180 + Math.toDegrees(Math.atan(dY / dX)));
                    }

                    if (dX >= 0 && dY < 0) {
                        angle = (float) (360 + Math.toDegrees(Math.atan(dY / dX)));
                    }

                    if (dX < 0 && dY < 0) {
                        angle = (float) (180 + Math.toDegrees(Math.atan(dY / dX)));
                    }

                    //sprite.rotate(angle);


                }
                //angle = Math.atan(dY/dX);
                return true;

                //return super.mouseMoved(screenX, screenY);
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

        if (player.getPosition().getX() >= GameSettings.WIDTH - GameSettings.PLAYER_WIDTH) {
            player.getPosition().setX(GameSettings.WIDTH - GameSettings.PLAYER_WIDTH);
        }

        if (player.getPosition().getX() <= 0) {
            player.getPosition().setX(0);
        }

        if (player.getPosition().getY() >= GameSettings.HEIGHT - GameSettings.PLAYER_HEIGHT) {
            player.getPosition().setY(GameSettings.HEIGHT - GameSettings.PLAYER_WIDTH);
        }

        if (player.getPosition().getY() <= 0) {
            player.getPosition().setY(0);
        }

        if (movingRight) {

            player.getPosition().setX((int) (player.getPosition().getX() + 200 * Gdx.graphics.getDeltaTime()));
        }

        if (movingLeft) {
            player.getPosition().setX((int) (player.getPosition().getX() - 200 * Gdx.graphics.getDeltaTime()));
        }

        if (movingUp) {
            player.getPosition().setY((int) (player.getPosition().getY() - 200 * Gdx.graphics.getDeltaTime()));
        }

        if (movingDown) {
            player.getPosition().setY((int) (player.getPosition().getY() + 200 * Gdx.graphics.getDeltaTime()));
        }


        Vector3 cameraPos = new Vector3(getPosition().getX(), getPosition().getY(), 0);
        cameraPos = camera.unproject(cameraPos);
        hitbox.setPosition(cameraPos.x, cameraPos.y);

        sprite.rotate(angle);
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

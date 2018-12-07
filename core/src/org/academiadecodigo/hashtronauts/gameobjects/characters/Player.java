package org.academiadecodigo.hashtronauts.gameobjects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.gameobjects.weapons.Weapon;
import org.academiadecodigo.hashtronauts.gameobjects.weapons.WeaponGelatin;
import org.academiadecodigo.hashtronauts.utils.Position;

public class Player extends Characters {

    private static Player player = new Player();

    private int score;
    private Weapon weapon;
    private Rectangle hitbox;
    private PlayerEvents playerEvents;

    private Texture activeTexture;
    private Texture textureUp;
    private Texture textureRight;
    private Texture textureDown;
    private Texture textureLeft;

    private boolean movingRight;
    private boolean movingLeft;
    private boolean movingUp;
    private boolean movingDown;
    private float angle;
    private Position mousePos;


    private Player() {
        super(new Position(100, 100));
        this.score = 0;
        //this.weapon = null;
        //this.playerRender = null;

        this.activeTexture = new Texture(GameSettings.QUEEN_FRONT_VIEW);
        this.textureUp = new Texture(GameSettings.QUEEN_FRONT_VIEW);
        this.textureRight = new Texture(GameSettings.QUEEN_RIGHT_VIEW);
        this.textureDown = new Texture(GameSettings.QUEEN_BACK_VIEW);
        this.textureLeft = new Texture(GameSettings.QUEEN_LEFT_VIEW);

        this.hitbox = new Rectangle(getPosition().getX(), getPosition().getY(), GameSettings.PLAYER_WIDTH, -GameSettings.PLAYER_HEIGHT);
        this.playerEvents = new PlayerEvents();
        this.angle = 0;
        this.weapon = new WeaponGelatin();
        this.mousePos = new Position(0,0);

    }


    public static Player getInstance() {
        return player;

    }

    public void shoot(Position touchedPos) {
        System.out.println("x shot: " + touchedPos.getX() + "y shot: " + touchedPos.getY());
        weapon.shoot(touchedPos, position);

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

        batch.draw(activeTexture, hitbox.getX(), hitbox.getY(), GameSettings.PLAYER_WIDTH, GameSettings.PLAYER_HEIGHT);
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

                //System.out.println("mouseX: " + screenX + ", mouseY: " + screenY);

                float calculatedAngle = angle;

                float dX = screenX - (getPosition().getX() + GameSettings.PLAYER_WIDTH/2);
                float dY = (getPosition().getY() + GameSettings.PLAYER_HEIGHT/2) - screenY;
                if ((dX != 0 && dY != 0)) {

                    if (dX >= 0 && dY >= 0) {
                        calculatedAngle = (float) Math.toDegrees(Math.atan(dY / dX));
                    }

                    if (dX < 0 && dY >= 0) {
                        calculatedAngle = (float) (180 + Math.toDegrees(Math.atan(dY / dX)));
                    }

                    if (dX >= 0 && dY < 0) {
                        calculatedAngle = (float) (360 + Math.toDegrees(Math.atan(dY / dX)));
                    }

                    if (dX < 0 && dY < 0) {
                        calculatedAngle = (float) (180 + Math.toDegrees(Math.atan(dY / dX)));
                    }

                    angle = calculatedAngle;

                mousePos.setX(screenX);
                mousePos.setY(screenY);
                }
                return true;

                //return super.mouseMoved(screenX, screenY);
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                Position tochedPos = new Position(screenX, screenY);
                
                if (Gdx.input.isTouched()) {

                    player.shoot(tochedPos);
                    return true;
                }
                return super.mouseMoved(screenX, screenY);
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



        //System.out.println("dX: " + dX);
        //System.out.println("dY: " + dY);




        //System.out.println("y: " + player.getPosition().getY());
        //System.out.println("x: " + player.getPosition().getX());

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
            setTexture(textureRight);
            player.getPosition().setX((int) (player.getPosition().getX() + 200 * Gdx.graphics.getDeltaTime()));
        }

        if (movingLeft) {
            setTexture(textureLeft);
            player.getPosition().setX((int) (player.getPosition().getX() - 200 * Gdx.graphics.getDeltaTime()));
        }

        if (movingUp) {
            setTexture(textureUp);
            player.getPosition().setY((int) (player.getPosition().getY() - 200 * Gdx.graphics.getDeltaTime()));
        }

        if (movingDown) {
            setTexture(textureDown);
            player.getPosition().setY((int) (player.getPosition().getY() + 200 * Gdx.graphics.getDeltaTime()));
        }


        if (angle >= 0 && angle < 45 || angle >= 315 && angle < 360) {
            //texture = new Texture(GameSettings.QUEEN_RIGHT_VIEW);
        }

        Vector3 cameraPos = new Vector3(getPosition().getX(), getPosition().getY(), 0);
        cameraPos = camera.unproject(cameraPos);
        hitbox.setPosition(cameraPos.x, cameraPos.y);

    }

    /**
     * Disposes the Player
     */
    @Override
    public void dispose() {
        textureLeft.dispose();
        textureDown.dispose();
        textureRight.dispose();
        textureUp.dispose();





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

    public void setTexture(Texture texture) {
        this.activeTexture = texture;
    }
}

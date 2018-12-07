package org.academiadecodigo.hashtronauts.gameobjects.characters;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.utils.Position;


public abstract class Enemy extends Characters {
    private Texture enemyImage;
    private Rectangle hitbox;
    private int health;
    private final int VELOCITIY = 1;


    Enemy(EnemyType type, Position position) {
        super(position);
        this.health = type.getHealth();
        enemyImage = new Texture(type.getPath());
        this.hitbox = new Rectangle(position.getX(), position.getY(), GameSettings.ENEMY_THICKNESS, GameSettings.ENEMY_THICKNESS);
    }

    private void checkCol() {

        if (position.getX() <= GameSettings.WALL_THICKNESS) {
            position.setX(GameSettings.WALL_THICKNESS);
        }
        if (position.getX() >= GameSettings.WIDTH - hitbox.width - GameSettings.WALL_THICKNESS) {
            position.setX((int) (GameSettings.WIDTH - hitbox.width - GameSettings.WALL_THICKNESS));
        }
        if (position.getY() <= GameSettings.WALL_THICKNESS) {
            position.setY(GameSettings.WALL_THICKNESS);
        }
        if (position.getY() >= GameSettings.HEIGHT - hitbox.width - GameSettings.WALL_THICKNESS) {
            position.setY((int) (GameSettings.HEIGHT - hitbox.width - GameSettings.WALL_THICKNESS));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(enemyImage, hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }

    @Override
    public void update(Camera camera) {
        if (isDead()) {
            GameObjectContainer.getInstance().removeObject(this);
            dispose();
            return;
        }

        Position playerPos = Player.getInstance().getPosition();

        Position direction;

        float xDiff = playerPos.getX() - position.getX();
        float yDiff = playerPos.getY() - position.getY();


        int calculatedX = 0;
        int calculatedY = 0;

        if (Math.random() > 0.6) {
            calculatedX = (int) (xDiff * 0.04);
        }

        if (Math.random() > 0.6) {
            calculatedY = (int) (yDiff * 0.04);
        }


        direction = new Position(calculatedX, calculatedY);

        position = new Position(position.getX() + (direction.getX()),
                (position.getY() + (direction.getY())));

        checkCol();

        Vector3 screenLocation = new Vector3(position.getX(), position.getY(), 0);

        screenLocation = camera.unproject(screenLocation);

        hitbox.setPosition(screenLocation.x, screenLocation.y);

    }

    @Override
    public void dispose() {
        enemyImage.dispose();
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public void hit(int damage) {
        if (damage > health || health <= 0) {
            health = 0;
        }
        health -= damage;
    }
}
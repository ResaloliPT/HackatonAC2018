package org.academiadecodigo.hashtronauts.gameobjects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.utils.Position;


public abstract class Enemy extends Characters {
    private Texture enemyImage;
    private Rectangle hitbox;
    private int health;


    Enemy(EnemyType type, Position position) {
        super(position);
        this.health = type.getHealth();
        enemyImage = new Texture(type.getPath());
        this.hitbox = new Rectangle(position.getX(), position.getY(), GameSettings.ENEMY_THICKNESS, GameSettings.ENEMY_THICKNESS);
    }

    private void checkCol() {

        if (hitbox.x <= GameSettings.WALL_THICKNESS) {
            hitbox.x = GameSettings.WALL_THICKNESS;
        }
        if (hitbox.x >= GameSettings.WIDTH - hitbox.width - GameSettings.WALL_THICKNESS) {
            hitbox.x = GameSettings.WIDTH - hitbox.width - GameSettings.WALL_THICKNESS;
        }
        if (hitbox.y >= GameSettings.HEIGHT - hitbox.height - GameSettings.WALL_THICKNESS) {
            hitbox.y = GameSettings.HEIGHT;
        }
        if (hitbox.y <= GameSettings.WALL_THICKNESS) {
            hitbox.y = GameSettings.WALL_THICKNESS;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(enemyImage, hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }

    @Override
    public void update(Camera camera) {
        if (isDead()) {
            dispose();
            return;
        }
        final int VELOCITIY = 90;
        Position position = new Position((int) (getPosition().getX() + (VELOCITIY * Gdx.graphics.getDeltaTime())),
                (int) (getPosition().getY() + (VELOCITIY * Gdx.graphics.getDeltaTime())));

        Vector3 vector3 = new Vector3(position.getX(), position.getY(), 0);
        camera.unproject(vector3);
        this.hitbox.setPosition(vector3.x, vector3.y);
        checkCol();
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
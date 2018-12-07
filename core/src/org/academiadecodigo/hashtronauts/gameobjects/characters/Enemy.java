package org.academiadecodigo.hashtronauts.gameobjects.characters;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.utils.Position;


public abstract class Enemy extends Characters {
    private Texture enemyImage;
    private Rectangle hitbox;
    private Position position;
    private EnemyType enemyType;
    private int health;

    public Enemy(EnemyType type, Position position) {
        super(position);
        this.position = position;
        this.enemyType = type;
        this.health = enemyType.getHealth();
        enemyImage = new Texture(type.getPath());
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
        int width = 20;
        int height = 20;
        int y = (int) (GameSettings.HEIGHT - hitbox.height);
        int x = (int) MathUtils.random(GameSettings.WALL_THICKNESS, GameSettings.WIDTH - hitbox.width - GameSettings.WALL_THICKNESS);
        this.hitbox = new Rectangle(x, y, width, height);

        batch.draw(enemyImage, hitbox.x, hitbox.y, enemyImage.getWidth(), enemyImage.getHeight());
    }

    @Override
    public void update(Camera camera) {
        Vector3 vector3 = new Vector3(position.getVector().x, position.getVector().y, 0);
        camera.unproject(vector3);
        if (isDead()) {
            dispose();
            return;
        }
        hitbox.x = 200 * (hitbox.x + Player.getInstance().getPosition().getVector().x);
        hitbox.y = 200 * (hitbox.y + Player.getInstance().getPosition().getVector().y);
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
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public void hit(int damage) {
        health -= damage;
        if (damage > health || health <= 0) {
            health = 0;
        }
    }
}
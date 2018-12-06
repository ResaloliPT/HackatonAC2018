package org.academiadecodigo.hashtronauts.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.hashtronauts.utils.Position;


public abstract class Enemy extends Characters {
    private Texture enemyImage;
    private Rectangle hitbox;
    private int health;
    private Position position;
    private EnemyType enemyType;
    private boolean dead = false;

    public Enemy(EnemyType type, Position position) {
        this.enemyType = type;
        this.position = position;
        enemyImage = new Texture(type.getPath());

    }

    public void move(Position targetPosition) {
        if (isDead()) {
            dispose();
            return;
        }
        int x = (int) (Math.random() + 1) * 10;
        if (x <= 5) {

            hitbox.x = 200 * (hitbox.x + targetPosition.getVector().x) * 2;
            hitbox.y = 200 * (hitbox.y + targetPosition.getVector().y) * 2;
            checkCol();
        }
    }

    private void checkCol() {
        if (hitbox.x <= 0) {
            hitbox.x = 0;
        }
        if (hitbox.x >= 736) {    // 800-64
            hitbox.x = 736;
        }
        if (hitbox.y >= 536) {    //600-64
            hitbox.y = 536;
        }
        if (hitbox.y <= 0) {
            hitbox.y = 0;
        }
    }

    @Override
    public void hit(int damage) {
        health -= damage;
        if (damage > health || health <= 0) {
            setDead(true);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        String enemyImagePath = EnemyType.SOLDIER.getPath();
        enemyImage = new Texture(enemyImagePath);
        batch.draw(enemyImage, hitbox.x, hitbox.y, enemyImage.getWidth(), enemyImage.getHeight());
    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {
        enemyImage.dispose();
    }

    public Texture getEnemyImage() {
        return enemyImage;
    }

    public void setEnemyImage(Texture enemyImage) {
        this.enemyImage = enemyImage;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
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
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}

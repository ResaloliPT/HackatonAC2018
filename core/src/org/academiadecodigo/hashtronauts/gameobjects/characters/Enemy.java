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
    private int health;
    private Position position;
    private EnemyType enemyType;
    private boolean dead = false;

    public Enemy(EnemyType type, Position position) {
        super(position);
        this.position = position;
        this.enemyType = type;
        enemyImage = new Texture(type.getPath());
        hitbox = new Rectangle();

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
    public void render(SpriteBatch batch) {
        String enemyImagePath = EnemyType.SOLDIER.getPath();
        enemyImage = new Texture(enemyImagePath);

        hitbox.width = 20;
        hitbox.height = 20;
        hitbox.y = GameSettings.HEIGHT - hitbox.height;
        hitbox.x = MathUtils.random(GameSettings.HEIGHT - hitbox.width);

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
        int x = (int) (Math.random() + 1) * 10;
        if (x <= 5) {

            hitbox.x = 200 * (hitbox.x + Player.getInstance().getPosition().getVector().x) * 2;
            hitbox.y = 200 * (hitbox.y + Player.getInstance().getPosition().getVector().y) * 2;
            checkCol();
        }
    }

    @Override
    public void dispose() {
        enemyImage.dispose();
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
        return health <= 0;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @Override
    public void hit(int damage) {
        health -= damage;
        if (damage > health || health <= 0){
            health = 0;
        }
    }
}
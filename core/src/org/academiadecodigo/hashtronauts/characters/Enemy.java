package org.academiadecodigo.hashtronauts.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Enemy extends Characters {
    private Texture sprite;
    private Rectangle hitbox;
    private int health;
    private Position position;
    private EnemyType enemyType;
    private boolean dead = false;

    public Enemy(EnemyType type, Position position){
        this.enemyType = type;
        this.position = position;

    }

    public void move(Position targetPosition) {
        if (isDead()) {
            dispose();
            return;
        }
        int x = ((int) Math.random() + 1) * 10;
        if (x <= 5) {
            hitbox.x = 200 * (hitbox.x + targetPosition.getX) * 2;
            hitbox.y = 200 * (hitbox.y + targetPosition.getY) * 2;
        }
    }


    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite, hitbox.x, hitbox.y);
    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {
        sprite.dispose();
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

    @Override
    public void hit(int damage) {
        health -= damage;
        if(damage > health || health <= 0){
            setDead(true);
        }




    }
}
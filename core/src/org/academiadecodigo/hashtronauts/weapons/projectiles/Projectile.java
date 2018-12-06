package org.academiadecodigo.hashtronauts.weapons.projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Ellipse;
import org.academiadecodigo.hashtronauts.Renderable;

public class Projectile implements Renderable {

    //Render
    private Texture sprite;
    private Ellipse shape;

    // Postion & Movement
    private Position position;
    private Position velocity;

    //Projectile properties
    private int damage;

    /**
     * Creates a new Projectile
     *
     * @param projectileType the projectile type
     * @param startingPos    the starting position
     * @param direction      the direction of movement
     */
    public Projectile(ProjectileType projectileType, Position startingPos, Position direction) {
        sprite = new Texture(projectileType.getSpriteURI());
        shape = new Ellipse(startingPos.getX(), startingPos.getY(), sprite.getWidth(), sprite.getHeight());
        this.position = startingPos;
        this.velocity = direction;
        this.damage = projectileType.getDamage();
    }

    public void addObject(MainGame game) {
        game.addObject(this);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite, shape.x, shape.y, shape.width, shape.height);
    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {
        sprite.dispose();
    }
}

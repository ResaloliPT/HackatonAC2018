package org.academiadecodigo.hashtronauts.weapons.projectiles;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Ellipse;
import org.academiadecodigo.hashtronauts.Renderable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    /**
     * Adds this projectile to the Game List to be rendered/updated
     *
     * @param game the game class wich contains the Render/update list
     */
    public void addObject(MainGame game) {
        game.addObject(this);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite, shape.x, shape.y, shape.width, shape.height);
    }

    @Override
    public void update(Camera camera) {
        //TODO: implement to move
        throw new NotImplementedException();
    }

    @Override
    public void dispose() {
        sprite.dispose();
    }
}

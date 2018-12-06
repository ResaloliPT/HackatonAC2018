package org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.hashtronauts.MainGame;
import org.academiadecodigo.hashtronauts.Renderable;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.gameobjects.characters.interfaces.Killable;
import org.academiadecodigo.hashtronauts.utils.Position;

public class Projectile implements Renderable {

    //Render
    private Texture sprite;
    private Ellipse shape;

    // Position & Movement
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
        shape = new Ellipse(startingPos.getVector().x, startingPos.getVector().y, sprite.getWidth(), sprite.getHeight());
        this.position = startingPos;
        this.velocity = direction;
        this.damage = projectileType.getDamage();
    }

    /**
     * Adds this projectile to the Game List to be rendered/updated
     *
     * @param game the game class which contains the Render/update list
     */

    public void addObject() {
        GameObjectContainer.getInstance();
    }

    /**
     * Hits the target then disposes itself
     *
     * @param target the target to be hit
     * @param game   the game containing the render/update list
     */

    public void hit(Killable target, MainGame game) {
        target.hit(damage);
        GameObjectContainer.getInstance().removeObject(this);
        dispose();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite, shape.x, shape.y, shape.width, shape.height);
    }

    @Override
    public void update(Camera camera) {
        Vector3 newCoords = new Vector3(position.getVector().x + velocity.getVector().x, position.getVector().y + velocity.getVector().y, 0);
        newCoords = camera.unproject(newCoords);

        position.setVector(new Vector2(newCoords.x, newCoords.y));
    }

    @Override
    public void dispose() {
        sprite.dispose();
    }
}

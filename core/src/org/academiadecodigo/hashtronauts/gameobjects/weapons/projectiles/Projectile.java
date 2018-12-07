package org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.hashtronauts.MainGame;
import org.academiadecodigo.hashtronauts.Renderable;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.gameobjects.characters.interfaces.Killable;
import org.academiadecodigo.hashtronauts.utils.Position;

public class Projectile implements Renderable {

    //Render
    private Texture sprite;
    private Ellipse shape; // Can be used as Projectile position

    // Position & Movement
    private Position velocity;
    private Position position;

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
        shape = new Ellipse(startingPos.getVector().x, startingPos.getVector().y, 20, 10);

        this.position = startingPos;
        this.velocity = direction;
        this.damage = projectileType.getDamage();
    }

    /**
     * Adds this projectile to the Game List to be rendered/updated
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
        position = new Position((int) (position.getVector().x + (velocity.getVector().x * Gdx.graphics.getDeltaTime())),
                (int) (position.getVector().y + (velocity.getVector().y * Gdx.graphics.getDeltaTime())));


        Vector3 newCoords = new Vector3(position.getVector().x,
                position.getVector().y, 0);


        camera.unproject(newCoords);

        this.shape = this.shape.setPosition(newCoords.x, newCoords.y);
    }

    @Override
    public void dispose() {
        sprite.dispose();
    }
}

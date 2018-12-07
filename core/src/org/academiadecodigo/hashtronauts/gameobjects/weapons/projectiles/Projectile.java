package org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.hashtronauts.Renderable;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.gameobjects.characters.interfaces.Killable;
import org.academiadecodigo.hashtronauts.utils.Position;

public class Projectile implements Renderable {

    //Render
    private Texture sprite;
    private Rectangle hitbox;

    // Position & Movement
    private Position velocity;
    private Position position;

    //Projectile properties
    private int damage;
    private boolean toDispose;

    /**
     * Creates a new Projectile
     *
     * @param projectileType the projectile type
     * @param startingPos    the starting position
     * @param direction      the direction of movement
     */
    public Projectile(ProjectileType projectileType, Position startingPos, Position direction) {
        sprite = new Texture(projectileType.getSpriteURI());
        hitbox = new Rectangle(startingPos.getVector().x, startingPos.getVector().y, 30, 30);

        this.position = new Position(startingPos.getX(), startingPos.getY());
        this.velocity = direction;
        this.damage = projectileType.getDamage();
    }

    /**
     * Adds this projectile to the Game List to be rendered/updated
     */
    public void deleteObject() {
        GameObjectContainer.getInstance().removeObject(this);
    }

    /**
     * Hits the target then disposes itself
     *
     * @param target the target to be hit
     */
    public void hit(Killable target) {
        target.hit(damage);
        toDispose = true;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite, hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }

    @Override
    public void update(Camera camera) {

        position = new Position(position.getX() + velocity.getX(), position.getY() + velocity.getY());

        Vector3 screenLocation = new Vector3(position.getX() + velocity.getX(), position.getY() + velocity.getY(), 0);

        screenLocation = camera.unproject(screenLocation);

        hitbox.setPosition(screenLocation.x, screenLocation.y);

        if ((position.getX() < 0 || position.getX() > GameSettings.WIDTH) ||
                (position.getY() < 0 || position.getY() > GameSettings.HEIGHT)) {
            deleteObject();
            dispose();

        }

    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    @Override
    public void dispose() {
        sprite.dispose();
    }

    public boolean isToDispose() {
        return toDispose;
    }
}

package org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
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

    /**
     * Creates a new Projectile
     *
     * @param projectileType the projectile type
     * @param startingPos    the starting position
     * @param direction      the direction of movement
     */
    public Projectile(ProjectileType projectileType, Position startingPos, Position direction) {
        sprite = new Texture(projectileType.getSpriteURI());
        hitbox = new Rectangle(startingPos.getVector().x, startingPos.getVector().y, 90, 90);

        this.position = startingPos;
        this.velocity = direction;
        this.damage = projectileType.getDamage();
    }

    /**
     * Adds this projectile to the Game List to be rendered/updated
     */
    public void addObject() {
        GameObjectContainer.getInstance().addObject(this);
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
        GameObjectContainer.getInstance().removeObject(this);
        dispose();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite, hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }

    @Override
    public void update(Camera camera) {
        Vector2 newPos = position.getVector().set(position.getX() + (velocity.getX() * Gdx.graphics.getDeltaTime()), position.getY() + (velocity.getY() * Gdx.graphics.getDeltaTime()));
        position.setVector(newPos);

        Vector3 screenLocation = new Vector3(position.getX(), position.getY(), 0);

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
}

package org.academiadecodigo.hashtronauts.gameobjects.characters;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.hashtronauts.Renderable;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.gameobjects.GameObject;
import org.academiadecodigo.hashtronauts.utils.Position;

public class Guillotine extends GameObject {

    private Rectangle hitbox;
    private Texture texture;
    private Position pos;
    private Position startingFall;
    private boolean falling;


    public Guillotine(Position position) {
        this.texture = new Texture("images/projectiles/projectile1.png");
        this.hitbox = new Rectangle(position.getX(), position.getY(), GameSettings.ENEMY_SIZE, GameSettings.ENEMY_SIZE);
        startingFall = new Position(position.getX(), position.getY() + 70);
        this.pos = position;

    }

    public void hit() {
        Player.getInstance().hit(Player.getInstance().getHealth());
    }

    @Override

    public void render(SpriteBatch batch) {
        batch.draw(texture, hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }

    @Override
    public void update(Camera camera) {
        if(startingFall.getY() > pos.getY()) {
            startingFall.setY(startingFall.getY() - 5);
        }
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}

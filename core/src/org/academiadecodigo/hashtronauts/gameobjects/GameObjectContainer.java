package org.academiadecodigo.hashtronauts.gameobjects;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.Renderable;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Enemy;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Player;
import org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles.Projectile;

import java.util.LinkedList;
import java.util.List;

public class GameObjectContainer implements Renderable {

    private static GameObjectContainer instance = new GameObjectContainer();

    private List<Enemy> enemies;
    private List<Projectile> projectiles;
    private Player player;


    private GameObjectContainer() {
        this.player = Player.getInstance();
        this.enemies = new LinkedList<Enemy>();
        this.projectiles = new LinkedList<Projectile>();
    }

    public static GameObjectContainer getInstance() {
        return instance;
    }

    public void addObject(Projectile projectile) {
        projectiles.add(projectile);
    }

    public void addObject(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeObject(Projectile projectile) {
        projectiles.remove(projectile);
    }

    public void removeObject(Enemy enemy) {
        enemies.remove(enemy);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void update(Camera camera) {

    }

    @Override
    public void dispose() {

    }
}

package org.academiadecodigo.hashtronauts.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.Renderable;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
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
    private Sound enemyHit;

    private GameObjectContainer() {
        this.player = Player.getInstance();
        this.enemies = new LinkedList<Enemy>();
        this.projectiles = new LinkedList<Projectile>();
        this.enemyHit = Gdx.audio.newSound(Gdx.files.internal(GameSettings.ENEMY_HIT_SOUND));
    }

    public static GameObjectContainer getInstance() {
        return instance;
    }

    @Override
    public void render(SpriteBatch batch) {

        player.render(batch);

        for (Enemy enemy : enemies) {
            enemy.render(batch);
        }

        for (Projectile projectile : projectiles) {
            synchronized (this) {
                projectile.render(batch);
            }
        }
    }

    @Override
    public void update(Camera camera) {
        player.update(camera);

        for (Enemy enemy : enemies) {
            enemy.update(camera);
        }
            for (Projectile projectile : projectiles) {
                synchronized (this) {
                    projectile.update(camera);
            }
        }
    }

    @Override
    public void dispose() {

    }

    public synchronized void addObject(Projectile projectile) {
        projectiles.add(projectile);
    }

    public synchronized void addObject(Enemy enemy) {
        enemies.add(enemy);
    }

    public synchronized void removeObject(Projectile projectile) {
        projectiles.remove(projectile);
    }

    public synchronized void removeObject(Enemy enemy) {
        enemies.remove(enemy);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

}

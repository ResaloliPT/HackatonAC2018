package org.academiadecodigo.hashtronauts.gameobjects;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import org.academiadecodigo.hashtronauts.Renderable;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Enemy;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Player;
import org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles.Projectile;
import org.academiadecodigo.hashtronauts.utils.Score;

import java.util.LinkedList;
import java.util.List;

public class GameObjectContainer implements Renderable {

    private static GameObjectContainer instance = new GameObjectContainer();

    private volatile List<Enemy> enemies;
    private volatile List<Projectile> projectiles;
    private Player player;
    private Score score;


    private GameObjectContainer() {
        this.player = Player.getInstance();
        this.enemies = new LinkedList<Enemy>();
        this.projectiles = new LinkedList<Projectile>();
        this.score = new Score();
    }

    public static GameObjectContainer getInstance() {
        return instance;
    }

    @Override
    public synchronized void render(SpriteBatch batch) {

        player.render(batch);

        for (Enemy enemy : enemies) {
            enemy.render(batch);
        }

        for (Projectile projectile : projectiles) {
            projectile.render(batch);
        }

        score.draw(batch);

    }

    @Override
    public synchronized void update(Camera camera) {
        player.update(camera);

        for (Enemy enemy : enemies) {
            enemy.update(camera);

            if (Intersector.overlaps(player.getHitbox(), enemy.getHitbox())) {
                player.hit(1);
            }

            for (Projectile projectile : projectiles) {
                projectile.update(camera);


                if (Intersector.overlaps(projectile.getHitbox(), enemy.getHitbox())) {
                    projectile.hit(enemy);
                }

            }

        }


    }

    @Override
    public synchronized void dispose() {

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
        //score.changeScore(enemy.getScore());
        enemies.remove(enemy);
    }

}

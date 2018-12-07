package org.academiadecodigo.hashtronauts.gameobjects;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.Renderable;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Enemy;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Player;
import org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles.Projectile;
import org.academiadecodigo.hashtronauts.utils.Score;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameObjectContainer implements Renderable {

    private static final java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();

    private static GameObjectContainer instance = new GameObjectContainer();

    private volatile List<Enemy> enemies;
    private volatile List<Projectile> projectiles;
    private Player player;
    private Score score;
    private boolean gameOver;
    private long playerTimer = 0;
    private long playerInverubility = 1000;

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
    public void render(SpriteBatch batch) {

        player.render(batch);

        for (Enemy currentEnemy : enemies) {
            currentEnemy.render(batch);
        }

        for (Projectile projectile : projectiles) {
            projectile.render(batch);
        }

        score.draw(batch);
    }

    @Override
    public void update(Camera camera) {
        player.update(camera);


        for (Iterator<Enemy> iterator = enemies.iterator(); iterator.hasNext(); ) {
            Enemy currentEnemy = iterator.next();

            if (currentEnemy.isToDispose()) {

                score.changeScore(currentEnemy.getEnemyScore());

                iterator.remove();
                if (enemies.size() == 0) {
                    gameOver = true;
                }
                continue;
            }

            currentEnemy.update(camera);

            if (Intersector.overlaps(player.getHitbox(), currentEnemy.getHitbox())) {
                long difftime = TimeUtils.millis() - playerTimer;

                if (difftime < playerInverubility) {
                    return;
                }

                playerTimer = TimeUtils.millis();
                player.hit(1)
                ;
            }
        }

        for (Iterator<Projectile> pIterator = projectiles.iterator(); pIterator.hasNext(); ) {
            Projectile currentProjectile = pIterator.next();

            if (currentProjectile.isToDispose()) {
                pIterator.remove();
                continue;
            }

            currentProjectile.update(camera);

            for (Iterator<Enemy> iterator = enemies.iterator(); iterator.hasNext(); ) {
                Enemy currentEnemy = iterator.next();

                if (Intersector.overlaps(currentProjectile.getHitbox(), currentEnemy.getHitbox())) {
                    currentProjectile.hit(currentEnemy);
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
        enemies.remove(enemy);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void reset() {
        for (Iterator<Enemy> iterator = enemies.iterator(); iterator.hasNext(); ) {
            Enemy projectile = iterator.next();

            if (projectile != null) {
                iterator.remove();
            }
        }

        for (Iterator<Projectile> iterator = projectiles.iterator(); iterator.hasNext(); ) {
            Projectile projectile = iterator.next();

            if (projectile != null) {
                iterator.remove();
            }
        }

        gameOver = false;

        score.changeScore(-score.getScore());
    }
}

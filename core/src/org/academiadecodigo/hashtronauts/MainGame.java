package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Player;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Soldier;
import org.academiadecodigo.hashtronauts.menu.GameOverScreen;
import org.academiadecodigo.hashtronauts.utils.Position;

public class MainGame implements Renderable {

    private KillerQueen game;
    private GameObjectContainer gameObjects;

    private double waveCount;

    public MainGame(KillerQueen game) {
        this.gameObjects = GameObjectContainer.getInstance();
        this.game = game;
        waveCount = 0.0;
        startWave();
    }

    @Override
    public void render(SpriteBatch batch) {
        gameObjects.render(batch);
    }

    public void gameOver() {
        game.setScreen(new GameOverScreen(game));
    }

    @Override
    public void update(Camera camera) {
        gameObjects.update(camera);

        if (gameObjects.isGameOver()) {
            startWave();
            return;
        }

        if (Player.getInstance().isDead()) {
            gameOver();
            return;
        }
    }

    private void startWave() {

        GameObjectContainer.getInstance().reset();

        waveCount += 0.05;
        int numOfEnemies = (int) ((Math.random() * (100 * waveCount)) + (50 * waveCount));

        for (int i = 0; i < numOfEnemies; i++) {
            GameObjectContainer.getInstance().addObject(new Soldier(new Position((int) ((Math.random() * GameSettings.WIDTH) + 50), -10)));
        }
    }

    @Override
    public void dispose() {
    }
}

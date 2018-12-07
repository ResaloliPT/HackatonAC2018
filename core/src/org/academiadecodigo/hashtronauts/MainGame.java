package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Player;
import org.academiadecodigo.hashtronauts.menu.GameOverScreen;

public class MainGame implements Renderable {

    private KillerQueen game;
    private GameObjectContainer gameObjects;

    public MainGame(KillerQueen game) {
        this.gameObjects = GameObjectContainer.getInstance();
        this.game = game;
    }

    public GameObjectContainer getGameObjects() {
        return gameObjects;
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
            gameOver();
            return;
        }

        if (Player.getInstance().isDead()) {
            gameOver();
            return;
        }
    }

    @Override
    public void dispose() {
    }
}

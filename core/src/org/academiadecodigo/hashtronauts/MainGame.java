package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.gameobjects.characters.Player;

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


        if (Player.getInstance().isDead()) {
            //game.setScreen(new GameOverScreen());
        }

    }

    @Override
    public void update(Camera camera) {
        gameObjects.update(camera);


        if (Player.getInstance().isDead()) {
            //gameOver();
        }
    }

    @Override
    public void dispose() {
    }
}

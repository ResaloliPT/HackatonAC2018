package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;

public class MainGame implements Renderable {

    private GameObjectContainer gameObjects;

    public MainGame() {
        this.gameObjects = GameObjectContainer.getInstance();
    }

    public GameObjectContainer getGameObjects() {
        return gameObjects;
    }

    @Override
    public void render(SpriteBatch batch) {
        gameObjects.render(batch);
    }

    @Override
    public void update(Camera camera) {
        gameObjects.update(camera);
    }

    @Override
    public void dispose() {
    }
}

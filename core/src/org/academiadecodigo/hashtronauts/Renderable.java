package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Renderable {
    /**
     * Used to Render the resources (Images, Texts, others)
     *
     * @param batch the sprite batch used to render
     */
    void render(SpriteBatch batch);

    /**
     * Used to updates positions & other game logic
     */
    void update();

    /**
     * Used to dispose all resources
     */
    void dispose();
}

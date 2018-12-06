package org.academiadecodigo.hashtronauts.characters.interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Renderable {

    void render(SpriteBatch b);

    void update();

    void dispose();
}

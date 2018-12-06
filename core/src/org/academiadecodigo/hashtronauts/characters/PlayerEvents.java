package org.academiadecodigo.hashtronauts.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;


public class PlayerEvents extends InputAdapter {

    private Player player;

    @Override
    public boolean keyDown(int keycode) {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.getHitbox().x -= 200 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.getHitbox().x += 200 * Gdx.graphics.getDeltaTime() * 2;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.getHitbox().y -= 200 * Gdx.graphics.getDeltaTime() * 2;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.getHitbox().y - += 200 * Gdx.graphics.getDeltaTime() * 2;
        }

        if (player.getHitbox().x < 0) {
            player.getHitbox().x = 0;
        }

        if (player.getHitbox().x > 736) {    // 800-64
            player.getHitbox().x = 736;
        }

        if (player.getHitbox().y < 0) {
            player.getHitbox().y = 0;
        }

        if (player.getHitbox().y > 600) {    // 800-64
            player.getHitbox().y = 600;
        }
    }


        return super.keyDown(keycode);

}

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if ()

        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return super.mouseMoved(screenX, screenY);
    }
}

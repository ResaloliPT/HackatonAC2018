package org.academiadecodigo.hashtronauts.gameobjects.characters;

import com.badlogic.gdx.InputAdapter;
import org.academiadecodigo.hashtronauts.utils.Position;


public class PlayerEvents extends InputAdapter {

    private Player player;
    private Position mousePos;

    /*@Override
    public boolean keyDown(int keycode) {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.getHitbox().se   .setX(player.getHitbox().getX() - 200 * Gdx.graphics.getDeltaTime());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.getHitbox().setX(player.getHitbox().getX() + 200 * Gdx.graphics.getDeltaTime() * 2);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.getHitbox().setY(player.getHitbox().getY() + 200 * Gdx.graphics.getDeltaTime() * 2);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.getHitbox().setY(player.getHitbox().getY() - 200 * Gdx.graphics.getDeltaTime() * 2);
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

        return super.keyDown(keycode);

    }*/




    @Override
    public boolean mouseMoved(int screenX, int screenY) {

        mousePos = new Position(screenX, screenY);
        //player.update();
        return true;

    }

    public Position getMousePos() {
        return mousePos == null ? new Position(0,0) : mousePos;
    }
}

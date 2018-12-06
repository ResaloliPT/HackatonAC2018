package org.academiadecodigo.hashtronauts.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.hashtronauts.utils.Position;

public class Player {

    private static Player player = new Player();

    private int score;
    private Rectangle hitbox;
    private PlayerEvents events;


    private Sprite sprite;



    private Player() {
        super();
        this.score = 0;
        this.sprite = new Sprite(new Texture(""));
    }


    public static Player getInstance() {
        return player;

    }

    public void shoot(Position touchedPos) {


    }


    /**
     * Renders the Player


    private void setEvents() {
        Gdx.input.setInputProcessor(new InputAdapter() {
        });
    }


    /**
     * Updates the Player position



    }

    /**
     * Disposes the Player
     */




    public Texture getSprite() {
        return null;
    }

    public void setSprite(Texture sprite) {
        this.sprite = null;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void update(Position mousePos) {
    }
}

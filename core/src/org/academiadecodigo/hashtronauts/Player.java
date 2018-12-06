package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player extends Character {

    private int score;
    private Weapon weapon;
    private SpriteBatch spriteBatch;
    private ShapeRenderer playerRender;


    public Player() {
        this.score = 0;
        this.weapon = null;
        this.spriteBatch = null;
        this.playerRender = null;
    }

    public Projectile shoot() {

        return new Projectile(Weapon weapon);
    }

    public void move() {

    }

    public void update() {

    }

    public void render() {
        playerRender.rect(0,0, 50, 50);

    }
}

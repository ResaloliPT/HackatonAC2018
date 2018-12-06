package org.academiadecodigo.hashtronauts.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public enum EnemyType {
    SOLDIER(5,"images/enemies/enemies.png"),
    KING(20,"images/enemies/enemies.png");

    private int health;
    private String path;

    EnemyType(int enemyHealth, String imagePath) {
        this.health = enemyHealth;
        this.path = imagePath;

    }

    public int getHealth() {
        return this.health;
    }

    public String getPath() {
        return path;
    }
}

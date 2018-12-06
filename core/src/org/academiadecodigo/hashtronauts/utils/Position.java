package org.academiadecodigo.hashtronauts.utils;

import com.badlogic.gdx.math.Vector2;

public class Position {

    private Vector2 vector;

    public Position(int x, int y) {
        this.vector = new Vector2((float) x, (float) y);
    }

    public Vector2 getVector() {
        return vector;
    }

    public void setVector(Vector2 vector) {
        this.vector = vector;
    }

    public int getX() {
        return (int) vector.x;
    }

    public int getY() {
        return (int) vector.y;
    }
}

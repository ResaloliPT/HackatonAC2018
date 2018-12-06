package org.academiadecodigo.hashtronauts.characters;

import org.academiadecodigo.hashtronauts.characters.interfaces.Killable;
import org.academiadecodigo.hashtronauts.characters.interfaces.Renderable;

public abstract class Characters implements Killable, Renderable {

    private int health;
    private Position;

    //Getters and Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    /**
     * Sees if the character is still alive
     *
     * @return True if the Character is alive
     */
    @Override
    public boolean isDead() {
        return getHealth() < 0;
    }
}




package org.academiadecodigo.hashtronauts.gameobjects.characters;

import org.academiadecodigo.hashtronauts.Renderable;
import org.academiadecodigo.hashtronauts.gameobjects.characters.interfaces.Killable;
import org.academiadecodigo.hashtronauts.utils.Position;

public abstract class Characters implements Killable, Renderable {

    protected int health;
    protected Position position;

    public Characters(Position position){
        this.position = position;
    }

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
        return getHealth() <= 0;
    }

    public Position getPosition() {
        return position;
    }
}




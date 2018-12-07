package org.academiadecodigo.hashtronauts.gameobjects.characters.interfaces;

public interface Killable {


    /**
     * Sees if the class that implements the interface is dead
     *
     * @return true if dead
     */
    boolean isDead();


    /**
     * @param damage The damage to be done to implemented Class
     */
    void hit(int damage);
}

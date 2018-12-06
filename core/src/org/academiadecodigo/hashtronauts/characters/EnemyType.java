package org.academiadecodigo.hashtronauts.characters;

public enum EnemyType {
    SOLDIER(5),
    King(20);

    private int health;

    EnemyType(int i) {
        this.health = i;

    }

    public int getHealth() {
        return this.health;
    }
}

package org.academiadecodigo.hashtronauts.characters;

public enum EnemyType {
    SOLDIER(5),
    King(20);

    private int health;

    EnemyType(int enemyHealth) {
        this.health = enemyHealth;

    }

    public int getHealth() {
        return this.health;
    }
}

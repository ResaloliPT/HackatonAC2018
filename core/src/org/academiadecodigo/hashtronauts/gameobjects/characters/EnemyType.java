package org.academiadecodigo.hashtronauts.gameobjects.characters;

public enum EnemyType {
    SOLDIER(3, "images/enemies/enemies.png",1),
    KING(20, "images/enemies/enemies.png",5);

    private int health;
    private String path;
    private int points;

    EnemyType(int enemyHealth, String imagePath, int points) {
        this.health = enemyHealth;
        this.path = imagePath;
        this.points = points;
    }

    public int getHealth() {
        return this.health;
    }

    public String getPath() {
        return path;
    }

    public int getPoints() {
        return points;
    }
}

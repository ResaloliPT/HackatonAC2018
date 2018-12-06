package org.academiadecodigo.hashtronauts.weapons.projectiles;

public enum ProjectileType {
    Gelatin("images/projectiles/gelatin.png", 1);

    private String spriteURI;
    private int damage;

    ProjectileType(String spriteURI, int damage) {
        this.spriteURI = spriteURI;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getSpriteURI() {
        return spriteURI;
    }
}

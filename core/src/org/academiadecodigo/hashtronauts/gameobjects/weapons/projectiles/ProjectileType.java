package org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles;

import static org.academiadecodigo.hashtronauts.configs.GameSettings.PROJECTILE_CAKE_IMAGE;

public enum ProjectileType {
    CAKE(PROJECTILE_CAKE_IMAGE, 1);

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

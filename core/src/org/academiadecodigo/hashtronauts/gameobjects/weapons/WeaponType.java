package org.academiadecodigo.hashtronauts.gameobjects.weapons;

import org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles.ProjectileType;

public enum WeaponType {
    GELATIN(ProjectileType.Gelatin);

    ProjectileType projectileType;

    WeaponType(ProjectileType projectileType) {
        this.projectileType = projectileType;
    }

    public ProjectileType getBulletType() {
        return this.projectileType;
    }
}

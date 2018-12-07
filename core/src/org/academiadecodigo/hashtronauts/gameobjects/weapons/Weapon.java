package org.academiadecodigo.hashtronauts.gameobjects.weapons;

import com.badlogic.gdx.Gdx;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles.Projectile;
import org.academiadecodigo.hashtronauts.utils.Position;

public abstract class Weapon {

    private WeaponType weaponType;

    public Weapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void shoot(Position touchedPos, Position position) {
        Position direction;

        int xDiff = touchedPos.getX() - position.getX();
        int yDiff = touchedPos.getY() - position.getY();

        int xThreeSimpleCalc = ((100 * GameSettings.PROJECTILE_GELATIN_SPEED) / xDiff);
        int yThreeSimpleCalc = ((100 * GameSettings.PROJECTILE_GELATIN_SPEED) / yDiff);

        direction = new Position((int) ((xThreeSimpleCalc * xDiff) * Gdx.graphics.getDeltaTime()), (int) ((yThreeSimpleCalc * yDiff) * Gdx.graphics.getDeltaTime()));

        Projectile projectile = new Projectile(weaponType.getBulletType(), position, direction);

        GameObjectContainer.getInstance().addObject(projectile);
    }
}

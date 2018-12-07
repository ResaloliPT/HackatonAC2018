package org.academiadecodigo.hashtronauts.gameobjects.weapons;

import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles.Projectile;
import org.academiadecodigo.hashtronauts.utils.Position;

public abstract class Weapon {

    private WeaponType weaponType;
    private long timer = 0;
    private long shootTime = 350;

    public Weapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public synchronized void shoot(Position touchedPos, Position position) {

        long difftime = TimeUtils.millis() - timer;

        if (difftime < shootTime) {
            return;
        }

        timer = TimeUtils.millis();


        Position direction;

        float xDiff = touchedPos.getX() - position.getX();
        float yDiff = touchedPos.getY() - position.getY();

        int calculatedX = (int) (xDiff * GameSettings.PROJECTILE_GELATIN_SPEED);
        int calculatedY = (int) (yDiff * GameSettings.PROJECTILE_GELATIN_SPEED);


        direction = new Position(calculatedX, calculatedY);

        Projectile projectile = new Projectile(weaponType.getBulletType(), position, direction);

        GameObjectContainer.getInstance().addObject(projectile);
    }
}

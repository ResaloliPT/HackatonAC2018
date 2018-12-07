package org.academiadecodigo.hashtronauts.gameobjects.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.configs.GameSettings;
import org.academiadecodigo.hashtronauts.gameobjects.GameObjectContainer;
import org.academiadecodigo.hashtronauts.gameobjects.weapons.projectiles.Projectile;
import org.academiadecodigo.hashtronauts.utils.Position;

public abstract class Weapon {

    private WeaponType weaponType;
    private long timer = 0;
    private long shootTime = 500;
    private Sound shootfx;

    public Weapon(WeaponType weaponType) {
        this.shootfx = Gdx.audio.newSound(Gdx.files.internal(GameSettings.SHOOTING_SOUND));
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

        int calculatedX = (int) (xDiff * GameSettings.PROJECTILE_CAKE_SPEED);
        int calculatedY = (int) (yDiff * GameSettings.PROJECTILE_CAKE_SPEED);


        direction = new Position(calculatedX, calculatedY);

        Projectile projectile = new Projectile(weaponType.getBulletType(), position, direction);
        shootfx.play();

        GameObjectContainer.getInstance().addObject(projectile);
    }
}

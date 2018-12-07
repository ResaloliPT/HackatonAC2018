package org.academiadecodigo.hashtronauts.characters;

import org.academiadecodigo.hashtronauts.gameobjects.characters.Enemy;
import org.academiadecodigo.hashtronauts.gameobjects.characters.EnemyType;
import org.academiadecodigo.hashtronauts.utils.Position;

public class Soldier  extends Enemy {

    public Soldier(Position position) {
        super(EnemyType.SOLDIER, position);
    }
}

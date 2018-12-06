package org.academiadecodigo.hashtronauts.characters;

public abstract class Characters implements Killable implements Renderable{

    private int health;
    private int score;
    private Position;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /** Sees if the character is still alive
     * @return True if the Character is alive
     */
    @Override
    public boolean isDead() {
        return getHealth() < 0;
    }
}


}

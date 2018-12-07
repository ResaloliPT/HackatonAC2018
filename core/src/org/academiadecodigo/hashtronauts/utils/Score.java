package org.academiadecodigo.hashtronauts.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.configs.GameStrings;

public class Score {

    private BitmapFont scoreText;
    private Integer score;

    public Score() {
        score = 0;
        scoreText = Fonts.COLLEGE.getFont();
    }

    public void draw(SpriteBatch batch) {
        scoreText.draw(batch, GameStrings.SCORE_BASE_STRING + score, 50, Gdx.graphics.getHeight() - (scoreText.getCapHeight()));
    }

    public Integer changeScore(Integer enemyScore) {
        this.score += enemyScore;
        return score;
    }

    public Integer getScore() {
        return score;
    }

    public void dispose() {
        scoreText.dispose();
    }

}

package br.com.alura.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.engine.Sound;
import br.com.alura.jumper.graphic.Color;

public class Score {

    private static final Paint WHITE = Color.getScoreColor();
    private int points = 0;
    private Sound sound;

    public Score(Sound sound) {
        this.sound = sound;
    }

    public void drawIn(Canvas canvas) {
        canvas.drawText(String.valueOf(points), 100, 100, WHITE);
    }

    public void increment() {
        points++;
        sound.play(Sound.SCORE);
    }
}

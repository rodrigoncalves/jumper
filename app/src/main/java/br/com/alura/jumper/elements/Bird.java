package br.com.alura.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.R;
import br.com.alura.jumper.engine.Sound;
import br.com.alura.jumper.graphic.Color;
import br.com.alura.jumper.graphic.Screen;

public class Bird {

    public static final float X = 100;
    public static final int RADIUS = 50;
    private static final Paint RED = Color.getBirdColor();
    private final Screen screen;
    private final Bitmap bird;
    private float height;
    private Sound sound;

    public Bird(Screen screen, Context context, Sound sound) {
        this.sound = sound;
        this.height = 100;
        this.screen = screen;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.bird = Bitmap.createScaledBitmap(bitmap, RADIUS * 2, RADIUS * 2, false);
    }

    public void drawIn(Canvas canvas) {
//        canvas.drawCircle(X, height, RADIUS, RED);
        canvas.drawBitmap(bird, X - RADIUS, height - RADIUS, null);
    }

    public void fall() {
        boolean atTheGround = height + RADIUS > screen.getHeight();
        if (!atTheGround) this.height += 5;
    }

    public void jump() {
        if (height > RADIUS) {
            sound.play(Sound.JUMP);
            this.height -= 150;
        }
    }

    public float getHeight() {
        return height;
    }
}

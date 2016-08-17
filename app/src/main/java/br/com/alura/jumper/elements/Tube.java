package br.com.alura.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.R;
import br.com.alura.jumper.graphic.Color;
import br.com.alura.jumper.graphic.Screen;

public class Tube {

    private static final Paint GREEN = Color.getTubeColor();
    private static final int TUBE_SIZE = 250;
    private static final int TUBE_WIDTH = 100;
    private final int superiorHeight;
    private final int inferiorHeight;
    private int pos;
    private Screen screen;
    private final Bitmap superiorTube;
    private final Bitmap inferiorTube;

    public Tube(Screen screen, int pos, Context context) {
        this.screen = screen;
        this.pos = pos;
        this.superiorHeight = TUBE_SIZE + randomValue();
        this.inferiorHeight = screen.getHeight() - TUBE_SIZE - randomValue();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        this.superiorTube = Bitmap.createScaledBitmap(bitmap, TUBE_WIDTH, superiorHeight, false);
        this.inferiorTube = Bitmap.createScaledBitmap(bitmap, TUBE_WIDTH, inferiorHeight, false);
    }

    private int randomValue() {
        return (int) (Math.random() * 150);
    }

    public void drawIn(Canvas canvas) {
        drawSuperiorTubeIn(canvas);
        drawInferiorTubeIn(canvas);
    }

    private void drawSuperiorTubeIn(Canvas canvas) {
//        canvas.drawRect(pos, 0, pos + TUBE_WIDTH, superiorHeight, GREEN);
        canvas.drawBitmap(superiorTube, pos, 0, null);
    }

    private void drawInferiorTubeIn(Canvas canvas) {
//        canvas.drawRect(pos, inferiorHeight, pos + TUBE_WIDTH, screen.getHeight(), GREEN);
        canvas.drawBitmap(inferiorTube, pos, inferiorHeight, null);
    }

    public void move() {
        this.pos -= 5;
    }

    public boolean outOfScreen() {
        return pos + TUBE_WIDTH < 0;
    }

    public int getPos() {
        return pos;
    }

    public boolean hasHorizontalCollisionWith(Bird bird) {
        return this.pos < bird.X + bird.RADIUS;
    }

    public boolean hasVerticalCollisionWith(Bird bird) {
        return this.superiorHeight > bird.getHeight() - bird.RADIUS ||
               this.inferiorHeight < bird.getHeight() + bird.RADIUS;
    }
}

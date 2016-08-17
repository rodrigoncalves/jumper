package br.com.alura.jumper.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;

public class Color {

    public static Paint getBirdColor() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        return paint;
    }

    public static Paint getTubeColor() {
        Paint paint = new Paint();
        paint.setColor(0xFF00FF00);
        return paint;
    }

    public static Paint getScoreColor() {
        Paint paint = new Paint();
        paint.setColor(0xFFFFFFFF);
        paint.setTextSize(80);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(3, 5, 5, 0xFF000000);
        return paint;
    }

    public static Paint getGameOverColor() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        paint.setTextSize(50);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(2, 3, 3, 0xFF000000);
        return paint;
    }
}

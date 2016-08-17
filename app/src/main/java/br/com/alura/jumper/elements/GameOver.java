package br.com.alura.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import br.com.alura.jumper.graphic.Color;
import br.com.alura.jumper.graphic.Screen;

public class GameOver {
    private static final Paint RED = Color.getGameOverColor();
    private Screen screen;

    public GameOver(Screen screen) {
        this.screen = screen;
    }

    public void drawIn(Canvas canvas) {
        String text = "Game Over";
        int textInCenter = centerText(text);
        canvas.drawText(text, textInCenter, screen.getHeight()/2, RED);
    }

    private int centerText(String text) {
        Rect rect = new Rect();
        RED.getTextBounds(text, 0, text.length(), rect);
        return screen.getWidth()/2 - (rect.right - rect.left)/2;
    }
}

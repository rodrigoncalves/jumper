package br.com.alura.jumper.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.alura.jumper.graphic.Screen;

public class Tubes {

    private static final int DISTANCE_BETWEEN_TUBES = 400;
    private static final int TUBES_QTY = 5;
    private final List<Tube> tubes = new ArrayList<>();
    private final Context context;
    private Screen screen;
    private Score score;

    public Tubes(Screen screen, Score score, Context context) {
        this.screen = screen;
        this.score = score;
        this.context = context;

        int pos = 400;
        for (int i = 0; i < TUBES_QTY; i++) {
            pos += DISTANCE_BETWEEN_TUBES;
            Tube tube = new Tube(screen, pos, this.context);
            tubes.add(tube);
        }
    }

    public void drawIn(Canvas canvas) {
        for (Tube tube : tubes) {
            tube.drawIn(canvas);
        }
    }

    public void move() {
        ListIterator<Tube> it = tubes.listIterator();
        while (it.hasNext()) {
            Tube tube = it.next();
            tube.move();
            if (tube.outOfScreen()) {
                score.increment();
                it.remove();
                Tube otherTube = new Tube(screen, getMax() + DISTANCE_BETWEEN_TUBES, context);
                it.add(otherTube);
            }
        }
    }


    public int getMax() {
        int max = 0;
        for (Tube tube : tubes) {
            max = Math.max(tube.getPos(), max);
        }

        return max;
    }

    public boolean hasCollisionWith(Bird bird) {
        for (Tube tube : tubes) {
            if (tube.hasHorizontalCollisionWith(bird) &&
                tube.hasVerticalCollisionWith(bird)) {
                return true;
            }
        }
        return false;
    }
}

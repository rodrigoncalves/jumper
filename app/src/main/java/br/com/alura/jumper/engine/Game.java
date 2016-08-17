package br.com.alura.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.alura.jumper.R;
import br.com.alura.jumper.elements.Bird;
import br.com.alura.jumper.elements.GameOver;
import br.com.alura.jumper.elements.Score;
import br.com.alura.jumper.elements.Tubes;
import br.com.alura.jumper.graphic.Screen;

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Bird bird;
    private Bitmap background;
    private Screen screen;
    private Tubes tubes;
    private Score score;
    private Context context;
    private Sound sound;

    public Game(Context context) {
        super(context);
        this.context = context;
        this.screen = new Screen(context);
        this.sound = new Sound(context);

        setOnTouchListener(this);
        init();
    }

    private void init() {
        bird = new Bird(screen, context, sound);
        score = new Score(sound);
        tubes = new Tubes(screen, score, context);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back, back.getWidth(), screen.getHeight(), false);
    }

    @Override
    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            // draw components
            canvas.drawBitmap(background, 0, 0, null);
            bird.drawIn(canvas);
            bird.fall();
            tubes.drawIn(canvas);
            tubes.move();
            score.drawIn(canvas);

            if (new CollisionVerifier(bird, tubes).hasCollision()) {
                new GameOver(screen).drawIn(canvas);
                isRunning = false;
                sound.play(Sound.COLLISION);
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void start() {
        isRunning = true;
    }

    public void pause() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        bird.jump();
        return false;
    }
}
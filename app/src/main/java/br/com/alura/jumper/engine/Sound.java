package br.com.alura.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import br.com.alura.jumper.R;

public class Sound {

    private final SoundPool soundPool;
    public static int JUMP;
    public static int SCORE;
    public static int COLLISION;

    public Sound(Context context) {
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        JUMP = soundPool.load(context, R.raw.pulo, 1);
        SCORE = soundPool.load(context, R.raw.pontos, 1);
        COLLISION = soundPool.load(context, R.raw.colisao, 1);
    }

    public void play(int sound) {
        soundPool.play(sound, 1, 1, 1, 0, 1);
    }
}

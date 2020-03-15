package com.example.mystopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private Button startButton;
    private Button stopButton;
    private ChronoState state;
    private ImageView anchor;
    private Animation anchorAnimation;

    public StopWatchActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_watch_act);

        //Initialization
        chronometer = findViewById(R.id.chrono);
        startButton = findViewById(R.id.btn_start);
        stopButton = findViewById(R.id.btn_stop);
        anchor = findViewById(R.id.ivAnchor);

        state = ChronoState.STOPPED;
        startButton.setTranslationY(100f);
        stopButton.setAlpha(0f);

        chronometer.setBase(SystemClock.elapsedRealtime());

    }

    // start the chronometer
    public void startTimer(View view) {
        if (state != ChronoState.RUNNING) {
            chronometer.start();
            onStartAnimation();
            state = ChronoState.RUNNING;
        }
    }

    // stop the chronometer
    public void finishTimer(View view) {
        if (state != ChronoState.STOPPED) {
            chronometer.stop();
            onStopAnimation();
            state = ChronoState.STOPPED;
        }
    }


    //animation when start button clicked
    public void onStartAnimation() {
        anchorAnimation = AnimationUtils.loadAnimation(this, R.anim.anchor_anim);
        anchor.startAnimation(anchorAnimation);
        startButton.animate().translationYBy(-100).setDuration(300).setInterpolator(new AccelerateDecelerateInterpolator());
        stopButton.animate().alpha(1f).setDuration(200);
    }

    //animation when stop button clicked
    public void onStopAnimation() {
        anchor.clearAnimation();
        startButton.animate().translationYBy(100).setDuration(300);
        stopButton.animate().alpha(0f).setDuration(200);
    }

    private enum ChronoState {RUNNING, STOPPED}
}

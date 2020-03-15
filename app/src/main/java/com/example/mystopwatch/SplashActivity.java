package com.example.mystopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private Button splashButton;
    private ImageView splashIv;
    private TextView headerTv;
    private TextView subTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_act);

        //Initialization
        splashButton = findViewById(R.id.bSplash);
        splashIv = findViewById(R.id.ivSplash);
        headerTv = findViewById(R.id.tvSplash);
        subTv = findViewById(R.id.tvSubSplash);

        startSplashAnimation();

    }

    private void startSplashAnimation () {
        //animate image
        Animation ivAnimation = AnimationUtils.loadAnimation(this, R.anim.iv_anim);
        splashIv.startAnimation(ivAnimation);

        //animate button
        Animation buAnimation = AnimationUtils.loadAnimation(this, R.anim.bu_anim);
        splashButton.startAnimation(buAnimation);

        //animate text
        Animation tvAnimation = AnimationUtils.loadAnimation(this, R.anim.tv_anim);
        headerTv.startAnimation(tvAnimation);
        subTv.startAnimation(tvAnimation);

    }

    public void getStarted(View view) {
        Intent intent = new Intent(this, StopWatchActivity.class);
        startActivity(intent);
    }
}

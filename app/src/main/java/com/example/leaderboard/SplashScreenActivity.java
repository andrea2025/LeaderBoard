package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {
    private  static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);  requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        } else {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }
}

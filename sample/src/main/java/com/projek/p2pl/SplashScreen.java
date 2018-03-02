package com.projek.p2pl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

public class SplashScreen extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                        Intent mainIntent = new Intent(SplashScreen.this, Main2Activity.class);
                        SplashScreen.this.startActivity(mainIntent);
                        SplashScreen.this.finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);



    }
}

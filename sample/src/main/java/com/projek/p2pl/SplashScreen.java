package com.projek.p2pl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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
                if(isNetworkAvailable()){
                    Toast.makeText(SplashScreen.this, "Internet Availabel", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SplashScreen.this, "Internet Not Available", Toast.LENGTH_SHORT).show();
                }
                Intent mainIntent = new Intent(SplashScreen.this, LoginActivity.class);
                        SplashScreen.this.startActivity(mainIntent);
                        SplashScreen.this.finish();

                    }
                }, SPLASH_DISPLAY_LENGTH);



    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

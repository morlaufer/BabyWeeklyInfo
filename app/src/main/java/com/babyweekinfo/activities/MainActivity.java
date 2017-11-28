package com.babyweekinfo.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mork.babyweekinfo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Comments", "onCreate");
    }

    protected void onStart(){
        super.onStart();
        final String PREFS_NAME = "MyPrefsFile";

        int TIME_OUT = 4000;
        Log.d("Comments", "onStart");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                if (settings.getBoolean("first_boot", true)) {
                    //the app is being launched for first time, do something
                    Log.d("Comments", "First time");
                    // first time task

                    // record the fact that the app has been started at least once
                    settings.edit().putBoolean("first_boot", false).commit();

                    Intent i = new Intent(MainActivity.this, com.babyweekinfo.activities.settings.class);
                    startActivity(i);
                    finish();

                }
                else
                {
                    Log.d("Comments", "not First time");
                    Intent i = new Intent(MainActivity.this, Options.class);
                    startActivity(i);
                    finish();
                }

            }
        }, TIME_OUT);


    }

    //woohoo
    //hello
}

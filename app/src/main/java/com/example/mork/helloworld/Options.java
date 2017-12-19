package com.example.mork.helloworld;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Log.d("Comments", "Entered  Options activity");

        SharedPreferences settings = getSharedPreferences(getResources().getString(R.string.PREFS_NAME), 0);
        Toast.makeText(getApplicationContext(), "name: " + settings.getString("name",null) + " gender: " +
                settings.getString("gender",null) + " date of birth : " + settings.getString("date",null), Toast.LENGTH_SHORT).show();
    }

}

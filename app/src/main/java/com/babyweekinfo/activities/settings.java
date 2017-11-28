package com.babyweekinfo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mork.babyweekinfo.R;

public class settings extends AppCompatActivity {


    String baby_name = "";
    String baby_date = "";
    String baby_gender = "";
    Button submit;

    EditText name,dateOfBirth,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Log.d("Comments", "Entered  settings activity");


        name= (EditText) findViewById(R.id.nameEditText);
        dateOfBirth = (EditText) findViewById(R.id.dateEditText);
        gender = (EditText) findViewById(R.id.genderEditText);

        name.setHint("Baby name");
        dateOfBirth.setHint("Date of Birth");
        gender.setHint("Gender");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || dateOfBirth.getText().toString().isEmpty() || gender.getText().toString().isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "Enter the Data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Name -  " + name.getText().toString() + " \n" + "Date of Birth -  " + dateOfBirth.getText().toString()
                            + " \n" + "Gender -  " + gender.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });



//        final String PREFS_NAME = "MyPrefsFile";
//        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//
//        baby_name = settings.getString("name",null);
//        name.setText(baby_name);
//
//        baby_date = settings.getString("date",null);
//        dateOfBirth.setText(baby_date);
//
//        baby_gender = settings.getString("gender",null);
//        gender.setText(baby_gender);


    }
}

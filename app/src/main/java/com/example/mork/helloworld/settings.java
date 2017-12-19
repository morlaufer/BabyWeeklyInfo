package com.example.mork.helloworld;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.DatePicker;
import java.util.Calendar;
import android.view.View.OnClickListener;
public class settings extends AppCompatActivity {


    private String baby_name = "";
    private String baby_date = "";
    private String baby_gender = "";
    private RadioGroup radioGroup;
    private DatePicker dpResult;

    private Button btnChangeDate;
    private int year, month, day;
    static final int DATE_DIALOG_ID = 999;

    EditText name,dateOfBirth,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Log.d("Comments", "Entered  settings activity");
        setCurrentDateOnView();

        name= (EditText) findViewById(R.id.nameEditText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGender);

        //dateOfBirth = (EditText) findViewById(R.id.dateEditText);
        Button submit = (Button)findViewById(R.id.submitButton);
        Log.d("Comments", "Entered  settings activity2222");
        name.setHint("Baby name");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast msg;
                if (name.getText().toString().isEmpty()   ) {
                    Toast.makeText(getApplicationContext(), "No name entered", Toast.LENGTH_SHORT).show();
                } else {
                    //get gender
                    Button sexButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

                    //get date of birth

                    String date = "" + (month + 1) + "-" + day + "-" + year;

                    Log.d("Comments",  "Name -  " + name.getText().toString() + " \n" +
                            "gender - " + sexButton.getText() + "Birth date - " + date);

                    SharedPreferences settings = getSharedPreferences(getString(R.string.PREFS_NAME), 0);

                    // save name, birthday and gender in shared pref
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("name", name.getText().toString());
                    editor.putString("gender", sexButton.getText().toString());
                    editor.putString("date", date);
                    editor.commit();

                   // Toast.makeText(getApplicationContext(), "name: " + settings.getString("name",null) + " gender: " +
                     //       settings.getString("gender",null) + " date of birth : " + settings.getString("date",null), Toast.LENGTH_SHORT).show();



                    Intent i = new Intent(settings.this, Options.class);
                    startActivity(i);
                    finish();

;
                }
            }
        });

    }

    // display current date
    public void setCurrentDateOnView() {

        dpResult = (DatePicker) findViewById(R.id.datePicker);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into datepicker
        dpResult.init(year, month, day, null);

    }



    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into datepicker also
            dpResult.init(year, month, day, null);

        }
    };
}

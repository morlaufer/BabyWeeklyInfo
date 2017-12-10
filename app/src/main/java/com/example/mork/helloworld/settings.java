package com.example.mork.helloworld;

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
        addListenerOnDateButton();



        name= (EditText) findViewById(R.id.nameEditText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGender);


        //dateOfBirth = (EditText) findViewById(R.id.dateEditText);
        Button submit = (Button)findViewById(R.id.submitButton);
        Log.d("Comments", "Entered  settings activity2222");
        name.setHint("Baby name");
//        dateOfBirth.setHint("Date of Birth");
       // gender.setHint("Gender");

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

                        Toast.makeText(getApplicationContext(), "Name -  " + name.getText().toString() + " \n" +
                                "gender - " + sexButton.getText()  , Toast.LENGTH_SHORT).show();

;
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

    public void addListenerOnDateButton(){
        btnChangeDate = (Button) findViewById(R.id.btnChangeDate);

//continue here!

    }
}

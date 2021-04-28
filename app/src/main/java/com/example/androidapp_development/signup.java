package com.example.androidapp_development;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class signup extends AppCompatActivity {
    private Button button, datePick;


//for date picker
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    EditText et_fName, et_lName,et_email,et_desc, et_occu;
    TextView textView;

    public static final String ExtraName = "com.example.androidapp_development.Extraname";
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //Assign variable
        textView=findViewById(R.id.date);
        et_email=findViewById(R.id.email);
        et_lName =findViewById(R.id.lname);
        et_fName=findViewById(R.id.fname);
        datePick=(Button)findViewById(R.id.datePickerButton);
        AwesomeValidation awesomeValidation;
        //set currentdate
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String currentDateandTime = sdf.format(new Date());
        textView.setText(currentDateandTime);

        button = (Button) findViewById(R.id.signup);
        //Initalize valadation

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //validation add
        awesomeValidation.addValidation(this,R.id.fname, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.lname, RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.errormessge);
        awesomeValidation.addValidation(this, R.id.description,  RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.occupation,  RegexTemplate.NOT_EMPTY,R.string.invalid_name);



        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(awesomeValidation.validate()) {
                    //on success
                    openResultActivity();
                }
                else {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "This a positioned toast message",
                            Toast.LENGTH_LONG);

                    t.setGravity(Gravity.BOTTOM | Gravity.RIGHT,0,0);
                    t.show();

                }

            }
        });


        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);

    }
    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);

    }
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {


            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);

            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_DEVICE_DEFAULT_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }
    private String makeDateString(int day, int month, int year)
    {
        return month + "/ " + day + "/ " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }


    private void openResultActivity() {
        //Pass fIrst name
        EditText firstName = (EditText) findViewById(R.id.fname);
        String username = firstName.getText().toString();
        Intent intent = new Intent(this, result.class);
        intent.putExtra("fn", username);

//pass last name
        EditText lastName = (EditText) findViewById(R.id.lname);
        String userlname = lastName.getText().toString();
        Intent intent2 = new Intent(this, result.class);
        intent2.putExtra("ln", userlname);


        //Description
        EditText desc = (EditText) findViewById(R.id.description);
        String usesrDescription = desc.getText().toString();
        Intent intent_desc = new Intent(this, result.class);
        intent_desc.putExtra("des", usesrDescription);


        //Description
        EditText occ = (EditText) findViewById(R.id.occupation);
        String userOccupation  = desc.getText().toString();
        Intent intent_Occ = new Intent(this, result.class);
        intent_desc.putExtra("oc", userOccupation);

        @SuppressLint("WrongViewCast") Button age =findViewById((R.id.datePickerButton));
        String  birthDate= age.getText().toString();
        Intent intentAge =new Intent(this, result.class);
        intentAge.putExtra("ag", birthDate);

        startActivity(intent);
    }


}
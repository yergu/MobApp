
package com.example.androidapp_development;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class signup1 extends AppCompatActivity {

    //for passing from Activity to frgment




    //for date picker
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private int age;
    EditText et_fName, et_lName,et_email,et_desc, et_occu;
    TextView textView;
    private FragmentManager manager;

     //public static final String ExtraName = "com.example.androidapp_development.Extraname";
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        //For Tab

        myPagerAdapter myPagerAdapter = new myPagerAdapter(this,getSupportFragmentManager());
        ViewPager viewPager =findViewById(R.id.view_pager);
        viewPager.setAdapter(myPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        //End of Tab
        //Passing profile data to activity to profile Fragment



        //End profile Faragment

        //Assign variable
        textView=findViewById(R.id.date);
        et_email=findViewById(R.id.email);
        et_lName =findViewById(R.id.lname);
        et_fName=findViewById(R.id.fname);
        Button datePick = (Button) findViewById(R.id.datePickerButton);
        et_desc=findViewById(R.id.description);
        et_occu=findViewById(R.id.occupation);
        AwesomeValidation awesomeValidation;
        //set currentdate
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String currentDateandTime = sdf.format(new Date());
        textView.setText(currentDateandTime);

        Button button = findViewById(R.id.signup);
        Button button2 = findViewById(R.id.signupf);
        //Initalize valadation

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //validation add
        awesomeValidation.addValidation(this, R.id.fname, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        //adding validation to firstname invalid char
        awesomeValidation.addValidation(this, R.id.fname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.lname, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.lname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.errormessge);
        awesomeValidation.addValidation(this, R.id.description,  RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.occupation,  RegexTemplate.NOT_EMPTY, R.string.invalid_name);


        //on click bent send datas to fragment

button2.setOnClickListener(view -> {
    if(awesomeValidation.validate()) {
        sendDataToFragment();
    }
    else
    {
        Toast t = Toast.makeText(getApplicationContext(),
                "This a positioned toast message",
                Toast.LENGTH_LONG);

        t.setGravity(Gravity.BOTTOM | Gravity.RIGHT,0,0);
        t.show();
    }
});
//send data to result activity



        button.setOnClickListener(view -> {
            if(awesomeValidation.validate()) {
                //on success
                openResultActivity();
            }
            else
            {
                Toast t = Toast.makeText(getApplicationContext(),
                        "This a positioned toast message",
                        Toast.LENGTH_LONG);

                t.setGravity(Gravity.BOTTOM | Gravity.RIGHT,0,0);
                t.show();
            }

        });
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);

    }

//method to pass data to profile mgt
public void sendDataToFragment() {
    //Pass fIrst name
    EditText firstName = findViewById(R.id.fname);
    String userName = firstName.getText().toString();
//pass last name
    //Description
    EditText desc = findViewById(R.id.description);
    String usesrDescription = desc.getText().toString();

    //Occupation
    EditText occ = findViewById(R.id.occupation);
    String userOccupation  = occ.getText().toString();
    //email
    EditText emailadd = findViewById(R.id.email);
    String em_add  = emailadd.getText().toString();

    Bundle args= new Bundle();

    args.putString("Name",userName);
    args.putString("Description ",usesrDescription);
    args.putString("Occcupation ",userOccupation);
    args.putString("Email ",em_add);
    //PASS OVER THE BUNDLE TO OUR FRAGMENT
    profileFragment fragment = new profileFragment();
    fragment.setArguments(args);
    //THEN NOW SHOW OUR FRAGMENT
    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();


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

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }


    private void openResultActivity() {
        //Pass fIrst name
        Bundle bundle= new Bundle();
        EditText firstName = findViewById(R.id.fname);
        String username = firstName.getText().toString();
        Intent intent = new Intent(this, result1.class);
        bundle.putString("fn", username);
        intent.putExtras(bundle);

//pass last name
        //Description
        EditText desc = findViewById(R.id.description);
        String usesrDescription = desc.getText().toString();

        bundle.putString("des", usesrDescription);
        intent.putExtras(bundle);

        //Occupation
        EditText occ = findViewById(R.id.occupation);
        String userOccupation  = occ.getText().toString();
        bundle.putString("oc", userOccupation);
        intent.putExtras(bundle);

        //email
        EditText emailadd =  (EditText) findViewById(R.id.email);
        String em_add  = emailadd.getText().toString();
        bundle.putString("em", em_add);
        intent.putExtras(bundle);

        // @SuppressLint("WrongViewCast") Button age =findViewById((R.id.datePickerButton));
        //  String  birthDate= age.getText().toString();

   /*     Intent intentAge =new Intent(this, result.class);
        intentAge.putExtra("ag", birthDate);
        intent.putExtra("ag", birthDate);*/

        startActivity(intent);
    }
    /*private void openResultActivity() {
        //Pass fIrst name

        EditText firstName = findViewById(R.id.fname);
        String username = firstName.getText().toString();
        Intent intent = new Intent(this, result.class);
        intent.putExtra("fn", username);

//pass last name
        //Description
        EditText desc = findViewById(R.id.description);
        String usesrDescription = desc.getText().toString();
        intent.putExtra("des", usesrDescription);

        //Occupation
        EditText occ = findViewById(R.id.occupation);
        String userOccupation  = occ.getText().toString();
        intent.putExtra("oc", userOccupation);

        //email
        EditText emailadd =  (EditText) findViewById(R.id.email);
        String em_add  = emailadd.getText().toString();
        intent.putExtra("em", em_add);

       // @SuppressLint("WrongViewCast") Button age =findViewById((R.id.datePickerButton));
      //  String  birthDate= age.getText().toString();

   *//*     Intent intentAge =new Intent(this, result.class);
        intentAge.putExtra("ag", birthDate);
        intent.putExtra("ag", birthDate);*//*

        startActivity(intent);
    }*/


}
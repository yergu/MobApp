package com.example.androidapp_development.assignment2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.androidapp_development.R;

import java.time.LocalDate;

public class signup2MainActivity extends AppCompatActivity {
    private EditText nameField, userDescription, emailField, dobField;
    private Button signupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_new);

        nameField = (EditText) findViewById(R.id.name);
        userDescription = (EditText) findViewById(R.id.description);
        emailField = (EditText) findViewById(R.id.email);
        dobField = (EditText) findViewById(R.id.dob);
        signupBtn = (Button) findViewById(R.id.submit);
        dobField.setOnClickListener(view -> {
            dobField.setTextColor(Color.parseColor("black"));
            LocalDate lDate = LocalDate.now();
            new DatePickerDialog(signup2MainActivity.this,(view1, year, month, dayOfMonth) -> {
                String dob = (month+1)+"/"+dayOfMonth+"/"+year;
                dobField.setText(dob);
            },lDate.getYear(), lDate.getMonthValue()-1, lDate.getDayOfMonth() ).show();
        });
        AwesomeValidation awesomeValidation;

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //validation add
        awesomeValidation.addValidation(this, R.id.name, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        //adding validation to firstname invalid char
        awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.errormessge);
        awesomeValidation.addValidation(this, R.id.description,  RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        signupBtn.setOnClickListener(view->{
            String name = nameField.getText().toString();
            String desc = userDescription.getText().toString();
            String email = emailField.getText().toString();
            String dob = dobField.getText().toString();
            if(dob != null && !dob.isEmpty())
            {
                String[] dobArr = dob.split("/");
                LocalDate dateOfBirth = LocalDate.of(Integer.parseInt(dobArr[2]),Integer.parseInt(dobArr[0]), Integer.parseInt(dobArr[1]));
                if(dateOfBirth.isAfter(LocalDate.now().minusYears(18))){
                    dobField.setTextColor(Color.parseColor("red"));
                    Toast.makeText(signup2MainActivity.this,"You're too young!", Toast.LENGTH_LONG).show();
                }

                else if(!(awesomeValidation.validate()))

                {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "This a positioned toast message",
                            Toast.LENGTH_LONG);

                    t.setGravity(Gravity.BOTTOM | Gravity.RIGHT,0,0);
                    t.show();
                }

                else {
                    Intent intent = new Intent(this, result2Activity.class);
                    intent.putExtra("username", name);
                    startActivity(intent);
                    nameField.setText("");
                    userDescription.setText("");
                    emailField.setText("");
                    dobField.setText("");
                }
            }
            else {
                Toast.makeText(signup2MainActivity.this,"Please enter your date of birth", Toast.LENGTH_LONG).show();
            }
        });
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, MainFragment.newInstance())
//                    .commitNow();
//        }
    }
}
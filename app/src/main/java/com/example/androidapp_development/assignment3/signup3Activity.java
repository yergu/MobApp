package com.example.androidapp_development.assignment3;

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

public class signup3Activity extends AppCompatActivity {

    private EditText nameField, ageField, descriptionField, emailaddress, occupationField;
    private Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment3);

        nameField = (EditText) findViewById(R.id.name);
        descriptionField = (EditText) findViewById(R.id.description);
        ageField = (EditText) findViewById(R.id.age);
        emailaddress =findViewById(R.id.emailadd);
        occupationField = (EditText) findViewById(R.id.occupation);
        signupBtn = (Button) findViewById(R.id.create_profile);
        AwesomeValidation awesomeValidation;
       // ImageView imageView =(ImageView)findViewById(R.id.profile_image);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //validation add
        awesomeValidation.addValidation(this, R.id.name, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        //adding validation to firstname invalid char
        awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.emailadd, Patterns.EMAIL_ADDRESS, R.string.errormessge);
        awesomeValidation.addValidation(this, R.id.description,  RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.occupation,  RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        signupBtn.setOnClickListener(view->{
            String name = nameField.getText().toString();
            String description = descriptionField.getText().toString();
            String age = ageField.getText().toString();
            String occupation = occupationField.getText().toString();
            String email= emailaddress.getText().toString();


            if(age != null && !age.isEmpty()){
                if(Integer.parseInt(age) < 18){
                    ageField.setTextColor(Color.parseColor("red"));
                    Toast.makeText(signup3Activity.this,"You should be above 18!", Toast.LENGTH_LONG).show();
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
                    Intent intent = new Intent(this, Profile3_Activity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("description", description);
                    intent.putExtra("occupation", occupation);
                    intent.putExtra("age", age);
              //     intent.putExtra("email_Add", email);
                    intent.putExtra("picId", R.drawable.cat);
                    startActivity(intent);
                    nameField.setText("");
                    ageField.setText("");
                    descriptionField.setText("");
                    occupationField.setText("");
                }
            }
            else {
                Toast.makeText(signup3Activity.this,"Please enter your age", Toast.LENGTH_LONG).show();
            }
        });
    }
}
package com.example.androidapp_development.assignment4;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.androidapp_development.R;
import com.example.androidapp_development.assignment6.FirestoreUtil;
import com.example.androidapp_development.assignment6.LocationService;
import com.example.androidapp_development.assignment6.SettingsRepository;

public class Assignment4Signup extends AppCompatActivity {

    private EditText nameField, ageField, descriptionField, occupationField;
    private Button signupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment3);

        nameField = (EditText) findViewById(R.id.name);
        descriptionField = (EditText) findViewById(R.id.description);
        ageField = (EditText) findViewById(R.id.age);
        occupationField = (EditText) findViewById(R.id.occupation);
        ImageView profileImageView = findViewById(R.id.profile_image);
        signupBtn = (Button) findViewById(R.id.create_profile);

        signupBtn.setOnClickListener(view->{
            String name = nameField.getText().toString();
            String description = descriptionField.getText().toString();
            String age = ageField.getText().toString();
            String occupation = occupationField.getText().toString();
            AwesomeValidation awesomeValidation;

            awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
            //validation add
            awesomeValidation.addValidation(this, R.id.name, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
            //adding validation to firstname invalid char
            awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.invalid_name);
            ;
            awesomeValidation.addValidation(this, R.id.emailadd, Patterns.EMAIL_ADDRESS, R.string.errormessge);

            awesomeValidation.addValidation(this, R.id.description,  RegexTemplate.NOT_EMPTY, R.string.invalid_Description);
            awesomeValidation.addValidation(this, R.id.occupation,  RegexTemplate.NOT_EMPTY, R.string.invalid_Occupation);
            if(age != null && !age.isEmpty()){
                if(Integer.parseInt(age) < 18) {
                    ageField.setTextColor(Color.parseColor("red"));
                    Toast.makeText(Assignment4Signup.this, "You're too young!", Toast.LENGTH_LONG).show();
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
                    Intent intent = new Intent(this, Signup4Activity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("description", description);
                    intent.putExtra("occupation", occupation);
                    intent.putExtra("age", age);
                    intent.putExtra("picId", R.drawable.cat);

                   // Bundle img = getIntent().getExtras();
                  //int imgID = img.getInt("profImage");
                    startActivity(intent);
                    nameField.setText("");
                    ageField.setText("");
                    descriptionField.setText("");
                    occupationField.setText("");
                }
            }
            else {
                Toast.makeText(Assignment4Signup.this,"Please enter your age", Toast.LENGTH_LONG).show();
            }
        });
        LocationService.init(this);
        new Thread(()-> {
            FirestoreUtil.initData();
            SettingsRepository.init(getApplicationContext());
        }).start();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            LocationService.init(this);
        }



    }

}
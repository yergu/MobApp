package com.example.androidapp_development.assignment3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidapp_development.R;

public class Profile3_Activity extends AppCompatActivity {
    TextView nameView, descriptionView, ageView, occupationView;
    Button backBtn;
    ImageView profileImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String occupation = getIntent().getStringExtra("occupation");
        String age = getIntent().getStringExtra("age");
        Bundle bundle =getIntent().getExtras();


        nameView = findViewById(R.id.profile_name);
        descriptionView = findViewById(R.id.profile_description);
        ageView = findViewById(R.id.profile_age);
        occupationView = findViewById(R.id.profile_occupation);
        backBtn = findViewById(R.id.profile_backBtn);
        profileImageView = findViewById(R.id.profile_image2);
    //    profileImageView.setImageDrawable(getDrawable(R.mipmap.profile_image_round));
        nameView.setText(name);
        descriptionView.setText(description);
        occupationView.setText(occupation);
        ageView.setText(age+" years");
        if(bundle!=null) {

            int resid = bundle.getInt("picId");

            profileImageView.setImageResource(resid);
        }

        backBtn.setOnClickListener(view->{finish();});
    }
}
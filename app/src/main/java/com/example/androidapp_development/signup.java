package com.example.androidapp_development;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class signup extends AppCompatActivity {
    private Button button;
    public static final String ExtraName = "com.example.androidapp_development.Extraname";
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TextView textView=findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String currentDateandTime = sdf.format(new Date());
        textView.setText(currentDateandTime);

        button = (Button) findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openResultActivity();

            }
        });

    }

    private void openResultActivity() {
        EditText firstName = (EditText) findViewById(R.id.fname);
        String username = firstName.getText().toString();
        Intent intent = new Intent(this, result.class);
        intent.putExtra(ExtraName, username);
        startActivity(intent);
    }


}
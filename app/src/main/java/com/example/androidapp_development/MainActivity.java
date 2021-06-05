package com.example.androidapp_development;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


    }
    public void onButtonClick(View view)
    {
        TextView txtHelloWorld= findViewById(R.id.txtHello);
        EditText edtTxtFname = findViewById(R.id.edtTxtFname);

        txtHelloWorld.setText( "Hi " + edtTxtFname.getText().toString());
    }
}
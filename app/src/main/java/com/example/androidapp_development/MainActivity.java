package com.example.androidapp_development;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onButtonClick(View view)
    {
        TextView txtHelloWorld= findViewById(R.id.txtHello);
        EditText edtTxtFname = findViewById(R.id.edtTxtFname);

        txtHelloWorld.setText( "Hi " + edtTxtFname.getText().toString());
    }
}
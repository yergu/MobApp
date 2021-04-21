package com.example.androidapp_development;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


                Intent intent =getIntent();
                String name=intent.getStringExtra(signup.ExtraName);
                TextView textname = (TextView) findViewById(R.id.fname2);
                textname.setText("Thanks for Signing Up " + name+"!");
            }

}
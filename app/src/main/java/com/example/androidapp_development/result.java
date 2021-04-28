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
                String name=intent.getStringExtra("fn");


                Intent intentl=getIntent();
                        String l_name= intentl.getStringExtra("ln");


        Intent intent3=getIntent();
        String D_name= intent3.getStringExtra("des");

        Intent intent4=getIntent();
        String Occup= intent3.getStringExtra("oc");


        Intent intent5=getIntent();
        String age_1= intent3.getStringExtra("ag");


        TextView textname = (TextView) findViewById(R.id.fname2);






                textname.setText("Name "+name+" "+l_name+"/n");
            }

}
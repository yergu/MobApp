package com.example.androidapp_development;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class result extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        openSignAppActivity();


                Intent intent =getIntent();

                String name=intent.getStringExtra("fn");
                String l_name= intent.getStringExtra("ln");
                String age= intent.getStringExtra("ag");
                String descreption= intent.getStringExtra("des");
                String Occ= intent.getStringExtra("oc");
                String email= intent.getStringExtra("em");


        TextView textname = (TextView) findViewById(R.id.fname2);
        TextView u_age = (TextView) findViewById(R.id.age);
        TextView u_des = (TextView) findViewById(R.id.desc);
        TextView u_occup = (TextView) findViewById(R.id.occ);
        TextView u_email = (TextView) findViewById(R.id.emailaddress);



            textname.setText("Name : "+name+" "+l_name);
            u_age.setText("Age:"+age);
            u_des.setText(descreption);
            u_occup.setText("Occupation :"+Occ);
            u_email.setText("Email Adress :"+email);

            }

    private void openSignAppActivity()
    {
        Button backSignup= (Button)findViewById(R.id.signupagain) ;
        backSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(result.this,signup.class);
                startActivity(intent);
            }
        });
    }



}

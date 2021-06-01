package com.example.androidapp_development;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class result1 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_result1);
            openSignAppActivity();


            Intent intent =getIntent();
//retrive data
            String name=intent.getStringExtra("fn");
            String l_name= intent.getStringExtra("ln");
           // String age= intent.getStringExtra("ag");
            String descreption= intent.getStringExtra("des");
            String Occ= intent.getStringExtra("oc");
            String email= intent.getStringExtra("em");


            TextView textname = (TextView) findViewById(R.id.fname2);
           // TextView u_age = (TextView) findViewById(R.id.age);
            TextView u_des = (TextView) findViewById(R.id.desc);
            TextView u_occup = (TextView) findViewById(R.id.occ);
            TextView u_email = (TextView) findViewById(R.id.emailaddress);



            textname.setText(getString(R.string.firstnmae) + name + " " + l_name);
           // u_age.setText(getString(R.string.age)+age);
            u_des.setText(descreption);
            u_occup.setText("Occupation :"+Occ);
            u_email.setText("Email Adress :"+email);
//pass data to fragment using bundle
           Bundle bundle =new Bundle();
           bundle.putString("Name",name);
           //bundle.putString("Lname",l_name);
           bundle.putString("Desc",descreption);
           bundle.putString("Occ",Occ);
           bundle.putString("Email",email);

            profileFragment myfragment =new profileFragment();
            myfragment.setArguments(bundle);
           Intent i = new Intent(getApplicationContext(), result1.class);
            i.putExtras(bundle);
            startActivity(i);


        }

        private void openSignAppActivity()
        {
            Button backSignup= (Button)findViewById(R.id.signupagain) ;
            backSignup.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent = new Intent(result1.this, signup1.class);
                    startActivity(intent);
                }
            });
        }



    }
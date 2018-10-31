package com.lodabiergarten.lodabiergarten;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




public class SecondActivity extends AppCompatActivity {

     EditText Username;
     EditText Password;
     EditText Fname;
     EditText Lname;
     EditText Age;
     EditText Zipcode;
     Button Actualsignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Username = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Fname = (EditText) findViewById(R.id.etFname);
        Lname = (EditText) findViewById(R.id.etLname);
        Age = (EditText) findViewById(R.id.etAge);
        Zipcode = (EditText) findViewById(R.id.etZipcode);
        Actualsignup = (Button) findViewById(R.id.btnActualsignup);
        //SIGNUP PAGE CASTS


    }

    public void onSignup(View view) {

        String str_username = Username.getText().toString();
        String str_password = Password.getText().toString();
        String str_fname = Fname.getText().toString();
        String str_lname = Lname.getText().toString();
        String str_age = Age.getText().toString();
        String str_zipcode = Zipcode.getText().toString();
        String type = "signup";

        BackgroundWorker backgroundworker = new BackgroundWorker(this); //takes the context from backgroundworker.java
        backgroundworker.execute(type,str_username, str_password,str_fname, str_lname, str_age, str_zipcode);
    }


        }





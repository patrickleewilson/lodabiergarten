package com.lodabiergarten.lodabiergarten;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;





public class SecondActivity extends AppCompatActivity {

    private EditText Fname;
    private EditText Lname;
    private EditText Age;
    private EditText Zipcode;
    private Button Actualsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Fname = (EditText) findViewById(R.id.etFname);
        Lname = (EditText) findViewById(R.id.etLname);
        Age = (EditText) findViewById(R.id.etAge);
        Zipcode = (EditText) findViewById(R.id.etZipcode);
        Actualsignup = (Button) findViewById(R.id.btnActualsignup);
        //SIGNUP PAGE CASTS


    }


        }





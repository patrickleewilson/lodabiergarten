package com.lodabiergarten.lodabiergarten;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

import com.lodabiergarten.lodabiergarten.activities.BeerList;

public class MainActivity extends AppCompatActivity {




    private EditText Username;
    private EditText Password;
    private Button Login;
    private Button Signup;
    private Button List;
    //LOGIN VARIABLES DECLARED



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        Signup = (Button) findViewById(R.id.btnSignup);
        List = (Button) findViewById(R.id.btnList);
        //LOGIN CASTS
    }
    public void OnLogin(View view) {

        String user_name = Username.getText().toString();
        String pass_word = Password.getText().toString();
        String type = "login";

        BackgroundWorker backgroundworker = new BackgroundWorker(this); //takes the context from backgroundworker.java
        backgroundworker.execute(type,user_name, pass_word);
        startActivity(new Intent(getApplication(),HomePage.class));

        }

    public void OpenSignup(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void OpenList(View view) {
        startActivity(new Intent(this, BeerList.class));
    }
    }







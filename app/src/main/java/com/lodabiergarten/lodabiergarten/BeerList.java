package com.lodabiergarten.lodabiergarten;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;



public class BeerList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      //  JsonView list = new JsonView();
        //list.jsonParse();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }





        );

//        final WebView webView = (WebView) findViewById(R.id.web);//R.id.web from your layout file
//        webView.loadUrl("http://google.com/");
        //new things
//
//        String clientId = "jarvisossa@yahoo.com";
//        String clientSecret = "ShTdpKYVxTGzAWrSN4KB\n" +
//                "\n";
//
//        Untappd untappd = new Untappd(clientId, clientSecret);
//
//        Brewery brewery = null;
//        try {
//            brewery = untappd.getBrewery(459);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(brewery.getBreweryName());
//        System.out.println(brewery.getBeerCount());

    }
    }


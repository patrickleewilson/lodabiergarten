package com.lodabiergarten.lodabiergarten;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import java.io.IOException;
import br.com.thiagomoreira.untappd.Untappd;
import br.com.thiagomoreira.untappd.model.Brewery;
import retrofit2.http.GET;
import retrofit2.http.Path;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;



public class BeerList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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


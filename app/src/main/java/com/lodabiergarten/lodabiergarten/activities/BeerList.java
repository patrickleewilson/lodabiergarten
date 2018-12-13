package com.lodabiergarten.lodabiergarten.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lodabiergarten.lodabiergarten.R;
import com.lodabiergarten.lodabiergarten.adapters.RecyclerViewAdapter;
import com.lodabiergarten.lodabiergarten.model.Beer;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeerList extends AppCompatActivity {
    private String URL_JSON = "https://business.untappd.com/api/v1/menus/1361?full=true";
    private JsonArrayRequest ArrayRequest;
    private RequestQueue requestQueue;

    private List<Beer> FirstBeer = new ArrayList<>();
    private RecyclerView myrv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_list);
        myrv = findViewById(R.id.recyclerviewid);
        requestQueue = Volley.newRequestQueue(BeerList.this);
        jsoncall();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void jsoncall() {


        String url = "https://business.untappd.com/api/v1/menus/1361?full=true";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONObject jsonObject1 = response.getJSONObject("menu");
                    JSONArray jsonArray1 = jsonObject1.getJSONArray("sections");


                    for (int i = 0; i < jsonArray1.length(); i++) {
                        JSONObject employee = jsonArray1.getJSONObject(i);

                        JSONArray jArray = employee.getJSONArray("items");
                        for (int j = 0; j < jArray.length(); j++) {
                            JSONObject jOBJNEW = jArray.getJSONObject(j);

                            String beer_name = jOBJNEW.getString("name");
                            String beer_rating = jOBJNEW.getString("rating").substring(0, 4)
                                    + "/5";
                            String beer_image = jOBJNEW.getString("label_image");
                            String beer_description = jOBJNEW.getString("original_description");
                     //       beer.setBeerName(jOBJNEW.getString("name"));
                     //       beer.setRating(jOBJNEW.getString("rating"));


                         //   Beer beer = new Beer(beer_name, beer_rating, beer_image);
                            Beer beer = new Beer(beer_name, beer_description, beer_rating);
                            beer.setImage_url(beer_image);

                            FirstBeer.add(beer);


                        }


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
              //  Toast.makeText(BeerList.this, "Size of List " + String.valueOf(FirstBeer.size()), Toast.LENGTH_SHORT).show();//  Toast.makeText(BeerList.this, FirstBeer.get(1).toString(), Toast.LENGTH_SHORT).show();


                setRvadapter(FirstBeer);
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String credentials = "jarvisossa@yahoo.com:ShTdpKYVxTGzAWrSN4KB";
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }
        };




      //  requestQueue = Volley.newRequestQueue(BeerList.this);
        requestQueue.add(request); //ArrayRequest
    }


    public void setRvadapter(List<Beer> lst) {

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lst);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);


    }

}


/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    */
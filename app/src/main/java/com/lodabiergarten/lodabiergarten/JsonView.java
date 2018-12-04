package com.lodabiergarten.lodabiergarten;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonView extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_view);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
            }
        });
    }


    private void jsonParse() {

        String url = "https://business.untappd.com/api/v1/menus/1361?full=true";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
<<<<<<< HEAD
                //RelativeLayout layout = (RelativeLayout)findViewById(R.id.beerLayout);
=======
>>>>>>> patricks_branch

                try {
                    JSONObject jsonObject1 = response.getJSONObject("menu");
                    JSONArray jsonArray1 = jsonObject1.getJSONArray("sections");
                   // JSONArray jsonArray2 = response.getJSONArray("items");
                  //  JSONArray jsonArray = response.getJSONArray("custom_menus");

                    for (int i = 0; i < jsonArray1.length(); i++) {
                        JSONObject employee = jsonArray1.getJSONObject(i);

                        JSONArray jArray = employee.getJSONArray("items");
                        for (int j = 0; j < jArray.length(); j++)
                        {
                            JSONObject jOBJNEW = jArray.getJSONObject(j);

                            String firstName = jOBJNEW.getString("name");
                            String label_image = jOBJNEW.getString("label_image");
                            String rating = jOBJNEW.getString("rating");
                            mTextViewResult.append(firstName + "\n" + label_image + "\n" + rating);

                        }


<<<<<<< HEAD
                   //     String firstName = employee.getString("name");

                   //     mTextViewResult.append(firstName + "\n");
=======

>>>>>>> patricks_branch

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
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

        mQueue.add(request);
    }
}

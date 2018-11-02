package com.example.rob.crimedetailsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://data.police.uk/api/crimes-at-location?date=2017-02&location_id=884227";

        apiCall(url);
    }

    void apiCall(String url){
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("usTwo", String.valueOf("Error"));            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
        rQueue.add(request);
    }

    void parseJsonData(String jsonString) {
        try {
              JSONArray arr = new JSONArray(jsonString);
              Log.d("usTwo", jsonString);

        } catch (JSONException e) {
            Log.d("usTwo", e.getMessage());
            e.printStackTrace();
        }
    }

    }

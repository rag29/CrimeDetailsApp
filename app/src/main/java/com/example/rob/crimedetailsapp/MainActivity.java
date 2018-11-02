package com.example.rob.crimedetailsapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    double longitude;
    double latitude;

    String crimesInLondonURL = "https://data.police.uk/api/crimes-no-location?category=all-crime&force=leicestershire&date=2018-08";
    String crimesAtMyLocationURL = "https://data.police.uk/api/crimes-at-location?date=2017-02&location_id=884227";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String url = "https://data.police.uk/api/crimes-no-location?category=all-crime&date=2018-08";

//        String url ="https://data.police.uk/api/crimes-at-location?date=2018-08" + "lat=" + String.valueOf(latitude) + "&lng=" + String.valueOf(longitude);

//        String url = "https://data.police.uk/api/crimes-no-location?category=all-crime&force=leicestershire&date=2018-08";
//
//        apiCall(url);

//        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//            return;
//        }else{
//            // Write you code here if permission already given.
//            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            if(location != null) {
//                longitude = location.getLongitude();
//                latitude = location.getLatitude();
//
//                String url ="https://data.police.uk/api/crimes-at-location?date=2018-08" + "lat=" + String.valueOf(latitude) + "&lng=" + String.valueOf(longitude);
//
//                apiCall(url);
//            }
//        }

        Button londonButton = findViewById(R.id.crimesInLondonButton);
        Button myLocationButton = findViewById(R.id.crimesAtMyLocationButton);

        londonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiCall(crimesInLondonURL);
            }
        });

        myLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiCall(crimesAtMyLocationURL);
            }
        });

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
                Log.d("usTwo", volleyError.getMessage());            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
        rQueue.add(request);
    }

    void parseJsonData(String jsonString) {
        try {
              JSONArray arr = new JSONArray(jsonString);
              int lengthOfArray = arr.length();
              ArrayList<CrimeDetails> crimeDetailsList = new ArrayList<CrimeDetails>();

              for(int i = 0; i < lengthOfArray; i++){
                  CrimeDetails crimeDetails = new CrimeDetails();
                  JSONObject jsonObject = arr.getJSONObject(i);
                  Log.d("usTwo", "whole object =" + jsonObject.toString());

                  if(jsonObject.getString("month") != null) {
                      crimeDetails.setDate(jsonObject.getString("month"));
                      Log.d("usTwo", "date=" + crimeDetails.getDate());
                  }

                  if(!jsonObject.isNull("location")) {
                      crimeDetails.setLatitude(jsonObject.getJSONObject("location").getString("latitude"));
                      Log.d("usTwo", "latitude=" + crimeDetails.getLatitude());
                  }

                  if(!jsonObject.isNull("location")) {
                      crimeDetails.setLongitude(jsonObject.getJSONObject("location").getString("longitude"));
                      Log.d("usTwo", "longitude=" + crimeDetails.getLongitude());
                  }

                  if(!jsonObject.isNull("location")) {
                      crimeDetails.setStreetName(jsonObject.getJSONObject("location").getJSONObject("street").getString("name"));
                      Log.d("usTwo", "street name=" + crimeDetails.getStreetName());
                  }

                  if(!jsonObject.isNull("location")) {
                      crimeDetails.setLocationId(jsonObject.getJSONObject("location").getJSONObject("street").getString("id"));
                      Log.d("usTwo", "location id=" + crimeDetails.getLocationId());
                  }

                  if(jsonObject.getString("category") != null) {
                      crimeDetails.setCategory(jsonObject.getString("category"));
                      Log.d("usTwo", "category=" + crimeDetails.getCategory());
                  }

                  if(jsonObject.getJSONObject("outcome_status").getString("category") != null) {
                      crimeDetails.setOutcome(jsonObject.getJSONObject("outcome_status").getString("category"));
                      Log.d("usTwo", "outcome=" + crimeDetails.getOutcome());
                  }

                  if(jsonObject.getJSONObject("outcome_status").getString("date") != null) {
                      crimeDetails.setDateOfOutcome(jsonObject.getJSONObject("outcome_status").getString("date"));
                      Log.d("usTwo", "outcome date=" + crimeDetails.getDateOfOutcome());
                  }

                  crimeDetailsList.add(crimeDetails);
              }

              Log.d("usTwo", jsonString);

        } catch (JSONException e) {
            Log.d("usTwo", e.getMessage());
            e.printStackTrace();
        }
    }

    }

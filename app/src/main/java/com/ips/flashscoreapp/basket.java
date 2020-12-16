package com.ips.flashscoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;


public class basket extends AppCompatActivity implements DFJLHttp.AsyncResponse {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        new DFJLHttp(this).execute("http://192.168.1.72/get/getBasketGames.php");

    }

    @Override
    public void processFinish(JSONArray output) throws JSONException {
        Log.v("abcde", output.get(0).toString());
        Log.v("abcde", output.getJSONObject(0).getString("games"));
    }
}


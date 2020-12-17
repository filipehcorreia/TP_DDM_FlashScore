package com.ips.flashscoreapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;


public class foot extends AppCompatActivity implements DFJLHttp.AsyncResponse {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot);

        new DFJLHttp(this).execute("http://192.168.1.72/get/getFutGames.php");

    }

    @Override
    public void processFinish(JSONArray output) throws JSONException {

       Log.v("abcde", output.getJSONObject(0).toString());   // Liga num 0
        Log.v("abcde", "a__________________________");

        Log.v("abcde", output.getJSONObject(0).getString("games"));  // jogos da liga num 0
        Log.v("abcde", "b__________________________");


        String arrayGamesCleaned =  output.getJSONObject(0).getString("games");   // clean array dos jogos da liga 0
        arrayGamesCleaned=arrayGamesCleaned.substring(1,arrayGamesCleaned.length()-1);


        JSONArray js = new JSONArray(arrayGamesCleaned);
        Log.v("abcde", String.valueOf(js.getJSONObject(0).get("home_team")));    //objeto do array da liga 0 jogo 0 limpo
        Log.v("abcde", "c__________________________");

        String arrayGamesInfoCleaned =  String.valueOf(js.getJSONObject(0).get("game_info"));   // clean array dos detalhes do jgo 0
        arrayGamesInfoCleaned=arrayGamesInfoCleaned.substring(1,arrayGamesInfoCleaned.length()-1);


        JSONArray jsInfo = new JSONArray(arrayGamesInfoCleaned);
        Log.v("abcde", String.valueOf(jsInfo.getJSONObject(0).get("tempo")));    //objeto do array dos detalhes do jogo 0 liga 0  (pos 0 dos detalhes)
        Log.v("abcde", "d__________________________");
        
    }
}

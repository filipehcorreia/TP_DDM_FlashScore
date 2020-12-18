package com.ips.flashscoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class foot extends AppCompatActivity implements DFJLHttp.AsyncResponse {

    public ArrayList<FutLigas> oGames= new ArrayList<FutLigas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot);

        new DFJLHttp(this).execute("http://192.168.1.198/get/getFutGames.php");

    }

    @Override
    public void processFinish(JSONArray output) throws JSONException {

        for(int i=0 ; i<output.length();i++) {
            Log.v("abcde", output.getJSONObject(i).toString());   // Liga num 0
            Log.v("abcde", "a__________________________"+i);

            Log.v("abcde", output.getJSONObject(i).getString("games"));  // jogos da liga num 0
            Log.v("abcde", "b__________________________");



            FutLigas tempLigas= new FutLigas( output.getJSONObject(i).getString("name"));
            oGames.add(tempLigas);

            JSONArray js = new JSONArray(output.getJSONObject(i).getString("games"));

           for(int j=0 ; j<js.length();j++) {

               String hTeam = String.valueOf(js.getJSONObject(j).get("home_team"));
               String aTeam = String.valueOf(js.getJSONObject(j).get("away_team"));
               String aGoals = String.valueOf(js.getJSONObject(j).get("aGoals"));
               String hGoals = String.valueOf(js.getJSONObject(j).get("hGoals"));
               String gameTime = String.valueOf(js.getJSONObject(j).get("game_time"));
               String gameLink = String.valueOf(js.getJSONObject(j).get("game_link"));
               String gameStatus = String.valueOf(js.getJSONObject(j).get("game_status"));

               FutGames tempGame = new FutGames(gameTime,hTeam,aTeam,gameStatus,aGoals,hGoals,gameLink);
               oGames.get(i).games.add(tempGame);


               String arrayGamesInfoCleaned = String.valueOf(js.getJSONObject(j).get("game_info"));
               arrayGamesInfoCleaned = arrayGamesInfoCleaned.substring(1, arrayGamesInfoCleaned.length() - 1);
               JSONArray jsInfo = new JSONArray(arrayGamesInfoCleaned);
               String time = String.valueOf(jsInfo.getJSONObject(j).get("tempo"));
               String description = String.valueOf(jsInfo.getJSONObject(j).get("descricao"));
               String tipe = String.valueOf(jsInfo.getJSONObject(j).get("tipo"));

               FutInfo tempInfo= new FutInfo(time,description,tipe);



            }



        }

        Log.v("abcde",  oGames.toString());
    }
}

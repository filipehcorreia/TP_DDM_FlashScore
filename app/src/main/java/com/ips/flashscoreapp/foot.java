package com.ips.flashscoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class foot extends AppCompatActivity implements DFJLHttp.AsyncResponse {

    public ArrayList<FutLigas> oGames= new ArrayList<FutLigas>();
private Menu menu;
    private ListView gamesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot);

        new DFJLHttp(this).execute("http://192.168.1.12/get/getFutGames.php");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu=menu;
        return super.onCreateOptionsMenu(menu);
        
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        System.out.println(item.getItemId());

        gamesView = (ListView) findViewById(R.id.listGames);
ArrayList temp= new ArrayList();
        temp.add(oGames.get(item.getItemId()));
        ArrayAdapter<FutLigas> arrayAdapter =
                new ArrayAdapter<FutLigas>(this,android.R.layout.simple_list_item_1, temp);
        // Set The Adapter
        gamesView.setAdapter(arrayAdapter);


        return super.onOptionsItemSelected(item);

    }

    @Override
    public void processFinish(JSONArray output) throws JSONException {

        for(int i=0 ; i<output.length();i++) {
            FutLigas tempLigas= new FutLigas( output.getJSONObject(i).getString("name"));
            oGames.add(tempLigas);

            menu.add(Menu.NONE,i,Menu.NONE,tempLigas.name);

            JSONArray js = new JSONArray(output.getJSONObject(i).getString("games"));
            Log.v("abcde",  js.toString());

           for(int j=0 ; j<js.length();j++) {

               String hTeam = String.valueOf(js.getJSONObject(j).get("home_team"));
               String aTeam = String.valueOf(js.getJSONObject(j).get("away_team"));
               String aGoals = String.valueOf(js.getJSONObject(j).get("aGoals"));
               String hGoals = String.valueOf(js.getJSONObject(j).get("hGoals"));
               String gameTime = String.valueOf(js.getJSONObject(j).get("game_time"));
               String gameLink = String.valueOf(js.getJSONObject(j).get("game_link"));
               String gameStatus = String.valueOf(js.getJSONObject(j).get("game_status"));

               FutGames tempGame = new FutGames(gameTime,hTeam,aTeam,gameStatus,aGoals,hGoals,gameLink);


               String arrayGamesInfoCleaned = String.valueOf(js.getJSONObject(j).get("game_info"));
               if (!arrayGamesInfoCleaned.equals("null")){
                   if (!arrayGamesInfoCleaned.equals("[]")) {

                       Log.v("tap", arrayGamesInfoCleaned);
                           arrayGamesInfoCleaned = arrayGamesInfoCleaned.substring(arrayGamesInfoCleaned.indexOf("[",1), arrayGamesInfoCleaned.length() - 1);
                       Log.v("tap", arrayGamesInfoCleaned);
                       JSONArray jsInfo = new JSONArray(arrayGamesInfoCleaned);
                       Log.v("tempinfo", String.valueOf(jsInfo.length()));
                       for (int k = 0; k < jsInfo.length(); k++) {
                           String time = String.valueOf(jsInfo.getJSONObject(k).get("tempo"));
                           String description = String.valueOf(jsInfo.getJSONObject(k).get("descricao"));
                           String type = String.valueOf(jsInfo.getJSONObject(k).get("tipo"));

                           FutInfo tempInfo = new FutInfo(time, description, type);
                           Log.v("tempinfo", tempInfo.toString());
                           tempGame.game_info.add(tempInfo);
                       }
                   }

            }
               oGames.get(i).games.add(tempGame);
           }

        }



        Log.v("abcdef",  oGames.toString());
    }
}

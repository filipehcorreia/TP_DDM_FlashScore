package com.ips.flashscoreapp.Class;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ips.flashscoreapp.Activities.BaskDetailsActivity;
import com.ips.flashscoreapp.DataTypes.BaskInfo;
import com.ips.flashscoreapp.DataTypes.Games;
import com.ips.flashscoreapp.DataTypes.Ligas;
import com.ips.flashscoreapp.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class basket extends AppCompatActivity implements DFJLHttp.AsyncResponse {

    public ArrayList<Ligas> oGames = new ArrayList<Ligas>();
    private Menu menu;
    private ListView gamesView;
    private TextView mTextView;
    private int leagueIAmAt = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        mTextView = findViewById(R.id.idTextView);
        getSupportActionBar().setTitle("Games");


        new DFJLHttp(this).execute("http://192.168.54.118/get/getBasketGames.php");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        mTextView.setText("");
        leagueIAmAt = item.getItemId();

        gamesView = (ListView) findViewById(R.id.listGames);
        ArrayList temp = new ArrayList();


        for (int i = 0; i < oGames.get(item.getItemId()).games.size(); i++) {
            temp.add(oGames.get(item.getItemId()).games.get(i));
        }

        ArrayAdapter<Ligas> arrayAdapter =
                new ArrayAdapter<Ligas>(this, android.R.layout.simple_list_item_1, temp);

        gamesView.setAdapter(arrayAdapter);

        gamesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int gameIamAt = (int) id;
                Games temp = (Games) oGames.get(leagueIAmAt).games.get(gameIamAt);
                if (!(temp.game_status.equals("Scheduled") || temp.game_status.equals("Postponed"))) {

                    Intent intent = new Intent(getBaseContext(), BaskDetailsActivity.class);
                    intent.putExtra("Games", temp.game_info);
                    startActivity(intent);
                } else {
                    String toastStr = "";
                    if (temp.game_status.equals("Scheduled")) {
                        toastStr = "Game has not started yet \n It will start at " + temp.game_time;

                        Intent intentAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);
                        intentAlarm.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(temp.game_time.substring(0, 2)));
                        intentAlarm.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(temp.game_time.substring(3, 5)));
                        intentAlarm.putExtra(AlarmClock.EXTRA_MESSAGE, temp.home_team + " - " + temp.away_team);
                        startActivity(intentAlarm);


                    } else if (temp.game_status.equals("Postponed")) {
                        toastStr = "Game will not started today \n It was postponed";
                    }

                    Toast toast = Toast.makeText(getApplicationContext(), toastStr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        gamesView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int gameIamAt = (int) id;
                Games temp = (Games) oGames.get(leagueIAmAt).games.get(gameIamAt);
                Log.v("pai",temp.game_lineup);
                System.out.println(temp.game_lineup.toString());
                if (!temp.game_lineup.equals("")) {
                String url = "http://www.flashscore.mobi" + temp.game_lineup;

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }else {
                String toastStr = "Game doesn't have a Lineup ";

                Toast toast = Toast.makeText(getApplicationContext(), toastStr, Toast.LENGTH_SHORT);
                toast.show();
            }
                return false;
            }
        });

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void processFinish(JSONArray output) throws JSONException {

        for (int i = 0; i < output.length(); i++) {
            Ligas tempLigas = new Ligas(output.getJSONObject(i).getString("name"));
            oGames.add(tempLigas);

            menu.add(Menu.NONE, i, Menu.NONE, tempLigas.name);

            JSONArray js = new JSONArray(output.getJSONObject(i).getString("games"));

            for (int j = 0; j < js.length(); j++) {

                String hTeam = String.valueOf(js.getJSONObject(j).get("home_team"));
                String aTeam = String.valueOf(js.getJSONObject(j).get("away_team"));
                String aGoals = String.valueOf(js.getJSONObject(j).get("aGoals"));
                String hGoals = String.valueOf(js.getJSONObject(j).get("hGoals"));
                String gameTime = String.valueOf(js.getJSONObject(j).get("game_time"));
                String gameLink = String.valueOf(js.getJSONObject(j).get("game_link"));
                String gameStatus = String.valueOf(js.getJSONObject(j).get("game_status"));
                String gameLineup = String.valueOf(js.getJSONObject(j).get("game_lineup"));

                Games tempGame = new Games(gameTime, hTeam, aTeam, gameStatus, aGoals, hGoals, gameLink,gameLineup);


                String arrayGamesInfoCleaned = String.valueOf(js.getJSONObject(j).get("game_info"));
                if (!arrayGamesInfoCleaned.equals("null")) {
                    if (!arrayGamesInfoCleaned.equals("[]")) {

/*
                        arrayGamesInfoCleaned = arrayGamesInfoCleaned.substring(arrayGamesInfoCleaned.indexOf("[", 1), arrayGamesInfoCleaned.length() - 1);
                        arrayGamesInfoCleaned = arrayGamesInfoCleaned.replace("[", "");
                        arrayGamesInfoCleaned = arrayGamesInfoCleaned.replace("]", "");*/
                     //   arrayGamesInfoCleaned = "[" + arrayGamesInfoCleaned + "]";


                        JSONArray jsInfo = new JSONArray(arrayGamesInfoCleaned);
                        for (int k = 0; k < jsInfo.length(); k++) {
                            String quarter = String.valueOf(jsInfo.getJSONObject(k).get("part"));
                            String score = String.valueOf(jsInfo.getJSONObject(k).get("score"));

                            BaskInfo tempInfo = new BaskInfo(quarter,score);
                            tempGame.game_info.add(tempInfo);
                        }
                    }

                }
                oGames.get(i).games.add(tempGame);
            }

        }


    }
}

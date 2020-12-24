package com.ips.flashscoreapp;

import java.io.Serializable;
import java.util.ArrayList;

public class FutGames implements Serializable {

    public String game_time;
    public String home_team;
    public String away_team;
    public String game_status;
    public String aGoals;
    public String hGoals;
    public String game_link;
    public ArrayList<FutInfo> game_info =new ArrayList<FutInfo>();

    public void setGame_info(FutInfo gameI) {
        game_info.add(gameI);
    }

    public FutGames(String game_time, String home_team, String away_team, String game_status, String aGoals, String hGoals, String game_link) {
        this.game_time = game_time;
        this.home_team = home_team;
        this.away_team = away_team;
        this.game_status = game_status;
        this.aGoals = aGoals;
        this.hGoals = hGoals;
        this.game_link = game_link;
    }

    @Override
    public String toString() {
        return    game_time   +"  " + game_status +"\n "+
                home_team  + " - " + away_team  + "  " + hGoals  + " : " + aGoals  + "\n"   ;
    }
}

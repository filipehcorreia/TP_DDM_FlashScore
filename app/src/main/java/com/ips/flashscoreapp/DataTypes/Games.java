package com.ips.flashscoreapp.DataTypes;

import java.io.Serializable;
import java.util.ArrayList;

public class Games implements Serializable {

    public String game_time;
    public String home_team;
    public String away_team;
    public String game_status;
    public String aGoals;
    public String hGoals;
    public String game_link;
    public String game_lineup="";
    public ArrayList<Object> game_info =new ArrayList<Object>();

    public void setGame_info(Object gameI) {
        game_info.add(gameI);
    }

    public Games(String game_time, String home_team, String away_team, String game_status, String aGoals, String hGoals, String game_link, String game_lineup) {
        this.game_time = game_time;
        this.home_team = home_team;
        this.away_team = away_team;
        this.game_status = game_status;
        this.aGoals = aGoals;
        this.hGoals = hGoals;
        this.game_link = game_link;
        this.game_lineup= game_lineup;
    }

    //toString made to look better in the listView
    @Override
    public String toString() {
        return    game_time   +"  " + game_status +"\n "+
                home_team  + " - " + away_team  + "  " + hGoals  + " : " + aGoals  + "\n"   ;
    }
}

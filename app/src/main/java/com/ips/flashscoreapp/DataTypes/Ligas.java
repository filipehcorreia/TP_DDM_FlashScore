package com.ips.flashscoreapp.DataTypes;

import com.ips.flashscoreapp.DataTypes.Games;

import java.io.Serializable;
import java.util.ArrayList;

public class Ligas implements Serializable {

    public String name;
    public ArrayList games = new ArrayList();

    public Ligas(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getGames() {
        return games;
    }

    public void setGames(ArrayList games) {
        this.games = games;
    }

    public Ligas(String name, ArrayList<Games> games) {
        this.name = name;
        this.games = games;


        System.out.println(games);
    }

    @Override
    public String toString() {
        return "" + games;
    }
}

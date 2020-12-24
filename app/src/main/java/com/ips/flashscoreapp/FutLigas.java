package com.ips.flashscoreapp;

import java.io.Serializable;
import java.util.ArrayList;

public class FutLigas implements Serializable {

    public String name;
    public ArrayList games = new ArrayList();

    public FutLigas(String name) {
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

    public FutLigas(String name, ArrayList<FutGames> games) {
        this.name = name;
        this.games = games;


        System.out.println(games);
    }

    @Override
    public String toString() {
        return "" + games;
    }
}

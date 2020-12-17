package com.ips.flashscoreapp;

import java.util.ArrayList;

public class FutLigas {

    public String name;
    public ArrayList games =new ArrayList();
    public ArrayList<FutGames> games2 =new ArrayList<FutGames>();

    public FutLigas(String name, ArrayList<FutGames> games) {
        this.name = name;
        this.games2 = games;
        this.games.add(0,games2);

        System.out.println(games);
    }

    @Override
    public String toString() {
        return "FutLigas{" +
                "name='" + name + '\'' +
                ", games=" + games +
                '}';
    }
}

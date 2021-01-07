package com.ips.flashscoreapp.DataTypes;

import java.io.Serializable;

public class BaskInfo implements Serializable {

    public String quarter;
    public String score;

    public BaskInfo(String quarter, String score) {
        this.quarter = quarter;
        this.score = score;
    }
    //toString made to look better in the listView
    @Override
    public String toString() {
       return quarter + "  "+ score;
    }
}

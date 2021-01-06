package com.ips.flashscoreapp;

import java.io.Serializable;

public class BaskInfo implements Serializable {

    public String quarter;
    public String score;

    public BaskInfo(String quarter, String score) {
        this.quarter = quarter;
        this.score = score;
    }

    @Override
    public String toString() {
       return quarter + "  "+ score;
    }
}

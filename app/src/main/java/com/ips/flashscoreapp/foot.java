package com.ips.flashscoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.os.Bundle;
import org.json.JSONObject;

public class foot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot);
        init();
    }

    public void init (){
        DFJLHttp get= new DFJLHttp();
        get.execute("https://www.google.com");
    }

}

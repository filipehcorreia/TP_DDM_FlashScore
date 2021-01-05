package com.ips.flashscoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FutDetailsActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList gamesaqui;
    private String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fut_details);
        getSupportActionBar().setTitle("Details");
        gamesaqui = new ArrayList<>();
        gamesaqui = (ArrayList) getIntent().getSerializableExtra("Games");

        addPart2();
        addPart1();
        init();

    }

    void init() {
        mListView = findViewById(R.id.idFutDetailsListView);


        ArrayAdapter<FutLigas> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gamesaqui);

        mListView.setAdapter(arrayAdapter);

    }

    String addPart2(){
        for(int i=0;i<gamesaqui.size();i++){
            temp=gamesaqui.get(i).toString();
            if(temp.contains("+")){
                temp=temp.substring(0,temp.indexOf("+"));
            }else{
                temp=temp.substring(0,temp.indexOf("'"));
            }
            if(Integer.parseInt(temp)>45){
                gamesaqui.add(i,"2st Part");

                return "";
            }
        }
        return "";
    }

    void addPart1(){
        gamesaqui.add(0,"1st Part");
    }

}
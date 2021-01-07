package com.ips.flashscoreapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ips.flashscoreapp.DataTypes.Ligas;
import com.ips.flashscoreapp.R;

import java.util.ArrayList;

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


        ArrayAdapter<Ligas> arrayAdapter =
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
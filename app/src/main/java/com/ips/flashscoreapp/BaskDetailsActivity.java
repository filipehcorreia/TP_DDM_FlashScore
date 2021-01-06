package com.ips.flashscoreapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BaskDetailsActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList gamesaqui;
    private String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bask_details);
        getSupportActionBar().setTitle("Details");
        gamesaqui = new ArrayList<>();
        gamesaqui = (ArrayList) getIntent().getSerializableExtra("Games");

        init();

    }

    void init() {
        mListView = findViewById(R.id.idBaskDetailsListView);


        ArrayAdapter<Ligas> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gamesaqui);

        mListView.setAdapter(arrayAdapter);

    }


}
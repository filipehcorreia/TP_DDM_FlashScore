package com.ips.flashscoreapp.Activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ips.flashscoreapp.DataTypes.Ligas;
import com.ips.flashscoreapp.R;

import java.util.ArrayList;

public class BaskDetailsActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList gamesaqui;
    private String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //changes the layout
        setContentView(R.layout.activity_bask_details);
        //changes the tittle of the screen
        getSupportActionBar().setTitle("Details");
        gamesaqui = new ArrayList<>();
        gamesaqui = (ArrayList) getIntent().getSerializableExtra("Games");

        init();

    }

    void init() {
        //get the view

        mListView = findViewById(R.id.idBaskDetailsListView);

        //create the navigation to the next screen
        ArrayAdapter<Ligas> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gamesaqui);

        mListView.setAdapter(arrayAdapter);

    }


}
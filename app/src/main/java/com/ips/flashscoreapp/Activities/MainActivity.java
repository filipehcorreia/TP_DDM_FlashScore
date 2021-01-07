package com.ips.flashscoreapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ips.flashscoreapp.R;
import com.ips.flashscoreapp.Class.home;
import com.ips.flashscoreapp.Class.info;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //it creates the bottom toolbar
        toolbar = getSupportActionBar();
        toolbar.setTitle("Inicío");
        //add navigation to the bottom of the screen
        AddBottomNavigation();
    }//onCreate

    private void AddBottomNavigation() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment[] fragment = {new home()};
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment, fragment[0]).commit();
        //get resources of the bottom navigation
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.idBottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            //create the bottom options
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //changes the tittle of the screen,and calls the new fragment
                switch (item.getItemId()) {
                    case R.id.home2:
                        toolbar.setTitle("Inicío");
                        fragment[0] = new home();
                        break;
                    case R.id.info2:
                        toolbar.setTitle("Informação");
                        fragment[0] = new info();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment, fragment[0]).commit();
                return true;
            }//onNavigationItemSelected
        });
    }//AddBottomNavigation

}

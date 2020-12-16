package com.ips.flashscoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Inicío");

        AddBottomNavigation();
    }

    private void AddBottomNavigation() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment[] fragment = {new home()};
        FragmentTransaction transaction =
                fragmentManager.beginTransaction();
        transaction.add(R.id.fragment, fragment[0]).commit();
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.idBottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
            }
        });
    }


    void init() {

    }

}

package com.tss.sga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainHomeActivity  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {
        BottomNavigationView bottomNavigationView;
        int name;
        Fragment fragment = null;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_home);
            init();
            bottomNavigationView.setOnNavigationItemSelectedListener(this);
            if (savedInstanceState == null) {
                Fragment fragment = new Home();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit();
            }
        }
        private void init() {
            bottomNavigationView = findViewById(R.id.bottomNavigationView);
        }
        // bottom navigation
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            switch (id) {
                case R.id.home:
                    fragment = new Home();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                    break;
                case R.id.tablechart:
                    fragment = new Category();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                    break;
                case R.id.carts:
                    fragment = new Carts();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                    break;
                case R.id.notification:
                    fragment = new Profiles();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                    break;
            }
            return true;
        }
    }
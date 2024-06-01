package com.example.bottom_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom = findViewById(R.id.bnview);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.home)
                {
                     loadfra(new AFragment(),0);
                }
                else if(id==R.id.search)
                {
                   loadfra(new BFragment(),1);
                }
                else if(id==R.id.utilites)
                {
                   loadfra(new CFragment(),1);
                }
                else if(id==R.id.contact)
                {
                    loadfra(new DFragment(),1);

                }
                else
                {
                    loadfra(new EFragment(),1);
                }
                return true;
            }
        });
    }
    public void loadfra(Fragment fragment,int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag==0)
        {
            ft.add(R.id.container,fragment);
        }
        else
        {
            ft.replace(R.id.container,fragment);
        }

        ft.commit();
    }

}
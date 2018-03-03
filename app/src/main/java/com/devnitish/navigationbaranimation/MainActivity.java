package com.devnitish.navigationbaranimation;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    ArrayList<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),this);
        adapter.addFragement(new MenuPage());
        adapter.addFragement(new ContentPage());
        adapter.addFragement(new Menu2());

        pager.setAdapter(adapter);
        pager.setPageTransformer(true,new CoolMenu());
        pager.setCurrentItem(1);
//        adapter.set

    }

    public void showPage(View view){
        pager.setCurrentItem(1);
    }
}

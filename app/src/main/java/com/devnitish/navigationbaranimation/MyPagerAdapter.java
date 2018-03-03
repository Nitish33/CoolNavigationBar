package com.devnitish.navigationbaranimation;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Nitish Prasad on 3/3/2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    ArrayList<android.support.v4.app.Fragment> fragmentsList;
    LayoutInflater inflater;
    Context mContext;

    public MyPagerAdapter(FragmentManager fm,Context context) {
        super(fm);

        mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.fragmentsList = new ArrayList<>();
    }



    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    public void addFragement(Fragment fragment){
        fragmentsList.add(fragment);
    }


}



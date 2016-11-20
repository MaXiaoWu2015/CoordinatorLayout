package com.aqy.matingting.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by maxiaowu on 16/11/20.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> tablist;

    public MyViewPagerAdapter(FragmentManager fm, List<String> tabs){
        super(fm);
        this.tablist=tabs;


    }
    @Override
    public int getCount() {
        return tablist.size();
    }

    @Override
    public Fragment getItem(int position) {
        return new Fragment();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tablist.get(position);
    }
}

package com.example.administrator.afinal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ManagePageAdapter1 extends FragmentPagerAdapter {
    private String[] title =new String[]{"用户信息","---信息"};



    public ManagePageAdapter1(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new userFragment();
        } else{
            return new modifyHuodongFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
//        if (position==0){
//            return "First";
//        }
//        return "Title" + position;
        return title[position];
    }
}


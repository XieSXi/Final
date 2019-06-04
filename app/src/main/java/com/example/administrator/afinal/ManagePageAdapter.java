package com.example.administrator.afinal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class ManagePageAdapter extends FragmentPagerAdapter {
    private String[] title =new String[]{"学生信息","组织信息"};



    public ManagePageAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new OneFragment();
        } else{
            return new RegisterFragment1();
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


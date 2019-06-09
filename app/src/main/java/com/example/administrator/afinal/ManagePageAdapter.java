package com.example.administrator.afinal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class ManagePageAdapter extends FragmentPagerAdapter {
    private String[] title =new String[]{"发布活动","修改活动信息"};



    public ManagePageAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new issueHuodongFragment();
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


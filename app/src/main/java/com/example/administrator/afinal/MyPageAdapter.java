package com.example.administrator.afinal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPageAdapter extends FragmentPagerAdapter {
    private String[] title =new String[]{"注册","完善身份信息"};

    public  MyPageAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RegisterFragment1();
        } else{
            return new RegisterFragment2();
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


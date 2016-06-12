package com.zxkj.governmentrent.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 林炜智 on 2016/3/19.
 * 党建聚焦的
 */
public class Focus_Fragment_ViewPager extends FragmentPagerAdapter {
    private List<Fragment> viewList;

    public Focus_Fragment_ViewPager(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.viewList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return viewList.get(position);
    }

    @Override
    public int getCount() {
        return viewList == null ? 0 : viewList.size();
    }
}

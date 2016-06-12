package com.zxkj.governmentrent.widget.banner_control.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.zxkj.governmentrent.widget.banner_control.model.BannerModel;

import java.util.List;

public class Adapter extends PagerAdapter {

	private List<BannerModel> banners;
	
	@Override
	public int getCount() {
		if(banners ==null)
			return 0;
		return banners.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

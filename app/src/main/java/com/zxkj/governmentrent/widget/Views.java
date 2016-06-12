package com.zxkj.governmentrent.widget;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.model.PoliticsNews_Model;
import com.zxkj.governmentrent.ui.activity.NewsDetails;
import com.zxkj.governmentrent.utils.IntentUtil;
import com.zxkj.governmentrent.widget.banner_control.BGABanner;
import com.zxkj.governmentrent.widget.banner_control.model.BannerModel;
import com.zxkj.governmentrent.widget.gridview_control.GridViewForScrollView;
import com.zxkj.governmentrent.widget.toast_control.Toast_Common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 林炜智 on 2016/4/11.
 * 习惯的控件
 */
public class Views {
    public final static String getBannerTag = "getBanner";
    public final static String getGridViewTag = "getGridView";

    /**
     * Don't let anyone instantiate this class.
     */
    private Views() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 空的View 用于返回
     */
    public static View getDefaultNull(Context context) {
        View views_default_null = View.inflate(context, R.layout.views_default_null, null);
        return views_default_null;
    }

    /**
     * 自定义Banner 广告栏
     */
    public static View getBanner(final Context context, final List<BannerModel> banner) {
        if (context == null) {
            return null;
        } else if (banner == null || banner.size() == 0) {
            return getDefaultNull(context);
        } else {
            View CustomView = View.inflate(context, R.layout.views_banner, null);
            BGABanner bgaBanner = (BGABanner) CustomView.findViewById(R.id.views_banner);
            List<View> views = new ArrayList<>();
            for (int i = 0; i < banner.size(); i++) {
                View view = View.inflate(context, R.layout.views_banner_item, null);
                ImageView image = (ImageView) view.findViewById(R.id.views_banner_item_image);
//                Glide.with(context).load(banner.get(i).getUrl()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
//                        .crossFade().into(image);
                image.setImageResource(banner.get(i).getImg());
                final int finalI = i;
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        IntentUtil.goToContext(context, NewsDetails.class, getBannerTag, banner.get(finalI));
                    }
                });
                views.add(view);
            }
            bgaBanner.setViews(views);

            List<String> tips = new ArrayList<>();
            for (int i = 0; i < banner.size(); i++) {
                tips.add(banner.get(i).getTitle());
            }
            bgaBanner.setTips(tips);
            return CustomView;
        }
    }

    /**
     * @param context
     * @param adapter
     * @param itemClickListener
     * @return 首页视频
     */
    public static View getGridView(Context context, BaseAdapter adapter, AdapterView.OnItemClickListener itemClickListener) {
        if (context == null)
            return null;
        if (adapter == null)
            return null;
        View CustomView = View.inflate(context, R.layout.views_politicsnews_gridview, null);
        GridView gridViewForScrollView = (GridView) CustomView.findViewById(R.id.views_politicsnews_gridview_GridView);
        gridViewForScrollView.setAdapter(adapter);
        gridViewForScrollView.setOnItemClickListener(itemClickListener);
        return CustomView;
    }

    public static View getSmallTitle(Context context, int img, String title) {
        if (context == null)
            return null;
        View CustomView = View.inflate(context, R.layout.views_small_title, null);
        ImageView imageView = (ImageView) CustomView.findViewById(R.id.views_small_title_ImageView);
        TextView textView = (TextView) CustomView.findViewById(R.id.views_small_title_TextView);
        imageView.setImageResource(img);
        textView.setText(title);
        return CustomView;
    }
}

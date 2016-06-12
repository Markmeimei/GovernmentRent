package com.zxkj.governmentrent.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.model.PoliticsNews_Model;
import com.zxkj.governmentrent.simulateData.SimulateData;
import com.zxkj.governmentrent.ui.activity.NewsDetails;
import com.zxkj.governmentrent.ui.activity.VideoViewDetails;
import com.zxkj.governmentrent.ui.adapter.PoliticsNews_GridView;
import com.zxkj.governmentrent.ui.adapter.PoliticsNews_ListView;
import com.zxkj.governmentrent.utils.IntentUtil;
import com.zxkj.governmentrent.widget.Views;
import com.zxkj.governmentrent.widget.banner_control.model.BannerModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by 林炜智 on 2016/4/11.
 * 时政要闻
 */
public class PoliticsNews extends Fragment {
    public final static String Tag = "PoliticsNews";

    @Bind(R.id.fragment_politicsnews_ListView)
    ListView fragmentPoliticsnewsListView;

    private View view;
    private PoliticsNews_ListView news_listView;
    private PoliticsNews_GridView news_gridView;
    private List<PoliticsNews_Model> list;
    private List<BannerModel> bannerModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_politicsnews, container, false);
            ButterKnife.bind(this, view);
            Init();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    private void Init() {
        list = SimulateData.getPoliticsNewsData();
        bannerModels = SimulateData.getBannerModelData();
        news_listView = new PoliticsNews_ListView(getActivity(), list);
        news_gridView = new PoliticsNews_GridView(getActivity(), list);
        Content();
    }

    private void Content() {
        fragmentPoliticsnewsListView.addHeaderView(Views.getBanner(getActivity(), bannerModels));
        fragmentPoliticsnewsListView.addFooterView(Views.getGridView(getActivity(), news_gridView, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IntentUtil.goToContext(getActivity(), VideoViewDetails.class, Tag, list.get(position));
            }
        }));
        fragmentPoliticsnewsListView.setAdapter(news_listView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.fragment_politicsnews_ListView)
    public void onItemClick(int position) {
        IntentUtil.goToContext(getActivity(), NewsDetails.class, Tag, list.get(position - 1));
    }
}

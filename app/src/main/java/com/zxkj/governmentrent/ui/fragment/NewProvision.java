package com.zxkj.governmentrent.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.model.PoliticsNews_Model;
import com.zxkj.governmentrent.simulateData.SimulateData;
import com.zxkj.governmentrent.ui.activity.NewsDetails;
import com.zxkj.governmentrent.ui.adapter.PoliticsNews_ListView;
import com.zxkj.governmentrent.utils.IntentUtil;
import com.zxkj.governmentrent.widget.Views;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by 林炜智 on 2016/4/11.
 */
public class NewProvision extends Fragment {
    public final static String Tag = "NewProvision";

    @Bind(R.id.fragment_newprovision_ListView)
    ListView fragmentNewprovisionListView;

    private View view;
    private PoliticsNews_ListView news_listView;
    private List<PoliticsNews_Model> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_newprovision, container, false);
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
        news_listView = new PoliticsNews_ListView(getActivity(), list);
        Content();
    }

    private void Content() {
        fragmentNewprovisionListView.addHeaderView(Views.getSmallTitle(getActivity(), R.mipmap.img_hot, "党规"));
        fragmentNewprovisionListView.setAdapter(news_listView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.fragment_newprovision_ListView)
    public void onItemClick(int position) {
        if (position != 0)
            IntentUtil.goToContext(getActivity(), NewsDetails.class, Tag, list.get(position - 1));
    }
}

package com.zxkj.governmentrent.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.ui.adapter.Affairs_GridView;
import com.zxkj.governmentrent.widget.toast_control.Toast_Common;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by 林炜智 on 2016/4/11.
 */
public class Affairs extends Fragment {
    @Bind(R.id.fragment_affairs_GridView)
    GridView fragmentAffairsGridView;

    private View view;
    private Affairs_GridView news_gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_affairs, container, false);
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
        news_gridView = new Affairs_GridView(getActivity());
        Content();
    }

    private void Content() {
        fragmentAffairsGridView.setAdapter(news_gridView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.fragment_affairs_GridView)
    public void onItemClick(int position) {
        Toast_Common.DefaultToast(getActivity(), "" + position);
    }
}

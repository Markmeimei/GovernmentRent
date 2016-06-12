package com.zxkj.governmentrent.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.ui.adapter.ActivityRoom_GridView;
import com.zxkj.governmentrent.widget.toast_control.Toast_Common;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by 林炜智 on 2016/4/11.
 */
public class ActivityRoom extends Fragment {
    @Bind(R.id.fragment_activityroom_GridView)
    GridView fragmentActivityroomGridView;

    private View view;
    private ActivityRoom_GridView room_gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_activityroom, container, false);
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
        room_gridView = new ActivityRoom_GridView(getActivity());
        Content();
    }

    private void Content() {
        fragmentActivityroomGridView.setAdapter(room_gridView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.fragment_activityroom_GridView)
    public void onItemClick(int position) {
        Toast_Common.DefaultToast(getActivity(), "" + position);
    }
}

package com.zxkj.governmentrent.ui.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.constant.Constant;
import com.zxkj.governmentrent.ui.activity.AmapActivity;
import com.zxkj.governmentrent.ui.activity.Counter_Activity;
import com.zxkj.governmentrent.ui.adapter.Supermarket_GridView;
import com.zxkj.governmentrent.widget.gridview_control.GridViewForScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by 林炜智 on 2016/4/11.
 */
public class Supermarket extends Fragment {
    @Bind(R.id.fragment_supermarket_GridViewUp)
    GridViewForScrollView fragmentSupermarketGridViewUp;
    @Bind(R.id.fragment_supermarket_GridViewDown)
    GridViewForScrollView fragmentSupermarketGridViewDown;

    private View view;
    private Supermarket_GridView supermarket_gridView;
    private List<Constant.TitleImageText> imageTextList;

    private List<PackageInfo> mAllApps;
    private PackageManager mPackageManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_supermarket, container, false);
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
        mPackageManager = getActivity().getPackageManager();
        imageTextList = new ArrayList<>();
//        mAllApps = PackageUtils.getAllApps(getActivity());
//        for (int i = 0; i < mAllApps.size(); i++) {
//            PackageInfo pinfo = mAllApps.get(i);
//            this.imageTextList.add(new Constant.TitleImageText(pinfo.applicationInfo.loadIcon(mPackageManager),
//                    pinfo.applicationInfo.loadLabel(mPackageManager).toString(), ""));
//        }

        supermarket_gridView = new Supermarket_GridView(getActivity(), Constant.getSuperMarket_My());
        Content();
    }

    private void Content() {
        fragmentSupermarketGridViewUp.setAdapter(supermarket_gridView);
        fragmentSupermarketGridViewDown.setAdapter(new Supermarket_GridView(getActivity(),Constant.getSuperMarket_Like()));

    }

    @OnItemClick(R.id.fragment_supermarket_GridViewUp)
    public void onItemClick(int position) {
        if(position == 0){
//            Intent intent = new Intent();
//            intent.setAction("android.intent.action.VIEW");
//            Uri content_url = Uri.parse("http://dj.adpanshi.com/guidance/affair/dues_calculate.php");
//            intent.setData(content_url);
//            startActivity(intent);
            startActivity(new Intent(getActivity(), Counter_Activity.class));
        }
        if(position == 1){
            Intent intent = new Intent(getActivity(), AmapActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            getActivity().overridePendingTransition(0, 0);
        }else {
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }
}

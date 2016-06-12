package com.zxkj.governmentrent.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.ui.adapter.Focus_Fragment_ViewPager;
import com.zxkj.governmentrent.widget.viewpager_control.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 林炜智 on 2016/4/11.
 * 党建聚焦
 */
public class Focus extends Fragment {
    @Bind(R.id.fragment_focus_PoliticsNews)
    RadioButton fragmentFocusPoliticsNews;  //时政要闻
    @Bind(R.id.fragment_focus_NewProvision)
    RadioButton fragmentFocusNewProvision;  //最新党规
    @Bind(R.id.fragment_focus_RadioGroup)
    RadioGroup fragmentFocusRadioGroup;
    @Bind(R.id.fragment_focus_PoliticsNewsPointer)
    View fragmentFocusPoliticsNewsPointer;  //时政要闻指针
    @Bind(R.id.fragment_focus_NewProvisionPointer)
    View fragmentFocusNewProvisionPointer;  //最新党规指针
    @Bind(R.id.fragment_focus_Content)
    NoScrollViewPager fragmentFocusContent;   //容器

    private View view;
    private Focus_Fragment_ViewPager fragment_viewPager;
    private List<Fragment> fragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_focus, container, false);
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
        fragments = new ArrayList<>();
        fragments.add(new PoliticsNews());
        fragments.add(new NewProvision());
        fragment_viewPager = new Focus_Fragment_ViewPager(getFragmentManager(), fragments);
        Content();
    }

    private void Content() {
        fragmentFocusContent.setNoScroll(true);
        fragmentFocusContent.setAdapter(fragment_viewPager);
        fragmentFocusContent.setCurrentItem(0);
        fragmentFocusPoliticsNews.setTextColor(getResources().getColor(R.color.text_color4));
        fragmentFocusPoliticsNewsPointer.setBackgroundColor(getResources().getColor(R.color.text_color4));
        fragmentFocusContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        fragmentFocusPoliticsNews.setChecked(true);
                        fragmentFocusPoliticsNews.setTextColor(getResources().getColor(R.color.text_color4));
                        fragmentFocusPoliticsNewsPointer.setBackgroundColor(getResources().getColor(R.color.text_color4));
                        fragmentFocusNewProvision.setTextColor(getResources().getColor(R.color.text_color3));
                        fragmentFocusNewProvisionPointer.setBackgroundColor(getResources().getColor(R.color.background));
                        break;
                    case 1:
                        fragmentFocusNewProvision.setChecked(true);
                        fragmentFocusPoliticsNews.setTextColor(getResources().getColor(R.color.text_color3));
                        fragmentFocusPoliticsNewsPointer.setBackgroundColor(getResources().getColor(R.color.background));
                        fragmentFocusNewProvision.setTextColor(getResources().getColor(R.color.text_color4));
                        fragmentFocusNewProvisionPointer.setBackgroundColor(getResources().getColor(R.color.text_color4));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }

    @OnClick({R.id.fragment_focus_PoliticsNews, R.id.fragment_focus_NewProvision})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_focus_PoliticsNews:
                fragmentFocusContent.setCurrentItem(0);
                break;
            case R.id.fragment_focus_NewProvision:
                fragmentFocusContent.setCurrentItem(1);
                break;
        }
    }
}

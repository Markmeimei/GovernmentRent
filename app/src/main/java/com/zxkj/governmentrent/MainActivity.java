package com.zxkj.governmentrent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zxkj.governmentrent.ui.adapter.MainActivity_ListView;
import com.zxkj.governmentrent.ui.fragment.ActivityRoom;
import com.zxkj.governmentrent.ui.fragment.Affairs;
import com.zxkj.governmentrent.ui.fragment.Focus;
import com.zxkj.governmentrent.ui.fragment.Supermarket;
import com.zxkj.governmentrent.widget.headTitle.HeadTitle;
import com.zxkj.governmentrent.widget.navigation_control.DragLayout;
import com.zxkj.governmentrent.widget.toast_control.Toast_Common;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 *
 */
public class MainActivity extends BaseActivity {
    @Bind(R.id.activity_main_DragLayout)
    DragLayout activityMainDragLayout;  //侧滑布局
    @Bind(R.id.include_main_left_Versions)
    TextView includeMainLeftVersions;   //版本号
    @Bind(R.id.include_main_left_ListView)
    ListView includeMainLeftListView;   //菜单
    @Bind(R.id.activity_main_HeadTitle)
    HeadTitle activityMainHeadTitle;    //标题
    @Bind(R.id.activity_main_Content)
    FrameLayout activityMainContent;    //容器
    @Bind(R.id.include_tab_button_FocusImage)
    ImageView includeTabButtonFocusImage;   //党建聚焦图标
    @Bind(R.id.include_tab_button_FocusText)
    TextView includeTabButtonFocusText;     //党建聚焦文字
    @Bind(R.id.include_tab_button_Focus)
    LinearLayout includeTabButtonFocus;     //党建聚焦布局
    @Bind(R.id.include_tab_button_AffairsImage)
    ImageView includeTabButtonAffairsImage;//智慧党务图标
    @Bind(R.id.include_tab_button_AffairsText)
    TextView includeTabButtonAffairsText;//智慧党务文字
    @Bind(R.id.include_tab_button_Affairs)
    LinearLayout includeTabButtonAffairs;//智慧党务布局
    @Bind(R.id.include_tab_button_ActivityRoomImage)
    ImageView includeTabButtonActivityRoomImage;    //党员活动室图标
    @Bind(R.id.include_tab_button_ActivityRoomText)
    TextView includeTabButtonActivityRoomText;  //党员活动室文字
    @Bind(R.id.include_tab_button_ActivityRoom)
    LinearLayout includeTabButtonActivityRoom;  //党员活动室布局
    @Bind(R.id.include_tab_button_SupermarketImage)
    ImageView includeTabButtonSupermarketImage; //软件超市图标
    @Bind(R.id.include_tab_button_SupermarketText)
    TextView includeTabButtonSupermarketText;   //软件超市文字
    @Bind(R.id.include_tab_button_Supermarket)
    LinearLayout includeTabButtonSupermarket;   //软件超市布局

    private MainActivity_ListView activity_listView;


    private Fragment[] fragments;
    private ImageView[] imageViews;
    private TextView[] textViews;

    private Focus focus;    //  党建聚焦
    private Affairs affairs;    //智慧党务
    private ActivityRoom activityRoom;  //党员活动室
    private Supermarket supermarket;    //软件超市

    private int index;
    private int fragment_index;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setStatusBar();
        Init();
    }

    private void Init() {
        this.focus = new Focus();
        this.affairs = new Affairs();
        this.activityRoom = new ActivityRoom();
        this.supermarket = new Supermarket();
//        this.supermarket =

        fragments = new Fragment[]{focus, affairs, activityRoom, supermarket};
        imageViews = new ImageView[]{includeTabButtonFocusImage, includeTabButtonAffairsImage, includeTabButtonActivityRoomImage, includeTabButtonSupermarketImage};
        textViews = new TextView[]{includeTabButtonFocusText, includeTabButtonAffairsText, includeTabButtonActivityRoomText, includeTabButtonSupermarketText};

        activity_listView = new MainActivity_ListView(this);
        Content();
    }

    private void Content() {
        imageViews[0].setSelected(true);
        textViews[0].setTextColor(getResources().getColor(R.color.theme_color));
        getSupportFragmentManager().beginTransaction()
                .add(activityMainContent.getId(), focus)
                .add(activityMainContent.getId(), affairs)
                .add(activityMainContent.getId(), activityRoom)
                .add(activityMainContent.getId(), supermarket)
                .hide(affairs).hide(activityRoom).hide(supermarket)
                .show(focus).commit();

        includeMainLeftListView.setAdapter(activity_listView);
        activityMainHeadTitle.setLeftOnclick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMainDragLayout.open();
            }
        });

        activityMainDragLayout.setDragListener(new DragLayout.DragListener() {
            //界面打开的时候
            @Override
            public void onOpen() {

            }

            //界面关闭的时候
            @Override
            public void onClose() {

            }

            //界面滑动的时候
            @Override
            public void onDrag(float percent) {

            }
        });
    }

    @OnClick({R.id.include_tab_button_Focus, R.id.include_tab_button_Affairs, R.id.include_tab_button_ActivityRoom, R.id.include_tab_button_Supermarket})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.include_tab_button_Focus:
                index = 0;
                break;
            case R.id.include_tab_button_Affairs:
                index = 1;
                break;
            case R.id.include_tab_button_ActivityRoom:
                index = 2;
                break;
            case R.id.include_tab_button_Supermarket:
                index = 3;
                break;
        }
        if (fragment_index != index) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(fragments[fragment_index]);
            if (!fragments[index].isAdded()) {
                transaction.add(activityMainContent.getId(), fragments[index]);
            }
            transaction.show(fragments[index]).commit();
        }
        imageViews[fragment_index].setSelected(false);
        imageViews[index].setSelected(true);
        textViews[fragment_index].setTextColor(getResources().getColor(R.color.text_color2));
        textViews[index].setTextColor(getResources().getColor(R.color.theme_color));
        fragment_index = index;
    }

    /**
     * 退出应用
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                // 判断2次点击事件时间
                if ((System.currentTimeMillis() - exitTime) > 2000) {
                    Toast_Common.CenterToast(this, "再按一次退出程序");
                    exitTime = System.currentTimeMillis();
                } else {
                    moveTaskToBack(false);
                    finish();
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @OnItemClick(R.id.include_main_left_ListView)
    public void onItemClick(int position) {
        Toast_Common.CenterToast(this, position + "");
    }
}

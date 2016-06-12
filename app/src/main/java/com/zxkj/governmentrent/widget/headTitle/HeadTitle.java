package com.zxkj.governmentrent.widget.headTitle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxkj.governmentrent.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 林炜智 on 2015/8/10.
 * HeadTitle 是自定义控件
 * 用于界面标题
 */
public class HeadTitle extends LinearLayout {

    @Bind(R.id.head_title_LinearLayout)
    LinearLayout headTitleLinearLayout;
    @Bind(R.id.head_title_left_TextView)
    TextView headTitleLeftTextView;
    @Bind(R.id.head_title_left_LinearLayout)
    LinearLayout headTitleLeftLinearLayout;
    @Bind(R.id.head_title_right_TextView)
    TextView headTitleRightTextView;
    @Bind(R.id.head_title_right_LinearLayout)
    LinearLayout headTitleRightLinearLayout;
    @Bind(R.id.head_title_center_TextView)
    TextView headTitleCenterTextView;
    @Bind(R.id.head_title_left_ImageView)
    ImageView headTitleLeftImageView;
    @Bind(R.id.head_title_right_ImageView)
    ImageView headTitleRightImageView;
    @Bind(R.id.head_title_center_ImageView)
    ImageView headTitleCenterImageView;

    private String titleLeft, titleCenter, titleRight;
    private Drawable imgLeft, imgCenter, imgRight;
    private Integer themeColor;
    private TypedArray tArray;
    private Context context;

    public HeadTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        tArray = context.obtainStyledAttributes(attrs, R.styleable.HeadTitle);
        this.context = context;
        titleLeft = tArray.getString(R.styleable.HeadTitle_titleLeft);
        titleCenter = tArray.getString(R.styleable.HeadTitle_titleCenter);
        titleRight = tArray.getString(R.styleable.HeadTitle_titleRight);
        imgLeft = tArray.getDrawable(3);
        imgRight = tArray.getDrawable(4);
        imgCenter = tArray.getDrawable(5);
        themeColor = tArray.getInt(6, context.getResources().getColor(R.color.theme_color));
    }

    /**
     * 左侧标题的点击事件
     */
    public void setLeftOnclick(OnClickListener onclick) {
        headTitleLeftLinearLayout.setOnClickListener(onclick);
    }

    /**
     * 中间标题的点击事件
     */
    public void setCenterOnclick(OnClickListener onclick) {
        headTitleCenterTextView.setOnClickListener(onclick);
    }

    /**
     * 右侧标题的点击事件
     */
    public void setRightOnclick(OnClickListener onclick) {
        headTitleRightLinearLayout.setOnClickListener(onclick);
    }


    @SuppressLint("NewApi")
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.widget_head_title, this);
        ButterKnife.bind(this);

        headTitleLeftLinearLayout.setVisibility(titleLeft != null || imgLeft != null ? VISIBLE : GONE);
        headTitleCenterTextView.setVisibility(titleCenter != null ? VISIBLE : GONE);
        headTitleRightLinearLayout.setVisibility(titleRight != null || imgRight != null ? VISIBLE : GONE);
        headTitleCenterImageView.setVisibility(imgCenter != null ? VISIBLE : GONE);

        headTitleLeftTextView.setText(titleLeft);
        headTitleCenterTextView.setText(titleCenter);
        headTitleRightTextView.setText(titleRight);
        headTitleLeftImageView.setImageDrawable(imgLeft);
        headTitleRightImageView.setImageDrawable(imgRight);
        headTitleCenterImageView.setImageDrawable(imgCenter);
        headTitleLinearLayout.setBackgroundColor(themeColor);
    }

    @OnClick({R.id.head_title_left_LinearLayout, R.id.head_title_right_LinearLayout, R.id.head_title_center_TextView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head_title_left_LinearLayout:
                Activity activity = (Activity) getContext();
                activity.finish();
                break;
            case R.id.head_title_right_LinearLayout:
                break;
            case R.id.head_title_center_TextView:
                break;
        }
    }
}
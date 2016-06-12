package com.zxkj.governmentrent.ui.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.zxkj.governmentrent.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author：Mark
 * Date：2016/4/13 0013
 * Tell：15006330640
 */
public class Counter_Activity extends AmapActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);
        toolbar.setNavigationIcon(R.mipmap.ic_toolbar_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setTitle("党费计算器");
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));
        webView.loadUrl("http://sdds.rizhao.cn/dfjs/index.html");
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
    }
}

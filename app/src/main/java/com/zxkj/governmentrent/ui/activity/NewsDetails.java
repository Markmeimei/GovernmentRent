package com.zxkj.governmentrent.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.model.PoliticsNews_Model;
import com.zxkj.governmentrent.ui.fragment.NewProvision;
import com.zxkj.governmentrent.ui.fragment.PoliticsNews;
import com.zxkj.governmentrent.widget.Views;
import com.zxkj.governmentrent.widget.banner_control.model.BannerModel;
import com.zxkj.governmentrent.widget.headTitle.HeadTitle;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsDetails extends AppCompatActivity {

    @Bind(R.id.activity_main_HeadTitle)
    HeadTitle activityMainHeadTitle;
    @Bind(R.id.activity_news_details_Title)
    TextView activityNewsDetailsTitle;
    @Bind(R.id.activity_news_details_Date)
    TextView activityNewsDetailsDate;
    @Bind(R.id.activity_news_details_)
    TextView activityNewsDetails;
    @Bind(R.id.activity_news_details_ImageView)
    ImageView activityNewsDetailsImageView;
    @Bind(R.id.activity_news_details_Content)
    TextView activityNewsDetailsContent;

    private Intent intent;
    private PoliticsNews_Model newsModel;
    private BannerModel banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        intent = getIntent();
        if (intent.getSerializableExtra(PoliticsNews.Tag) != null)
            newsModel = (PoliticsNews_Model) intent.getSerializableExtra(PoliticsNews.Tag);
        else if (intent.getSerializableExtra(NewProvision.Tag) != null)
            newsModel = (PoliticsNews_Model) intent.getSerializableExtra(NewProvision.Tag);
        else if (intent.getSerializableExtra(Views.getBannerTag) != null)
            banner = (BannerModel) intent.getSerializableExtra(Views.getBannerTag);
        Content();
    }

    private void Content() {
        if (banner != null) {
            activityNewsDetailsTitle.setText(banner.getTitle());
            activityNewsDetailsDate.setText(banner.getDate());
            activityNewsDetailsImageView.setImageResource(banner.getImg());
            activityNewsDetailsContent.setText(banner.getContent());
        } else {
            activityNewsDetailsTitle.setText(newsModel.getTitle());
            activityNewsDetailsDate.setText(newsModel.getDate());
            activityNewsDetailsImageView.setImageResource(newsModel.getImg());
            activityNewsDetailsContent.setText(newsModel.getContent());
        }
    }
}

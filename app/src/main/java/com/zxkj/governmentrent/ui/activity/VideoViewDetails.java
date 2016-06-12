package com.zxkj.governmentrent.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.model.PoliticsNews_Model;
import com.zxkj.governmentrent.ui.fragment.PoliticsNews;
import com.zxkj.governmentrent.widget.headTitle.HeadTitle;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VideoViewDetails extends AppCompatActivity {

    @Bind(R.id.activity_videoview_details_VideoView)
    VideoView activityVideoviewDetailsVideoView;
    @Bind(R.id.activity_videoview_details_HeadTitle)
    HeadTitle activityVideoviewDetailsHeadTitle;
    @Bind(R.id.activity_videoview_details_Title)
    TextView activityVideoviewDetailsTitle;
    @Bind(R.id.activity_videoview_details_Date)
    TextView activityVideoviewDetailsDate;
    @Bind(R.id.activity_videoview_details_Content)
    TextView activityVideoviewDetailsContent;

    private MediaController controller;
    private PoliticsNews_Model model;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoview_details);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        intent = getIntent();
        if (intent.getSerializableExtra(PoliticsNews.Tag) != null)
            model = (PoliticsNews_Model) intent.getSerializableExtra(PoliticsNews.Tag);
        controller = new MediaController(this);
        Content();
    }

    private void Content() {
        activityVideoviewDetailsVideoView.setMediaController(controller);
        //下面android:resource://是固定的，org.dengzh是我的包名，不是.java文件package名称，R.raw.movie_1是id名称
        activityVideoviewDetailsVideoView.setVideoURI(Uri.parse("android.resource://com.zxkj.governmentrent/" + R.raw.party));
        activityVideoviewDetailsVideoView.start();

        if (intent.getSerializableExtra(PoliticsNews.Tag) != null) {
            activityVideoviewDetailsTitle.setText(model.getTitle());
            activityVideoviewDetailsDate.setText(model.getDate());
            activityVideoviewDetailsContent.setText(model.getContent());
        }
    }
}

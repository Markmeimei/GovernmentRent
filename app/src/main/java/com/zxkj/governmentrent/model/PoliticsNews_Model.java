package com.zxkj.governmentrent.model;

import java.io.Serializable;

/**
 * Created by 林炜智 on 2016/4/11.
 * 时政要闻的列表
 */
public class PoliticsNews_Model implements Serializable {
    private int img;    //图片
    private String title;   //标题
    private String date;    //时间
    private String content; //内容

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

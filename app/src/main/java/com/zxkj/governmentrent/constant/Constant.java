package com.zxkj.governmentrent.constant;

import android.graphics.drawable.Drawable;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.ui.adapter.MainActivity_ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 林炜智 on 2016/4/10.
 */
public class Constant {
    public final static List<MainActivity_ListView.ObjectBean> getMainList() {
        List<MainActivity_ListView.ObjectBean> list = new ArrayList<>();
        list.add(new MainActivity_ListView.ObjectBean(R.mipmap.img_home, "首页"));
        list.add(new MainActivity_ListView.ObjectBean(R.mipmap.img_help, "帮助中心"));
        list.add(new MainActivity_ListView.ObjectBean(R.mipmap.img_opinion, "意见反馈"));
        list.add(new MainActivity_ListView.ObjectBean(R.mipmap.img_individuation, "个性化"));
        list.add(new MainActivity_ListView.ObjectBean(R.mipmap.img_setting, "设置"));
        return list;
    }

    public final static List<TitleImageText> getAffairs_GridView() {
        List<TitleImageText> list = new ArrayList<>();
        list.add(new TitleImageText(R.mipmap.img_affairs_01, "我来报到", "定位签到方便快捷", R.color.color_affairs_01, R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_affairs_02, "查询党费", "查询党费缴纳详情", R.color.color_affairs_02, R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_affairs_03, "评选投票", "参与民主生活", R.color.color_affairs_03, R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_affairs_04, "调研问卷", "党务管理数据分析", R.color.color_affairs_04, R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_affairs_05, "党务知识库", "党务相关理论著作", R.color.color_affairs_05, R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_affairs_06, "通知提醒", "实时接收提示", R.color.color_affairs_06, R.color.text_color2));
        return list;
    }

    public final static List<TitleImageText> getActivityRoom_GridView() {
        List<TitleImageText> list = new ArrayList<>();
        list.add(new TitleImageText(R.mipmap.img_activityroom_01, "志愿服务", "微心愿和志愿活动", R.color.color_activityroom_01, R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_activityroom_02, "兴趣小组", "党员干部交流经验", R.color.color_activityroom_02, R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_activityroom_03, "心灵驿站", "文学 感想 摄影", R.color.color_activityroom_03, R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_activityroom_04, "税收创客", "DIY手工作品", R.color.color_activityroom_04, R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_activityroom_05, "网淘", "以物易物  无偿捐赠", R.color.color_activityroom_05, R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_activityroom_06, "温馨祝福", "给好友发送祝福", R.color.color_activityroom_06, R.color.text_color2));
        return list;
    }

    public final static List<TitleImageText> getSuperMarket_My(){
        List<TitleImageText> list = new ArrayList<>();
        list.add(new TitleImageText(R.mipmap.ic_market_coutor, "党费计算器",  R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.ic_market_map, "党建地图",  R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.ic_market_fund, "公积金查询",  R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.ic_market_pedometer, "春雨计步器", R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.ic_market_taxi, "快的打车",  R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_add_apply, "添加新应用",  R.color.text_color2));
        return list;
    }
    public final static List<TitleImageText> getSuperMarket_Like(){
        List<TitleImageText> list = new ArrayList<>();
        list.add(new TitleImageText(R.mipmap.ic_market_cloud, "云盘",  R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.ic_market_alipay, "支付宝",  R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.ic_market_anti, "杀毒软件",  R.color.text_color2));
        list.add(new TitleImageText(R.mipmap.img_add_apply, "添加新应用",  R.color.text_color2));
        return list;
    }
    public static class TitleImageText {
        private int img;
        private String title;
        private String content;
        private int titleColor;
        private int contentColor;
        private Drawable icon;

        public TitleImageText() {
        }

        public TitleImageText(Drawable icon, String title, String content) {
            this.icon = icon;
            this.title = title;
            this.content = content;
        }

        public TitleImageText(int img, String title, String content) {
            this.img = img;
            this.title = title;
            this.content = content;
        }
        public TitleImageText(int img, String title, int titleColor) {
            this.img = img;
            this.title = title;
            this.titleColor = titleColor;
        }
        public TitleImageText(int img, String title, String content, int titleColor, int contentColor) {
            this.img = img;
            this.title = title;
            this.content = content;
            this.titleColor = titleColor;
            this.contentColor = contentColor;
        }

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getTitleColor() {
            return titleColor;
        }

        public void setTitleColor(int titleColor) {
            this.titleColor = titleColor;
        }

        public int getContentColor() {
            return contentColor;
        }

        public void setContentColor(int contentColor) {
            this.contentColor = contentColor;
        }

        public Drawable getIcon() {
            return icon;
        }

        public void setIcon(Drawable icon) {
            this.icon = icon;
        }
    }
}

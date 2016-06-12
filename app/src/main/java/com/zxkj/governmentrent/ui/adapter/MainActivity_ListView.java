package com.zxkj.governmentrent.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.constant.Constant;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/4/10.
 */
public class MainActivity_ListView extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<ObjectBean> list;

    public MainActivity_ListView(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = Constant.getMainList();
    }

    @Override

    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_mainactivity_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemMainactivityListviewPicture.setImageResource(list.get(position).getPicture());
        holder.itemMainactivityListviewContent.setText(list.get(position).getContent());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.item_mainactivity_listview_Picture)
        ImageView itemMainactivityListviewPicture;
        @Bind(R.id.item_mainactivity_listview_Content)
        TextView itemMainactivityListviewContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 内部类
     */
    public static class ObjectBean {
        private int picture;
        private String content;

        public ObjectBean(int picture, String content) {
            this.picture = picture;
            this.content = content;
        }

        public ObjectBean() {
        }

        public int getPicture() {
            return picture;
        }

        public void setPicture(int picture) {
            this.picture = picture;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    }

}

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
 * Created by 林炜智 on 2016/4/11.
 */
public class ActivityRoom_GridView extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Constant.TitleImageText> list;

    public ActivityRoom_GridView(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = Constant.getActivityRoom_GridView();
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
            convertView = inflater.inflate(R.layout.item_activityroom_gridview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemActivityroomGridviewImageView.setImageResource(list.get(position).getImg());
        holder.itemActivityroomGridviewTitle.setText(list.get(position).getTitle());
        holder.itemActivityroomGridviewTitle.setTextColor(context.getResources().getColor(list.get(position).getTitleColor()));
        holder.itemActivityroomGridviewContent.setText(list.get(position).getContent());
        holder.itemActivityroomGridviewContent.setTextColor(context.getResources().getColor(list.get(position).getContentColor()));
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.item_activityroom_gridview_ImageView)
        ImageView itemActivityroomGridviewImageView;
        @Bind(R.id.item_activityroom_gridview_Title)
        TextView itemActivityroomGridviewTitle;
        @Bind(R.id.item_activityroom_gridview_Content)
        TextView itemActivityroomGridviewContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

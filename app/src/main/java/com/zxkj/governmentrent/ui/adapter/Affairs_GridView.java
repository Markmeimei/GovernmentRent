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
import com.zxkj.governmentrent.model.PoliticsNews_Model;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/4/11.
 */
public class Affairs_GridView extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Constant.TitleImageText> list;

    public Affairs_GridView(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = Constant.getAffairs_GridView();
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
            convertView = inflater.inflate(R.layout.item_affairs_gridview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemAffairsGridviewImageView.setImageResource(list.get(position).getImg());
        holder.itemAffairsGridviewTitle.setText(list.get(position).getTitle());
        holder.itemAffairsGridviewTitle.setTextColor(context.getResources().getColor(list.get(position).getTitleColor()));
        holder.itemAffairsGridviewContent.setText(list.get(position).getContent());
        holder.itemAffairsGridviewContent.setTextColor(context.getResources().getColor(list.get(position).getContentColor()));
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.item_affairs_gridview_ImageView)
        ImageView itemAffairsGridviewImageView;
        @Bind(R.id.item_affairs_gridview_Title)
        TextView itemAffairsGridviewTitle;
        @Bind(R.id.item_affairs_gridview_Content)
        TextView itemAffairsGridviewContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

package com.zxkj.governmentrent.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.model.PoliticsNews_Model;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/4/11.
 */
public class PoliticsNews_GridView extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<PoliticsNews_Model> list;

    public PoliticsNews_GridView(Context context, List<PoliticsNews_Model> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
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
            convertView = inflater.inflate(R.layout.item_politicsnews_gridview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemPoliticsnewsGridviewImageView.setImageResource(list.get(position).getImg());
        holder.itemPoliticsnewsGridviewTitle.setText(list.get(position).getTitle());
        holder.itemPoliticsnewsGridviewDate.setText(list.get(position).getDate());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.item_politicsnews_gridview_ImageView)
        ImageView itemPoliticsnewsGridviewImageView;
        @Bind(R.id.item_politicsnews_gridview_Title)
        TextView itemPoliticsnewsGridviewTitle;
        @Bind(R.id.item_politicsnews_gridview_Date)
        TextView itemPoliticsnewsGridviewDate;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

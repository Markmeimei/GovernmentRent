package com.zxkj.governmentrent.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxkj.governmentrent.R;
import com.zxkj.governmentrent.constant.Constant;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/4/12.
 */
public class Supermarket_GridView extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Constant.TitleImageText> list;

    public Supermarket_GridView(Context context, List<Constant.TitleImageText> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
//        this.list.add(new Constant.TitleImageText(R.mipmap.img_add_apply, "添加应用", "添加应用"));
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
            convertView = inflater.inflate(R.layout.item_supermarket_gridview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (list.get(position).getIcon() == null)
            holder.itemSupermarketGridviewImageView.setImageResource(list.get(position).getImg());
        else
            holder.itemSupermarketGridviewImageView.setImageDrawable(list.get(position).getIcon());
        holder.itemSupermarketGridviewTextView.setText(list.get(position).getTitle());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.item_supermarket_gridview_ImageView)
        ImageView itemSupermarketGridviewImageView;
        @Bind(R.id.item_supermarket_gridview_TextView)
        TextView itemSupermarketGridviewTextView;
        @Bind(R.id.item_supermarket_gridview_LinearLayout)
        LinearLayout itemSupermarketGridviewLinearLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

package com.paraches.android.tablistgridtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.paraches.android.tablistgridtest.dynamicgid.BaseDynamicGridAdapter;

import java.util.List;

/**
 * Created by tesshie on 2014/05/25.
 */
public class MyDynamicGridViewAdapter extends BaseDynamicGridAdapter {

    public MyDynamicGridViewAdapter(Context context, List<?> items, int columnCount) {
        super(context, items, columnCount);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridViewHolder holder;
        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.gridview_cell, null);
            holder = new GridViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (GridViewHolder)convertView.getTag();
        }

        holder.build((String)getItem(position));

        return convertView;
    }

    private class GridViewHolder {
        private TextView titleText;
        private ImageView imageView;

        private GridViewHolder(View view) {
            titleText = (TextView)view.findViewById(R.id.item_title);
            imageView = (ImageView)view.findViewById(R.id.item_img);
        }

        void build(String title) {
            titleText.setText(title);
            imageView.setImageResource(R.drawable.ic_launcher);
        }
    }

}

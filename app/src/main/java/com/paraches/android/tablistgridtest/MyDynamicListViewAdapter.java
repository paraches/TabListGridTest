package com.paraches.android.tablistgridtest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.paraches.android.tablistgridtest.R;
import com.paraches.android.tablistgridtest.listviewdragginganimation.StableArrayAdapter;

import java.util.List;

/**
 * Created by tesshie on 2014/05/25.
 */
public class MyDynamicListViewAdapter extends StableArrayAdapter {
    private LayoutInflater mInflater;

    public MyDynamicListViewAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);

        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ListViewHolder viewHolder;

        if (convertView==null) {
            view = mInflater.inflate(R.layout.listview_cell, parent, false);
            TextView textView = (TextView)view.findViewById(R.id.text_view);
            ImageView imageView = (ImageView)view.findViewById(R.id.image_view);
            viewHolder = new ListViewHolder(imageView, textView);
            view.setTag(viewHolder);
        }
        else {
            view = convertView;
            viewHolder = (ListViewHolder)view.getTag();
        }

        viewHolder.textView.setText(getItem(position));

        return view;
    }

    private class ListViewHolder {
        ImageView imageView;
        TextView textView;

        public ListViewHolder(ImageView imageView, TextView textView) {
            this.imageView = imageView;
            this.textView = textView;
        }
    }
}

package com.paraches.android.tablistgridtest;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.paraches.android.tablistgridtest.listviewdragginganimation.Cheeses;
import com.paraches.android.tablistgridtest.listviewdragginganimation.DynamicListView;

import java.util.ArrayList;

/**
 * Created by tesshie on 2014/05/25.
 */
public class MyDynamicListViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_listview, container, false);
        DynamicListView dynamicListView = (DynamicListView)rootView.findViewById(R.id.dynamic_listview);

        ArrayList<String>cheeseList = new ArrayList<String>();
        for (int i = 0; i < Cheeses.sCheeseStrings.length; ++i) {
            cheeseList.add(Cheeses.sCheeseStrings[i]);
        }

        MyDynamicListViewAdapter adapter = new MyDynamicListViewAdapter(getActivity().getApplicationContext(), R.layout.listview_cell, cheeseList);

        dynamicListView.setCheeseList(cheeseList);
        dynamicListView.setAdapter(adapter);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB) {
            dynamicListView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        }

        return rootView;
    }
}

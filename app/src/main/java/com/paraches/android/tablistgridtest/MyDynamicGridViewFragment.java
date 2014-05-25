package com.paraches.android.tablistgridtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.paraches.android.tablistgridtest.dynamicgid.DynamicGridView;
import com.paraches.android.tablistgridtest.listviewdragginganimation.Cheeses;

import java.util.ArrayList;

/**
 * Created by tesshie on 2014/05/25.
 */
public class MyDynamicGridViewFragment extends Fragment {
    private DynamicGridView mDynamicGridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gridview, container, false);
        mDynamicGridView = (DynamicGridView)rootView.findViewById(R.id.dynamic_gridview);

        ArrayList<String> cheeseList = new ArrayList<String>();
        for (int i = 0; i < Cheeses.sCheeseStrings.length; ++i) {
            cheeseList.add(Cheeses.sCheeseStrings[i]);
        }

        final MyDynamicGridViewAdapter adapter = new MyDynamicGridViewAdapter(getActivity().getApplicationContext(), cheeseList, 4);
        mDynamicGridView.setAdapter(adapter);
        mDynamicGridView.setOnDropListener(new DynamicGridView.OnDropListener() {
            @Override
            public void onActionDrop() {
                ((MainActivity)getActivity()).setViewPagerSwipe(true);
                mDynamicGridView.stopEditMode();
            }
        });
        mDynamicGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((MainActivity)getActivity()).setViewPagerSwipe(false);
                mDynamicGridView.startEditMode();
                return false;
            }
        });
        mDynamicGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String cheese = (String)adapterView.getAdapter().getItem(position);
                Toast.makeText(getActivity().getApplicationContext(), cheese, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}

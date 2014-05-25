package com.paraches.android.tablistgridtest;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by tesshie on 2014/05/25.
 */
public class MyViewPager extends ViewPager {
    private boolean swipeEnabled = true;

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (swipeEnabled) {
            return super.onTouchEvent(ev);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (swipeEnabled) {
            return super.onInterceptTouchEvent(ev);
        }
        else {
            return false;
        }
    }

    public void setSwipeEnabled(boolean state) {
        swipeEnabled = state;
    }

    public boolean getSwipeEnabled() {
        return swipeEnabled;
    }
}

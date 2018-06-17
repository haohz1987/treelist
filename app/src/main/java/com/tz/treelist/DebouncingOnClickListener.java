package com.tz.treelist;

import android.view.View;

/**
 * ***********************************************************************
 * Author:haohz
 * CreateData:2018-05-01 11:48
 * Version:1.0
 * Description:点击事件去抖
 * ***********************************************************************
 */
public abstract class DebouncingOnClickListener implements View.OnClickListener {
    private static boolean enabled = true;

    private static final Runnable ENABLE_AGAIN = new Runnable() {
        @Override
        public void run() {
            enabled = true;
        }
    };

    @Override
    public final void onClick(View v) {
        if (enabled) {
            enabled = false;
//            v.postDelayed(ENABLE_AGAIN,100);//延时0.1s可点击
            v.post(ENABLE_AGAIN);
            doClick(v);
        }
    }
    public abstract void doClick(View v);
}
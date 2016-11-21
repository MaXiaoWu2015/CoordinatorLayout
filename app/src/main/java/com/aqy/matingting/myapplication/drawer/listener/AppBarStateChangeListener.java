package com.aqy.matingting.myapplication.drawer.listener;

import android.support.design.widget.AppBarLayout;
import android.util.Log;

/**
 * Created by matingting on 2016/11/21.
 */

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
    private static final String TAG = "AppBarStateChangeListen";
    public static final int EXPANDED=0;
    public static final int COLLAPSED=1;
    public static final int IDLE=2;
    private int mCurrentState=EXPANDED;
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        Log.d(TAG, "onOffsetChanged: "+verticalOffset+":"+appBarLayout.getTotalScrollRange());
        int totalScrollRange=appBarLayout.getTotalScrollRange();

        if (verticalOffset==0){
            if (mCurrentState!=EXPANDED){
                onStateChanged(appBarLayout,verticalOffset,EXPANDED);
            }
            mCurrentState=EXPANDED;
        }else if (Math.abs(verticalOffset)>=totalScrollRange){
            if (mCurrentState!=COLLAPSED){
                onStateChanged(appBarLayout,verticalOffset,COLLAPSED);
            }
            mCurrentState=COLLAPSED;
        }else {
            if (mCurrentState!=IDLE){
                onStateChanged(appBarLayout,verticalOffset,IDLE);
            }
            mCurrentState=IDLE;
        }
        onOffsetChanged(totalScrollRange,verticalOffset);
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout,int verticalOffset, int state);

    public abstract void onOffsetChanged(int totalScrollRange,int verticalOffset);
}

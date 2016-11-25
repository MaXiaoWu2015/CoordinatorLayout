package com.aqy.matingting.myapplication.drawer.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

/**
 * Created by liuhonghai on 2016/6/28.
 */
public class LinearLayoutForListView extends LinearLayout {

    //V7.11 add onclick in hit top page by langjian@qiyi.com
    private OnItemClickListener mOnItemClickListener;

    public LinearLayoutForListView(Context context) {
        super(context);
    }

    public LinearLayoutForListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayoutForListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 绑定布局
     */
    public void setAdapter(BaseAdapter adapter) {
        int count = adapter.getCount();
        this.removeAllViews();
        for (int i = 0; i < count; i++) {
            View v = adapter.getView(i, null, null);

            //V7.11 add 给item添加点击事件
            final int finalPosition = i;
            v.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnItemClickListener != null){
                        mOnItemClickListener.onItemClick(finalPosition);
                    }
                }
            });
            addView(v, i);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(@Nullable LinearLayoutForListView.OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

}

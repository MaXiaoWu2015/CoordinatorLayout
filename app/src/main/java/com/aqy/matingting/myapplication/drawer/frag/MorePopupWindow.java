package com.aqy.matingting.myapplication.drawer.frag;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.aqy.matingting.myapplication.R;

import Utils.ViewUtils;

/**
 * Created by matingting on 2016/11/23.
 */

public class MorePopupWindow {
    public static void show(final Activity context,String[] items,View anchor){
        ViewGroup viewGroup= (ViewGroup) LayoutInflater.from(context).inflate(R.layout.toolbar_more_dialog,null,false);

        int popupWidth= ViewUtils.dp2px(context,120);
        int itemHeight = ViewUtils.dp2px(context, 40);
        final PopupWindow popupWindow=new PopupWindow(viewGroup,popupWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));

        //两个一起设置
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);


        //添加item项
        String item="";
        for (int i=0;i< items.length;i++){
             item=items[i];
            TextView textView=new TextView(context);
            textView.setText(item);
            textView.setId(i);
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(context.getResources().getColor(R.color.color_333333));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
            LinearLayout.LayoutParams itemLayoutParams=new LinearLayout.LayoutParams(popupWidth,itemHeight);
            viewGroup.addView(textView,itemLayoutParams);

            final String finalItem = item;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ViewUtils.showToast(context, finalItem);
                    popupWindow.dismiss();
                }
            });
            //添加item的分割线
            if (i!=items.length-1){
                View view=new View(context);
                view.setBackgroundColor(context.getResources().getColor(R.color.cell_separate_line_dark));
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,1);
                viewGroup.addView(view,layoutParams);
            }

        }
        //设置PopupWindow的位置
        int xOffset=ViewUtils.dp2px(context,90);
        int yOffset=ViewUtils.dp2px(context,3);
        popupWindow.showAsDropDown(anchor,-xOffset,yOffset);
        ViewUtils.changeBackgroundAlpha(context,0.5f);


        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ViewUtils.changeBackgroundAlpha(context,1.0f);
            }
        });
    }
}

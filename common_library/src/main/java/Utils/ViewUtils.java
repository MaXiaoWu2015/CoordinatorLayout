package Utils;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by matingting on 2016/11/23.
 */

public class ViewUtils {
    public static int dp2px(Context context,float dp){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }

    public static void showToast(Context context,String content){
        Toast.makeText(context,content,Toast.LENGTH_LONG).show();
    }

    // 设置PopupWindow以外部分的背景颜色  有一种变暗的效果
    public static void changeBackgroundAlpha(Activity context, float alpha){

        WindowManager.LayoutParams wlBackground=context.getWindow().getAttributes();
        wlBackground.alpha=alpha;
        context.getWindow().setAttributes(wlBackground);
    }
}

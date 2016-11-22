package com.aqy.matingting.myapplication.drawer.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aqy.matingting.myapplication.R;

/**
 * Created by matingting on 2016/11/22.
 *
 * toolbar上‘更多’的对话框
 */

public class ToolBarMoreDialog extends DialogFragment implements View.OnClickListener{
    public static String DIALOG_TYPE="type";
    private int type;

    private TextView tvShare;
    private TextView tvDetail;
    private TextView tvFeedback;
    public static ToolBarMoreDialog newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(DIALOG_TYPE,type);
        ToolBarMoreDialog fragment = new ToolBarMoreDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type= (int) getArguments().get(DIALOG_TYPE);

        // Pick a style based on the num.
//        int style = DialogFragment.STYLE_NORMAL, theme = 0;
//        switch ((type-1)%6) {
//            case 1: style = DialogFragment.STYLE_NO_TITLE; break;
//            case 2: style = DialogFragment.STYLE_NO_FRAME; break;
//            case 3: style = DialogFragment.STYLE_NO_INPUT; break;
//            case 4: style = DialogFragment.STYLE_NORMAL; break;
//            case 5: style = DialogFragment.STYLE_NORMAL; break;
//            case 6: style = DialogFragment.STYLE_NO_TITLE; break;
//            case 7: style = DialogFragment.STYLE_NO_FRAME; break;
//            case 8: style = DialogFragment.STYLE_NORMAL; break;
//        }
//        switch ((type-1)%6) {
//            case 4: theme = android.R.style.Theme_Holo; break;
//            case 5: theme = android.R.style.Theme_Holo_Light_Dialog; break;
//            case 6: theme = android.R.style.Theme_Holo_Light; break;
//            case 7: theme = android.R.style.Theme_Holo_Light_Panel; break;
//            case 8: theme = android.R.style.Theme_Holo_Light; break;
//        }
//        setStyle(style, theme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.toolbar_more_dialog,container,false);
        tvShare= (TextView) view.findViewById(R.id.more_dialog_tv_share);
        tvDetail= (TextView) view.findViewById(R.id.more_dialog_tv_detail);
        tvFeedback= (TextView) view.findViewById(R.id.more_dialog_tv_feedback);
        tvShare.setOnClickListener(this);
        tvDetail.setOnClickListener(this);
        tvFeedback.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.more_dialog_tv_share:break;
            case R.id.more_dialog_tv_detail:break;
            case R.id.more_dialog_tv_feedback:break;
        }
    }
}

package com.aqy.matingting.myapplication.drawer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aqy.matingting.myapplication.R;

import java.util.ArrayList;

/**
 * Created by matingting on 2016/11/24.
 */

public class NormalTaskListAdapter extends BaseAdapter {
    private ArrayList<String>  mDataList=new ArrayList<>();
    private Context mContext;

    public NormalTaskListAdapter(ArrayList<String> dataList, Context context) {
        mDataList = dataList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        TaskViewHolder taskViewHolder=null;
        if (convertview==null){
             taskViewHolder=new TaskViewHolder();
             convertview= LayoutInflater.from(mContext).inflate(R.layout.task_item,viewGroup,false);
            taskViewHolder.mTextView= (TextView) convertview.findViewById(R.id.textView3);
            convertview.setTag(taskViewHolder);
        }else{
            taskViewHolder= (TaskViewHolder) convertview.getTag();
        }
        taskViewHolder.mTextView.setText(mDataList.get(i));
        return convertview;
    }

    class TaskViewHolder{
        public TextView mTextView;
    }
}

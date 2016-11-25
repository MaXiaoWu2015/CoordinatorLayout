package com.aqy.matingting.myapplication.drawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aqy.matingting.myapplication.R;
import com.aqy.matingting.myapplication.drawer.adapter.NormalTaskListAdapter;
import com.aqy.matingting.myapplication.drawer.view.LinearLayoutForListView;

import java.util.ArrayList;
import java.util.Arrays;

import Utils.ViewUtils;

public class TaskCenterActivity extends AppCompatActivity {
    private TextView tvDailyTask;
    private LinearLayoutForListView llnormalTaskList;
    private ViewGroup.MarginLayoutParams llnormalTaskListMarginParams;
    private boolean isExpanded;
    private ArrayList<String> mTasks=new ArrayList<>(Arrays.asList("task1","task2","task3","task1",
            "task2","task3","task1","task2","task3","task1","task2","task3"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_center);
        tvDailyTask= (TextView) findViewById(R.id.daily_task_title_view);
        llnormalTaskList= (LinearLayoutForListView) findViewById(R.id.normal_task_list);
        llnormalTaskList.setAdapter(new NormalTaskListAdapter(mTasks,TaskCenterActivity.this));
        llnormalTaskListMarginParams=
                (ViewGroup.MarginLayoutParams) llnormalTaskList.getLayoutParams();

        tvDailyTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewUtils.showToast(TaskCenterActivity.this,"日常任务");
                if (!isExpanded){
                    //FIXME:margin为负值，view跑哪去了
                   llnormalTaskListMarginParams.topMargin=-llnormalTaskList.getHeight()-tvDailyTask.getHeight();
                   isExpanded=true;
               }else {
                   llnormalTaskListMarginParams.topMargin=0;
                   isExpanded=false;
               }
                llnormalTaskList.setLayoutParams(llnormalTaskListMarginParams);
            }
        });
    }

    public void test(View view){
        ViewUtils.showToast(TaskCenterActivity.this,"Yeah!");
    }
}

package com.aqy.matingting.myapplication.drawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aqy.matingting.myapplication.R;
import com.aqy.matingting.myapplication.drawer.adapter.NormalTaskListAdapter;
import com.aqy.matingting.myapplication.drawer.view.LinearLayoutForListView;

import java.util.ArrayList;
import java.util.Arrays;

import Utils.ViewUtils;

public class TaskCenterActivity extends AppCompatActivity {
    private static final String TAG = "TaskCenterActivity";
    private ScrollView svTaskList;
    private TextView tvDailyTask;
    private TextView tvRewardTask;
    private RelativeLayout rlTaskCenterHeader;
    private LinearLayoutForListView llNormalTaskList;
    private LinearLayoutForListView llRewardTaskList;
    private ViewGroup.MarginLayoutParams llNormalTaskListMarginParams;
    private ViewGroup.MarginLayoutParams rlTaskCenterHeaderMarginParams;
    private NormalTaskListAdapter dailyTaskAdapter;
    private boolean isExpanded;
    private boolean isHeaderShow=true;
    private int     currentHeight;


    //TestData
    private ArrayList<String> mTasks=new ArrayList<>(Arrays.asList("task1","task2","task3","task1",
            "task2","task3","task1","task2","task3","task1","task2","task3","task2","task3","task1","task2","task3","task1","task2","task3"));
    private boolean firstTime=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_center);
        initView();
    }

    public void initView(){

        svTaskList= (ScrollView) findViewById(R.id.sv_task_list);
        rlTaskCenterHeader= (RelativeLayout) findViewById(R.id.rl_task_center_header);
        tvDailyTask= (TextView) findViewById(R.id.daily_task_title_view);
        tvRewardTask= (TextView) findViewById(R.id.reward_task_title_view);
        llRewardTaskList= (LinearLayoutForListView) findViewById(R.id.reward_task_list);
        llNormalTaskList = (LinearLayoutForListView) findViewById(R.id.normal_task_list);

        dailyTaskAdapter=new NormalTaskListAdapter(mTasks,TaskCenterActivity.this);

//        llNormalTaskList.setAdapter(dailyTaskAdapter);
        llRewardTaskList.setAdapter(dailyTaskAdapter);

        llNormalTaskListMarginParams =
                (ViewGroup.MarginLayoutParams) llNormalTaskList.getLayoutParams();
        rlTaskCenterHeaderMarginParams=
                (ViewGroup.MarginLayoutParams) rlTaskCenterHeader.getLayoutParams();

        Log.d(TAG, "onCreate headerShowState: "+rlTaskCenterHeader.getHeight());

        tvDailyTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewUtils.showToast(TaskCenterActivity.this,"日常任务");
                if (firstTime){
                    llNormalTaskList.setAdapter(dailyTaskAdapter);
                    firstTime=false;
                }else{
                    if (!isExpanded){
                        //FIXME:margin为负值，view跑哪去了
                        setTopMarginParams(-llNormalTaskList.getHeight()-tvDailyTask.getHeight(),llNormalTaskListMarginParams);
                        isExpanded=true;
                    }else {
                        setTopMarginParams(0,llNormalTaskListMarginParams);
                        isExpanded=false;

                    }
                    llNormalTaskList.setLayoutParams(llNormalTaskListMarginParams);
                }
                headerShowState();

            }
        });
    }


    public void setTopMarginParams(int margin, ViewGroup.MarginLayoutParams llNormalTaskListMarginParams){
        llNormalTaskListMarginParams.topMargin=margin;
        llNormalTaskList.setLayoutParams(llNormalTaskListMarginParams);
    }

    //View滑动的三种方式：1scrollTo、scrollBy 2.改变LayoutParams 3.平移动画
    public void headerShowState(){
//        svTaskList.post(new Runnable() {
//            @Override
//            public void run() {
////                    Log.d(TAG, "headerShowState: "+rlTaskCenterHeader.getHeight());
//
//        });
                            Log.d(TAG, "headerShowState: "+svTaskList.getScrollY()+":"+rlTaskCenterHeader.getHeight());
                            if (svTaskList.getScrollY()==0 &&!isExpanded){
                                svTaskList.smoothScrollTo(0,rlTaskCenterHeader.getHeight());
                                isHeaderShow=false;
                            }else if (isExpanded && svTaskList.getScrollY()!=0){
                                svTaskList.smoothScrollTo(0,0);
                                isHeaderShow=true;
                            }


        //下面这两种方法，当header隐藏后，就不能随着滚动了
//        if (!isHeaderShow){
//            rlTaskCenterHeaderMarginParams.topMargin=0;
////            ObjectAnimator.ofFloat(svTaskList,"translationY",0,-rlTaskCenterHeader.getHeight()).setDuration(100).start();
//            isHeaderShow=true;
//        }else{
//            rlTaskCenterHeaderMarginParams.topMargin=-rlTaskCenterHeader.getHeight();
//            isHeaderShow=false;
//        }
//        rlTaskCenterHeader.setLayoutParams(rlTaskCenterHeaderMarginParams);
    }

    public void taskTitleClick(){

    }


    public void test(View view){
        ViewUtils.showToast(TaskCenterActivity.this,"Yeah!");
    }
}

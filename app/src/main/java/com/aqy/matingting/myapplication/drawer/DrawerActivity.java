package com.aqy.matingting.myapplication.drawer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aqy.matingting.myapplication.R;
import com.aqy.matingting.myapplication.drawer.adapter.MyViewPagerAdapter;
import com.aqy.matingting.myapplication.drawer.frag.MorePopupWindow;
import com.aqy.matingting.myapplication.drawer.listener.AppBarStateChangeListener;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 *
 * */
public class DrawerActivity extends AppCompatActivity {
    private static final String TAG = "DrawerActivity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private FloatingActionButton floatingActionButton;
    private TextView toolbarTitle;
    private TextView toolbarBack;
    private TextView toolbarGroupChat;
    private TextView toolbarShare;
    private TextView toolbarMore;
    private Button   taskBtn;


    private ArrayList<String> tabList =new ArrayList<>(Arrays.asList("明星","推荐","我的","阅读"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        initVar();
        initView();

    }
    public void initVar() {}

    public void initView() {
        //Toolbar
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.drawer_toolbar);
        setSupportActionBar(toolbar);
        ////设置返回键可用
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setBackgroundColor(Color.argb(0, 128, 255, 255));
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });


        toolbarBack= (TextView) findViewById(R.id.toolbar_back);
        toolbarGroupChat= (TextView) findViewById(R.id.toolbar_group_chat);
        toolbarShare= (TextView) findViewById(R.id.toolbar_share);
        toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        toolbarGroupChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到群聊页面
            }
        });

        toolbarShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        toolbarMore= (TextView) findViewById(R.id.toolbar_more);
        toolbarMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] items={"反馈","圈子资料","分享"};
                MorePopupWindow.show(DrawerActivity.this,items,toolbarMore);
            }
        });

        //AppBarLayout
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarLayout);
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, int verticalOffset, int state) {
                stateChange(appBarLayout, verticalOffset, state);
            }

            @Override
            public void onOffsetChanged(int totalScrollRange, int verticalOffset) {
                changeToolBarAlpha(totalScrollRange, verticalOffset);
            }
        });

        //ViewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), tabList);
        viewPager.setAdapter(myViewPagerAdapter);

        //TableLayout
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < 4; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabList.get(i)));
        }
        tabLayout.setupWithViewPager(viewPager);


        taskBtn= (Button) findViewById(R.id.task_btn);
        taskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DrawerActivity.this,TaskCenterActivity.class));
            }
        });
    }

    /**
     * AppBarLayout 状态的变化   展开 OR  折叠
     * */
    private void stateChange(AppBarLayout appBarLayout, int verticalOffset, int state) {
        if (state == AppBarStateChangeListener.COLLAPSED) {
            toolbarTitle.setText("COLLAPSED");
        } else if (state == AppBarStateChangeListener.EXPANDED) {
            toolbarTitle.setText("标题");
        }
    }
    /**
     * toolbar背景透明度的变化
     * */
    private void changeToolBarAlpha(int totalScrollRange, int verticalOffset) {
        verticalOffset = Math.abs(verticalOffset);
        if (verticalOffset <= totalScrollRange) {
            float scale = (float) (verticalOffset * 1.0 / totalScrollRange);
            Log.d(TAG, "changeToolBarAlpha: " + scale);
            float alpha = scale * 255;
            toolbar.setBackgroundColor(Color.argb((int) alpha, 128, 255, 255));
        } else {
            toolbar.setBackgroundColor(Color.WHITE);
        }
    }

}

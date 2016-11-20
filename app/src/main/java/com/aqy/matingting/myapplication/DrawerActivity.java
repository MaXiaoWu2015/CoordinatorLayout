package com.aqy.matingting.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawerActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private List<View> views=new ArrayList<View>() ;
    private Toolbar toolbar;
//    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
//    private FloatingActionButton floatingActionButton;
    private ArrayList<String> list= new ArrayList<>() ;
    private ArrayList<String> tablist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        initVar();
        initView();

    }

    public void initVar(){
        list.add("123");
        list.add("1232");
        list.add("1231");
        list.add("1232");
        list.add("1233");
        list.add("1235");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");


        tablist.add("明星");
        tablist.add("推荐");
        tablist.add("我的");
        tablist.add("阅读");
    }

    @SuppressLint("WrongViewCast")
    public void initView(){
//        recyclerView= (RecyclerView) findViewById(R.id.recylerview);
//        recyclerView.setAdapter(new MyAdapter(this,list));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        toolbar= (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        tabLayout= (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i=0;i<4;i++){
            tabLayout.addTab(tabLayout.newTab().setText(tablist.get(i)));
        }


        viewPager= (ViewPager) findViewById(R.id.viewpager);
        myViewPagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager(),tablist);
        viewPager.setAdapter(myViewPagerAdapter);


        tabLayout.setupWithViewPager(viewPager);



        //        toolbar.setTitle("ToolBar");
//        toolbar.setSubtitle("toolbar");
//        toolbar.setNavigationIcon(R.drawable.back);
//        floatingActionButton= (FloatingActionButton) findViewById(R.id.floatingBtn);
//        coordinatorLayout= (CoordinatorLayout) findViewById(R.id.activity_main);
    }
}

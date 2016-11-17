package com.aqy.matingting.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DrawerActivity extends AppCompatActivity {
//    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
//    private FloatingActionButton floatingActionButton;
    private ArrayList<String> list= new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
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
        recyclerView= (RecyclerView) findViewById(R.id.recylerview);
        recyclerView.setAdapter(new MyAdapter(this,list));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        floatingActionButton= (FloatingActionButton) findViewById(R.id.floatingBtn);
//        coordinatorLayout= (CoordinatorLayout) findViewById(R.id.activity_main);
    }
}

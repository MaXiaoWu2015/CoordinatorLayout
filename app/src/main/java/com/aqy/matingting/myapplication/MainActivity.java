package com.aqy.matingting.myapplication;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aqy.matingting.myapplication.drawer.adapter.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private ArrayList<String> list= new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        floatingActionButton= (FloatingActionButton) findViewById(R.id.floatingBtn);
        coordinatorLayout= (CoordinatorLayout) findViewById(R.id.activity_main);
    }
    public void showSnackBar(View view){
        //FIXME:当点击按钮出现snackbar，snackbar消失后，按钮位置下移,当把Coordinator的padding去掉，则没有问题
        Snackbar.make(view, "SnackbarTest", Snackbar.LENGTH_LONG).show();
    }
}

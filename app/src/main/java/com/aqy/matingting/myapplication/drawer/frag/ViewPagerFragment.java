package com.aqy.matingting.myapplication.drawer.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aqy.matingting.myapplication.R;
import com.aqy.matingting.myapplication.drawer.adapter.MyAdapter;

import java.util.ArrayList;

/**
 * Created by matingting on 2016/11/21.
 */

public class ViewPagerFragment extends Fragment{
    private RecyclerView recyclerView;
    private int mPage;
    private static final String ARGS_PAGE="args_page";
    ArrayList<String> list=new ArrayList<>();
    public static ViewPagerFragment  newInstance(int page) {
        Bundle args=new Bundle();
        args.putInt(ARGS_PAGE,page);
        ViewPagerFragment viewPagerFragment=new ViewPagerFragment();
        viewPagerFragment.setArguments(args);
        return  viewPagerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPage=getArguments().getInt(ARGS_PAGE);
        initVar();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tabfrag,container,false);

        recyclerView= (RecyclerView) view.findViewById(R.id.frag_recylerview);
        recyclerView.setAdapter(new MyAdapter(getActivity(),list));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        return view;
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

    }

}

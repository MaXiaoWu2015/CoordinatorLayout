package com.aqy.matingting.myapplication.HorizontalScrollView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aqy.matingting.myapplication.R;
import com.aqy.matingting.myapplication.drawer.frag.ViewPagerFragment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by matingting on 2016/11/28.
 * 最简单的方式实现tab indicator，没有indicator的滑动效果，效果有点生硬
 */

public class TabIndicatorFragment0 extends Fragment implements ViewPager.OnPageChangeListener {
    private static final String TAG = "TabIndicatorFragment0";
    private LinearLayout llTabContainer;
    private ViewPager mainViewPager;
    private HorizontalScrollView mHorizontalScrollView;
    private ArrayList<Fragment> fragments;
    private MyPagerAdapter pagerAdapter;
    private int curSelectedTabIndex = 0;
    private ArrayList<String> tablist = new ArrayList<>(
            Arrays.asList("全部", "氪TV", "O2O", "新硬件", "Fun!!", "企业服务", "Fit&Health", "在线教育", "互联网金融",
                    "大公司", "专栏", "新产品"));

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag0_tab_indicator, container, false);
        loadData();
        initView(view);
        return view;
    }

    public void loadData() {

    }

    public void initView(View fragLayout) {
        llTabContainer = (LinearLayout) fragLayout.findViewById(R.id.tab_container);
        mainViewPager = (ViewPager) fragLayout.findViewById(R.id.main_viewpager);
        mHorizontalScrollView = (HorizontalScrollView) fragLayout.findViewById(R.id.tab_scrollview);

        fragments = new ArrayList<>();
        for (int i = 0; i < tablist.size(); i++) {
            fragments.add(new ViewPagerFragment());
        }
        pagerAdapter = new MyPagerAdapter(getFragmentManager());
        pagerAdapter.setFragments(fragments);
        mainViewPager.setAdapter(pagerAdapter);
        mainViewPager.setOnPageChangeListener(this);
        addTabsToContainer();

    }

    public void addTabsToContainer() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        for (int i = 0; i < tablist.size(); i++) {
            final View tabItem = inflater.inflate(R.layout.tab_item, null);
            TextView tabText = (TextView) tabItem.findViewById(R.id.tab);
            tabText.setText(tablist.get(i));
            if (i == 0) {
                ImageView IvIndicator = (ImageView) tabItem.findViewById(R.id.iv_indicator);
                IvIndicator.setBackground(
                        new ColorDrawable(getResources().getColor(R.color.tab_indicator_red)));
            }
//            Drawable drawable=getResources().getDrawable(R.drawable.tab_indicator);
//            drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
//            tabText.setCompoundDrawables(null,null,null,drawable);
            tabItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView lastIvIndicator =
                            (ImageView) llTabContainer.getChildAt(curSelectedTabIndex).findViewById(
                                    R.id.iv_indicator);
                    lastIvIndicator.setBackground(null);

                    ImageView IvIndicator = (ImageView) view.findViewById(R.id.iv_indicator);
                    IvIndicator.setBackground(
                            new ColorDrawable(getResources().getColor(R.color.tab_indicator_red)));
                    curSelectedTabIndex = llTabContainer.indexOfChild(view);
                    mainViewPager.setCurrentItem(curSelectedTabIndex, true);
                }
            });

            llTabContainer.addView(tabItem, i);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(getActivity(),position+"",Toast.LENGTH_SHORT).show();
        View tabItem = llTabContainer.getChildAt(position);
        ImageView lastIvIndicator =
                (ImageView) llTabContainer.getChildAt(curSelectedTabIndex).findViewById(
                        R.id.iv_indicator);
        lastIvIndicator.setBackground(null);

        ImageView IvIndicator = (ImageView) tabItem.findViewById(R.id.iv_indicator);
        IvIndicator.setBackground(
                new ColorDrawable(getResources().getColor(R.color.tab_indicator_red)));
        mHorizontalScrollView.smoothScrollTo(tabItem.getLeft()-tabItem.getWidth(),0);
        curSelectedTabIndex = position;
    }
    @Override
    public void onPageScrollStateChanged(int state) {
    }
}

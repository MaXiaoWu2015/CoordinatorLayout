package com.aqy.matingting.myapplication.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
/**
 * Created by matingting on 2016/11/21.
 */

public class BaseFragment extends Fragment {

    public String mFragmentId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentId();
    }
    public String getFragmentId(){
        if (mFragmentId==null){
            StringBuilder sb=new StringBuilder();
            sb.append(this.getClass().getName()).append(":").append(this);
            mFragmentId=sb.toString();
        }
        return mFragmentId;
    }
}

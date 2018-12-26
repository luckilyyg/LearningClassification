package com.crazy.learn.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazy.learn.R;
import com.crazy.learn.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StringContentFragment extends Fragment {


    public StringContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_string, container, false);
//        Log.d("StringContentFragment:", StringUtil.priceInteger(68.6637));
//        Log.d("StringContentFragment:", StringUtil.priceDecimal(68.6637));
//        Log.d("StringContentFragment:", StringUtil.imgUrlName("http://img.my.csdn.net/uploads/201308/31/1377949442_4562.jpg"));
//        Log.d("StringContentFragment:", StringUtil.imgUrlExt("http://img.my.csdn.net/uploads/201308/31/1377949442_4562.jpg"));
//        Log.d("StringContentFragment:", StringUtil.priceBaoDecimal(68.6637) + "");
        List<String> mList = new ArrayList<>();
        mList.add("A");
        mList.add("B");
        mList.add("C");
        mList.add("D");
        mList.add("E");
        mList.add("F");
//        Log.d("StringContentFragment:", StringUtil.append(mList));
        String sStr = StringUtil.append(mList);
//        Log.d("StringContentFragment:", StringUtil.resolved(sStr) + "");
        double d1 = 86.50;
        double d2 = 45.2739;
//        Log.d("StringContentFragment:", StringUtil.add(d1,d2)+"");
//        Log.d("StringContentFragment:", StringUtil.sub(d1,d2)+"");
//        Log.d("StringContentFragment:", StringUtil.round(d1,2)+"");
//        Log.d("StringContentFragment:", StringUtil.roundUp(d1,2)+"");
//        Log.d("StringContentFragment:", StringUtil.convertsToFloat(d1)+"");
//        Log.d("StringContentFragment:", StringUtil.convertsToInt(d1)+"");

        return view;
    }

}

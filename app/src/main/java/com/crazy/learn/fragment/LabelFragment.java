package com.crazy.learn.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crazy.learn.R;
import com.crazy.learn.adapter.LabelAdapter;
import com.crazy.learn.bean.LabelInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView
 * 项目中用到
 * 多个item的时候 数据重组
 */
public class LabelFragment extends Fragment {

    private RecyclerView mRvLabel;
    private View mRootView;
    private RelativeLayout mRlSure;
    private TextView mTvShowContentChoose;
    private LabelAdapter labelAdapter;
    private List<LabelInfo> mInfoList;
    private List<String> mFinalList = new ArrayList<>();

    public LabelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_label, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRvLabel = mRootView.findViewById(R.id.rv_label);
        mRlSure = mRootView.findViewById(R.id.rl_sure);
        mTvShowContentChoose=mRootView.findViewById(R.id.tvshowchoose);
        init();
        initListener();

    }

    private void initListener() {
        mRlSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<LabelInfo> mData = labelAdapter.getData();
                for (LabelInfo mm : mData) {
                    if (mm.isCheck()) {
                        mFinalList.add(mm.getmLabelList().get(0));
                    } else {
                        Toast.makeText(getActivity(), "未选齐", Toast.LENGTH_SHORT).show();
                        mFinalList.clear();
                        return;
                    }
                }
                mRvLabel.setVisibility(View.GONE);
                mRlSure.setVisibility(View.GONE);
                mTvShowContentChoose.setVisibility(View.VISIBLE);
                mTvShowContentChoose.setText(mFinalList.toString());
                Toast.makeText(getActivity(), mFinalList.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<LabelInfo> getData() {
        //绑定数据
        mInfoList = new ArrayList<>();
        List<String> mColorList = new ArrayList<>();
        mColorList.add("红色");
        mColorList.add("橘色");
        mColorList.add("蓝色");
        mInfoList.add(new LabelInfo("颜色", mColorList));
        List<String> mSizeList = new ArrayList<>();
        mSizeList.add("S");
        mSizeList.add("M");
        mSizeList.add("L");
        mSizeList.add("XL");
        mSizeList.add("XXL");
        mSizeList.add("XXXL");
        mInfoList.add(new LabelInfo("尺寸", mSizeList));
        List<String> mCapacityList = new ArrayList<>();
        mCapacityList.add("16G");
        mCapacityList.add("32G");
        mCapacityList.add("64G");
        mCapacityList.add("128G");
        mCapacityList.add("256G");
        mInfoList.add(new LabelInfo("容量", mCapacityList));


        return mInfoList;
    }

    private void init() {
        mRvLabel.setLayoutManager(new LinearLayoutManager(getActivity()));
        labelAdapter = new LabelAdapter();
        labelAdapter.setNewData(getData());
        mRvLabel.setAdapter(labelAdapter);

    }
}

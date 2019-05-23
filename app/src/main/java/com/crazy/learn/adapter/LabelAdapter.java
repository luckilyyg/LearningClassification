package com.crazy.learn.adapter;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.crazy.learn.R;
import com.crazy.learn.bean.LabelInfo;

import java.util.ArrayList;
import java.util.List;

import library.FlowTagLayout;
import library.OnTagClickListener;
import library.OnTagSelectListener;
import library.TagAdapter;

/**
 * 作者：Administrator
 * 时间：2019/5/17
 * 功能：
 */
public class LabelAdapter extends BaseQuickAdapter<LabelInfo, BaseViewHolder> {

    public LabelAdapter() {
        super(R.layout.rv_label_item, null);
    }

    @Override
    protected void convert(BaseViewHolder helper,final LabelInfo item) {
        helper.setText(R.id.tv_group, item.getsName());
        FlowTagLayout mFlowLayout = helper.getView(R.id.demo_flow_layout);
        mFlowLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_SINGLE);
        TagAdapter<String> mTagAdapter = new TagAdapter<>(mContext);
        mFlowLayout.setAdapter(mTagAdapter);
        mFlowLayout.setOnTagSelectListener(new OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowTagLayout parent, List<Integer> selectedList) {
                if (selectedList != null && selectedList.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i : selectedList) {
                        sb.append(parent.getAdapter().getItem(i));
                        sb.append(":");
                    }
                    item.setCheck(true);
                    List<String> mLabel=new ArrayList<>();
                    mLabel.add(sb.toString());
                    item.setmLabelList(mLabel);
//                    Snackbar.make(parent, "移动研发:" + sb.toString(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }else{
//                    Snackbar.make(parent, "没有选择标签", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    item.setCheck(false);
                }
            }
        });
        mTagAdapter.onlyAddAll(item.getmLabelList());//必须要按照这个顺序，不然标签数据显示不出来
    }
}

package com.crazy.learn.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Administrator
 * 时间：2019/5/17
 * 功能：
 */
public class LabelInfo {
    private String sName;
    private List<String> mLabelList;
    private boolean isCheck;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public LabelInfo(String sName, List<String> mLabelList) {
        this.sName = sName;
        this.mLabelList = mLabelList;
    }

    public String getsName() {
        return sName == null ? "" : sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public List<String> getmLabelList() {
        if (mLabelList == null) {
            return new ArrayList<>();
        }
        return mLabelList;
    }

    public void setmLabelList(List<String> mLabelList) {
        this.mLabelList = mLabelList;
    }
}

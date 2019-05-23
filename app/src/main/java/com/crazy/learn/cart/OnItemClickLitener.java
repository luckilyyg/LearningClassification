package com.crazy.learn.cart;

import android.view.View;

/**
 * 作者：Administrator
 * 时间：2019/4/9
 * 功能：
 */
public interface OnItemClickLitener
{
    void onItemClick(View view, int position);
    void onItemLongClick(View view, int position);
    /**置顶*/
    void onTopClick(int position);
    /**删除*/
    void onDeleteClick(int position);
}

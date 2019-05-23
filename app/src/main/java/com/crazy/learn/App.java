package com.crazy.learn;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.noober.background.BackgroundLibrary;


/**
 * 作者：Administrator
 * 时间：2018/4/16
 * 功能：
 */
public class App extends Application {
    public static Context mContext;

    //服务器地址
    public static String path = "http://www.wanandroid.com/";
    //imooc的api
    public static String imoocPath = "http://www.imooc.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        BackgroundLibrary.inject(mContext);

    }

    //返回
    public static Context getContextObject() {
        return mContext;
    }

}

package com.crazy.learn.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;

import java.text.DecimalFormat;

/**
 * 工具类
 */

public class App_Utils {

    /**
     * 防止每次启动都走第一个activity
     *
     * @param activity
     */
    public static void NotAllWaysShow(Activity activity) {
        //防止每次都重新进入
        if (!activity.isTaskRoot()) {
            Intent intent = activity.getIntent();
            String action = intent.getAction();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(action)) {
                activity.finish();
                return;
            }
        }
    }

    /*
     * 获取当前程序的版本号
     */
    public static String getVersionName(Context context) {
        try {
            //获取packagemanager的实例
            PackageManager packageManager = context.getPackageManager();
            //getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * dp转px
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取view控件宽高（无法测量math_parent的情况）
     *
     * @param view getViewMeasure(view).getMeasuredWidth();宽
     *             getViewMeasure(view).getMeasuredHeight();高
     */
    public static View getViewMeasure(View view) {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        view.measure(widthMeasureSpec, heightMeasureSpec);
        return view;
    }

    public static boolean isTextEmpty(String str) {
        if (str == null)
            return true;
        return str.isEmpty();
    }

    /***
     * 获取url 指定name的value;
     * @param url
     * @param name
     * @return
     */
    public static String getUrlValueByName(String url, String... name) {
        String result = "";
        int index = url.indexOf("?");
        String temp = url.substring(index + 1);
        String[] keyValue = temp.split("&");
        for (String str : keyValue) {
            if (name.length >= 2) {
                if (str.contains(name[0])) {
                    result = str.replace(name[0] + "=", "");
                    break;
                }else if(str.contains(name[1])){
                    result = str.replace(name[1] + "=", "");
                    break;
                }
            }else {
                    if (str.contains(name[0])){
                        result = str.replace(name[0] + "=", "");
                        break;
                    }
                }
        }
        return result;
    }

//    /**
//     * 重构图片路径_400x400
//     *
//     * @param url
//     * @return
//     */
//    public static String getImgUrl_180(String url) {
//        if (url != null && !url.isEmpty()) {
//            if (url.contains("http://"))//可能是微信图片
//                return url;
//            String name = url.substring(0, url.lastIndexOf("."));
//            String type = url.substring(url.lastIndexOf("."), url.length());
//            return MyApplication.ServerImgPath + name + "_180x180" + type;
//        }
//        return "";
//    }

//    /**
//     * 重构图片路径_400x400
//     *
//     * @param url
//     * @return
//     */
//    public static String getImgUrl_400(String url) {
//        if (url != null && !url.isEmpty()) {
//            if (url.contains("http://"))//可能是微信图片
//                return url;
//            String name = url.substring(0, url.lastIndexOf("."));
//            String type = url.substring(url.lastIndexOf("."), url.length());
//            return MyApplication.ServerImgPath + name + "_400x400" + type;
//        }
//        return "";
//    }

//    /**
//     * 重构图片路径 原图
//     *
//     * @param url
//     * @return
//     */
//    public static String getImgUrl(String url) {
//        if (url != null && !url.isEmpty()) {
//            if (url.contains("http://"))//可能是微信图片
//                return url;
//            return MyApplication.ServerImgPath + url;
//        }
//        return "";
//    }

    /**
     * 向上取整的保留2位小数（eg: 1.111=1.12）
     *
     * @param m
     * @return
     */
    public static double getMathDouble(double m) {
        String[] str = ("" + m).split("\\.");
        if (str.length >= 2) {
            DecimalFormat df = new DecimalFormat("#.00");
            int length = str[1].length();
            ALog.e("取两位小数：" + str[1]);
            if (length >= 3 && !str[1].substring(1, 2).equals("0")) {
                return Double.parseDouble(str[0] + "." + (Integer.parseInt(str[1].substring(1, 2)) + 1));
                //return (Double.parseDouble(df.format(m))+0.01);
            } else {
                return Double.parseDouble(df.format(m));
            }
        }
        return m;
    }


}

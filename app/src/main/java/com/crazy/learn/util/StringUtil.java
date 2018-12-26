package com.crazy.learn.util;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Administrator
 * 时间：2018/12/12
 * 功能：
 */
public class StringUtil {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;
    private static StringBuilder builder;


    /**
     * 将集合元素拼接，逗号隔开
     */
    public static String append(List<String> data) {

        builder = new StringBuilder();

        for (String str : data) {
            builder.append(str).append(",");
        }
        return builder.toString().substring(0, builder.length() - 1);
    }

    /**
     * 將多个用","隔开图片名称分解為集合元素
     *
     * @param path
     * @return
     */
    public static List<String> resolved(String path) {

        List<String> list = new ArrayList<>();
        int index = -1;
        String str = null;
        do {
            index = path.indexOf(',');
            if (index != -1) {
                str = path.substring(0, index);
                list.add(str);
                path = path.substring(index + 1, path.length());
            } else {
                list.add(path);
            }
        } while (index != -1);

        return list;
    }
    /**
     * 对价格的截取，生成两部分：整数部分和小数部分
     * 返回整数部分
     *
     * @param price
     * @return
     */
    public static String priceInteger(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        String str = df.format(price);
        String integer = str.substring(0, str.indexOf("."));
        return integer;
    }


    public static String priceInteger(BigDecimal price) {
        DecimalFormat df = new DecimalFormat("0.00");
        String str = df.format(price);
        String integer = str.substring(0, str.indexOf("."));
        return integer;
    }


    /**
     * 对价格的截取，生成两部分：整数部分和小数部分
     * 返回小数后两位并且是四舍五入
     *
     * @param price
     * @return
     */
    public static String priceDecimal(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        String str = df.format(price);
        String decimal = str.substring(str.indexOf("."));
        return decimal;
    }

    public static String priceDecimal(BigDecimal price) {
        DecimalFormat df = new DecimalFormat("0.00");
        String str = df.format(price);
        String decimal = str.substring(str.indexOf("."));
        return decimal;
    }


    /**
     * 对价格的截取，生成两部分：整数部分和小数部分
     * 返回保留两位小数并四舍五入
     *
     * @param price
     * @return
     */
    public static double priceBaoDecimal(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        String str = df.format(price);
        return Double.parseDouble(str);
    }

    /**
     * 对图片名进行截取，获取图片名称
     *
     * @param url
     * @return
     */
    public static String imgUrlName(String url) {
        if (url.lastIndexOf(".") == -1) return url;
        String urlName = url.substring(0, url.lastIndexOf("."));
        return urlName;
    }

    /**
     * 对图片名进行截取，获取图片名称扩展名
     *
     * @param url
     * @return
     */
    public static String imgUrlExt(String url) {
        if (url.lastIndexOf(".") == -1) return url;
        String urlExt = url.substring(url.lastIndexOf("."), url.length());
        return urlExt;
    }


    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }


    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1,double v2){
        return div(v1,v2,DEF_DIV_SCALE);
    }
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**
     * 提供精确的小数进位处理。
     * @param v 需要进位的数字
     * @param scale 小数点后保留几位
     * @return 进位的结果
     */
    public static double roundUp(double v,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one,scale,BigDecimal.ROUND_UP).doubleValue();
    }
    /**
     * 提供精确的类型转换(Float)
     * @param v 需要被转换的数字
     * @return 返回转换结果
     */
    public static float convertsToFloat(double v){
        BigDecimal b = new BigDecimal(v);
        return b.floatValue();
    }
    /**
     * 提供精确的类型转换(Int)不进行四舍五入
     * @param v 需要被转换的数字
     * @return 返回转换结果
     */
    public static int convertsToInt(double v){
        BigDecimal b = new BigDecimal(v);
        return b.intValue();
    }
    /**
     * 提供精确的类型转换(Long)
     * @param v 需要被转换的数字
     * @return 返回转换结果
     */
    public static long convertsToLong(double v){
        BigDecimal b = new BigDecimal(v);
        return b.longValue();
    }
    /**
     * 返回两个数中大的一个值
     * @param v1 需要被对比的第一个数
     * @param v2 需要被对比的第二个数
     * @return 返回两个数中大的一个值
     */
    public static double returnMax(double v1,double v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.max(b2).doubleValue();
    }
    /**
     * 返回两个数中小的一个值
     * @param v1 需要被对比的第一个数
     * @param v2 需要被对比的第二个数
     * @return 返回两个数中小的一个值
     */
    public static double returnMin(double v1,double v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.min(b2).doubleValue();
    }
    /**
     * 精确对比两个数字
     * @param v1 需要被对比的第一个数
     * @param v2 需要被对比的第二个数
     * @return 如果两个数一样则返回0，如果第一个数比第二个数大则返回1，反之返回-1
     */
    public static int compareTo(double v1,double v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.compareTo(b2);
    }

    /**
     * SpannableString
     * @param tvString
     * @param context
     */
    public  void SpannableStringMethod(TextView tvString,Context context){
    String text = "风景点击，美食点击";
    SpannableString styledText = new SpannableString(text);
    setTextClickSpan(styledText, 2, 4,1);
    setTextClickSpan(styledText, 7, text.length(),2);
    tvString.setText(styledText, TextView.BufferType.SPANNABLE);
    //开始响应点击事件
    tvString.setMovementMethod(TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
}
    private void setTextClickSpan(SpannableString spStr, int start, int end, final int flag) {
        spStr.setSpan(new ClickableSpan() {

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                //设置文件颜色
                ds.setColor(Color.parseColor("#0099EE"));
                ds.setUnderlineText(false);      //设置下划线
            }

            @Override
            public void onClick(View widget) {
                if (flag==1){
//                    Toast.makeText(SpannableStringActivity.this,"风景",Toast.LENGTH_SHORT).show();
                }else if (flag==2){
//                    Toast.makeText(SpannableStringActivity.this,"美食",Toast.LENGTH_SHORT).show();
                }
            }
        }, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }
    public static  class TextViewFixTouchConsume extends TextView {

        boolean dontConsumeNonUrlClicks = true;

        boolean linkHit;


        public TextViewFixTouchConsume(Context context) {

            super(context);

        }


        public TextViewFixTouchConsume(Context context, AttributeSet attrs) {

            super(context, attrs);

        }


        public TextViewFixTouchConsume(Context context, AttributeSet attrs, int defStyle) {

            super(context, attrs, defStyle);

        }


        @Override

        public boolean hasFocusable() {

            return false;

        }


        @Override

        public boolean onTouchEvent(MotionEvent event) {

            linkHit = false;

            boolean res = super.onTouchEvent(event);


            if (dontConsumeNonUrlClicks)

                return linkHit;

            return res;


        }


        public static class LocalLinkMovementMethod extends LinkMovementMethod {

            static LocalLinkMovementMethod sInstance;


            public static LocalLinkMovementMethod getInstance() {

                if (sInstance == null)

                    sInstance = new LocalLinkMovementMethod();


                return sInstance;

            }


            @Override

            public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {

                int action = event.getAction();


                if (action == MotionEvent.ACTION_UP ||

                        action == MotionEvent.ACTION_DOWN) {

                    int x = (int) event.getX();

                    int y = (int) event.getY();


                    x -= widget.getTotalPaddingLeft();

                    y -= widget.getTotalPaddingTop();


                    x += widget.getScrollX();

                    y += widget.getScrollY();


                    Layout layout = widget.getLayout();

                    int line = layout.getLineForVertical(y);

                    int off = layout.getOffsetForHorizontal(line, x);


                    ClickableSpan[] link = buffer.getSpans(off, off, ClickableSpan.class);


                    if (link.length != 0) {

                        if (action == MotionEvent.ACTION_UP) {

                            link[0].onClick(widget);

                        } else if (action == MotionEvent.ACTION_DOWN) {

                            Selection.setSelection(buffer,

                                    buffer.getSpanStart(link[0]),

                                    buffer.getSpanEnd(link[0]));

                        }


                        if (widget instanceof TextViewFixTouchConsume) {

                            ((TextViewFixTouchConsume) widget).linkHit = true;

                        }

                        return true;

                    } else {

                        Selection.removeSelection(buffer);

                        Touch.onTouchEvent(widget, buffer, event);

                        return false;

                    }

                }

                return Touch.onTouchEvent(widget, buffer, event);

            }

        }

    }

}

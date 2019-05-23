package com.crazy.learn.fragment;


import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.crazy.learn.R;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import library.FlowTagLayout;
import library.OnTagClickListener;
import library.TagAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickFragment extends Fragment {
//    @Bind(R.id.btn_countdown)
//    Button btnCountdown;

    //关于时间选择
    private TimePickerView pvTime;
    //验证码倒计时
    private CountDownTimer countDownTimer;

    public TimePickFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo_content, container, false);
//        ButterKnife.bind(this, view);
        return view;
    }


//    @OnClick({ R.id.btn_countdown, R.id.tv_timeselector})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.btn_countdown://验证码倒计时
//                initCountDownTimer();// ***放到onCreateView（）方法中
//                countDownTimer.start();
//                break;
//            case R.id.tv_timeselector://时间选择器---（省市区的选在可以参考Android-PickerView）
//                initTimePicker();//      ***放到onCreateView（）方法中
//                pvTime.show(view);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
//                break;
//        }
//    }


    /**
     * 验证码倒计时
     */
//    private void initCountDownTimer() {
//        countDownTimer = new CountDownTimer(30000, 1000) {
//            @Override
//            public void onTick(long l) {
//                btnCountdown.setClickable(false);
//                btnCountdown.setText((l / 1000) + "秒后可重发");
//            }
//
//            @Override
//            public void onFinish() {
//                btnCountdown.setClickable(true);
//                btnCountdown.setText("重新获取验证码");
//            }
//        };
//    }


    /**
     * 拨打电话
     *
     * @param teleNumber
     */
//    private void CallTelephone(String teleNumber) {
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        Uri data = Uri.parse("tel:" + teleNumber);
//        intent.setData(data);
//        startActivity(intent);
//    }

    /**
     * 时间选择
     */
//    private void initTimePicker() {
//
//        pvTime = new TimePickerBuilder(getActivity(), new OnTimeSelectListener() {
//            @Override
//            public void onTimeSelect(Date date, View v) {
//                Toast.makeText(getActivity(), getTime(date), Toast.LENGTH_SHORT).show();
//                Log.i("pvTime", "onTimeSelect");
//
//            }
//        })
//                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
//                    @Override
//                    public void onTimeSelectChanged(Date date) {
//                        Log.i("pvTime", "onTimeSelectChanged");
//                    }
//                })
//                .setType(new boolean[]{true, true, true, true, true, true})
//                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
//                .build();
//
//        Dialog mDialog = pvTime.getDialog();
//        if (mDialog != null) {
//
//            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT,
//                    Gravity.BOTTOM);
//
//            params.leftMargin = 0;
//            params.rightMargin = 0;
//            pvTime.getDialogContainerLayout().setLayoutParams(params);
//
//            Window dialogWindow = mDialog.getWindow();
//            if (dialogWindow != null) {
//                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
//                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
//            }
//        }
//    }

    /**
     * 可根据需要自行截取数据显示
     *
     * @param date
     * @return
     */
//    private String getTime(Date date) {
//        Log.d("getTime()", "choice date millis: " + date.getTime());
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return format.format(date);
//    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        ButterKnife.unbind(this);
//    }
}

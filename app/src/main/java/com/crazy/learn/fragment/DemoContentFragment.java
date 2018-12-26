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
import com.crazy.learn.abstracts.CustomClickListener;

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
public class DemoContentFragment extends Fragment {


    @Bind(R.id.demo_flow_layout)
    FlowTagLayout demoFlowLayout;
    @Bind(R.id.tv_norepeatclick)
    TextView tvNorepeatclick;
    @Bind(R.id.tv_countdown)
    TextView tvCountdown;
    @Bind(R.id.tv_timeselector)
    TextView tvTimeselector;
    @Bind(R.id.btn_countdown)
    Button btnCountdown;
    @Bind(R.id.btn_norepeatclick)
    Button btnNorepeatclick;
    private TagAdapter<String> demoTagAdapter;
    //关于时间选择
    private TimePickerView pvTime;
    //验证码倒计时
    private CountDownTimer countDownTimer;

    public DemoContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo_content, container, false);
        ButterKnife.bind(this, view);
        initView();
        initDemoData();
        return view;
    }

    private void initView() {
        demoTagAdapter = new TagAdapter<>(getActivity());
        demoFlowLayout.setAdapter(demoTagAdapter);
        demoFlowLayout.setOnTagClickListener(new OnTagClickListener() {
            @Override
            public void onItemClick(FlowTagLayout parent, View view, int position) {

            }
        });
    }


    private void initDemoData() {
        List<String> dataSource = new ArrayList<>();
        dataSource.add("保存图片到本地");//...util.SavePictureToLocalUtils
        dataSource.add("拨打电话");//.......CallTelephone(String teleNumber)
        dataSource.add("防重复点击");
        dataSource.add("彩虹色");
        dataSource.add("深蓝色");
        dataSource.add("白色");
        dataSource.add("玫瑰红色");
        dataSource.add("紫黑紫兰色");
        dataSource.add("葡萄红色");
        dataSource.add("屎黄色");
        dataSource.add("绿色");
        dataSource.add("牡丹色");
        demoTagAdapter.onlyAddAll(dataSource);
    }


    @OnClick({R.id.tv_norepeatclick, R.id.btn_countdown, R.id.tv_timeselector})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_norepeatclick:
                //btnNorepeatclick点击事件
                //initNoRepeatClick();
                break;
            case R.id.btn_countdown://验证码倒计时
                initCountDownTimer();// ***放到onCreateView（）方法中
                countDownTimer.start();
                break;
            case R.id.tv_timeselector://时间选择器---（省市区的选在可以参考Android-PickerView）
                initTimePicker();//      ***放到onCreateView（）方法中
                pvTime.show(view);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                break;
        }
    }

    //防止重复点击
    private void initNoRepeatClick() {
        btnNorepeatclick.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Toast.makeText(getActivity(), "正常触发", Toast.LENGTH_LONG).show();
            }

            @Override
            protected void onFastClick() {
                Toast.makeText(getActivity(), "不要频繁的触发点击事件", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 验证码倒计时
     */
    private void initCountDownTimer() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                btnCountdown.setClickable(false);
                btnCountdown.setText((l / 1000) + "秒后可重发");
            }

            @Override
            public void onFinish() {
                btnCountdown.setClickable(true);
                btnCountdown.setText("重新获取验证码");
            }
        };
    }


    /**
     * 拨打电话
     *
     * @param teleNumber
     */
    private void CallTelephone(String teleNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + teleNumber);
        intent.setData(data);
        startActivity(intent);
    }

    /**
     * 时间选择
     */
    private void initTimePicker() {

        pvTime = new TimePickerBuilder(getActivity(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Toast.makeText(getActivity(), getTime(date), Toast.LENGTH_SHORT).show();
                Log.i("pvTime", "onTimeSelect");

            }
        })
                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {
                        Log.i("pvTime", "onTimeSelectChanged");
                    }
                })
                .setType(new boolean[]{true, true, true, true, true, true})
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .build();

        Dialog mDialog = pvTime.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            pvTime.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
            }
        }
    }

    /**
     * 可根据需要自行截取数据显示
     *
     * @param date
     * @return
     */
    private String getTime(Date date) {
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

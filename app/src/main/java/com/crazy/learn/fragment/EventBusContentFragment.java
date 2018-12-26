package com.crazy.learn.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crazy.learn.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * 三步：
 * 1、定义事件
 * 2、准备订阅者
 * 3、发送事件
 */
public class EventBusContentFragment extends Fragment {


    @Bind(R.id.tvnoparameter)
    TextView tvnoparameter;
    @Bind(R.id.tvwithparameters)
    TextView tvwithparameters;

    public EventBusContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_bus_content, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void noParameterMethod(EventBus_Model eventBus_model) {
        tvnoparameter.setText("无参EventBus");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void withParametersMethod(Event_Msg eventBus_msg) {
        tvwithparameters.setText(eventBus_msg.getMsg());
    }


    @OnClick({R.id.tvnoparameter, R.id.tvwithparameters})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvnoparameter:
                EventBus.getDefault().post(new EventBus_Model());
                break;
            case R.id.tvwithparameters:
                Event_Msg event_msg = new Event_Msg();
                event_msg.setMsg("有参EventBus");
                EventBus.getDefault().post(event_msg);
                break;
        }
    }

    public class EventBus_Model {

        public EventBus_Model() {
        }

    }

    public class Event_Msg {
        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}

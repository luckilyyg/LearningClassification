package com.crazy.learn.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.crazy.learn.R;
import com.just.agentweb.AgentWeb;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * 测试成功
 */
public class AgentWebContentFragment extends Fragment {
    @Bind(R.id.agentwebviewlin)
    LinearLayout agentwebviewlin;
    private AgentWeb agentWeb;

    public AgentWebContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agent_web_content, container, false);
        ButterKnife.bind(this, view);
        initWebView();
        return view;
    }

    private void initWebView() {
//        agentWeb = AgentWeb.with(this)
//                .setAgentWebParent(agentwebviewlin, new LinearLayout.LayoutParams(-1, -1))
//                .useDefaultIndicator()
//                .createAgentWeb()
//                .ready()
//                .go("https://www.baidu.com");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

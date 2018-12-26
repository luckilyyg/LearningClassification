package com.crazy.learn.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crazy.learn.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * //toast、dialog、snackbar
 */
public class TipsContentFragment extends Fragment {


    @Bind(R.id.tv_showdialog)
    TextView tvShowdialog;
    @Bind(R.id.tv_showsnackbar)
    TextView tvShowsnackbar;


    private AlertDialog alert;//弹出框

    public TipsContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tips_content, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.tv_showdialog, R.id.tv_showsnackbar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_showdialog:
                showDialog();
                break;
            case R.id.tv_showsnackbar:
                showSnackbar();
                break;
        }

    }




    private void showDialog() {
        alert = new AlertDialog.Builder(getActivity()).create();
        alert.show();
        //加载自定义dialog
        alert.getWindow().setContentView(R.layout.dialog_choose);
        alert.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView textView = (TextView) alert.getWindow().findViewById(R.id.dialog_content);
        textView.setText("确认登录？");
        //取消
        alert.getWindow().findViewById(R.id.dialog_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
                return;
            }
        });
        //确定
        alert.getWindow().findViewById(R.id.dialog_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //--操作你想要的事情--
                alert.dismiss();
                return;
            }
        });
    }


    private void showSnackbar() {
        Snackbar.make(tvShowsnackbar, "data deleted", Snackbar.LENGTH_LONG)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .show();

    }
}

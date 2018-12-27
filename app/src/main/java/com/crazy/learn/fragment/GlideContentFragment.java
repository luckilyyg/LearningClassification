package com.crazy.learn.fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.crazy.learn.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GlideContentFragment extends Fragment {


    @Bind(R.id.show_glideloadcircle)
    ImageView showGlideloadcircle;

    public GlideContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_glide_content, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    /**
     * 加载圆形图片
     */
    private void initData() {
        Glide.with(getContext()).load("http://tupian.qqjay.com/u/2017/1201/2_161641_2.jpg").asBitmap().centerCrop().into(new BitmapImageViewTarget(showGlideloadcircle) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                showGlideloadcircle.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

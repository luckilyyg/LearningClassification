package com.crazy.learn.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazy.learn.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NetRequestContentFragment extends Fragment {


    public NetRequestContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_net_request_content, container, false);
    }

}

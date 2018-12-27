package com.crazy.learn;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.crazy.learn.base.BaseActivity;
import com.crazy.learn.fragment.DemoContentFragment;
import com.crazy.learn.fragment.EventBusContentFragment;
import com.crazy.learn.fragment.FileContentFragment;
import com.crazy.learn.fragment.FourComponentsContentFragment;
import com.crazy.learn.fragment.GlideContentFragment;
import com.crazy.learn.fragment.LazyContentFragment;
import com.crazy.learn.fragment.StatusBarContentFragment;
import com.crazy.learn.fragment.PictureContentFragment;
import com.crazy.learn.fragment.StringContentFragment;
import com.crazy.learn.fragment.SynchronousContentFragment;
import com.crazy.learn.fragment.TipsContentFragment;
import com.crazy.learn.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.typerecyclerview)
    RecyclerView typerecyclerview;
    @Bind(R.id.fragment_container)
    FrameLayout fragmentContainer;
    private StudyAdapter adapter;
    private List<StudyType> mList;
    private StatusBarContentFragment statusBarContentFragment;
    private PictureContentFragment pictureContentFragment;
    private StringContentFragment stringContentFragment;
    private TipsContentFragment tipsContentFragment;
    private LazyContentFragment lazyContentFragment;
    private FileContentFragment fileFragment;
    private DemoContentFragment demoContentFragment;
    private EventBusContentFragment eventBusContentFragment;
    private SynchronousContentFragment synchronousContentFragment;
    private FourComponentsContentFragment fourComponentsContentFragment;
    private GlideContentFragment glideContentFragment;
    public static int mPosition;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        typerecyclerview.setLayoutManager(new LinearLayoutManager(this));


        initDataTitle();


        initFragment();


    }

    private void initDataTitle() {
        mList = new ArrayList<>();
        mList.add(new StudyType("-沉浸式模式-"));
        mList.add(new StudyType("-Picture-"));
        mList.add(new StudyType("-String-"));
        mList.add(new StudyType("-提示-"));
        mList.add(new StudyType("-懒加载-"));
        mList.add(new StudyType("-关于File-"));
        mList.add(new StudyType("-点点demo-"));
        mList.add(new StudyType("-EventBus-"));
        mList.add(new StudyType("同步or异步"));
        mList.add(new StudyType("四大组件"));
        mList.add(new StudyType("MVP架构"));
        mList.add(new StudyType("网络请求框架"));
        mList.add(new StudyType("Glide框架"));
        mList.add(new StudyType("......."));
        adapter = new StudyAdapter();
        adapter.setNewData(mList);
        typerecyclerview.setAdapter(adapter);


    }

    private void initFragment() {
        statusBarContentFragment = new StatusBarContentFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, statusBarContentFragment);
        fragmentTransaction.commit();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPosition = position;
                adapter.notifyDataSetChanged();
                switch (mPosition) {
                    case 0://沉浸式模式
                        statusBarContentFragment = new StatusBarContentFragment();
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.fragment_container, statusBarContentFragment);
                        fragmentTransaction1.commit();
                        break;
                    case 1://Picture
                        pictureContentFragment = new PictureContentFragment();
                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.fragment_container, pictureContentFragment);
                        fragmentTransaction2.commit();
                        break;
                    case 2://String
                        stringContentFragment = new StringContentFragment();
                        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.fragment_container, stringContentFragment);
                        fragmentTransaction3.commit();
                        break;
                    case 3://toast、dialog、snackbar
                        tipsContentFragment = new TipsContentFragment();
                        FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction4.replace(R.id.fragment_container, tipsContentFragment);
                        fragmentTransaction4.commit();
                        break;
                    case 4://懒加载
                        lazyContentFragment = new LazyContentFragment();
                        FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction5.replace(R.id.fragment_container, lazyContentFragment);
                        fragmentTransaction5.commit();
                        break;
                    case 5://关于文件夹
                        fileFragment = new FileContentFragment();
                        FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction6.replace(R.id.fragment_container, fileFragment);
                        fragmentTransaction6.commit();
                        break;
                    case 6://小demo
                        demoContentFragment = new DemoContentFragment();
                        FragmentTransaction fragmentTransaction7 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction7.replace(R.id.fragment_container, demoContentFragment);
                        fragmentTransaction7.commit();
                        break;
                    case 7://EventBus
                        eventBusContentFragment = new EventBusContentFragment();
                        FragmentTransaction fragmentTransaction8 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction8.replace(R.id.fragment_container, eventBusContentFragment);
                        fragmentTransaction8.commit();
                        break;
                    case 8:
                        synchronousContentFragment = new SynchronousContentFragment();
                        FragmentTransaction fragmentTransaction9 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction9.replace(R.id.fragment_container, synchronousContentFragment);
                        fragmentTransaction9.commit();
                        break;
                    case 9:
                        fourComponentsContentFragment = new FourComponentsContentFragment();
                        FragmentTransaction fragmentTransaction10 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction10.replace(R.id.fragment_container, fourComponentsContentFragment);
                        fragmentTransaction10.commit();
                        break;
                    case 10:
                        glideContentFragment = new GlideContentFragment();
                        FragmentTransaction fragmentTransaction11 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction11.replace(R.id.fragment_container, glideContentFragment);
                        fragmentTransaction11.commit();
                        break;

                }
            }
        });
    }

    class StudyType {
        private String sName;

        public StudyType(String sName) {
            this.sName = sName;
        }

        public String getsName() {
            return sName == null ? "" : sName;
        }

        public void setsName(String sName) {
            this.sName = sName;
        }
    }

    class StudyAdapter extends BaseQuickAdapter<StudyType, BaseViewHolder> {
        public StudyAdapter() {
            super(R.layout.studytype_item, null);
        }

        @Override
        protected void convert(BaseViewHolder helper, StudyType item) {
            helper.setText(R.id.tv_type, item.getsName());
            if (helper.getAdapterPosition() == mPosition) {
                helper.setBackgroundColor(R.id.tv_type, Color.parseColor("#ffffff"));
            } else {
                helper.setBackgroundColor(R.id.tv_type, Color.parseColor("#f4f4f4"));
            }
        }
    }
}

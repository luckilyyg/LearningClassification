package com.crazy.learn;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.crazy.learn.base.BaseActivity;
import com.crazy.learn.fragment.AgentWebContentFragment;
import com.crazy.learn.fragment.DailyQuestionFragment;
import com.crazy.learn.fragment.LabelFragment;
import com.crazy.learn.fragment.ShoppingCartFragment;
import com.crazy.learn.fragment.TimePickFragment;
import com.crazy.learn.fragment.DownLoadContentFragment;
import com.crazy.learn.fragment.EventBusContentFragment;
import com.crazy.learn.fragment.FileContentFragment;
import com.crazy.learn.fragment.FourComponentsContentFragment;
import com.crazy.learn.fragment.GlideContentFragment;
import com.crazy.learn.fragment.LazyContentFragment;
import com.crazy.learn.fragment.MoreThreadsContentFragment;
import com.crazy.learn.fragment.PermissionContentFragment;
import com.crazy.learn.fragment.PictureContentFragment;
import com.crazy.learn.fragment.RAMContentFragment;
import com.crazy.learn.fragment.StatusBarContentFragment;
import com.crazy.learn.fragment.StringContentFragment;
import com.crazy.learn.fragment.SynchronousContentFragment;
import com.crazy.learn.fragment.TipsContentFragment;
import com.crazy.learn.util.App_Utils;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {
    private RadioGroup mRg;
    private FrameLayout mFlContent;
    private FragmentManager fManager;
    private FragmentTransaction fTransaction;
    //所有fragment
    private StatusBarContentFragment statusBarContentFragment;
    private PictureContentFragment pictureContentFragment;
    private StringContentFragment stringContentFragment;
    private TipsContentFragment tipsContentFragment;
    private LazyContentFragment lazyContentFragment;
    private FileContentFragment fileFragment;
    private TimePickFragment demoContentFragment;
    private LabelFragment labelFragment;
    private EventBusContentFragment eventBusContentFragment;
    private SynchronousContentFragment synchronousContentFragment;
    private FourComponentsContentFragment fourComponentsContentFragment;
    private GlideContentFragment glideContentFragment;
    private RAMContentFragment ramFragment;
    private DownLoadContentFragment loadContentFragment;
    private AgentWebContentFragment webContentFragment;
    private MoreThreadsContentFragment threadsContentFragment;
    private PermissionContentFragment permissionContentFragment;
    private ShoppingCartFragment shoppingCartFragment;
    private DailyQuestionFragment dailyQuestionFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        mRg = findViewById(R.id.rg_classify);
        mFlContent = findViewById(R.id.fl_content);
        dataDeal();
        initFragment();
        listener();
    }

    private void initFragment() {
        fManager = getSupportFragmentManager();
        fTransaction = fManager.beginTransaction();
        statusBarContentFragment = new StatusBarContentFragment();
        fTransaction.add(R.id.fl_content, statusBarContentFragment);
        fTransaction.commitAllowingStateLoss();


    }

    private void listener() {
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                fTransaction = fManager.beginTransaction();
                hideAllFragment(fTransaction);
                switch (i) {
                    case 0:
                        if (statusBarContentFragment == null) {
                            statusBarContentFragment = new StatusBarContentFragment();
                            fTransaction.add(R.id.fl_content, statusBarContentFragment);
                        } else {
                            fTransaction.show(statusBarContentFragment);
                        }
                        break;
                    case 1:
                        if (pictureContentFragment == null) {
                            pictureContentFragment = new PictureContentFragment();
                            fTransaction.add(R.id.fl_content, pictureContentFragment);
                        } else {
                            fTransaction.show(pictureContentFragment);
                        }
                        break;
                    case 2:
                        if (stringContentFragment == null) {
                            stringContentFragment = new StringContentFragment();
                            fTransaction.add(R.id.fl_content, stringContentFragment);
                        } else {
                            fTransaction.show(stringContentFragment);
                        }
                        break;
                    case 3:
                        if (tipsContentFragment == null) {
                            tipsContentFragment = new TipsContentFragment();
                            fTransaction.add(R.id.fl_content, tipsContentFragment);
                        } else {
                            fTransaction.show(tipsContentFragment);
                        }
                        break;
                    case 4:
                        if (lazyContentFragment == null) {
                            lazyContentFragment = new LazyContentFragment();
                            fTransaction.add(R.id.fl_content, lazyContentFragment);
                        } else {
                            fTransaction.show(lazyContentFragment);
                        }
                        break;
                    case 5:
                        if (fileFragment == null) {
                            fileFragment = new FileContentFragment();
                            fTransaction.add(R.id.fl_content, fileFragment);
                        } else {
                            fTransaction.show(fileFragment);
                        }
                        break;
                    case 6:
                        if (demoContentFragment == null) {
                            demoContentFragment = new TimePickFragment();
                            fTransaction.add(R.id.fl_content, demoContentFragment);
                        } else {
                            fTransaction.show(demoContentFragment);
                        }
                        break;
                    case 7:
                        if (labelFragment == null) {
                            labelFragment = new LabelFragment();
                            fTransaction.add(R.id.fl_content, labelFragment);
                        } else {
                            fTransaction.show(labelFragment);
                        }
                        break;


                    case 8:
                        if (eventBusContentFragment == null) {
                            eventBusContentFragment = new EventBusContentFragment();
                            fTransaction.add(R.id.fl_content, eventBusContentFragment);
                        } else {
                            fTransaction.show(eventBusContentFragment);
                        }
                        break;

                    case 9:
                        if (synchronousContentFragment == null) {
                            synchronousContentFragment = new SynchronousContentFragment();
                            fTransaction.add(R.id.fl_content, synchronousContentFragment);
                        } else {
                            fTransaction.show(synchronousContentFragment);
                        }
                        break;
                    case 10:
                        if (fourComponentsContentFragment == null) {
                            fourComponentsContentFragment = new FourComponentsContentFragment();
                            fTransaction.add(R.id.fl_content, fourComponentsContentFragment);
                        } else {
                            fTransaction.show(fourComponentsContentFragment);
                        }
                        break;
                    case 11:
                        if (glideContentFragment == null) {
                            glideContentFragment = new GlideContentFragment();
                            fTransaction.add(R.id.fl_content, glideContentFragment);
                        } else {
                            fTransaction.show(glideContentFragment);
                        }
                        break;
                    case 12:
                        if (ramFragment == null) {
                            ramFragment = new RAMContentFragment();
                            fTransaction.add(R.id.fl_content, ramFragment);
                        } else {
                            fTransaction.show(ramFragment);
                        }
                        break;
                    case 13:
                        if (loadContentFragment == null) {
                            loadContentFragment = new DownLoadContentFragment();
                            fTransaction.add(R.id.fl_content, loadContentFragment);
                        } else {
                            fTransaction.show(loadContentFragment);
                        }
                        break;
                    case 14:
                        if (webContentFragment == null) {
                            webContentFragment = new AgentWebContentFragment();
                            fTransaction.add(R.id.fl_content, webContentFragment);
                        } else {
                            fTransaction.show(webContentFragment);
                        }
                        break;
                    case 15:
                        if (threadsContentFragment == null) {
                            threadsContentFragment = new MoreThreadsContentFragment();
                            fTransaction.add(R.id.fl_content, threadsContentFragment);
                        } else {
                            fTransaction.show(threadsContentFragment);
                        }
                        break;
                    case 16:
                        if (permissionContentFragment == null) {
                            permissionContentFragment = new PermissionContentFragment();
                            fTransaction.add(R.id.fl_content, permissionContentFragment);
                        } else {
                            fTransaction.show(permissionContentFragment);
                        }
                        break;
                    case 17:
                        if (shoppingCartFragment == null) {
                            shoppingCartFragment = new ShoppingCartFragment();
                            fTransaction.add(R.id.fl_content, shoppingCartFragment);
                        } else {
                            fTransaction.show(shoppingCartFragment);
                        }
                        break;
                    case 18:
                        if (dailyQuestionFragment == null) {
                            dailyQuestionFragment = new DailyQuestionFragment();
                            fTransaction.add(R.id.fl_content, dailyQuestionFragment);
                        } else {
                            fTransaction.show(dailyQuestionFragment);
                        }
                        break;
                    default:
                        break;
                }

                fTransaction.commitAllowingStateLoss();//别忘了
            }
        });
    }

    /**
     * 动态处理数据
     */
    private void dataDeal() {
        List<String> mTips = new ArrayList<>();
        mTips.add("沉浸式模式");
        mTips.add("Picture");
        mTips.add("String");
        mTips.add("提示");
        mTips.add("懒加载");
        mTips.add("关于File");
        mTips.add("时间选择器");
        mTips.add("标签");
        mTips.add("EventBus");
        mTips.add("同步or异步");
        mTips.add("四大组件");
        mTips.add("Glide框架");
        mTips.add("性能实践");
        mTips.add("断点续传");
        mTips.add("加载webview");
        mTips.add("多线程");
        mTips.add("权限请求");
        mTips.add("购物车");
        mTips.add("每日一问");
        //动态添加RadioButton
        mRg.removeAllViews();
        for (int i = 0; i < mTips.size(); i++) {
            RadioButton tempButton = new RadioButton(HomeActivity.this);
            if (i == 0) {
                tempButton.setChecked(true);
            }
            tempButton.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
            tempButton.setBackgroundResource(R.drawable.shelf_radio_btn);
            //tempButton.setTextColor(getResources().getColorStateList(R.color.radiobutton_text));
            tempButton.setId(i);
            tempButton.setTag(i);
            tempButton.setGravity(Gravity.CENTER);
            tempButton.setText(mTips.get(i));
            mRg.addView(tempButton, LinearLayout.LayoutParams.MATCH_PARENT, App_Utils.dip2px(HomeActivity.this, 72));
        }
    }

    private void hideAllFragment(FragmentTransaction fTransaction) {
        if (statusBarContentFragment != null) fTransaction.hide(statusBarContentFragment);
        if (pictureContentFragment != null) fTransaction.hide(pictureContentFragment);
        if (stringContentFragment != null) fTransaction.hide(stringContentFragment);
        if (tipsContentFragment != null) fTransaction.hide(tipsContentFragment);
        if (lazyContentFragment != null) fTransaction.hide(lazyContentFragment);
        if (fileFragment != null) fTransaction.hide(fileFragment);
        if (demoContentFragment != null) fTransaction.hide(demoContentFragment);
        if (labelFragment != null) fTransaction.hide(labelFragment);
        if (eventBusContentFragment != null) fTransaction.hide(eventBusContentFragment);
        if (synchronousContentFragment != null) fTransaction.hide(synchronousContentFragment);
        if (fourComponentsContentFragment != null) fTransaction.hide(fourComponentsContentFragment);
        if (glideContentFragment != null) fTransaction.hide(glideContentFragment);
        if (ramFragment != null) fTransaction.hide(ramFragment);
        if (loadContentFragment != null) fTransaction.hide(loadContentFragment);
        if (webContentFragment != null) fTransaction.hide(webContentFragment);
        if (threadsContentFragment != null) fTransaction.hide(threadsContentFragment);
        if (permissionContentFragment != null) fTransaction.hide(permissionContentFragment);
        if (shoppingCartFragment != null) fTransaction.hide(shoppingCartFragment);
        if (dailyQuestionFragment != null) fTransaction.hide(dailyQuestionFragment);
    }
}

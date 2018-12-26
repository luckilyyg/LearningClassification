package com.crazy.learn.fragment;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.crazy.learn.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 因为主线程不能做些耗时的操作，但是视图必须要在主线程中更新
 * 所以，就有了多线程
 * 而实现多线程
 * 1、Thread有两种方式，一种是使用Thread，一种是使用Runnable。（下面的例子）
 * 使用Thread执行任务，在结束后，需要通过Handler来发送消息，通知UI主线程，进行对应的界面更新。
 * 2、AsyncTask提供了方便的接口实现工作线程和主线程的通信
 */
public class SynchronousContentFragment extends Fragment {


    @Bind(R.id.displaypicture)
    ImageView image;
    @Bind(R.id.tv_showloadpicture)
    TextView tvShowloadpicture;

    private String image_path = "http://imgsrc.baidu.com/forum/pic/item/7c1ed21b0ef41bd51a5ac36451da81cb39db3d10.jpg";

    private ProgressDialog progress;

    public SynchronousContentFragment() {
        // Required empty public constructor
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_synchronous_content, container, false);
        ButterKnife.bind(this, view);

        initProgress();
        return view;
    }

    private void initProgress() {

        progress = new ProgressDialog(getActivity());
        progress.setIcon(R.mipmap.ic_launcher);
        progress.setTitle("提示信息");
        progress.setMessage("正在下载，请稍候...");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    /**
     * 多线程
     * 实现一：
     * 然后在主线程中调用
     * new MyThread().start();
     */
    public class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mHandler.sendEmptyMessage(0);

        }
    }


    /**
     * 多线程
     * 实现二：
     * 然后在主线程中调用
     * new Thread(new MyRunnable()).start();
     */
    public class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mHandler.sendEmptyMessage(0);
        }
    }

    /**
     * 触发异步加载
     */
    @OnClick(R.id.tv_showloadpicture)
    public void onViewClicked() {
        new MyAsyncTask().execute(image_path);
    }

    /**
     * 异步任务:执行网络下载图片（栗子）
     * 然后在主线程中调用
     * new MyAsyncTask().execute(1000);
     */

    class MyAsyncTask extends AsyncTask<String, Integer, Bitmap> {

        //执行异步任务（doInBackground）之前执行，并且在ui线程中执行
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            if (image != null) {
                image.setVisibility(View.GONE);
            }
            //开始下载 对话框进度条显示
            progress.show();
            progress.setProgress(0);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            // TODO Auto-generated method stub
            //params是一个可变长的数组 在这里我们只传进来了一个url
            String url = params[0];
            Bitmap bitmap = null;
            URLConnection connection;
            InputStream is;//用于获取数据的输入流
            ByteArrayOutputStream bos;//可以捕获内存缓冲区的数据，转换成字节数组。
            int len;
            float count = 0, total;//count为图片已经下载的大小 total为总大小
            try {
                //获取网络连接对象
                connection = (URLConnection) new URL(url).openConnection();
                //获取当前页面的总长度
                total = (int) connection.getContentLength();
                //获取输入流
                is = connection.getInputStream();
                bos = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                while ((len = is.read(data)) != -1) {
                    count += len;
                    bos.write(data, 0, len);
                    //调用publishProgress公布进度,最后onProgressUpdate方法将被执行
                    publishProgress((int) (count / total * 100));
                    //为了显示出进度 人为休眠0.5秒
                    Thread.sleep(500);
                }
                bitmap = BitmapFactory.decodeByteArray(bos.toByteArray(), 0, bos.toByteArray().length);
                is.close();
                bos.close();
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return bitmap;
        }

        //在ui线程中执行 可以操作ui
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            // TODO Auto-generated method stub
            super.onPostExecute(bitmap);
            //下载完成 对话框进度条隐藏
            progress.cancel();
            image.setImageBitmap(bitmap);
            image.setVisibility(View.VISIBLE);
        }

        /*
         * 在doInBackground方法中已经调用publishProgress方法 更新任务的执行进度后
         * 调用这个方法 实现进度条的更新
         * */
        @Override
        protected void onProgressUpdate(Integer... values) {
            // TODO Auto-generated method stub
            super.onProgressUpdate(values);
            progress.setProgress(values[0]);
        }
    }

}


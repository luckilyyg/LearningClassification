package com.crazy.learn.fragment;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazy.learn.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FileContentFragment extends Fragment {
    /**
     * 缓存文件保存路径
     */
    public static final String CACHE_FILE_PATH = "/smile/cache/";

    public FileContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_file, container, false);
        showFilePath();
        return view;
    }


    private void showFilePath() {
        // 应用私有存储（内置存储）---文件会随着App卸载而被删除
        Log.e("内部文件", getActivity().getFilesDir() + "");//   (/data/data/包名/files)
        Log.e("内部缓存", getActivity().getCacheDir() + "");//   (/data/data/包名/cache)
        //应用扩展存储（SD卡）---文件会随着App卸载而被删除---可以被其他的应用读取到的，所以这个目录下，不应该存放用户的敏感信息
        Log.e("外部文件", getActivity().getExternalFilesDir("") + "");//  (/storage/emulated/0/Android/data/包名/files)
        Log.e("外部缓存", getActivity().getExternalCacheDir() + "");//           (/storage/emulated/0/Android/data/包名/cache)
        //公共存储（SD卡）---如果我们的App需要存储一些公共的文件，甚至希望下载下来的文件即使在我们的App被删除之后，还可以被其他App使用，那么就可以使用这个目录。这个目录是始终需要申请SD写入权限的
        Log.e("公共存储文件", Environment.getExternalStorageDirectory() + "");//     (/storage/emulated/0）
    }
}

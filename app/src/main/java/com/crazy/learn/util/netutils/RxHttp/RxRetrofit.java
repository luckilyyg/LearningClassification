package com.crazy.learn.util.netutils.RxHttp;



import com.crazy.learn.App;
import com.crazy.learn.util.ALog;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求初始化操作类
 */

public class RxRetrofit {
    private static RxRetrofit mRxRetrofit;
    private Retrofit mRetrofit;
    private static String mPath = App.path;

    /**
     * 网络请求初始化配置
     */
    private RxRetrofit() {
        // log拦截器  打印所有的log
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                ALog.w("HTTP:" + message);
            }
        });
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 创建 OKHttpClient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)//连接超时时间(s)
                .writeTimeout(10, TimeUnit.SECONDS)//写操作超时时间(s)
                .readTimeout(10, TimeUnit.SECONDS)//读操作超时时间(s)
                .addInterceptor(new HttpInterceptor())
                .addInterceptor(logInterceptor)
                .cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(App.getContextObject())))
                .build();

        // 创建 Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(mPath)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 初始化
     */
    public static RxRetrofit getInstance() {
        if (mRxRetrofit == null) {
            synchronized (RxRetrofit.class) {
                if (mRxRetrofit == null) {
                    mRxRetrofit = new RxRetrofit();
                }
            }
        }
        return mRxRetrofit;
    }

    public <T> T create(Class<T> tClass) {
        return mRetrofit.create(tClass);
    }


}

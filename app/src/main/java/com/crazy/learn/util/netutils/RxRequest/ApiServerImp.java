package com.crazy.learn.util.netutils.RxRequest;



import com.crazy.learn.util.netutils.RxCallback.OnResultClick;
import com.crazy.learn.util.netutils.RxHttp.BaseHttpBean;
import com.crazy.learn.util.netutils.RxHttp.RxHttp;
import com.crazy.learn.util.netutils.RxHttp.RxRetrofit;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * 作者：Administrator
 * 时间：2018/4/16
 * 功能：
 */
public class ApiServerImp {
    /**
     * 首页轮播
     *
     * @param result
     */
//    public void BannerList(final OnResultClick<BaseHttpBean> result) {
//        //MD5加密
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getBannerList(), new Consumer<BaseHttpBean<List<BannerBean>>>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 首页文章列表
     *
     * @param result
     */
//    public void ArticleList(int page, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getArticleList(page), new Consumer<BaseHttpBean<ArticleList>>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /***
     * 获取项目分类
     * @param result
     */
//    public void ProjectCategories(final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getProjectCategories(), new Consumer<BaseHttpBean<List<Category>>>() {
//            @Override
//            public void accept(BaseHttpBean<List<Category>> baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }


    /**
     * 知识体系
     *
     * @param result
     */
//    public void KnowLedgeList(final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getKnowLedgeList(), new Consumer<BaseHttpBean<KnowLedgeBean>>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 登录
     *
     * @param username
     * @param psw
     * @param result
     */
//    public void Login(String username, String psw, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getLogin(username, psw), new Consumer<BaseHttpBean<LoginBean>>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 注册
     */
//    public void Register(String username, String psw, String repsw, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getRegister(username, psw, repsw), new Consumer<BaseHttpBean<RegisterBean>>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 项目分类
     *
     * @param result
     */
//    public void ProjectTree(final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getProjectTree(), new Consumer<BaseHttpBean<List<ProjectBean>>>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 项目列表数据
     *
     * @param cid
     * @param result
     */
//    public void ProjectList(int cid, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getProjectList(cid), new Consumer<BaseHttpBean>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 导航数据
     *
     * @param result
     */
//    public void NaviList(final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getNaviList(), new Consumer<BaseHttpBean>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 取消收藏
     *
     * @param id
     * @param originId
     * @param result
     */
//    public void RemoveCollectArticle(int id, int originId, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getRemoveCollectArticle(id, originId), new Consumer<BaseHttpBean>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 收藏文章
     *
     * @param id
     * @param result
     */
//    public void AddCollectArticle(int id, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getAddCollectArticle(id), new Consumer<BaseHttpBean>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 未完成 Todo 列表
     */
//    public void GetListNotDoList(int page, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getListNotDoList(page), new Consumer<BaseHttpBean<TodoListBean>>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 已完成 Done 列表
     */
//    public void GetListDoneList(int page, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.getListDoneList(page), new Consumer<BaseHttpBean<TodoListBean>>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 封装待完成、已完成列表
     *
     * @param isDone
     * @param page
     * @param result
     */
//    public void GetList(boolean isDone, int page, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(isDone ? mLoginServer.getListDoneList(page) : mLoginServer.getListNotDoList(page), new Consumer<BaseHttpBean<TodoListBean>>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 新增一条Todo
     *
     * @param title
     * @param content
     * @param date
     * @param result
     */
//    public void AddTodo(String title, String content, String date, String type, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.addtodo(title, content, date, type), new Consumer<BaseHttpBean>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 仅更新完成状态Todo
     *
     * @param id
     * @param status
     * @param result
     */
//    public void DoneTodo(int id, int status, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.donetodo(id, status), new Consumer<BaseHttpBean<TodoDesBean>>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }

    /**
     * 删除
     *
     * @param id
     */
//    public void DeleteTodo(int id, final OnResultClick<BaseHttpBean> result) {
//        ApiServer mLoginServer = RxRetrofit.getInstance().create(ApiServer.class);
//        RxHttp.sendRequest(mLoginServer.deletetodo(id), new Consumer<BaseHttpBean>() {
//            @Override
//            public void accept(BaseHttpBean baseHttpBean) throws Exception {
//                result.success(baseHttpBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                //网络请求失败
//                result.fail(throwable);
//            }
//        });
//    }




























}

package com.crazy.learn.util.netutils.RxCallback;


import java.util.List;

/**
 * 有返回值的
 */

public interface OnResultListClick<T> {
    void success(List<T> list);
    void fail(Throwable throwable);
}

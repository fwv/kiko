package com.kiko.tools.Concurrent;

/**
 * @Author fengwei
 * Created on 2016/9/28/0028.
 */
public abstract class FutureListener<T> {

    public abstract void onSuccess(T t);

    public abstract void onFailed();

}

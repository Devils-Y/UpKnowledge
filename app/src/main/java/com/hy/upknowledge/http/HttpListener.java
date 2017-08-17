package com.hy.upknowledge.http;

/**
 * Created by huyin on 2017/8/10.
 */

public interface HttpListener<T> {
     void onSuccess(T data);

     void onError();
}
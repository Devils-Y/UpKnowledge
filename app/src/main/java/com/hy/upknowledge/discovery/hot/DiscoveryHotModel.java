package com.hy.upknowledge.discovery.hot;

import com.hy.upknowledge.http.API;
import com.hy.upknowledge.http.HttpClient;
import com.hy.upknowledge.http.HttpListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by huyin on 2017/8/15.
 */

public class DiscoveryHotModel {
     Flowable<DiscoveryHotResult> discoveryHotFlowable;
     HttpListener<DiscoveryHotResult> mDiscoveryHotHttpListener;

     public void getDiscoveryHot(String url, int start, int num, HttpListener<DiscoveryHotResult> discoveryHotHttpListener) {
          this.mDiscoveryHotHttpListener = discoveryHotHttpListener;
          discoveryHotFlowable = HttpClient.retrofit().create(API.DiscoveryHotService.class)
                    .getDiscoveryHot(url, start, num);
          discoveryHotFlowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<DiscoveryHotResult>() {
                         @Override
                         public void onSubscribe(Subscription s) {
                              s.request(Long.MAX_VALUE);
                         }

                         @Override
                         public void onNext(DiscoveryHotResult discoveryHotResult) {
                              mDiscoveryHotHttpListener.onSuccess(discoveryHotResult);
                         }

                         @Override
                         public void onError(Throwable t) {
                              mDiscoveryHotHttpListener.onError();
                         }

                         @Override
                         public void onComplete() {
                         }
                    });
     }
}

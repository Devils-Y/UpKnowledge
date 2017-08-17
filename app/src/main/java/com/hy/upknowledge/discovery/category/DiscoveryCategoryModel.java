package com.hy.upknowledge.discovery.category;

import com.hy.upknowledge.http.API;
import com.hy.upknowledge.http.HttpClient;
import com.hy.upknowledge.http.HttpListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by huyin on 2017/8/17.
 */

public class DiscoveryCategoryModel {
     Flowable<DiscoveryCategoryResult> discoveryCategoryFlowable;
     HttpListener<DiscoveryCategoryResult> mDiscoveryCategoryHttpListener;

     public void getDiscoveryCategory(String url, int start, int num,
                                      HttpListener<DiscoveryCategoryResult> discoveryCategoryHttpListener) {
          this.mDiscoveryCategoryHttpListener = discoveryCategoryHttpListener;
          discoveryCategoryFlowable = HttpClient.retrofit().create(API.DiscoveryCategoryService.class)
                    .getDiscoveryCategory(url, start, num);
          discoveryCategoryFlowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<DiscoveryCategoryResult>() {
                         @Override
                         public void onSubscribe(Subscription s) {
                              s.request(Long.MAX_VALUE);
                         }

                         @Override
                         public void onNext(DiscoveryCategoryResult discoveryCategoryResult) {
                              mDiscoveryCategoryHttpListener.onSuccess(discoveryCategoryResult);
                         }

                         @Override
                         public void onError(Throwable t) {
                              mDiscoveryCategoryHttpListener.onError();
                         }

                         @Override
                         public void onComplete() {

                         }
                    });
     }
}

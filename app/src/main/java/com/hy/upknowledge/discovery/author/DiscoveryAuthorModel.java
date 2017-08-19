package com.hy.upknowledge.discovery.author;

import com.hy.upknowledge.http.API;
import com.hy.upknowledge.http.HttpClient;
import com.hy.upknowledge.http.HttpListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by huyin on 2017/8/18.
 */

public class DiscoveryAuthorModel {

     Flowable<DiscoveryAuthorResult> discoveryAuthorFlowable;
     HttpListener<DiscoveryAuthorResult> mDiscoveryAuthorHttpListener;

     public void getDiscoveryAuthor(String url, int start, int num,
                                    HttpListener<DiscoveryAuthorResult> discoveryAuthorHttpListener) {
          this.mDiscoveryAuthorHttpListener = discoveryAuthorHttpListener;
          discoveryAuthorFlowable = HttpClient.retrofit().create(API.DiscoveryAuthorService.class)
                    .getDiscoveryAuthor(url, start, num);
          discoveryAuthorFlowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<DiscoveryAuthorResult>() {
                         @Override
                         public void onSubscribe(Subscription s) {
                              s.request(Long.MAX_VALUE);
                         }

                         @Override
                         public void onNext(DiscoveryAuthorResult discoveryAuthorResult) {
                              mDiscoveryAuthorHttpListener.onSuccess(discoveryAuthorResult);
                         }

                         @Override
                         public void onError(Throwable t) {
                              mDiscoveryAuthorHttpListener.onError();
                         }

                         @Override
                         public void onComplete() {

                         }
                    });
     }
}

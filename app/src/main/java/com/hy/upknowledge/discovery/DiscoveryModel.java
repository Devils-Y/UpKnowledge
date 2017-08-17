package com.hy.upknowledge.discovery;

import com.hy.upknowledge.http.API;
import com.hy.upknowledge.http.HttpClient;
import com.hy.upknowledge.http.HttpListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryModel {
     Flowable<DiscoveryResult> discoveryFlowable;
     HttpListener<DiscoveryResult> mDiscoveryHttpListener;

     public void getDiscovery(HttpListener<DiscoveryResult> discoveryHttpListener) {
          this.mDiscoveryHttpListener = discoveryHttpListener;
          discoveryFlowable = HttpClient.retrofit().create(API.DiscoveryService.class).getDiscovery();
          discoveryFlowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<DiscoveryResult>() {
                         @Override
                         public void onSubscribe(Subscription s) {
                              s.request(Long.MAX_VALUE);
                         }

                         @Override
                         public void onNext(DiscoveryResult discovery) {
                              mDiscoveryHttpListener.onSuccess(discovery);
                         }

                         @Override
                         public void onError(Throwable t) {
                              mDiscoveryHttpListener.onError();
                         }

                         @Override
                         public void onComplete() {

                         }
                    });
     }
}

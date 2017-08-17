package com.hy.upknowledge.selected;

import com.hy.upknowledge.SelectedResult;
import com.hy.upknowledge.http.API;
import com.hy.upknowledge.http.HttpClient;
import com.hy.upknowledge.http.HttpListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by huyin on 2017/8/10.
 */

public class SelectedModel {
     Flowable<SelectedResult> selectedFlowable;
     HttpListener<SelectedResult> mHttpListener;

     public void getSelected(HttpListener<SelectedResult> httpListener){
          this.mHttpListener = httpListener;
          selectedFlowable = HttpClient.retrofit().create(API.SelectedService.class).getSelected();
          selectedFlowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<SelectedResult>() {
                         @Override
                         public void onSubscribe(Subscription s) {
                              s.request(Long.MAX_VALUE);
                         }

                         @Override
                         public void onNext(SelectedResult selectedResult) {
                              mHttpListener.onSuccess(selectedResult);
                         }

                         @Override
                         public void onError(Throwable t) {
                              mHttpListener.onError();
                         }

                         @Override
                         public void onComplete() {

                         }
                    });


     }
}

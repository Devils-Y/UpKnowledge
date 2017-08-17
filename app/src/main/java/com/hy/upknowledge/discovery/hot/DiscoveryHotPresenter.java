package com.hy.upknowledge.discovery.hot;

import com.hy.upknowledge.http.HttpListener;

/**
 * Created by huyin on 2017/8/15.
 */

public class DiscoveryHotPresenter implements HttpListener<DiscoveryHotResult> {

     DiscoveryHotView mDiscoveryHotView;
     DiscoveryHotModel discoveryHot;

     public DiscoveryHotPresenter(DiscoveryHotView mDiscoveryHotView) {
          this.mDiscoveryHotView = mDiscoveryHotView;
          discoveryHot = new DiscoveryHotModel();
     }

     public void getDiscoveryHot(String url, int start, int num) {
          discoveryHot.getDiscoveryHot(url, start, num, this);
     }

     @Override
     public void onSuccess(DiscoveryHotResult data) {
          if (mDiscoveryHotView != null) {
               if (data != null) {
                    mDiscoveryHotView.setDiscoveryHot(data);
               }
          }
     }

     @Override
     public void onError() {
          if (mDiscoveryHotView != null) {
               mDiscoveryHotView.showOther();
          }
     }

     public void onDestory() {
          if (mDiscoveryHotView != null) {
               mDiscoveryHotView = null;
          }
          if (discoveryHot != null) {
               discoveryHot = null;
          }
     }
}

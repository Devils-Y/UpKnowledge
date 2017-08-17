package com.hy.upknowledge.discovery;

import com.hy.upknowledge.http.HttpListener;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryPresenter implements HttpListener<DiscoveryResult> {

     DiscoveryView mDiscoveryView;
     DiscoveryModel discoveryModel;

     public DiscoveryPresenter(DiscoveryView mDiscoveryView) {
          this.mDiscoveryView = mDiscoveryView;
          this.discoveryModel = new DiscoveryModel();
     }

     public void getDiscovery() {
          discoveryModel.getDiscovery(this);
     }

     @Override
     public void onSuccess(DiscoveryResult data) {
          if (mDiscoveryView != null) {
               if (data != null) {
                    mDiscoveryView.setDiscovery(data);
               }
          }
     }

     @Override
     public void onError() {
          if (mDiscoveryView != null) {
               mDiscoveryView.showOther();
          }
     }

     public void onDestroy() {
          if (mDiscoveryView != null) {
               mDiscoveryView = null;
          }
          if (discoveryModel != null) {
               discoveryModel = null;
          }
     }
}

package com.hy.upknowledge.discovery.category;

import com.hy.upknowledge.http.HttpListener;

/**
 * Created by huyin on 2017/8/17.
 */

public class DiscoveryCategoryPresenter implements HttpListener<DiscoveryCategoryResult> {

     DiscoveryCategoryView discoveryCategoryView;
     DiscoveryCategoryModel discoveryCategory;

     public DiscoveryCategoryPresenter(DiscoveryCategoryView discoveryCategoryView) {
          this.discoveryCategoryView = discoveryCategoryView;
          discoveryCategory = new DiscoveryCategoryModel();
     }

     public void getDiscoveryCategory(String url, int start, int num) {
          discoveryCategory.getDiscoveryCategory(url, start, num, this);
     }

     @Override
     public void onSuccess(DiscoveryCategoryResult data) {
          if (discoveryCategoryView != null) {
               if (data != null) {
                    discoveryCategoryView.setDiscoveryCategory(data);
               }
          }
     }

     @Override
     public void onError() {
          if (discoveryCategoryView != null) {
               discoveryCategoryView.showOther();
          }
     }

     public void onDestroy() {
          if (discoveryCategoryView != null) {
               discoveryCategoryView = null;
          }
          if (discoveryCategory != null) {
               discoveryCategory = null;
          }
     }
}

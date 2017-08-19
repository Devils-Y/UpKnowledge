package com.hy.upknowledge.discovery.author;

import com.hy.upknowledge.http.HttpListener;

/**
 * Created by huyin on 2017/8/18.
 */

public class DiscoveryAuthorPresenter implements HttpListener<DiscoveryAuthorResult> {

     DiscoveryAuthorView discoveryAuthorView;
     DiscoveryAuthorModel discoveryAuthor;

     public DiscoveryAuthorPresenter(DiscoveryAuthorView discoveryAuthorView) {
          this.discoveryAuthorView = discoveryAuthorView;
          discoveryAuthor = new DiscoveryAuthorModel();
     }

     public void getDiscoveryAuthor(String url, int start, int num) {
          discoveryAuthor.getDiscoveryAuthor(url, start, num, this);
     }

     @Override
     public void onSuccess(DiscoveryAuthorResult data) {
          if (discoveryAuthorView != null) {
               if (data != null) {
                    discoveryAuthorView.setDiscoveryAuthor(data);
               }
          }
     }

     @Override
     public void onError() {
          if (discoveryAuthorView != null) {
               discoveryAuthorView.showOther();
          }
     }

     public void onDestroy() {
          if (discoveryAuthorView != null) {
               discoveryAuthorView = null;
          }
          if (discoveryAuthor != null) {
               discoveryAuthor = null;
          }
     }
}

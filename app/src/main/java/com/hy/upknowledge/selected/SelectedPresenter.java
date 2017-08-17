package com.hy.upknowledge.selected;

import com.hy.upknowledge.SelectedResult;
import com.hy.upknowledge.http.HttpListener;
import com.hy.upknowledge.quickopen.utils.toast.ToastUtils;

/**
 * Created by huyin on 2017/8/10.
 */

public class SelectedPresenter implements HttpListener<SelectedResult> {

     SelectedView selectedView;
     SelectedModel selectedModel;

     public SelectedPresenter(SelectedView selectedView) {
          this.selectedView = selectedView;
          selectedModel = new SelectedModel();
     }

     public void getSelected() {
          selectedModel.getSelected(this);
     }

     @Override
     public void onSuccess(SelectedResult data) {
          ToastUtils.toast("加载完成!!");
          if (selectedView != null) {
               selectedView.setSelected(data);
          }
     }

     @Override
     public void onError() {
          if (selectedView != null) {
               selectedView.setShowOther();
          }
     }

     public void onDestroy() {
          if (selectedView != null) {
               selectedView = null;
          }
          if (selectedModel != null) {
               selectedModel = null;
          }
     }
}

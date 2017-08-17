package com.hy.upknowledge;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by huyin on 2017/8/11.
 */

public class BasePagerHolder {

     SparseArray<View> views;
     public View itemView;

     public BasePagerHolder(View itemView) {
          if (itemView == null) {
               throw new IllegalArgumentException("itemView may not be null");
          }
          this.itemView = itemView;
          views = new SparseArray<>();
     }

     public <T extends View> T getView(int viewId) {
          View view = views.get(viewId);
          if (view == null) {
               view = itemView.findViewById(viewId);
               views.put(viewId, view);
          }
          return (T) view;
     }

     /**
      * 设置文本
      *
      * @param viewId
      * @param text
      * @return
      */
     public BasePagerHolder setText(int viewId, CharSequence text) {
          TextView textView = getView(viewId);
          textView.setText(text);
          return this;
     }


     /**
      * 设置本地图片
      *
      * @param viewId
      * @param resId
      * @return
      */
     public BasePagerHolder setImagResId(int viewId, int resId) {
          ImageView imageView = getView(viewId);
          imageView.setBackgroundResource(resId);
          return this;
     }


     /**
      * 设置网络图片
      *
      * @param viewId
      * @param holderImage
      * @return
      */
     public BasePagerHolder setImageUrl(int viewId, HolderImage holderImage) {
          ImageView imageView = getView(viewId);
          final WeakReference<ImageView> imageViewWeakReference = new WeakReference<>(imageView);
          ImageView target = imageViewWeakReference.get();
          holderImage.loadImg(target, holderImage.getmUrl());
          return this;
     }

     public abstract static class HolderImage {

          String mUrl;

          public String getmUrl() {
               return mUrl;
          }

          public HolderImage(String url) {
               this.mUrl = url;
          }

          public abstract void loadImg(ImageView imageView, String url);
     }
}

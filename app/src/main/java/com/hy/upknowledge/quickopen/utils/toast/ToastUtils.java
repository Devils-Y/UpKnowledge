package com.hy.upknowledge.quickopen.utils.toast;

import android.content.Context;

import com.hy.upknowledge.quickopen.base.BaseApplication;

/**
 * 吐司工具类
 */
public class ToastUtils {

     public static void toast(final String content) {
          CustomToast.showToast(BaseApplication.getContext(), content, 1000);
     }

     public static void toast(final int resID) {
          CustomToast.showToast(BaseApplication.getContext(), resID, 1000);
     }

     public static void toast(final Context context, final String content) {
          CustomToast.showToast(context, content, 1000);
     }

     public static void toast(final Context context, final int resID) {
          CustomToast.showToast(context, resID, 1000);
     }


     public static void longToast(final Context context, final String content) {
          CustomToast.showToast(context, content, 3000);
     }

     public static void longToast(final Context context, final int resID) {
          CustomToast.showToast(context, resID, 3000);
     }

}

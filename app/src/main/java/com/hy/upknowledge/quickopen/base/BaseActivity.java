package com.hy.upknowledge.quickopen.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hy.upknowledge.quickopen.utils.ScreenUtils;
import com.hy.upknowledge.quickopen.utils.UiControlUtils;

import butterknife.ButterKnife;

/**
 * Created by huyin on 2017/8/7.
 */

public abstract class BaseActivity extends AppCompatActivity {

     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(layoutID());
          ButterKnife.bind(this);

          initTitle();
          initView();
          initData();
     }

     @Override
     protected void onResume() {
          super.onResume();

          if (isFull()) {
               //全屏，输入法不遮挡
               UiControlUtils.hideSystemUi(this);
               getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
                         | WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
          }
     }

     /**
      * 沉浸式
      *
      * @param view
      */
     protected void setImmerseLayout(View view) {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
               Window window = getWindow();
               window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
               int statusBarHeight = ScreenUtils.getStatusBarHeight(getBaseContext());
               view.setPadding(0, statusBarHeight, 0, 0);
          }
     }

     /**
      * 布局ID
      *
      * @return
      */
     protected abstract int layoutID();

     /**
      * 初始化Title
      */
     protected abstract void initTitle();

     /**
      * 初始化View
      */
     protected abstract void initView();

     /**
      * 初始数据
      */
     protected abstract void initData();

     /**
      * 是否全屏
      *
      * @return
      */
     protected abstract boolean isFull();

     @Override
     protected void onDestroy() {
          super.onDestroy();
          DestroyView();
     }

     /**
      * 销毁
      */
     protected abstract void DestroyView();

     /**
      * 加载到下一个Activity，并传值
      *
      * @param targetActivity
      * @param bundle
      */
     public void startActivity(Class<? extends Activity> targetActivity, Bundle bundle) {
          Intent intent = new Intent(this, targetActivity);
          if (bundle != null) {
               intent.putExtras(bundle);
          }
          startActivity(intent);
     }

     /**
      * 跳转到下个Activity，并设置返回码
      *
      * @param targetActivity
      * @param RequestCode
      */
     public void startActvityForRsult(Class<? extends Activity> targetActivity, int RequestCode) {
          Intent intent = new Intent(this, targetActivity);
          startActivityForResult(intent, RequestCode);
     }

     /**
      * 带参数返回上一个Activity，并关闭
      *
      * @param bundle
      */
     public void setActivityResult(Bundle bundle) {
          Intent intent = new Intent();
          if (bundle != null) {
               intent.putExtras(bundle);
          }
          setResult(RESULT_OK, intent);
          this.finish();
     }

     /**
      * 跳转到下个Activity
      *
      * @param targetActivity
      */
     public void startActivity(Class<? extends Activity> targetActivity) {
          startActivity(targetActivity, null);
     }

     /**
      * 跳转下一个Activity,并关闭当前Activity
      *
      * @param targetActivity
      */
     public void startActivityAndCloseThis(Class<? extends Activity> targetActivity) {
          startActivity(targetActivity);
          this.finish();
     }

     /**
      * 按钮最后一次点击时间
      */
     private static long mLastClickTime = 0;

     /**
      * 空闲时间
      */
     private static final int SPACE_TIME = 1000;

     /**
      * 是否连续点击按钮多次
      *
      * @return 是否快速多次点击
      */
     public static boolean isFastDoubleClick() {
          long time = SystemClock.elapsedRealtime();
          if (time - mLastClickTime <= SPACE_TIME) {
               return true;
          } else {
               mLastClickTime = time;
               return false;
          }
     }
}

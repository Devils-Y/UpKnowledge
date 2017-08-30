package com.hy.upknowledge;

import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hy.upknowledge.quickopen.base.BaseSwipeActivity;

import butterknife.BindView;

import static com.hy.upknowledge.Constant.DETAIL_kEY;

/**
 * Created by huyin on 2017/8/29.
 */

public class DetailActivity extends BaseSwipeActivity {

     @BindView(R.id.toolbar_title)
     TextView toolbarTitle;
     @BindView(R.id.toolbar)
     RelativeLayout toolbar;
     @BindView(R.id.webView)
     WebView webView;

     String loadUrl;

     @Override
     protected int layoutID() {
          return R.layout.activity_detail;
     }

     @Override
     protected void initTitle() {

     }

     @Override
     protected void initView() {
          loadUrl = getIntent().getStringExtra(DETAIL_kEY);
          webView.loadUrl(loadUrl);
     }

     @Override
     protected void initData() {

     }

     @Override
     protected void DestroyView() {

     }
}

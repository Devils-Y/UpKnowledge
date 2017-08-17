package com.hy.upknowledge;

import android.widget.TextView;

import com.hy.upknowledge.quickopen.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的
 */

public class MineFragment extends BaseFragment {


     @BindView(R.id.watch_history)
     TextView watchHistory;
     @BindView(R.id.my_cache)
     TextView myCache;
     @BindView(R.id.setting)
     TextView setting;

     @OnClick(R.id.watch_history)
     public void onWatchHistoryClicked() {
     }

     @OnClick(R.id.my_cache)
     public void onMyCacheClicked() {
     }

     @OnClick(R.id.setting)
     public void onSettingClicked() {
     }

     @Override
     protected int layoutId() {
          return R.layout.fragment_mine;
     }

     @Override
     protected void initView() {

     }

     @Override
     protected void initData() {

     }

     @Override
     protected void DestroyView() {

     }
}

package com.hy.upknowledge;

import com.hy.upknowledge.discovery.category.DiscoveryCategoryPresenter;
import com.hy.upknowledge.discovery.category.DiscoveryCategoryResult;
import com.hy.upknowledge.discovery.category.DiscoveryCategoryView;
import com.hy.upknowledge.quickopen.base.BaseFragment;

import static com.hy.upknowledge.Constant.DISCOVERY_KEY;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryCategoryFragment extends BaseFragment implements DiscoveryCategoryView {

     String url;

     DiscoveryCategoryPresenter discoveryCategoryPresenter;
     private static final int PAGE_NUM = 20;
     private int PAGE = 0;

     @Override
     protected int layoutId() {
          return R.layout.fragment_discovery_category;
     }

     @Override
     protected void initView() {
          url = getArguments().getString(DISCOVERY_KEY);
          discoveryCategoryPresenter = new DiscoveryCategoryPresenter(this);
     }

     @Override
     protected void initData() {
          discoveryCategoryPresenter.getDiscoveryCategory(url, PAGE, PAGE_NUM);
     }

     @Override
     protected void DestroyView() {

     }

     @Override
     public void setDiscoveryCategory(DiscoveryCategoryResult discoveryCategory) {

     }

     @Override
     public void showOther() {

     }
}

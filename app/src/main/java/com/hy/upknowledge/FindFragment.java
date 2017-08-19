package com.hy.upknowledge;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hy.upknowledge.discovery.DiscoveryPresenter;
import com.hy.upknowledge.discovery.DiscoveryResult;
import com.hy.upknowledge.discovery.DiscoveryView;
import com.hy.upknowledge.quickopen.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;

import static com.hy.upknowledge.Constant.DISCOVERY_CATEGORY;
import static com.hy.upknowledge.Constant.DISCOVERY_HOT;
import static com.hy.upknowledge.Constant.DISCOVERY_KEY;
import static com.hy.upknowledge.Constant.DISCOVERY_PGCS;

/**
 * 发现
 */

public class FindFragment extends BaseFragment implements DiscoveryView {

     @BindView(R.id.toolbar)
     RelativeLayout toolbar;
     @BindView(R.id.tab)
     TabLayout tab;
     @BindView(R.id.toolbar_title)
     TextView toolbarTitle;
     @BindView(R.id.pager)
     ViewPager pager;

     @BindString(R.string.find_txt)
     String findTxt;

     DiscoveryPresenter discoveryPresenter;
     List<DiscoveryResult.TabInfoBean.TabListBean> list = new ArrayList<>();
     DiscoveryAdapter discoveryAdapter;
     UserProgressDialog userProgressDialog;

     DiscoveryHotFragment discoveryHotFragment;
     DiscoveryCategoryFragment discoveryCategoryFragment;
     DiscoveryAuthorFragment discoveryAuthorFragment;

     @Override
     protected int layoutId() {
          return R.layout.fragment_find;
     }

     @Override
     protected void initView() {
          toolbarTitle.setText(findTxt);
          TextPaint paint = toolbarTitle.getPaint();
          paint.setFakeBoldText(true);

          discoveryPresenter = new DiscoveryPresenter(this);
     }

     @Override
     protected void initData() {
          userProgressDialog = new UserProgressDialog(getActivity());
          userProgressDialog.show();
          discoveryPresenter.getDiscovery();
     }

     @Override
     protected void DestroyView() {
          userProgressDialog = null;
          discoveryPresenter.onDestroy();
     }

     @Override
     public void setDiscovery(DiscoveryResult discovery) {
          if (userProgressDialog != null) {
               userProgressDialog.dismiss();
          }
          for (int i = 0; i < discovery.getTabInfo().getTabList().size(); i++) {
               list.add(discovery.getTabInfo().getTabList().get(i));
          }
          discoveryAdapter = new DiscoveryAdapter(getChildFragmentManager(), list);
          pager.setAdapter(discoveryAdapter);
          tab.setupWithViewPager(pager);
     }

     @Override
     public void showOther() {

     }

     private class DiscoveryAdapter extends FragmentStatePagerAdapter {

          List<DiscoveryResult.TabInfoBean.TabListBean> list;

          public DiscoveryAdapter(FragmentManager fm, List<DiscoveryResult.TabInfoBean.TabListBean> tabList) {
               super(fm);
               this.list = tabList;
          }

          @Override
          public Fragment getItem(int position) {
               Bundle bundle = new Bundle();
               if (list.get(position).getName().equals(DISCOVERY_HOT)) {
                    bundle.putString(DISCOVERY_KEY, list.get(position).getApiUrl());
                    discoveryHotFragment = new DiscoveryHotFragment();
                    discoveryHotFragment.setArguments(bundle);
                    return discoveryHotFragment;
               } else if (list.get(position).getName().equals(DISCOVERY_CATEGORY)) {
                    bundle.putString(DISCOVERY_KEY, list.get(position).getApiUrl());
                    discoveryCategoryFragment = new DiscoveryCategoryFragment();
                    discoveryCategoryFragment.setArguments(bundle);
                    return discoveryCategoryFragment;
               } else if (list.get(position).getName().equals(DISCOVERY_PGCS)) {
                    bundle.putString(DISCOVERY_KEY, list.get(position).getApiUrl());
                    discoveryAuthorFragment = new DiscoveryAuthorFragment();
                    discoveryAuthorFragment.setArguments(bundle);
                    return discoveryAuthorFragment;
               }
               return null;
          }

          @Override
          public int getCount() {
               return list.size();
          }

          @Override
          public CharSequence getPageTitle(int position) {
               return list.get(position).getName();
          }
     }
}

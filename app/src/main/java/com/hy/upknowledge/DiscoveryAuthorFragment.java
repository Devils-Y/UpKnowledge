package com.hy.upknowledge;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hy.upknowledge.bean.BriefCardBean;
import com.hy.upknowledge.discovery.author.DiscoveryAuthorPresenter;
import com.hy.upknowledge.discovery.author.DiscoveryAuthorResult;
import com.hy.upknowledge.discovery.author.DiscoveryAuthorView;
import com.hy.upknowledge.quickopen.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.hy.upknowledge.Constant.BRIEFCARD;
import static com.hy.upknowledge.Constant.DISCOVERY_KEY;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryAuthorFragment extends BaseFragment implements DiscoveryAuthorView {

     @BindView(R.id.hotAuthor)
     TextView hotAuthor;
     @BindView(R.id.hotAuthorRecyclerView)
     RecyclerView hotAuthorRecyclerView;

     String url;

     DiscoveryAuthorPresenter discoveryAuthorPresenter;

     private static final int PAGE_NUM = 10;
     private int PAGE = 0;

     List<BriefCardBean> briefCardBeen = new ArrayList<>();
     HotAuthorAdapter hotAuthorAdapter;

     @Override
     protected int layoutId() {
          return R.layout.fragment_discovery_author;
     }

     @Override
     protected void initView() {
          url = getArguments().getString(DISCOVERY_KEY);
          discoveryAuthorPresenter = new DiscoveryAuthorPresenter(this);

          hotAuthorAdapter = new HotAuthorAdapter(getActivity(), briefCardBeen);
          hotAuthorRecyclerView.setLayoutManager(new NotRollGridLayoutManager(getActivity(), 3));
          hotAuthorRecyclerView.setAdapter(hotAuthorAdapter);
     }

     @Override
     protected void initData() {
          discoveryAuthorPresenter.getDiscoveryAuthor(url, PAGE, PAGE_NUM);
     }

     @Override
     protected void DestroyView() {

     }

     @Override
     public void setDiscoveryAuthor(DiscoveryAuthorResult discoveryAuthor) {
          Log.e("Tag", "discoveryAuthor----->-----" + discoveryAuthor.getItemList().get(2).getData());
          for (int i = 0; i < 4; i++) {
               if (discoveryAuthor.getItemList().get(i).getData().equals(BRIEFCARD)) {
                    hotAuthor.setVisibility(View.VISIBLE);
                    JsonObject jsonObject = discoveryAuthor.getItemList().get(i).getData();
                    BriefCardBean briefCardBean = new Gson().fromJson(jsonObject, BriefCardBean.class);
                    hotAuthorAdapter.add(briefCardBean);
               }
          }
     }

     @Override
     public void showOther() {

     }
}

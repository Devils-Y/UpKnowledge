package com.hy.upknowledge;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hy.upknowledge.bean.ActionCardBean;
import com.hy.upknowledge.bean.BannerCollBean;
import com.hy.upknowledge.bean.SquareCardBean;
import com.hy.upknowledge.bean.SquareCardCollBean;
import com.hy.upknowledge.bean.VideoCollHorizontalBean;
import com.hy.upknowledge.discovery.category.DiscoveryCategoryPresenter;
import com.hy.upknowledge.discovery.category.DiscoveryCategoryResult;
import com.hy.upknowledge.discovery.category.DiscoveryCategoryView;
import com.hy.upknowledge.quickopen.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.hy.upknowledge.Constant.BANNER_COLLECTION;
import static com.hy.upknowledge.Constant.DISCOVERY_KEY;
import static com.hy.upknowledge.Constant.SQUARE_CARD_COLLECTION;
import static com.hy.upknowledge.Constant.VIDEO_COLL_HORIZONTAL;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryCategoryFragment extends BaseFragment implements DiscoveryCategoryView {

     @BindView(R.id.hotCategory)
     TextView hotCategory;
     @BindView(R.id.categoryHeadRecyclerView)
     RecyclerView categoryHeadRecyclerView;
     @BindView(R.id.hotTopic)
     TextView hotTopic;
     @BindView(R.id.topicPager)
     ViewPager topicPager;
     @BindView(R.id.categoryRecyclerView)
     RecyclerView categoryRecyclerView;

     String url;

     DiscoveryCategoryPresenter discoveryCategoryPresenter;
     private static final int PAGE_NUM = 4;
     private int PAGE = 0;

     List<SquareCardBean> squareCardList = new ArrayList<>();
     SquareCardAdapter squareCardAdapter;

     List<BannerCollBean.ItemListBean.DataBean> bannerDataList = new ArrayList<>();
     CategoryBannerCollAdapter categoryBannerCollAdapter;

     List<VideoCollHorizontalBean> videoCollHorizontalList = new ArrayList<>();
     VideoCollHorizontalAdapter videoCollHorizontalAdapter;

     @Override
     protected int layoutId() {
          return R.layout.fragment_discovery_category;
     }

     @Override
     protected void initView() {
          url = getArguments().getString(DISCOVERY_KEY);
          discoveryCategoryPresenter = new DiscoveryCategoryPresenter(this);

          squareCardAdapter = new SquareCardAdapter(getActivity(), squareCardList);
          categoryHeadRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL, false));
          categoryHeadRecyclerView.setAdapter(squareCardAdapter);
          categoryHeadRecyclerView.setNestedScrollingEnabled(false);

          categoryBannerCollAdapter = new CategoryBannerCollAdapter(bannerDataList, getActivity());
          topicPager.setAdapter(categoryBannerCollAdapter);

          videoCollHorizontalAdapter = new VideoCollHorizontalAdapter(getActivity(), videoCollHorizontalList);
          categoryRecyclerView.setLayoutManager(new NotRollLinearLayoutManager(getActivity()));
          categoryRecyclerView.setAdapter(videoCollHorizontalAdapter);
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
          for (int i = 0; i < discoveryCategory.getCount(); i++) {
               if (discoveryCategory.getItemList().get(i).getType().equals(SQUARE_CARD_COLLECTION)) {
                    JsonObject jsonObject = discoveryCategory.getItemList().get(i).getData();
                    SquareCardCollBean squareCardCollBean = new Gson().fromJson(jsonObject,
                              SquareCardCollBean.class);
                    hotCategory.setText(squareCardCollBean.getHeader().getTitle());
                    for (int j = 0; j < squareCardCollBean.getCount(); j++) {
                         JsonObject jsonListObject = squareCardCollBean.getItemList().get(j).getData();
                         SquareCardBean squareCardBean = new Gson().fromJson(jsonListObject, SquareCardBean.class);
                         squareCardAdapter.add(squareCardBean);
                         ActionCardBean actionCardBean = new Gson().fromJson(jsonObject, ActionCardBean.class);
                    }
               }
               if (discoveryCategory.getItemList().get(i).getType().equals(BANNER_COLLECTION)) {
                    JsonObject jsonObject = discoveryCategory.getItemList().get(i).getData();
                    BannerCollBean bannerCollBean = new Gson().fromJson(jsonObject,
                              BannerCollBean.class);
                    hotTopic.setText(bannerCollBean.getHeader().getTitle());
                    for (int j = 0; j < bannerCollBean.getCount(); j++) {
                         categoryBannerCollAdapter.add(bannerCollBean.getItemList().get(j).getData());
                    }
               }
               if (discoveryCategory.getItemList().get(i).getType().equals(VIDEO_COLL_HORIZONTAL)) {
                    JsonObject jsonObject = discoveryCategory.getItemList().get(i).getData();
                    VideoCollHorizontalBean videoCollHorizontalBean = new Gson().fromJson(jsonObject,
                              VideoCollHorizontalBean.class);
                    videoCollHorizontalAdapter.add(videoCollHorizontalBean);
               }
          }
     }

     @Override
     public void showOther() {

     }
}

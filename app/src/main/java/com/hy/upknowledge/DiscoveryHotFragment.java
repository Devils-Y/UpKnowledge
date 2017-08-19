package com.hy.upknowledge;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hy.upknowledge.bean.ActionCardBean;
import com.hy.upknowledge.bean.HorizontalScrollCardBean;
import com.hy.upknowledge.bean.HotVideoBean;
import com.hy.upknowledge.bean.SquareCardBean;
import com.hy.upknowledge.bean.SquareCardCollBean;
import com.hy.upknowledge.discovery.hot.DiscoveryHotPresenter;
import com.hy.upknowledge.discovery.hot.DiscoveryHotResult;
import com.hy.upknowledge.discovery.hot.DiscoveryHotView;
import com.hy.upknowledge.quickopen.base.BaseFragment;
import com.hy.upknowledge.quickopen.utils.image.ImageUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.hy.upknowledge.Constant.DISCOVERY_KEY;
import static com.hy.upknowledge.Constant.HORIZONTALSCROLLCARD;
import static com.hy.upknowledge.Constant.SQUARE_CARD_COLLECTION;
import static com.hy.upknowledge.Constant.VIDEO_TYPE;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryHotFragment extends BaseFragment implements DiscoveryHotView {

     @BindView(R.id.banner)
     ImageView banner;
     @BindView(R.id.recentlyPopular)
     TextView recentlyPopular;
     @BindView(R.id.hotRecyclerView)
     RecyclerView hotRecyclerView;
     @BindView(R.id.squareCardColl)
     TextView squareCardColl;
     @BindView(R.id.cardCollRecyclerView)
     RecyclerView cardCollRecyclerView;
     @BindView(R.id.latestRelease)
     TextView latestRelease;
     @BindView(R.id.releaseRecyclerView)
     RecyclerView releaseRecyclerView;
     @BindView(R.id.NScrollView)
     NestedScrollView NScrollView;

     String url;

     private static final int PAGE_NUM = 20;
     private int PAGE = 0;

     DiscoveryHotPresenter discoveryHotPresenter;
     SelectedVideo4FindAdapter selectedVideo4FindAdapter;
     List<HotVideoBean> selectedVideoBeanList = new ArrayList<>();

     List<SquareCardBean> squareCardList = new ArrayList<>();
     SquareCardAdapter squareCardAdapter;

     SelectedVideo4FindAdapter video4Find2ReleaseAdapter;
     List<HotVideoBean> video4Find2ReleaseList = new ArrayList<>();

     @Override
     protected int layoutId() {
          return R.layout.fragment_discovery_hot;
     }

     @Override
     protected void initView() {
          url = getArguments().getString(DISCOVERY_KEY);

          selectedVideo4FindAdapter = new SelectedVideo4FindAdapter(getActivity(), selectedVideoBeanList);
          hotRecyclerView.setLayoutManager(new NotRollLinearLayoutManager(getActivity()));
          hotRecyclerView.setAdapter(selectedVideo4FindAdapter);
          hotRecyclerView.setNestedScrollingEnabled(false);
          discoveryHotPresenter = new DiscoveryHotPresenter(this);

          squareCardAdapter = new SquareCardAdapter(getActivity(), squareCardList);
          cardCollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL, false));
          cardCollRecyclerView.setAdapter(squareCardAdapter);
          cardCollRecyclerView.setNestedScrollingEnabled(false);

          video4Find2ReleaseAdapter = new SelectedVideo4FindAdapter(getActivity(), video4Find2ReleaseList);
          releaseRecyclerView.setLayoutManager(new NotRollLinearLayoutManager(getActivity()));
          releaseRecyclerView.setAdapter(video4Find2ReleaseAdapter);
          releaseRecyclerView.setNestedScrollingEnabled(false);
     }

     @Override
     protected void initData() {
          discoveryHotPresenter.getDiscoveryHot(url, PAGE, PAGE_NUM);
     }

     @Override
     protected void DestroyView() {
          discoveryHotPresenter.onDestory();
          discoveryHotPresenter = null;
     }

     @Override
     public void setDiscoveryHot(DiscoveryHotResult discoveryHot) {
          for (int i = 0; i < discoveryHot.getCount(); i++) {
               if (discoveryHot.getItemList().get(i).getType().equals(HORIZONTALSCROLLCARD)) {
                    JsonObject jsonObject = discoveryHot.getItemList().get(i).getData();
                    HorizontalScrollCardBean dhHorizontalScrollCardBean =
                              new Gson().fromJson(jsonObject, HorizontalScrollCardBean.class);
                    ImageUtils.getInstances().glideAsBitmap(getActivity(),
                              dhHorizontalScrollCardBean.getItemList().get(0).getData().getImage(), banner);
               }
               if (discoveryHot.getItemList().get(i).getType().equals(SQUARE_CARD_COLLECTION)) {
                    JsonObject jsonObject = discoveryHot.getItemList().get(i).getData();
                    SquareCardCollBean squareCardCollBean = new Gson().fromJson(jsonObject,
                              SquareCardCollBean.class);
                    squareCardColl.setText(squareCardCollBean.getHeader().getTitle());
                    for (int j = 0; j < squareCardCollBean.getCount(); j++) {
                         JsonObject jsonListObject = squareCardCollBean.getItemList().get(j).getData();
                         SquareCardBean squareCardBean = new Gson().fromJson(jsonListObject, SquareCardBean.class);
                         squareCardAdapter.add(squareCardBean);
                         ActionCardBean actionCardBean = new Gson().fromJson(jsonObject, ActionCardBean.class);
                    }
               }
          }

          for (int i = 1; i < 7; i++) {
               if (discoveryHot.getItemList().get(i).getType().equals(VIDEO_TYPE)) {
                    JsonObject jsonObject = discoveryHot.getItemList().get(i).getData();
                    HotVideoBean videoBean = new Gson().fromJson(
                              jsonObject, HotVideoBean.class);
                    selectedVideo4FindAdapter.add(videoBean);
               }
          }
          video4Find2ReleaseAdapter.clear();
          for (int i = 7; i < discoveryHot.getCount(); i++) {
               if (discoveryHot.getItemList().get(i).getType().equals(VIDEO_TYPE)) {
                    JsonObject jsonObject = discoveryHot.getItemList().get(i).getData();
                    HotVideoBean videoBean = new Gson().fromJson(
                              jsonObject, HotVideoBean.class);
                    video4Find2ReleaseAdapter.add(videoBean);
               }
          }
     }

     @Override
     public void showOther() {

     }
}

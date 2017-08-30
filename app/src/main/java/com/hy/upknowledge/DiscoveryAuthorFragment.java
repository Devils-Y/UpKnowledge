package com.hy.upknowledge;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hy.upknowledge.bean.BriefCardBean;
import com.hy.upknowledge.bean.VideoCollBriefBean;
import com.hy.upknowledge.discovery.author.DiscoveryAuthorPresenter;
import com.hy.upknowledge.discovery.author.DiscoveryAuthorResult;
import com.hy.upknowledge.discovery.author.DiscoveryAuthorView;
import com.hy.upknowledge.quickopen.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.hy.upknowledge.Constant.BRIEFCARD;
import static com.hy.upknowledge.Constant.DISCOVERY_KEY;
import static com.hy.upknowledge.Constant.VIDEO_COLL_BRIEF;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryAuthorFragment extends BaseFragment implements DiscoveryAuthorView {

     @BindView(R.id.hotAuthor)
     TextView hotAuthor;
     @BindView(R.id.hotAuthorRecyclerView)
     RecyclerView hotAuthorRecyclerView;
     @BindView(R.id.lately_update_author)
     TextView latelyUpdateAuthor;
     @BindView(R.id.latelyUpdateRecyclerView)
     RecyclerView latelyUpdateRecyclerView;
     @BindView(R.id.join_author)
     TextView joinAuthor;
     @BindView(R.id.joinAuthorRecyclerView)
     RecyclerView joinAuthorRecyclerView;
     @BindView(R.id.allAuthor)
     TextView allAuthor;
     @BindView(R.id.allAuthorRecyclerView)
     RecyclerView allAuthorRecyclerView;

     String url;

     UserProgressDialog userProgressDialog;
     DiscoveryAuthorPresenter discoveryAuthorPresenter;

     private static final int PAGE_NUM = 10;
     private int PAGE = 0;

     List<BriefCardBean> briefCardBeen = new ArrayList<>();
     HotOrJoinAuthorAdapter hotAuthorAdapter;

     List<VideoCollBriefBean> videoCollBriefList = new ArrayList<>();
     LatelyUpdateAdapter latelyUpdateAdapter;

     List<BriefCardBean> joinAuthorList = new ArrayList<>();
     HotOrJoinAuthorAdapter joinAuthorAdapter;


     List<BriefCardBean> allAuthorList = new ArrayList<>();
     AllAuthorAdapter allAuthorAdapter;

     @Override
     protected int layoutId() {
          return R.layout.fragment_discovery_author;
     }

     @Override
     protected void initView() {
          url = getArguments().getString(DISCOVERY_KEY);
          discoveryAuthorPresenter = new DiscoveryAuthorPresenter(this);

          hotAuthorAdapter = new HotOrJoinAuthorAdapter(getActivity(), briefCardBeen);
          hotAuthorRecyclerView.setLayoutManager(new NotRollGridLayoutManager(getActivity(), 3));
          hotAuthorRecyclerView.setNestedScrollingEnabled(false);
          hotAuthorRecyclerView.setAdapter(hotAuthorAdapter);

          latelyUpdateAdapter = new LatelyUpdateAdapter(getActivity(), videoCollBriefList);
          latelyUpdateRecyclerView.setLayoutManager(new NotRollLinearLayoutManager(getActivity()));
//          latelyUpdateRecyclerView.addItemDecoration(new BaseDividerItemDecoration(getActivity(),1));
          latelyUpdateRecyclerView.setNestedScrollingEnabled(false);
          latelyUpdateRecyclerView.setAdapter(latelyUpdateAdapter);

          joinAuthorAdapter = new HotOrJoinAuthorAdapter(getActivity(), joinAuthorList);
          joinAuthorRecyclerView.setLayoutManager(new NotRollGridLayoutManager(getActivity(), 3));
          joinAuthorRecyclerView.setNestedScrollingEnabled(false);
          joinAuthorRecyclerView.setAdapter(joinAuthorAdapter);

          allAuthorAdapter = new AllAuthorAdapter(getActivity(), allAuthorList);
          allAuthorRecyclerView.setLayoutManager(new NotRollLinearLayoutManager(getActivity()));
          allAuthorRecyclerView.setNestedScrollingEnabled(false);
          allAuthorRecyclerView.setAdapter(allAuthorAdapter);
     }

     @Override
     protected void initData() {
          userProgressDialog = new UserProgressDialog(getActivity());
          userProgressDialog.show();
          discoveryAuthorPresenter.getDiscoveryAuthor(url, PAGE, PAGE_NUM);
     }

     @Override
     protected void DestroyView() {
          userProgressDialog = null;
          discoveryAuthorPresenter.onDestroy();
     }

     @Override
     public void setDiscoveryAuthor(DiscoveryAuthorResult discoveryAuthor) {
          for (int i = 0; i < 4; i++) {
               if (discoveryAuthor.getItemList().get(i).getType().equals(BRIEFCARD)) {
                    hotAuthor.setVisibility(View.VISIBLE);
                    JsonObject jsonObject = discoveryAuthor.getItemList().get(i).getData();
                    BriefCardBean briefCardBean = new Gson().fromJson(jsonObject, BriefCardBean.class);
                    hotAuthorAdapter.add(briefCardBean);
               }
          }
          for (int i = 5; i < 10; i++) {
               if (discoveryAuthor.getItemList().get(i).getType().equals(VIDEO_COLL_BRIEF)) {
                    latelyUpdateAuthor.setVisibility(View.VISIBLE);
                    JsonObject jsonObject = discoveryAuthor.getItemList().get(i).getData();
                    VideoCollBriefBean videoCollBriefBean = new Gson().fromJson(jsonObject, VideoCollBriefBean.class);
                    latelyUpdateAdapter.add(videoCollBriefBean);
               }
          }
          for (int i = 10; i < 20; i++) {
               if (discoveryAuthor.getItemList().get(i).getType().equals(BRIEFCARD)) {
                    joinAuthor.setVisibility(View.VISIBLE);
                    JsonObject jsonObject = discoveryAuthor.getItemList().get(i).getData();
                    BriefCardBean briefCardBean = new Gson().fromJson(jsonObject, BriefCardBean.class);
                    joinAuthorAdapter.add(briefCardBean);
               }
          }
          for (int i = 20; i < discoveryAuthor.getCount(); i++) {
               if (discoveryAuthor.getItemList().get(i).getType().equals(BRIEFCARD)) {
                    allAuthor.setVisibility(View.VISIBLE);
                    JsonObject jsonObject = discoveryAuthor.getItemList().get(i).getData();
                    BriefCardBean briefCardBean = new Gson().fromJson(jsonObject, BriefCardBean.class);
                    allAuthorAdapter.add(briefCardBean);
               }
          }
          if (userProgressDialog != null) {
               userProgressDialog.dismiss();
          }
     }

     @Override
     public void showOther() {

     }
}

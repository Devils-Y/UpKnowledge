package com.hy.upknowledge;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hy.upknowledge.bean.SelectedCollCoverBean;
import com.hy.upknowledge.bean.SelectedVideoBean;
import com.hy.upknowledge.quickopen.base.BaseFragment;
import com.hy.upknowledge.quickopen.utils.image.ImageUtils;
import com.hy.upknowledge.selected.SelectedPresenter;
import com.hy.upknowledge.selected.SelectedView;
import com.hy.upknowledge.widget.SelectedPagerTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.hy.upknowledge.Constant.COLLECTION_COVER_TYPE;
import static com.hy.upknowledge.Constant.VIDEO_TYPE;

/**
 * 首页
 */

public class HomeFragment extends BaseFragment implements SelectedView {

     @BindView(R.id.homePager)
     ViewPager homePager;
     @BindView(R.id.collectionCover)
     ImageView collectionCover;
     @BindView(R.id.collRecyclerView)
     RecyclerView collRecyclerView;
     @BindView(R.id.videoRecyclerView)
     RecyclerView videoRecyclerView;

     SelectedPresenter selectedPresenter;
     UserProgressDialog userProgressDialog;
     SelectedPagerAdapter selectedAdapter;
     List<SelectedVideoBean> imageLists = new ArrayList<>();
     CollCoverAdapter collCoverAdapter;
     List<SelectedCollCoverBean.ItemListBean.DataBean> collCoverLists = new ArrayList<>();
     SelectedVideo4HomeAdapter selectedVideo4HomeAdapter;
     List<SelectedVideoBean> videoLists = new ArrayList<>();

     @Override
     protected int layoutId() {
          return R.layout.fragment_home;
     }

     @Override
     protected void initView() {
          selectedAdapter = new SelectedPagerAdapter(getActivity(), imageLists);
          collCoverAdapter = new CollCoverAdapter(getActivity(), collCoverLists);
          selectedVideo4HomeAdapter = new SelectedVideo4HomeAdapter(getActivity(), videoLists);
          selectedPresenter = new SelectedPresenter(this);

          homePager.setAdapter(selectedAdapter);
          homePager.setPageTransformer(true, new SelectedPagerTransformer());

          collRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL, false));
          collRecyclerView.setAdapter(collCoverAdapter);

          videoRecyclerView.setLayoutManager(new NotRollLinearLayoutManager(getActivity()));
          videoRecyclerView.setAdapter(selectedVideo4HomeAdapter);
          videoRecyclerView.setNestedScrollingEnabled(false);
     }

     @Override
     protected void initData() {
          userProgressDialog = new UserProgressDialog(getActivity());
          userProgressDialog.show();
          selectedPresenter.getSelected();
     }

     @Override
     public void setSelected(SelectedResult selected) {
          for (int i = 0; i < 7; i++) {
               if (selected.getItemList().get(i).getType().equals(VIDEO_TYPE)) {
                    JsonObject jsonObject = selected.getItemList().get(i).getData();
                    SelectedVideoBean selectedVideoBean = new Gson().fromJson(jsonObject, SelectedVideoBean.class);
                    selectedAdapter.add(selectedVideoBean);
               }
          }

          for (int i = 6; i < selected.getCount(); i++) {
               if (selected.getItemList().get(i).getType().equals(VIDEO_TYPE)) {
                    JsonObject jsonObject = selected.getItemList().get(i).getData();
                    SelectedVideoBean selectedVideoBean = new Gson().fromJson(jsonObject, SelectedVideoBean.class);
                    selectedVideo4HomeAdapter.add(selectedVideoBean);
               }

               if (selected.getItemList().get(i).getType().equals(COLLECTION_COVER_TYPE)) {
                    JsonObject jsonObject = selected.getItemList().get(i).getData();
                    SelectedCollCoverBean selectedCollCoverBean = new Gson().fromJson(jsonObject, SelectedCollCoverBean.class);
                    ImageUtils.getInstances().glideOBJContext(getActivity(),
                              selectedCollCoverBean.getHeader().getCover(), collectionCover);
                    for (int j = 0; j < selectedCollCoverBean.getItemList().size(); j++) {
                         collCoverAdapter.add(selectedCollCoverBean.getItemList().get(j).getData());
                    }
               }
          }
          if (userProgressDialog != null) {
               userProgressDialog.dismiss();
          }
     }

     @Override
     public void setShowOther() {

     }

     @Override
     protected void DestroyView() {
          userProgressDialog = null;
          selectedPresenter.onDestroy();
     }
}

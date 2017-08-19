package com.hy.upknowledge;

import android.util.Log;
import android.widget.TextView;

import com.hy.upknowledge.discovery.author.DiscoveryAuthorPresenter;
import com.hy.upknowledge.discovery.author.DiscoveryAuthorResult;
import com.hy.upknowledge.discovery.author.DiscoveryAuthorView;
import com.hy.upknowledge.quickopen.base.BaseFragment;

import butterknife.BindView;

import static com.hy.upknowledge.Constant.DISCOVERY_KEY;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryAuthorFragment extends BaseFragment implements DiscoveryAuthorView {

     @BindView(R.id.text)
     TextView text;

     String url;

     DiscoveryAuthorPresenter discoveryAuthorPresenter;


     private static final int PAGE_NUM = 10;
     private int PAGE = 0;

     @Override
     protected int layoutId() {
          return R.layout.fragment_discovery_author;
     }

     @Override
     protected void initView() {
          url = getArguments().getString(DISCOVERY_KEY);
          discoveryAuthorPresenter = new DiscoveryAuthorPresenter(this);
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
          Log.e("Tag","discoveryAuthor----->-----"+discoveryAuthor.getItemList().get(2).getData());
     }

     @Override
     public void showOther() {

     }
}

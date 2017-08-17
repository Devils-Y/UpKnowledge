package com.hy.upknowledge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.upknowledge.quickopen.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.hy.upknowledge.Constant.DISCOVERY_KEY;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryAuthorFragment extends BaseFragment {

     @BindView(R.id.text)
     TextView text;

     @Override
     protected int layoutId() {
          return R.layout.fragment_discovery_author;
     }

     @Override
     protected void initView() {
          text.setText(getArguments().getString(DISCOVERY_KEY));
     }

     @Override
     protected void initData() {

     }

     @Override
     protected void DestroyView() {

     }
}

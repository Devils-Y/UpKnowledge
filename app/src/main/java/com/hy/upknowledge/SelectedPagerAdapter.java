package com.hy.upknowledge;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.hy.upknowledge.bean.SelectedVideoBean;
import com.hy.upknowledge.quickopen.utils.image.ImageUtils;
import com.hy.upknowledge.quickopen.utils.toast.ToastUtils;

import java.util.List;

/**
 * Created by huyin on 2017/8/11.
 */

public class SelectedPagerAdapter extends BasePagerAdapter<SelectedVideoBean> {


     public SelectedPagerAdapter(Context mContext, List<SelectedVideoBean> mPager) {
          super(mPager, mContext, R.layout.home_selected_pager);
     }

     @Override
     public boolean isCycle() {
          return false;
     }

     @Override
     protected void convert(final BasePagerHolder holder, final SelectedVideoBean item, int position) {
          holder.setText(R.id.title, item.getTitle())
                    .setText(R.id.slogan, item.getSlogan());
          holder.setImageUrl(R.id.image, new BasePagerHolder.HolderImage(item.getCover().getHomepage()) {
               @Override
               public void loadImg(ImageView imageView, String url) {
                    ImageUtils.getInstances().glideOBJContext(mContext, url, imageView);
               }
          });
          holder.getView(R.id.image).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    ToastUtils.toast(mContext,item.getWebUrl().getRaw());
               }
          });
     }
}

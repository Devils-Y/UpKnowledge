package com.hy.upknowledge;

import android.content.Context;
import android.widget.ImageView;

import com.hy.upknowledge.bean.VideoCollHorizontalBean;
import com.hy.upknowledge.quickopen.utils.image.ImageUtils;

import java.util.List;

/**
 * Created by huyin on 2017/8/18.
 */

public class Item4VideoCollHorizontalAdapter extends BasePagerAdapter<VideoCollHorizontalBean.ItemListBean.DataBean>{

     public Item4VideoCollHorizontalAdapter(List<VideoCollHorizontalBean.ItemListBean.DataBean> mPager,
                                            Context mContext) {
          super(mPager, mContext, R.layout.item_category_banner_coll);
     }

     @Override
     public boolean isCycle() {
          return false;
     }

     @Override
     protected void convert(BasePagerHolder holder, VideoCollHorizontalBean.ItemListBean.DataBean item, int position) {
          holder.setImageUrl(R.id.image, new BasePagerHolder.HolderImage(item.getCover().getFeed()) {
               @Override
               public void loadImg(ImageView imageView, String url) {
                    ImageUtils.getInstances().glideOBJContext(mContext, url, imageView);
               }
          });
     }
}

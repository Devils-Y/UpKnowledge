package com.hy.upknowledge;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hy.upknowledge.bean.VideoCollBriefBean;
import com.hy.upknowledge.quickopen.base.BaseAdapter;
import com.hy.upknowledge.quickopen.base.BaseViewHolder;
import com.hy.upknowledge.quickopen.utils.image.ImageUtils;
import com.hy.upknowledge.util.TimeUtil;

import java.util.List;

/**
 * Created by huyin on 2017/8/25.
 */

public class LatelyUpdateImageAdapter extends BaseAdapter<VideoCollBriefBean.ItemListBean.DataBean> {


     public LatelyUpdateImageAdapter(Context context, List<VideoCollBriefBean.ItemListBean.DataBean> data) {
          super(context, data, R.layout.item_coll_over);
     }

     @Override
     protected void toChange(View view, ViewGroup parent) {
          Resources resources = mContext.getResources();
          DisplayMetrics dm = resources.getDisplayMetrics();
          int width = dm.widthPixels;

          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
          layoutParams.width = width / 4 * 3;
          view.setLayoutParams(layoutParams);
     }

     @Override
     protected void convert(BaseViewHolder holder, VideoCollBriefBean.ItemListBean.DataBean
               item, int position) {
          holder.setText(R.id.title, item.getTitle())
                    .setText(R.id.category_time, new StringBuilder().append("#")
                              .append(item.getCategory()).append("\t\t/\t\t")
                              .append(TimeUtil.durationChange(item.getDuration())));
          holder.setImageUrl(R.id.image, new BaseViewHolder.HolderImage(item.getCover().getFeed()) {
               @Override
               public void loadImg(ImageView imageView, String url) {
                    ImageUtils.getInstances().glideOBJContext(mContext,url,imageView);
               }
          });
     }

     public void clear(){
          mData.clear();
     }
}

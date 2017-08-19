package com.hy.upknowledge;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hy.upknowledge.bean.HotVideoBean;
import com.hy.upknowledge.quickopen.base.BaseAdapter;
import com.hy.upknowledge.quickopen.base.BaseViewHolder;
import com.hy.upknowledge.quickopen.utils.image.ImageUtils;
import com.hy.upknowledge.util.TimeUtil;

import java.util.List;

/**
 * Created by huyin on 2017/8/16.
 */

public class SelectedVideo4FindAdapter extends BaseAdapter<HotVideoBean> {

     public SelectedVideo4FindAdapter(Context context, List<HotVideoBean> data) {
          super(context, data, R.layout.item_for_find);
     }

     @Override
     protected void toChange(View view, ViewGroup parent) {
     }

     @Override
     protected void convert(BaseViewHolder holder, final HotVideoBean item, int position) {
          holder.setText(R.id.title, item.getTitle());
          holder.setText(R.id.profile, new StringBuilder().append(new String() == "" ? null : item.getProvider().getName())
                    .append("\t/\t#").append(item.getCategory()).append("\t/\t")
                    .append(TimeUtil.durationChange(item.getDuration())));
          if (item.getProvider().getIcon() != null
                    && !item.getProvider().getIcon().equals("")) {
               holder.setImageUrl(R.id.author_icon, new BaseViewHolder.HolderImage(item.getProvider().getIcon()) {
                    @Override
                    public void loadImg(ImageView imageView, String url) {
                         ImageUtils.getInstances().glide2Circle(mContext, url, imageView);
                    }
               });
          } else {
               if(item.getAuthor().getIcon() != null
                         && !item.getAuthor().getIcon().equals("")){
                    holder.setImageUrl(R.id.author_icon, new BaseViewHolder.HolderImage(item.getAuthor().getIcon()) {
                         @Override
                         public void loadImg(ImageView imageView, String url) {
                              ImageUtils.getInstances().glide2Circle(mContext, url, imageView);
                         }
                    });
               }
          }
          holder.setImageUrl(R.id.image, new BaseViewHolder.HolderImage(item.getCover().getFeed()) {
               @Override
               public void loadImg(ImageView imageView, String url) {
                    ImageUtils.getInstances().glideOBJContext(mContext, url, imageView);
               }
          });
     }
}

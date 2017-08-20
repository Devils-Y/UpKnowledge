package com.hy.upknowledge;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hy.upknowledge.bean.BriefCardBean;
import com.hy.upknowledge.quickopen.base.BaseAdapter;
import com.hy.upknowledge.quickopen.base.BaseViewHolder;
import com.hy.upknowledge.quickopen.utils.image.ImageUtils;

import java.util.List;

/**
 * Created by huyin on 2017/8/20.
 */

public class HotAuthorAdapter extends BaseAdapter<BriefCardBean> {

     public HotAuthorAdapter(Context context, List<BriefCardBean> data) {
          super(context, data, R.layout.item_hot_author);
     }

     @Override
     protected void toChange(View view, ViewGroup parent) {
     }

     @Override
     protected void convert(BaseViewHolder holder, BriefCardBean item, int position) {
          holder.setText(R.id.authorName, item.getTitle())
                    .setText(R.id.authorDescription, item.getDescription());
          TextView follow = holder.getView(R.id.followBtn);
          if(item.getFollow().isFollowed()){
               follow.setText("已关注");
               follow.setTextColor(mContext.getResources().getColor(R.color.magnesium));
          }else{
               follow.setText("关注");
               follow.setTextColor(mContext.getResources().getColor(R.color.mine_shaft));
          }
          holder.setImageUrl(R.id.authorIcon, new BaseViewHolder.HolderImage(item.getIcon()) {
               @Override
               public void loadImg(ImageView imageView, String url) {
                    ImageUtils.getInstances().glide2Circle(mContext, url, imageView);
               }
          });
     }
}

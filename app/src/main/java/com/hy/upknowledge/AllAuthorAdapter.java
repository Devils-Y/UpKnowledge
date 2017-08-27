package com.hy.upknowledge;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hy.upknowledge.bean.BriefCardBean;
import com.hy.upknowledge.quickopen.base.BaseAdapter;
import com.hy.upknowledge.quickopen.base.BaseViewHolder;
import com.hy.upknowledge.quickopen.utils.image.ImageUtils;

import java.util.List;

/**
 * Created by huyin on 2017/8/27.
 */

public class AllAuthorAdapter extends BaseAdapter<BriefCardBean>{

     public AllAuthorAdapter(Context context, List<BriefCardBean> data) {
          super(context, data, R.layout.item_all_author);
     }

     @Override
     protected void toChange(View view, ViewGroup parent) {
     }

     @Override
     protected void convert(BaseViewHolder holder, BriefCardBean item, int position) {
          holder.setText(R.id.authorName, item.getTitle())
                    .setText(R.id.authorDescription, item.getDescription());
          holder.setImageUrl(R.id.authorIcon, new BaseViewHolder.HolderImage(item.getIcon()) {
               @Override
               public void loadImg(ImageView imageView, String url) {
                    ImageUtils.getInstances().glide2Circle(mContext, url, imageView);
               }
          });
     }
}

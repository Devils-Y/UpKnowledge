package com.hy.upknowledge;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hy.upknowledge.discovery.hot.bean.SquareCardBean;
import com.hy.upknowledge.quickopen.base.BaseAdapter;
import com.hy.upknowledge.quickopen.base.BaseViewHolder;
import com.hy.upknowledge.quickopen.utils.image.ImageUtils;
import com.hy.upknowledge.quickopen.utils.toast.ToastUtils;

import java.util.List;

/**
 * Created by huyin on 2017/8/17.
 */

public class SquareCardAdapter extends BaseAdapter<SquareCardBean> {


     public SquareCardAdapter(Context context, List<SquareCardBean> data) {
          super(context, data, R.layout.item_square_card);
     }

     @Override
     protected void toChange(View view, ViewGroup parent) {
     }

     @Override
     protected void convert(BaseViewHolder holder, final SquareCardBean item, int position) {
          holder.setImageUrl(R.id.image, new BaseViewHolder.HolderImage(item.getImage()) {
               @Override
               public void loadImg(ImageView imageView, String url) {
                    ImageUtils.getInstances().glideOBJContext(mContext, url, imageView);
               }
          });
          holder.getView(R.id.image).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    ToastUtils.toast(mContext, item.getActionUrl());
               }
          });
     }
}

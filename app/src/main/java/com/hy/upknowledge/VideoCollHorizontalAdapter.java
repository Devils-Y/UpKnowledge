package com.hy.upknowledge;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.hy.upknowledge.bean.VideoCollHorizontalBean;
import com.hy.upknowledge.quickopen.base.BaseAdapter;
import com.hy.upknowledge.quickopen.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huyin on 2017/8/18.
 */

public class VideoCollHorizontalAdapter extends BaseAdapter<VideoCollHorizontalBean> {

     Item4VideoCollHorizontalAdapter item4VideoCollHorizontalAdapter;
     List<VideoCollHorizontalBean.ItemListBean.DataBean> videoCollList = new ArrayList<>();

     public VideoCollHorizontalAdapter(Context context, List<VideoCollHorizontalBean> data) {
          super(context, data, R.layout.item_video_coll_horizontal);
          item4VideoCollHorizontalAdapter = new Item4VideoCollHorizontalAdapter(videoCollList, mContext);
     }

     @Override
     protected void toChange(View view, ViewGroup parent) {
     }

     @Override
     protected void convert(BaseViewHolder holder, VideoCollHorizontalBean item, int position) {
          holder.setText(R.id.title, item.getHeader().getTitle());
//          ViewPager viewPager = holder.getView(R.id.horizontalPager);
//          viewPager.setAdapter(item4VideoCollHorizontalAdapter);
//          for (int i = 0; i < item.getCount(); i++) {
//               item4VideoCollHorizontalAdapter.add(item.getItemList().get(i).getData());
//          }
     }
}

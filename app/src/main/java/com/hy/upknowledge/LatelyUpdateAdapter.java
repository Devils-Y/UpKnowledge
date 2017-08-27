package com.hy.upknowledge;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hy.upknowledge.bean.VideoCollBriefBean;
import com.hy.upknowledge.quickopen.base.BaseAdapter;
import com.hy.upknowledge.quickopen.base.BaseViewHolder;
import com.hy.upknowledge.quickopen.utils.image.ImageUtils;

import java.util.ArrayList;
import java.util.List;

import static com.hy.upknowledge.Constant.VIDEO_TYPE;

/**
 * Created by huyin on 2017/8/21.
 */

public class LatelyUpdateAdapter extends BaseAdapter<VideoCollBriefBean> {

     List<VideoCollBriefBean.ItemListBean.DataBean> videoCollList = new ArrayList<>();
     LatelyUpdateImageAdapter latelyUpdateImageAdapter;

     public LatelyUpdateAdapter(Context context, List<VideoCollBriefBean> data) {
          super(context, data, R.layout.item_lately_update_author);
          latelyUpdateImageAdapter = new LatelyUpdateImageAdapter(mContext, videoCollList);
     }

     @Override
     protected void toChange(View view, ViewGroup parent) {

     }

     @Override
     protected void convert(BaseViewHolder holder, VideoCollBriefBean item, int position) {
          holder.setText(R.id.authorName, item.getHeader().getTitle())
                    .setText(R.id.authorDescription, item.getHeader().getDescription());
          latelyUpdateImageAdapter.clear();
          final RecyclerView lateUpdateRecyclerView = holder.getView(R.id.lateUpdateRecyclerView);
          lateUpdateRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,
                    LinearLayoutManager.HORIZONTAL, false));
          for (int i = 0; i < item.getItemList().size(); i++) {
               if (item.getItemList().get(i).getType().equals(VIDEO_TYPE)) {
                    latelyUpdateImageAdapter.add(item.getItemList().get(i).getData());
               }
          }
          new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                    lateUpdateRecyclerView.setAdapter(latelyUpdateImageAdapter);
                    //定位至第一位
                    lateUpdateRecyclerView.scrollToPosition(0);
               }
          }, 10);
          holder.setImageUrl(R.id.authorIcon, new BaseViewHolder.HolderImage(item.getHeader().getIcon()) {
               @Override
               public void loadImg(ImageView imageView, String url) {
                    ImageUtils.getInstances().glide2Circle(mContext, url, imageView);
               }
          });
     }
}

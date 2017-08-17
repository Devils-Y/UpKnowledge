package com.hy.upknowledge;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by huyin on 2017/8/11.
 */

public abstract class BasePagerAdapter<T> extends PagerAdapter {
//     implements ViewPager.OnPageChangeListener

     private int layoutId;

     private List<T> mPager;

     private ViewPager viewPager;

     public Context mContext;

     private LinkedList<View> mViewCache = null;

     private LayoutInflater mLayoutInflater = null;

     public BasePagerAdapter(List<T> mPager,Context mContext, int layoutId) {
          this.mPager = mPager;
          this.mContext = mContext;
//          this.viewPager = viewPager;
          this.layoutId = layoutId;
          this.mViewCache = new LinkedList<>();
          this.mLayoutInflater = LayoutInflater.from(mContext);
//          viewPager.setAdapter(this);
//          viewPager.setOnPageChangeListener(this);
     }

     @Override
     public int getCount() {
          return mPager.size();
     }

//     @Override
//     public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//     }
//
//     @Override
//     public void onPageSelected(int position) {
//          if (isCycle()) {
//               if (mPager.size() > 1) { //多于1，才会循环跳转
//                    if (position < 1) { //首位之前，跳转到末尾（N）
//                         position = mPager.size(); //注意这里是mList，而不是mViews
//                         viewPager.setCurrentItem(position, false);
//                    } else if (position > mPager.size()) { //末位之后，跳转到首位（1）
//                         viewPager.setCurrentItem(1, false); //false:不显示跳转过程的动画
//                         position = 1;
//                    }
//               }
//          }
//     }
//
//     @Override
//     public void onPageScrollStateChanged(int state) {
//
//     }

     public abstract boolean isCycle();

     @Override
     public boolean isViewFromObject(View view, Object object) {
          return view == object;
     }

     @Override
     public Object instantiateItem(ViewGroup container, int position) {
          BasePagerHolder viewHolder = null;
          View convertView = null;
          if (mViewCache.size() == 0) {
               convertView = mLayoutInflater.inflate(layoutId, container, false);
               viewHolder = new BasePagerHolder(convertView);
               convertView.setTag(viewHolder);
          } else {
               convertView = mViewCache.removeFirst();
               viewHolder = (BasePagerHolder) convertView.getTag();
          }

          convert(viewHolder, mPager.get(position), position);
          container.addView(convertView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
          return convertView;
     }

     protected abstract void convert(BasePagerHolder holder, T item, int position);

     @Override
     public void destroyItem(ViewGroup container, int position, Object object) {
          View contentView = (View) object;
          container.removeView(contentView);
          this.mViewCache.add(contentView);
     }

     public void add(T e){
          mPager.add(e);
          notifyDataSetChanged();
     }
}

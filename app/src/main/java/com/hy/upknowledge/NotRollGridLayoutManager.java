package com.hy.upknowledge;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

/**
 * Created by huyin on 2017/8/20.
 */

public class NotRollGridLayoutManager extends GridLayoutManager{

     private boolean isScrollEnabled = true;

     public NotRollGridLayoutManager(Context context, int spanCount) {
          super(context, spanCount);
     }

     public void setScrollEnabled(boolean flag) {
          this.isScrollEnabled = flag;
     }

     @Override
     public boolean canScrollVertically() {
          return super.canScrollVertically() && isScrollEnabled;
     }
}

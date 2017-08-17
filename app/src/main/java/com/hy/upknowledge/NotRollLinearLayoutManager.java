package com.hy.upknowledge;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by huyin on 2017/8/16.
 */

public class NotRollLinearLayoutManager extends LinearLayoutManager {

     private boolean isScrollEnabled = true;

     public NotRollLinearLayoutManager(Context context) {
          super(context);
     }

     public void setScrollEnabled(boolean flag) {
          this.isScrollEnabled = flag;
     }

     @Override
     public boolean canScrollVertically() {
          return super.canScrollVertically() && isScrollEnabled;
     }
}

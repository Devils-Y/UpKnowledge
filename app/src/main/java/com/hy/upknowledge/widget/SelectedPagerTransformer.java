package com.hy.upknowledge.widget;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by huyin on 2017/8/13.
 */

public class SelectedPagerTransformer implements ViewPager.PageTransformer {

     private static final float MIN_SCALE = 1f;

     @Override
     public void transformPage(View page, float position) {
          int pageWidth = page.getWidth();

          if (position < -1) { // [-Infinity,-1)
               // This page is way off-screen to the left.
               page.setAlpha(0);

          } else if (position <= 0) { // [-1,0]
               // Use the default slide transition when moving to the left page
               page.setAlpha(1);
               page.setTranslationX(0);
               page.setScaleX(1);
               page.setScaleY(1);
          } else if (position <= 1) { // (0,1]
               // Fade the page out.
               page.setAlpha(1 - position);

               // Counteract the default slide transition
               page.setTranslationX(pageWidth * -position);

//               // Scale the page down (between MIN_SCALE and 1)
//               float scaleFactor = MIN_SCALE
//                         + (1 - MIN_SCALE) * (1 - Math.abs(position));
//               page.setScaleX(scaleFactor);
//               page.setScaleY(scaleFactor);

          } else { // (1,+Infinity]
               // This page is way off-screen to the right.
               page.setAlpha(0);
          }
     }

//     private int border = 0;
//     private float speed = 0.2f;
//
//     @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//     @Override
//     public void transformPage(View view, float position) {
//
//          if (view == null ) {
//               Log.w("ParallaxPager", "There is no view");
//          }
//
//          if (view != null && Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB ) {
//               if (position > -1 && position < 1) {
//                    float width = view.getWidth();
//                    view.setTranslationX(-(position * width * speed));
//                    float sc = ((float)view.getWidth() - border)/ view.getWidth();
//                    if (position == 0) {
//                         view.setScaleX(1);
//                         view.setScaleY(1);
//                    } else {
//                         view.setScaleX(sc);
//                         view.setScaleY(sc);
//                    }
//               }
//          }
//     }
}

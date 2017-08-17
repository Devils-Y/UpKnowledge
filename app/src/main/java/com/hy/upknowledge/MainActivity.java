package com.hy.upknowledge;

import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.hy.upknowledge.quickopen.base.BaseActivity;
import com.hy.upknowledge.util.BottomNavigationViewHelper;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

     @BindView(R.id.bottomView)
     BottomNavigationView bottomNavigationView;

     HomeFragment homeFragment;
     FindFragment findFragment;
     FollowFragment followFragment;
     MineFragment mineFragment;
     FragmentManager fragmentManager;
     FragmentTransaction fragmentTransaction;

     @Override
     protected int layoutID() {
          return R.layout.activity_main;
     }

     @Override
     protected void initTitle() {

     }

     @Override
     protected void initView() {
          fragmentManager = getSupportFragmentManager();
          fragmentTransaction = fragmentManager.beginTransaction();

          hideFragments(fragmentTransaction);
          toHomeFragment();

          int[][] states = new int[][]{
                    new int[]{-android.R.attr.state_checked},
                    new int[]{android.R.attr.state_checked}
          };

          int[] colors = new int[]{getResources().getColor(R.color.stack),
                    getResources().getColor(R.color.blue_grey_color)
          };
          ColorStateList csl = new ColorStateList(states, colors);
          bottomNavigationView.setItemTextColor(csl);
          bottomNavigationView.setItemIconTintList(csl);
          BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
          bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                         @Override
                         public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                              fragmentTransaction = getSupportFragmentManager().beginTransaction();
                              hideFragments(fragmentTransaction);
                              switch (item.getItemId()) {
                                   case R.id.home:
                                        toHomeFragment();
                                        break;
                                   case R.id.find:
                                        toFindFragment();
                                        break;
                                   case R.id.follow:
                                        toFollowFragment();
                                        break;
                                   case R.id.mine:
                                        toMineFragment();
                                        break;
                              }
                              return true;
                         }
                    });
     }

     private void hideFragments(FragmentTransaction fragmentTransaction) {
          if (homeFragment != null) {
               fragmentTransaction.hide(homeFragment);
          }
          if (findFragment != null) {
               fragmentTransaction.hide(findFragment);
          }
          if (followFragment != null) {
               fragmentTransaction.hide(followFragment);
          }
          if (mineFragment != null) {
               fragmentTransaction.hide(mineFragment);
          }
     }

     private void toHomeFragment() {
          if (homeFragment == null) {
               homeFragment = new HomeFragment();
               fragmentTransaction.add(R.id.container, homeFragment);
          } else {
               fragmentTransaction.show(homeFragment);
          }
          fragmentTransaction.commit();
     }

     private void toFindFragment() {
          if (findFragment == null) {
               findFragment = new FindFragment();
               fragmentTransaction.add(R.id.container, findFragment);
          } else {
               fragmentTransaction.show(findFragment);
          }
          fragmentTransaction.commit();
     }

     private void toFollowFragment() {
          if (followFragment == null) {
               followFragment = new FollowFragment();
               fragmentTransaction.add(R.id.container, followFragment);
          } else {
               fragmentTransaction.show(followFragment);
          }
          fragmentTransaction.commit();
     }

     private void toMineFragment() {
          if (mineFragment == null) {
               mineFragment = new MineFragment();
               fragmentTransaction.add(R.id.container, mineFragment);
          } else {
               fragmentTransaction.show(mineFragment);
          }
          fragmentTransaction.commit();
     }

     @Override
     protected void initData() {
     }

     @Override
     protected boolean isFull() {
          return false;
     }

     @Override
     protected void DestroyView() {

     }
}

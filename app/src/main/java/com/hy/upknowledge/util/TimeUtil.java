package com.hy.upknowledge.util;

/**
 * Created by huyin on 2017/8/17.
 */

public class TimeUtil {
     public static String durationChange(int time) {
          StringBuilder duration = new StringBuilder();
          if (time == 0) {
               return null;
          }
          if (time / 60 > 9) {
               duration.append(time / 60).append("′");
          } else {
               duration.append("0").append(time / 60).append("′");
          }
          duration.append("\t");
          if (time % 60 > 9) {
               duration.append(time % 60).append("″");
          } else {
               duration.append("0").append(time % 60).append("″");
          }
          return duration.toString();
     }
}

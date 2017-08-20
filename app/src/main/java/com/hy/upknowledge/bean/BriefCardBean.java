package com.hy.upknowledge.bean;

/**
 * Created by huyin on 2017/8/20.
 */

public class BriefCardBean {

     private String dataType;
     private int id;
     private String icon;
     private String iconType;
     private String title;
     private Object subTitle;
     private String description;
     private String actionUrl;
     private Object adTrack;
     private FollowBean follow;
     private boolean ifPgc;

     public String getDataType() {
          return dataType;
     }

     public void setDataType(String dataType) {
          this.dataType = dataType;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getIcon() {
          return icon;
     }

     public void setIcon(String icon) {
          this.icon = icon;
     }

     public String getIconType() {
          return iconType;
     }

     public void setIconType(String iconType) {
          this.iconType = iconType;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public Object getSubTitle() {
          return subTitle;
     }

     public void setSubTitle(Object subTitle) {
          this.subTitle = subTitle;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getActionUrl() {
          return actionUrl;
     }

     public void setActionUrl(String actionUrl) {
          this.actionUrl = actionUrl;
     }

     public Object getAdTrack() {
          return adTrack;
     }

     public void setAdTrack(Object adTrack) {
          this.adTrack = adTrack;
     }

     public FollowBean getFollow() {
          return follow;
     }

     public void setFollow(FollowBean follow) {
          this.follow = follow;
     }

     public boolean isIfPgc() {
          return ifPgc;
     }

     public void setIfPgc(boolean ifPgc) {
          this.ifPgc = ifPgc;
     }

     public static class FollowBean {

          private String itemType;
          private int itemId;
          private boolean followed;

          public String getItemType() {
               return itemType;
          }

          public void setItemType(String itemType) {
               this.itemType = itemType;
          }

          public int getItemId() {
               return itemId;
          }

          public void setItemId(int itemId) {
               this.itemId = itemId;
          }

          public boolean isFollowed() {
               return followed;
          }

          public void setFollowed(boolean followed) {
               this.followed = followed;
          }
     }
}

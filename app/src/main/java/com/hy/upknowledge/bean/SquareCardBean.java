package com.hy.upknowledge.bean;

/**
 * Created by huyin on 2017/8/17.
 */

public class SquareCardBean {

     private String dataType;
     private int id;
     private String title;
     private String image;
     private String actionUrl;
     private boolean shade;
     private Object adTrack;

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

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getImage() {
          return image;
     }

     public void setImage(String image) {
          this.image = image;
     }

     public String getActionUrl() {
          return actionUrl;
     }

     public void setActionUrl(String actionUrl) {
          this.actionUrl = actionUrl;
     }

     public boolean isShade() {
          return shade;
     }

     public void setShade(boolean shade) {
          this.shade = shade;
     }

     public Object getAdTrack() {
          return adTrack;
     }

     public void setAdTrack(Object adTrack) {
          this.adTrack = adTrack;
     }
}

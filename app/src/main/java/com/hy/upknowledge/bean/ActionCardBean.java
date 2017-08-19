package com.hy.upknowledge.bean;

/**
 * Created by huyin on 2017/8/17.
 */

public class ActionCardBean {

     private String type;
     private DataBean data;
     private Object tag;

     public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }

     public DataBean getData() {
          return data;
     }

     public void setData(DataBean data) {
          this.data = data;
     }

     public Object getTag() {
          return tag;
     }

     public void setTag(Object tag) {
          this.tag = tag;
     }

     public static class DataBean {

          private String dataType;
          private int id;
          private String text;
          private String actionUrl;
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

          public String getText() {
               return text;
          }

          public void setText(String text) {
               this.text = text;
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
     }
}

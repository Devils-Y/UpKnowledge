package com.hy.upknowledge.bean;

import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by huyin on 2017/8/17.
 */

public class SquareCardCollBean {

     private String dataType;
     private HeaderBean header;
     private int count;
     private Object adTrack;
     private List<ItemListBean> itemList;

     public String getDataType() {
          return dataType;
     }

     public void setDataType(String dataType) {
          this.dataType = dataType;
     }

     public HeaderBean getHeader() {
          return header;
     }

     public void setHeader(HeaderBean header) {
          this.header = header;
     }

     public int getCount() {
          return count;
     }

     public void setCount(int count) {
          this.count = count;
     }

     public Object getAdTrack() {
          return adTrack;
     }

     public void setAdTrack(Object adTrack) {
          this.adTrack = adTrack;
     }

     public List<ItemListBean> getItemList() {
          return itemList;
     }

     public void setItemList(List<ItemListBean> itemList) {
          this.itemList = itemList;
     }

     public static class HeaderBean {

          private int id;
          private String title;
          private String font;
          private Object cover;
          private Object label;
          private String actionUrl;
          private Object labelList;

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

          public String getFont() {
               return font;
          }

          public void setFont(String font) {
               this.font = font;
          }

          public Object getCover() {
               return cover;
          }

          public void setCover(Object cover) {
               this.cover = cover;
          }

          public Object getLabel() {
               return label;
          }

          public void setLabel(Object label) {
               this.label = label;
          }

          public String getActionUrl() {
               return actionUrl;
          }

          public void setActionUrl(String actionUrl) {
               this.actionUrl = actionUrl;
          }

          public Object getLabelList() {
               return labelList;
          }

          public void setLabelList(Object labelList) {
               this.labelList = labelList;
          }
     }

     public static class ItemListBean {

          private String type;
          private JsonObject data;
          private Object tag;

          public String getType() {
               return type;
          }

          public void setType(String type) {
               this.type = type;
          }

          public JsonObject getData() {
               return data;
          }

          public void setData(JsonObject data) {
               this.data = data;
          }

          public Object getTag() {
               return tag;
          }

          public void setTag(Object tag) {
               this.tag = tag;
          }
     }
}

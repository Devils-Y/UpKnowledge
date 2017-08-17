package com.hy.upknowledge;

import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by huyin on 2017/8/13.
 */

public class SelectedResult {

     private int count;
     private int total;
     private String nextPageUrl;
     private long date;
     private long nextPublishTime;
     private Object dialog;
     private Object topIssue;
     private int refreshCount;
     private int lastStartId;
     private List<ListiItemBean> itemList;

     public int getCount() {
          return count;
     }

     public void setCount(int count) {
          this.count = count;
     }

     public int getTotal() {
          return total;
     }

     public void setTotal(int total) {
          this.total = total;
     }

     public String getNextPageUrl() {
          return nextPageUrl;
     }

     public void setNextPageUrl(String nextPageUrl) {
          this.nextPageUrl = nextPageUrl;
     }

     public long getDate() {
          return date;
     }

     public void setDate(long date) {
          this.date = date;
     }

     public long getNextPublishTime() {
          return nextPublishTime;
     }

     public void setNextPublishTime(long nextPublishTime) {
          this.nextPublishTime = nextPublishTime;
     }

     public Object getDialog() {
          return dialog;
     }

     public void setDialog(Object dialog) {
          this.dialog = dialog;
     }

     public Object getTopIssue() {
          return topIssue;
     }

     public void setTopIssue(Object topIssue) {
          this.topIssue = topIssue;
     }

     public int getRefreshCount() {
          return refreshCount;
     }

     public void setRefreshCount(int refreshCount) {
          this.refreshCount = refreshCount;
     }

     public int getLastStartId() {
          return lastStartId;
     }

     public void setLastStartId(int lastStartId) {
          this.lastStartId = lastStartId;
     }

     public List<ListiItemBean> getItemList() {
          return itemList;
     }

     public void setItemList(List<ListiItemBean> itemList) {
          this.itemList = itemList;
     }

     public static class ListiItemBean{
          private String type;
          private JsonObject data;
          private String tag;

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

          public String getTag() {
               return tag;
          }

          public void setTag(String tag) {
               this.tag = tag;
          }
     }
}

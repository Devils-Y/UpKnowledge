package com.hy.upknowledge.discovery.author;

import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by huyin on 2017/8/18.
 */

public class DiscoveryAuthorResult {

     private int count;
     private int total;
     private String nextPageUrl;
     private List<ItemListBean> itemList;

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

     public List<ItemListBean> getItemList() {
          return itemList;
     }

     public void setItemList(List<ItemListBean> itemList) {
          this.itemList = itemList;
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

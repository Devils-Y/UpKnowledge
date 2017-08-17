package com.hy.upknowledge.discovery.hot;

import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryHotResult {

     private int count;
     private int total;
     private String nextPageUrl;
     private List<ItemListBeanX> itemList;

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

     public List<ItemListBeanX> getItemList() {
          return itemList;
     }

     public void setItemList(List<ItemListBeanX> itemList) {
          this.itemList = itemList;
     }

     public static class ItemListBeanX {

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

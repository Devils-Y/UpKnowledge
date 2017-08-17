package com.hy.upknowledge.discovery;

import java.util.List;

/**
 * Created by huyin on 2017/8/14.
 */

public class DiscoveryResult {

     private TabInfoBean tabInfo;

     public TabInfoBean getTabInfo() {
          return tabInfo;
     }

     public void setTabInfo(TabInfoBean tabInfo) {
          this.tabInfo = tabInfo;
     }

     public static class TabInfoBean {

          private int defaultIdx;
          private List<TabListBean> tabList;

          public int getDefaultIdx() {
               return defaultIdx;
          }

          public void setDefaultIdx(int defaultIdx) {
               this.defaultIdx = defaultIdx;
          }

          public List<TabListBean> getTabList() {
               return tabList;
          }

          public void setTabList(List<TabListBean> tabList) {
               this.tabList = tabList;
          }

          public static class TabListBean {

               private int id;
               private String name;
               private String apiUrl;

               public int getId() {
                    return id;
               }

               public void setId(int id) {
                    this.id = id;
               }

               public String getName() {
                    return name;
               }

               public void setName(String name) {
                    this.name = name;
               }

               public String getApiUrl() {
                    return apiUrl;
               }

               public void setApiUrl(String apiUrl) {
                    this.apiUrl = apiUrl;
               }
          }
     }
}

package com.hy.upknowledge.bean;

/**
 * Created by huyin on 2017/8/14.
 */

public class SelectedFooterBean {

     private String dataType;
     private String text;
     private String font;
     private String actionUrl;
     private Object adTrack;

     public String getDataType() {
          return dataType;
     }

     public void setDataType(String dataType) {
          this.dataType = dataType;
     }

     public String getText() {
          return text;
     }

     public void setText(String text) {
          this.text = text;
     }

     public String getFont() {
          return font;
     }

     public void setFont(String font) {
          this.font = font;
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

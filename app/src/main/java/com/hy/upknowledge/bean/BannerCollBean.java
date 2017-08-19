package com.hy.upknowledge.bean;

import java.util.List;

/**
 * Created by huyin on 2017/8/18.
 */

public class BannerCollBean {

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
          /**
           * id : 4
           * title : 热门专题
           * font : bold
           * cover : null
           * label : null
           * actionUrl : eyepetizer://campaign/list/?title=%E4%B8%93%E9%A2%98
           * labelList : null
           */

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
               private String title;
               private String description;
               private String image;
               private String actionUrl;
               private Object adTrack;
               private boolean shade;
               private LabelBean label;
               private Object header;
               private List<?> labelList;

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

               public String getDescription() {
                    return description;
               }

               public void setDescription(String description) {
                    this.description = description;
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

               public Object getAdTrack() {
                    return adTrack;
               }

               public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
               }

               public boolean isShade() {
                    return shade;
               }

               public void setShade(boolean shade) {
                    this.shade = shade;
               }

               public LabelBean getLabel() {
                    return label;
               }

               public void setLabel(LabelBean label) {
                    this.label = label;
               }

               public Object getHeader() {
                    return header;
               }

               public void setHeader(Object header) {
                    this.header = header;
               }

               public List<?> getLabelList() {
                    return labelList;
               }

               public void setLabelList(List<?> labelList) {
                    this.labelList = labelList;
               }

               public static class LabelBean {

                    private String text;
                    private String card;
                    private Object detail;

                    public String getText() {
                         return text;
                    }

                    public void setText(String text) {
                         this.text = text;
                    }

                    public String getCard() {
                         return card;
                    }

                    public void setCard(String card) {
                         this.card = card;
                    }

                    public Object getDetail() {
                         return detail;
                    }

                    public void setDetail(Object detail) {
                         this.detail = detail;
                    }
               }
          }
     }
}

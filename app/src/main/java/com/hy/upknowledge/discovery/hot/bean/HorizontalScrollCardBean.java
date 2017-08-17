package com.hy.upknowledge.discovery.hot.bean;

import java.util.List;

/**
 * Created by huyin on 2017/8/16.
 */

public class HorizontalScrollCardBean {

     private String dataType;
     private int count;
     private List<ItemListBean> itemList;

     public String getDataType() {
          return dataType;
     }

     public void setDataType(String dataType) {
          this.dataType = dataType;
     }

     public int getCount() {
          return count;
     }

     public void setCount(int count) {
          this.count = count;
     }

     public List<ItemListBean> getItemList() {
          return itemList;
     }

     public void setItemList(List<ItemListBean> itemList) {
          this.itemList = itemList;
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
               private HeaderBean header;
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

               public HeaderBean getHeader() {
                    return header;
               }

               public void setHeader(HeaderBean header) {
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

               public static class HeaderBean {

                    private int id;
                    private Object title;
                    private Object font;
                    private Object cover;
                    private Object label;
                    private Object actionUrl;
                    private Object labelList;
                    private Object icon;
                    private Object description;

                    public int getId() {
                         return id;
                    }

                    public void setId(int id) {
                         this.id = id;
                    }

                    public Object getTitle() {
                         return title;
                    }

                    public void setTitle(Object title) {
                         this.title = title;
                    }

                    public Object getFont() {
                         return font;
                    }

                    public void setFont(Object font) {
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

                    public Object getActionUrl() {
                         return actionUrl;
                    }

                    public void setActionUrl(Object actionUrl) {
                         this.actionUrl = actionUrl;
                    }

                    public Object getLabelList() {
                         return labelList;
                    }

                    public void setLabelList(Object labelList) {
                         this.labelList = labelList;
                    }

                    public Object getIcon() {
                         return icon;
                    }

                    public void setIcon(Object icon) {
                         this.icon = icon;
                    }

                    public Object getDescription() {
                         return description;
                    }

                    public void setDescription(Object description) {
                         this.description = description;
                    }
               }
          }
     }
}

package com.hy.upknowledge.http;

import com.hy.upknowledge.SelectedResult;
import com.hy.upknowledge.discovery.DiscoveryResult;
import com.hy.upknowledge.discovery.author.DiscoveryAuthorResult;
import com.hy.upknowledge.discovery.category.DiscoveryCategoryResult;
import com.hy.upknowledge.discovery.hot.DiscoveryHotResult;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by huyin on 2017/8/10.
 */

public class API {
     public static final String KAIYAN_HEAD_URL = "http://baobab.kaiyanapp.com/api/";

     public static final String SelectedUrl = "v4/tabs/selected";

     public static final String DiscoveryUrl = "v4/discovery";

     /**
      * 首页
      */
     public interface SelectedService {
          @GET(SelectedUrl)
          Flowable<SelectedResult> getSelected();
     }

     /**
      * 获取发现分类
      */
     public interface DiscoveryService {
          @GET(DiscoveryUrl)
          Flowable<DiscoveryResult> getDiscovery();
     }

     /**
      * 动态获取发现中的'热门'
      */
     public interface DiscoveryHotService {
          @GET
          Flowable<DiscoveryHotResult> getDiscoveryHot(@Url String url,
                                                       @Query("start") int start,
                                                       @Query("num") int num);
     }

     /**
      * 动态获取发现中的'分类'
      */
     public interface DiscoveryCategoryService {
          @GET
          Flowable<DiscoveryCategoryResult> getDiscoveryCategory(@Url String url,
                                                                 @Query("start") int start,
                                                                 @Query("num") int num);
     }

     /**
      * 动态获取发现中的'作者'
      */
     public interface DiscoveryAuthorService {
          @GET
          Flowable<DiscoveryAuthorResult> getDiscoveryAuthor(@Url String url,
                                                             @Query("start") int start,
                                                             @Query("num") int num);
     }
}

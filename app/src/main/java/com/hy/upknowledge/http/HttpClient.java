package com.hy.upknowledge.http;

import com.google.gson.Gson;
import com.hy.upknowledge.BuildConfig;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.hy.upknowledge.http.API.KAIYAN_HEAD_URL;

/**
 * Created by huyin on 2017/8/7.
 */

public class HttpClient {
     private static Retrofit retrofit = null;

     public static Retrofit retrofit() {
          if (retrofit == null) {
               OkHttpClient.Builder builder = new OkHttpClient.Builder();
               /**
                * 设置Log信息拦截器
                */
               if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    builder.addInterceptor(loggingInterceptor);
               }

               builder.connectTimeout(10, TimeUnit.SECONDS);
               builder.readTimeout(10, TimeUnit.SECONDS);
               builder.writeTimeout(10, TimeUnit.SECONDS);
               builder.retryOnConnectionFailure(true);

               OkHttpClient okHttpClient = builder.build();

               retrofit = new Retrofit.Builder()
                         .baseUrl(KAIYAN_HEAD_URL)
                         .client(okHttpClient)
                         .addConverterFactory(GsonConverterFactory.create(new Gson()))
                         .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                         .build();
          }
          return retrofit;
     }
}

package com.xjd.a360fastloan.common;



import com.lm.lib_common.net.DownloadResponseBody;
import com.lm.lib_common.net.DownloadResponseBody.DownLoadListener;
import com.lm.lib_common.net.GsonConverterFactory;
import com.lm.lib_common.net.LoggerInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


/**
 * Created by lm on 2019/6/17
 */

public class Api {

    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static ApiService apiService;


    public static ApiService getApi() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(Link.SEREVE)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }

    public static OkHttpClient getOkHttpClient(DownLoadListener... downLoadListener) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                 .addInterceptor(new LoggerInterceptor("lm", true))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .addInterceptor(chain -> {//添加公共信息
                    Request originalRequest = chain.request();
                    // 添加新的参数
                    HttpUrl.Builder authorizedUrlBuilder = originalRequest.url()
                            .newBuilder()
                            .scheme(originalRequest.url().scheme())
                            .host(originalRequest.url().host())
                            .addQueryParameter("common", "aaa");

                    // 新的请求+请求头部
                    Request newRequest = originalRequest.newBuilder()
                            .header("Authorization", "token")
                            .method(originalRequest.method(), originalRequest.body())
                            .url(authorizedUrlBuilder.build())
                            .build();

                    return chain.proceed(newRequest);
                });
        if (downLoadListener.length > 0) {
            builder.addNetworkInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response originalResponse = chain.proceed(chain.request());
                    DownloadResponseBody downloadResponseBody = new DownloadResponseBody(originalResponse.body(), downLoadListener[0]);
                    return originalResponse.newBuilder().body(downloadResponseBody).build();
                }
            });
        }
        return builder.build();
    }

    public static ApiService getDownLoadApi(String url,final DownLoadListener downLoadListener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getOkHttpClient(downLoadListener))
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();

        return retrofit.create(ApiService.class);
    }
}

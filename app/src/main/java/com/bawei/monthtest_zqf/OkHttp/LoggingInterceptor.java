package com.bawei.monthtest_zqf.OkHttp;

import android.os.Build;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * 网络拦截器
 */

public class LoggingInterceptor implements Interceptor {
    private static final String UA = "User-Agent";

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader(UA, makeUA())
                .build();
        return chain.proceed(request);
    }

    private String makeUA() {
        String s = Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
        return Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
    }

}

package com.ylxnerf.www;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * ========================================
 * <p>
 * 版 权：赵涌优选
 * <p>
 * 作 者：杨理想
 * <p>
 * 创建日期：2019-05-28  22:04
 * <p>
 * 描 述：
 * <p>
 * ========================================
 */
public class HttpHelper implements IHttpProcessor {

    //业务员
    private static HttpHelper instance;

    private HttpHelper() {}

    public static HttpHelper getInstance() {
        synchronized (HttpHelper.class) {
            if(instance == null) {
                instance = new HttpHelper();
            }
        }
        return instance;
    }

    //这里相当于持有某个第三方网络框架
    private static IHttpProcessor mHttpProcessor;
    public static void init(IHttpProcessor httpProcessor) {
        mHttpProcessor = httpProcessor;
    }


    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        //post可以通用的get方法
        String finalUrl = appendParams(url, params);
        mHttpProcessor.post(finalUrl, params, callBack);
    }

    private String appendParams(String url, Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return url;
        }
        StringBuilder urlBuilder = new StringBuilder(url);
        if (urlBuilder.indexOf("?") <= 0) {
            urlBuilder.append("?");
        } else {
            if (!urlBuilder.toString().endsWith("?")) {
                urlBuilder.append("&");
            }
        }
        for (Map.Entry<String, Object> entry: params.entrySet()) {
            urlBuilder.append("&" + entry.getKey()).append("=").append(encode(entry.getValue().toString()));
        }
        return urlBuilder.toString();
    }

    private static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

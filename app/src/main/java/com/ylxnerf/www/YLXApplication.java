package com.ylxnerf.www;

import android.app.Application;

/**
 * ========================================
 * <p>
 * 版 权：赵涌优选
 * <p>
 * 作 者：杨理想
 * <p>
 * 创建日期：2019-05-28  22:27
 * <p>
 * 描 述：
 * <p>
 * ========================================
 */
public class YLXApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.init(new VolleyProcessor(this));
//        HttpHelper.init(new OkHttpProcessor());
    }
}

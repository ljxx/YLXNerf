package com.ylxnerf.www;

import java.util.Map;

/**
 * ========================================
 * <p>
 * 版 权：赵涌优选
 * <p>
 * 作 者：杨理想
 * <p>
 * 创建日期：2019-05-28  21:45
 * <p>
 * 描 述：
 * <p>
 * ========================================
 */
public interface IHttpProcessor {

    void post(String url, Map<String, Object> params, ICallBack callBack);

}

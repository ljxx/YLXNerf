package com.ylxnerf.www;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ========================================
 * <p>
 * 版 权：赵涌优选
 * <p>
 * 作 者：杨理想
 * <p>
 * 创建日期：2019-05-28  21:51
 * <p>
 * 描 述：
 * <p>
 * ========================================
 */
public abstract class HttpCallBack<T> implements ICallBack {

    @Override
    public void onSuccess(String result) {
        //将网络反问框架得到的数据转换成Json对象
        Gson gson = new Gson();

        //拿到HttpCallBack后面的范型类型
        Class<?> clazz = analysisClassInfo(this);
        T objResult = (T) gson.fromJson(result, clazz);

        onSuccess(objResult);
    }

    private Class<?> analysisClassInfo(Object obj) {
        Type genType = obj.getClass().getGenericSuperclass();
        Type[] actualType = ((ParameterizedType)genType).getActualTypeArguments();
        return (Class<?>) actualType[0];
    }

    public abstract void onSuccess(T result);


    @Override
    public void onFailure() {

    }
}

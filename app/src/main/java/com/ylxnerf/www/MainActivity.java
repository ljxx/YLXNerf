package com.ylxnerf.www;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String url = "http://v.juhe.cn/historyWeather/citys";

    private TextView mResponseTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResponseTxt = findViewById(R.id.m_response_txt);

        Map<String, Object> params = new HashMap<>();
        params.put("province_id", 1);
        HttpHelper.getInstance().post(url, params, new HttpCallBack<ResponseClass>() {
            @Override
            public void onSuccess(ResponseClass result) {
                Log.i("====得到返回值：", result.toString());
                mResponseTxt.setText("请求接口的返回值是：" + result.toString());
            }
        });
    }
}

package com.zll.wuye.lvshi.http;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.lvshi.bean.PersonMessageBean;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/14 11:32
 */
public class HttpOkGo {


    public static <T> void okgoget(String url, final Class<T> clazz, final okget<T> ok){
        final ArrayList<T> list = new ArrayList<>();
        OkGo.get(url)
            .tag(ok)
            .execute(new StringCallback() {
                @Override
                public void onSuccess(String s, Call call, Response response) {
                    Gson gson = new Gson();
                    T t = gson.fromJson(s, clazz);
                    list.add(t);
                    ok.shuju(list);
                }

                @Override
                public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                    super.upProgress(currentSize, totalSize, progress, networkSpeed);
                }
            });
    }



    public interface okget<T>{
        void shuju(ArrayList<T> list);
    }


    public static  void okgopost(String url, HashMap<String, Object> params, final okpost ok) {

        JSONObject jsonObject = new JSONObject(params);

        OkGo.post(url)//
                .tag(ok)//
                .upJson(jsonObject.toString())//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        ok.fanhui(s);

                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    public interface okpost{
        void fanhui(String s);
    }
}

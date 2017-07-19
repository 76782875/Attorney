package com.zll.wuye.lvshi.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/24 19:52
 */
public abstract class BaseFragment extends Fragment {

    public Context mcontext;
    //该方法在Fragment创建时回调,得到上下文
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mcontext = getActivity();
    }
    //让Fragment加载XML布局资源,因为每个子类Fragment显示的界面都不同,所以返回一个抽象方法
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return initview(inflater, container, savedInstanceState);
    }
    //加载Fragment布局资源,子类必须要覆写的抽象方法
    public abstract View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    //Fragment与Activity被创建是回调,进行数据的初始化
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initdata();
    }
    //联网获取数据,进行数据的初始化,展示数据,子类必须要覆写抽象方法
    public abstract void initdata();
}

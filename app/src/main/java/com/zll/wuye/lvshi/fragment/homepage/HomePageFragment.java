package com.zll.wuye.lvshi.fragment.homepage;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.base.BaseFragment;
import com.zll.wuye.lvshi.fragment.homepage.adapter.HomepagerAdapter;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/23 14:44
 */
public class HomePageFragment extends BaseFragment {


    private View mView;
    private RecyclerView mRecyclerView;

    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.homepagefragment, null);
        return mView;
    }

    @Override
    public void initdata() {

        mRecyclerView = (RecyclerView) mView.findViewById(R.id.zhuye_recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new HomepagerAdapter(getActivity()));

    }
}

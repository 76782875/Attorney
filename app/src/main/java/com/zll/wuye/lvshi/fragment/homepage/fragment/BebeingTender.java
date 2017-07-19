package com.zll.wuye.lvshi.fragment.homepage.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.lzy.okgo.OkGo;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.bean.MyTenderBean;
import com.zll.wuye.lvshi.fragment.homepage.fragment.adapter.MyTenderAdapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/19 11:06
 */
public class BebeingTender extends Fragment {

    private View mInflate;
    private RecyclerView bebing;
    private String token;
    ArrayList<MyTenderBean.BodyBean> mlist = new ArrayList();
    private MyTenderAdapter adapter;
    private MaterialRefreshLayout mRefreshLayout;
    private int p=1;
    private boolean isLoadMore = true;
    private int size;
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mInflate = View.inflate(getActivity(), R.layout.bebeingfragment, null);
        return mInflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences sp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        bebing = (RecyclerView) mInflate.findViewById(R.id.bebeing_render);
        bebing.setLayoutManager(new LinearLayoutManager(getActivity()));
        String url = "https://wuye.kylinlaw.com/case/lawyer/list?status=0&token="+token;
        initdata(url);
        mRefreshLayout = (MaterialRefreshLayout) mInflate.findViewById(R.id.bebeing_mater);
        mRefreshLayout.setLoadMore(isLoadMore);
        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                tv.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();

            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if(mlist.size()>1){
                    size = mlist.size()-1;
                    String url = "https://wuye.kylinlaw.com/case/lawyer/list?status=0&token="+token+"&lastId="+(mlist.size()-1);
                    initdata(url);
                }else{
                    tv.setVisibility(View.VISIBLE);
                     mRefreshLayout.finishRefreshLoadMore();
                }
            }
        });
        tv = (TextView) mInflate.findViewById(R.id.bebeing_shangla);
    }

    private void initdata(String url) {

        HttpOkGo.okgoget(url, MyTenderBean.class, new HttpOkGo.okget<MyTenderBean>() {
            @Override
            public void shuju(ArrayList<MyTenderBean> list) {
                List<MyTenderBean.BodyBean> body = list.get(0).getBody();
                if(body.size()>=1){
                    if(p==1){
                        mlist.addAll(body);
                        adapter = new MyTenderAdapter(mlist,getActivity(),token,1);
                        bebing.setAdapter(adapter);
                        p++;
                    }else{
                        if(body.size()>=10){
                            mlist.addAll(body);
                            adapter.notifyItemRangeChanged(size,mlist.size()-1);
                        }else{
                            tv.setVisibility(View.VISIBLE);
                        }
                    }

                }else{
                    tv.setVisibility(View.VISIBLE);
                }

                mRefreshLayout.finishRefreshLoadMore();

            }
        });
    }
}

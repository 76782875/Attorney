package com.zll.wuye.lvshi.fragment.homepage.fragment;

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
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.bean.MakeBean;
import com.zll.wuye.lvshi.fragment.homepage.adapter.MakeAdapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/22 16:54
 */
public class MakeFragment extends Fragment {

    private View mView;
    ArrayList<MakeBean.BodyBean> mList = new ArrayList<>();
    private RecyclerView recyc;
    private MaterialRefreshLayout mRefreshLayout;
    private boolean isLoadMore = true;
    private int p=1;
    private int size;
    private String url;
    private MakeAdapter mAdapter;
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.makefragment, null);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        jiexi(url);
        recyc = (RecyclerView) mView.findViewById(R.id.make_fm_recycle);
        recyc.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRefreshLayout = (MaterialRefreshLayout) mView.findViewById(R.id.make_fm_mater);
        mRefreshLayout.setLoadMore(isLoadMore);

        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {

            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                tv.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();
            }


            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if(mList.size()>=1){
                    size = mList.size()-1;
                    jiexi(url+"&lastId="+mList.get(size).getId());
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });
        tv = (TextView) mView.findViewById(R.id.make_fm__shangla);
    }

    private void jiexi(String url) {
        HttpOkGo.okgoget(url, MakeBean.class, new HttpOkGo.okget<MakeBean>() {
            @Override
            public void shuju(ArrayList<MakeBean> list) {
                List<MakeBean.BodyBean> body = list.get(0).getBody();
                if(body!=null&&body.size()>=1){

                    if(p==1){
                        mList.addAll(body);
                        mAdapter = new MakeAdapter(getActivity(),mList);
                        recyc.setAdapter(mAdapter);
                        p++;
                    }else{
                        if(body.size()>=10){
                            mList.addAll(body);
                            mAdapter.notifyItemRangeChanged(size,mList.size()-1);
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

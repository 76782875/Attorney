package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.bean.TenderBean;
import com.zll.wuye.lvshi.fragment.homepage.adapter.TenderAdapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

public class TenderActivity extends AutoLayoutActivity {

    private String token;
    private ImageView tender_fanhui;
    private RecyclerView tender_recycle;
    ArrayList<TenderBean.BodyBean> mList = new ArrayList<>();
    private MaterialRefreshLayout mRefreshLayout;
    private int p=1;
    private boolean isLoadMore = true;
    private int size;
    private TenderAdapter adapter;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initdata();

    }

    private void initdata() {
        tender_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String url = "https://wuye.kylinlaw.com/case/list?pageSize=10&token="+token;
        shuju(url);
        tender_recycle.setLayoutManager(new LinearLayoutManager(this));
        mRefreshLayout.setLoadMore(isLoadMore);
        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                tv.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();

            }
            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if(mList.size()>1){
                    tv.setVisibility(View.GONE);
                    size = mList.size()-1;
                    String url = "https://wuye.kylinlaw.com/case/list?token="+token+"&pageSize=10&lastId="+mList.get(size).getId();
                    shuju(url);
                }else{
                    tv.setVisibility(View.VISIBLE);
                    mRefreshLayout.finishRefreshLoadMore();
                }

            }
        });


    }


    private void shuju(String url) {
        HttpOkGo.okgoget(url, TenderBean.class, new HttpOkGo.okget<TenderBean>() {
            @Override
            public void shuju(ArrayList<TenderBean> list) {
                List<TenderBean.BodyBean> body = list.get(0).getBody();
                if(body!=null){
                    if(p==1){
                        mList.addAll(body);
                        adapter = new TenderAdapter(mList, TenderActivity.this,token);
                        tender_recycle.setAdapter(adapter);
                        p++;
                    }else{
                        if(body.size()>=10){
                            mList.addAll(body);
                        }else{
                            tv.setVisibility(View.VISIBLE);
                        }
                        adapter.notifyItemRangeChanged(size,mList.size()-1);
                    }
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });
    }

    private void initView() {
        tender_fanhui = (ImageView) findViewById(R.id.tender_fanhui);
        tender_recycle = (RecyclerView) findViewById(R.id.tender_recycle);
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.tender_mater);
        tv = (TextView) findViewById(R.id.tender_shangla);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mList.clear();
        initdata();
    }
}

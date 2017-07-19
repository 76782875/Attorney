package com.zll.wuye.lvshi.fragment.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.bean.Pingjia;
import com.zll.wuye.lvshi.fragment.mypage.adapter.PingjiaAdapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

public class MyPingJia extends AppCompatActivity {

    private String token;
    private ImageView wode_pingjia_fanhui;
    private RecyclerView wode_pingjia_recycle;
    ArrayList<Pingjia.BodyBean> mList = new ArrayList<>();
    private MaterialRefreshLayout mRefreshLayout;
    private TextView tv;
    private boolean isLoadMore = true;
    private int p=1;
    private int size;
    private PingjiaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ping_jia);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        String url = "https://wuye.kylinlaw.com/lawyer/commt/all?token=" + token;
        jirxi(url);
        initdata();

    }

    private void jirxi(String url) {
        HttpOkGo.okgoget(url, Pingjia.class, new HttpOkGo.okget<Pingjia>() {
            @Override
            public void shuju(ArrayList<Pingjia> list) {
                List<Pingjia.BodyBean> body = list.get(0).getBody();
                if(body!=null&&body.size()>=1){
                    if(p==1){
                        mList.addAll(body);
                        adapter = new PingjiaAdapter(MyPingJia.this, mList);
                        wode_pingjia_recycle.setAdapter(adapter);
                        p++;
                    }else{
                        if(body.size()>=10){
                            mList.addAll(body);
                            adapter.notifyItemRangeChanged(size-1,list.size()-1);
                        }else{
                            tv.setVisibility(View.VISIBLE);
                        }
                    }
                }else{
                    tv.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    private void initdata() {
        wode_pingjia_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wode_pingjia_recycle.setLayoutManager(new LinearLayoutManager(this));
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
                    size = mList.size();
                    String url = "https://wuye.kylinlaw.com/lawyer/commt/all?token=" + token+"&lastId="+mList.get(size-1).getId();
                    jirxi(url);
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });
    }

    private void initView() {
        wode_pingjia_fanhui = (ImageView) findViewById(R.id.wode_pingjia_fanhui);
        wode_pingjia_recycle = (RecyclerView) findViewById(R.id.wode_pingjia_recycle);
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.wode_pingjia_material);
        tv = (TextView) findViewById(R.id.wode_pingjia_shangla);
    }
}

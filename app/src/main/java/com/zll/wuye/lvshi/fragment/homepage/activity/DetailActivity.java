package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.bean.DetailBean;
import com.zll.wuye.lvshi.fragment.homepage.adapter.DetailAdapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AutoLayoutActivity {

    private String token;
    private ImageView shouyimingxi_fanhui;
    private RecyclerView shouyimingxi_recycle;
    private MaterialRefreshLayout mRefreshLayout;
    ArrayList<DetailBean.BodyBean> mlist = new ArrayList<>();
    private boolean isLoadMore = true;
    private int size;
    private int num = 1;
    private DetailAdapter adapter;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initdata();
    }

    private void initdata() {
        shouyimingxi_recycle.setLayoutManager(new LinearLayoutManager(this));
        String url = "https://wuye.kylinlaw.com/trans/list?token=" + token;
        qingqiu(url);

        shouyimingxi_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
                    String url = "https://wuye.kylinlaw.com/trans/list?token=" + token+"&lastId="+size;
                    qingqiu(url);
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });
    }

    private void initView() {
        shouyimingxi_fanhui = (ImageView) findViewById(R.id.shouyimingxi_fanhui);
        shouyimingxi_recycle = (RecyclerView) findViewById(R.id.shouyimingxi_recycle);
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.shouyimingxi_mater);
        tv = (TextView) findViewById(R.id.shouyimingxi_shangla);
    }

    public void qingqiu(String url){
        HttpOkGo.okgoget(url, DetailBean.class, new HttpOkGo.okget<DetailBean>() {
            @Override
            public void shuju(ArrayList<DetailBean> list) {
                List<DetailBean.BodyBean> body = list.get(0).getBody();
                if(body.size()>=1){
                    if(num==1){
                        mlist.addAll(body);
                        adapter = new DetailAdapter(DetailActivity.this,mlist);
                        shouyimingxi_recycle.setAdapter(adapter);
                        num++;
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

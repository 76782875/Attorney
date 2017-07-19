package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.bean.PhotoBean;
import com.zll.wuye.lvshi.fragment.homepage.adapter.PhotoAdapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

public class PhotoMeeth extends AppCompatActivity {

    private String token;
    private ImageView photo_fanhui;
    private RecyclerView photo_recycle;
    ArrayList<PhotoBean.BodyBean> mList = new ArrayList<>();
    private MaterialRefreshLayout mRefreshLayout;
    private int size;
    private boolean isLoadMore = true;
    private int p=1;
    private PhotoAdapter mAdapter;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_meeth);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initdata();

    }

    private void initdata() {
        photo_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        photo_recycle.setLayoutManager(new LinearLayoutManager(this));
        String url = "https://wuye.kylinlaw.com/order/lawyer/ask/list?token="+token;
        jiexi(url);
    }

    private void jiexi(String url) {
        HttpOkGo.okgoget(url, PhotoBean.class, new HttpOkGo.okget<PhotoBean>() {
            @Override
            public void shuju(ArrayList<PhotoBean> list) {
                List<PhotoBean.BodyBean> body = list.get(0).getBody();
                if(body!=null&&body.size()>=1){

                    if(p==1) {
                        mList.addAll(body);
                        mAdapter = new PhotoAdapter(PhotoMeeth.this, mList, token);
                        photo_recycle.setAdapter(mAdapter);
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

    private void initView() {
        photo_fanhui = (ImageView) findViewById(R.id.photo_fanhui);
        photo_recycle = (RecyclerView) findViewById(R.id.photo_recycle);
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.photo_material);


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
                    String url = "https://wuye.kylinlaw.com/order/lawyer/ask/list?token="+token+"&lastId="+mList.get(size).getId();
                    jiexi(url);
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });
        tv = (TextView) findViewById(R.id.photo_shangla);
    }
}

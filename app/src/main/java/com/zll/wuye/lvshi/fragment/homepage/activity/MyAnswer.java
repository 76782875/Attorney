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
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.bean.MyAnswerBean;
import com.zll.wuye.lvshi.fragment.homepage.adapter.AnswerAdapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

public class MyAnswer extends AppCompatActivity {

    private ImageView myanswer_fanhui;
    private RecyclerView answer_recycle;
    private String token;
    private ArrayList<MyAnswerBean.BodyBean> mlist = new ArrayList<>();
    private MaterialRefreshLayout mRefreshLayout;
    private int p=1;
    private boolean isLoadMore = true;
    private int size;
    private AnswerAdapter adapter;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_answer);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initView();
        initdata();

    }

    private void initdata() {
        myanswer_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        answer_recycle.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initView() {
        myanswer_fanhui = (ImageView) findViewById(R.id.myanswer_fanhui);
        answer_recycle = (RecyclerView) findViewById(R.id.answer_recycle);
        String url = "https://wuye.kylinlaw.com/ask/my/reply/list?token="+token;
        jiexi(url);
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.answer_mater);
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
                    isLoadMore = true;
                    size = mlist.size()-1;
                    String url = "https://wuye.kylinlaw.com/ask/my/reply/list?token="+token+"&lastId="+mlist.get(size).getId();
                    jiexi(url);
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });

        tv = (TextView) findViewById(R.id.answer_shangla);

    }

    private void jiexi(String url) {
        HttpOkGo.okgoget(url, MyAnswerBean.class, new HttpOkGo.okget<MyAnswerBean>() {
            @Override
            public void shuju(ArrayList<MyAnswerBean> list) {
                List<MyAnswerBean.BodyBean> body = list.get(0).getBody();
                if(body!=null&&body.size()>=1){

                    if(p==1){
                        mlist.addAll(body);
                        adapter = new AnswerAdapter(MyAnswer.this,mlist,token);
                        answer_recycle.setAdapter(adapter);
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

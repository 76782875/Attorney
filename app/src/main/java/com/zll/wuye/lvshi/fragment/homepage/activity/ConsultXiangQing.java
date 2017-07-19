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

import com.bumptech.glide.Glide;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.HuiFuBean;
import com.zll.wuye.lvshi.bean.XiangqingBean;
import com.zll.wuye.lvshi.fragment.homepage.adapter.HomepagezixunHolder;
import com.zll.wuye.lvshi.fragment.homepage.adapter.HuiFuAdapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

//咨询详情
public class ConsultXiangQing extends AutoLayoutActivity {

    private ImageView consult_xq_fanhui;
    private ImageView consult_xq_touxiang;
    private TextView consult_xq_name;
    private TextView consult_xq_time;
    private TextView consult_xq_message;
    private AutoRelativeLayout consult_xq_woyaohuida;
    private RecyclerView consult_xq_recycle;
    private String id;
    private String token;
    ArrayList<HuiFuBean.BodyBean> mList = new ArrayList<>();
    private MaterialRefreshLayout mRefreshLayout;
    private int p=1;
    private boolean isLoadMore = true;
    private int size;
    private HuiFuAdapter adapter;
    private String mmp;
    private TextView mtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_xiang_qing);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        token = intent.getStringExtra("token");
        mmp = intent.getStringExtra("p");

        initView();
        initdata();

    }


    private void initdata() {
        consult_xq_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        consult_xq_recycle.setLayoutManager(new LinearLayoutManager(this));
        String url = "https://wuye.kylinlaw.com/ask/reply/list?askId="+id+"&token="+token;
        huidaneirong(url);

        mRefreshLayout.setLoadMore(isLoadMore);
        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {

            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                mtv.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();
            }


            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                isLoadMore = true;
                if(mList.size()>1){
                    size = mList.size()-1;
                    String url = "https://wuye.kylinlaw.com/ask/reply/list?askId="+id+"&token="+token+"&lastAskRecId="+mList.get(size).getId();
                    huidaneirong(url);
                }else{
                    mtv.setVisibility(View.VISIBLE);
                    mRefreshLayout.finishRefreshLoadMore();
                }

            }
        });

        consult_xq_woyaohuida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsultXiangQing.this,ConsultHuida.class);
                intent.putExtra("id",id);
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });
    }

    private void huidaneirong(String url) {
        HttpOkGo.okgoget(url, HuiFuBean.class, new HttpOkGo.okget<HuiFuBean>() {
            @Override
            public void shuju(ArrayList<HuiFuBean> list) {
                List<HuiFuBean.BodyBean> body = list.get(0).getBody();
                if(body!=null&&body.size()>=1){
                    if(p==1){
                        mList.addAll(body);
                        adapter = new HuiFuAdapter(mList, ConsultXiangQing.this);
                        consult_xq_recycle.setAdapter(adapter);
                        p++;
                    }else{
                        if(body.size()>=10){
                            mList.addAll(body);
                            adapter.notifyItemRangeChanged(size-1,mList.size()-1);
                        }else {
                            mtv.setVisibility(View.VISIBLE);
                        }
                    }

                }else{
                    mtv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });

    }

    private void initView() {
        consult_xq_fanhui = (ImageView) findViewById(R.id.consult_xq_fanhui);
        consult_xq_touxiang = (ImageView) findViewById(R.id.consult_xq_touxiang);
        consult_xq_name = (TextView) findViewById(R.id.consult_xq_name);
        consult_xq_time = (TextView) findViewById(R.id.consult_xq_time);
        consult_xq_message = (TextView) findViewById(R.id.consult_xq_message);
        consult_xq_woyaohuida = (AutoRelativeLayout) findViewById(R.id.consult_xq_woyaohuida);
        consult_xq_recycle = (RecyclerView) findViewById(R.id.consult_xq_recycle);
        canshu();
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.consult_xq_mater);
        TextView tv= (TextView) findViewById(R.id.consult_xq_tv);
        if(mmp.equals("1")){
            consult_xq_woyaohuida.setVisibility(View.GONE);
            tv.setVisibility(View.GONE);
        }else{
            consult_xq_woyaohuida.setVisibility(View.VISIBLE);
            tv.setVisibility(View.VISIBLE);
        }
        mtv = (TextView) findViewById(R.id.consult_xq_shangla);
    }

    private void canshu() {
        String url = "https://wuye.kylinlaw.com/ask/detail?askId="+id+"&token="+token;
        HttpOkGo.okgoget(url, XiangqingBean.class, new HttpOkGo.okget<XiangqingBean>() {
            @Override
            public void shuju(ArrayList<XiangqingBean> list) {
                XiangqingBean.BodyBean body = list.get(0).getBody();

                if(body!=null){
                    Glide.with(ConsultXiangQing.this).load(body.getHeadImg()).bitmapTransform(new RoundedCornersTransformation(ConsultXiangQing.this, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(consult_xq_touxiang);
                    consult_xq_name.setText("用户姓名:"+body.getUserName());
                    consult_xq_time.setText("发布时间:"+body.getQuestTm());
                    consult_xq_message.setText("问题内容:"+body.getQuest());

                }

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mList.clear();
        initView();
        initdata();
    }
}

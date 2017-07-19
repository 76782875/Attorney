package com.zll.wuye.lvshi.fragment.homepage.fragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.MyTenderXQBean;
import com.zll.wuye.lvshi.fragment.homepage.activity.Alot;
import com.zll.wuye.lvshi.fragment.homepage.activity.MyTender;
import com.zll.wuye.lvshi.fragment.homepage.activity.TenderXingQing;
import com.zll.wuye.lvshi.fragment.homepage.adapter.TuPianAdapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;

import static android.support.v7.widget.StaggeredGridLayoutManager.HORIZONTAL;

public class MyTenderXq extends AppCompatActivity {
    private ImageView fanhui;
    private ImageView mytenderxq_user_touxiang;
    private TextView mytenderxq_user_name;
    private TextView mytenderxq_user_time;
    private TextView mytenderxq_user_diqu;
    private TextView mytenderxq_user_leixing;
    private TextView mytenderxq_user_message;
    private RecyclerView mytenderxq_user_recycle;
    private TextView mytenderxq_user_baojia;
    private TextView mytenderxq_user_baozhengjin;
    private ImageView mytenderxq_lvshi_touxiang;
    private TextView mytenderxq_lvshi_name;
    private TextView mytenderxq_lvshi_photo;
    private TextView mytenderxq_lvshi_message;
    private TextView mytenderxq_lvshi_zhuangtai;
    private TextView mytenderxq_lvshi_price;
    private String id;
    private String token;
    private MyTenderXQBean.BodyBean body;
    private String[] split;
    private String p;
    private Button lianxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tender_xq);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        token = intent.getStringExtra("token");
        p = intent.getStringExtra("p");
        initView();
        initdata();
    }

    private void initdata() {
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mytenderxq_user_recycle.setLayoutManager(new StaggeredGridLayoutManager(1,
                HORIZONTAL));
        String url = "https://wuye.kylinlaw.com/case/lawyer/show?caseId="+id+"&token="+token;
        jiexi(url);
    }

    private void jiexi(String url) {

        HttpOkGo.okgoget(url, MyTenderXQBean.class, new HttpOkGo.okget<MyTenderXQBean>() {
            @Override
            public void shuju(ArrayList<MyTenderXQBean> list) {
                body = list.get(0).getBody();
                Glide.with(MyTenderXq.this)
                        .load(body.getUser().getHeadUrl())
                        .bitmapTransform(new RoundedCornersTransformation(MyTenderXq.this, 30, 0, RoundedCornersTransformation.CornerType.ALL))
                        .crossFade(1000)
                        .into(mytenderxq_user_touxiang);
                mytenderxq_user_name.setText(body.getUser().getName());
                mytenderxq_user_time.setText("发布时间:"+body.getCreatTm());
                mytenderxq_user_message.setText("发布内容:"+body.getCntn());
                mytenderxq_user_diqu.setText("地点:"+body.getAddress());
                mytenderxq_user_leixing.setText("案件类型:"+body.getTypeName());

                String urls = body.getFileUrls();
                split = urls.split("[,]");
                mytenderxq_user_recycle.setAdapter(new TuPianAdapter(split,MyTenderXq.this));
                mytenderxq_user_baojia.setText("委托报价:￥"+body.getOfferStrt()+"-"+body.getOfferEnd());
                mytenderxq_user_baozhengjin.setText("委托保证金:￥50");

                Glide.with(MyTenderXq.this)
                        .load(body.getCaseRec().getLawyer().getHeadUrl())
                        .bitmapTransform(new RoundedCornersTransformation(MyTenderXq.this, 30, 0, RoundedCornersTransformation.CornerType.ALL))
                        .crossFade(1000)
                        .into(mytenderxq_lvshi_touxiang);
                mytenderxq_lvshi_name.setText(body.getCaseRec().getLawyer().getName());
                mytenderxq_lvshi_photo.setText("律所:"+body.getCaseRec().getLawyer().getLawName());
                mytenderxq_lvshi_message.setText("竞争时的描述:"+body.getCaseRec().getCntn());
                mytenderxq_lvshi_price.setText("竞标价格:"+body.getCaseRec().getPrice());
                if(p.equals("1")){
                    mytenderxq_lvshi_zhuangtai.setText("竞标中");

                }else if(p.equals("2")){
                    mytenderxq_lvshi_zhuangtai.setText("您以成功中标");
                    lianxi.setVisibility(View.VISIBLE);
                }else if(p.equals("3")){
                    mytenderxq_lvshi_zhuangtai.setText("很遗憾您在本次竞标中失败");
                }

                lianxi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("zzz",body.getTel());
                        new Alot().dadianhua(MyTenderXq.this,body.getTel());
                    }
                });
            }
        });

    }

    private void initView() {
        fanhui = (ImageView) findViewById(R.id.mytenderxq_fanhui);
        mytenderxq_user_touxiang = (ImageView) findViewById(R.id.mytenderxq_user_touxiang);
        mytenderxq_user_name = (TextView) findViewById(R.id.mytenderxq_user_name);
        mytenderxq_user_time = (TextView) findViewById(R.id.mytenderxq_user_time);
        mytenderxq_user_diqu = (TextView) findViewById(R.id.mytenderxq_user_diqu);
        mytenderxq_user_leixing = (TextView) findViewById(R.id.mytenderxq_user_leixing);
        mytenderxq_user_message = (TextView) findViewById(R.id.mytenderxq_user_message);
        mytenderxq_user_recycle = (RecyclerView) findViewById(R.id.mytenderxq_user_recycle);
        mytenderxq_user_baojia = (TextView) findViewById(R.id.mytenderxq_user_baojia);
        mytenderxq_user_baozhengjin = (TextView) findViewById(R.id.mytenderxq_user_baozhengjin);
        mytenderxq_lvshi_touxiang = (ImageView) findViewById(R.id.mytenderxq_lvshi_touxiang);
        mytenderxq_lvshi_name = (TextView) findViewById(R.id.mytenderxq_lvshi_name);
        mytenderxq_lvshi_photo = (TextView) findViewById(R.id.mytenderxq_lvshi_photo);
        mytenderxq_lvshi_message = (TextView) findViewById(R.id.mytenderxq_lvshi_message);
        mytenderxq_lvshi_zhuangtai = (TextView) findViewById(R.id.mytenderxq_lvshi_zhuangtai);
        mytenderxq_lvshi_price = (TextView) findViewById(R.id.mytenderxq_lvshi_price);
        lianxi = (Button) findViewById(R.id.mytenderxq_lvshi_lianxi);
    }
}

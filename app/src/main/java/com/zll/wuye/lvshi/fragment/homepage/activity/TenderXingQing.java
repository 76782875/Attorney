package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.FanMang;
import com.zll.wuye.lvshi.bean.TenderXqBean;
import com.zll.wuye.lvshi.fragment.homepage.adapter.TuPianAdapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static android.support.v7.widget.StaggeredGridLayoutManager.HORIZONTAL;

public class TenderXingQing extends AutoLayoutActivity{

    private String id;
    private String token;
    private TenderXqBean.BodyBean body;
    private ImageView tender_xq_touxiang;
    private TextView tender_xq_name;
    private TextView tender_xq_time;
    private TextView tender_xq_message;
    private TextView tender_xq_diqu;
    private TextView tender_xq_leixing;
    private RecyclerView tender_xq_recycle;
    private TextView tender_xq_baojia;
    private TextView tender_xq_baozhengjin;
    private TextView tender_xq_jingbiaojia;
    private EditText tender_xq_fangan;
    private Button tender_xq_toubiao;
    private String[] split;
    private EditText shuru;
    private ImageView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_xing_qing);
        initView();
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        token = intent.getStringExtra("token");
        initdata();
    }

    private void initdata() {
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tender_xq_recycle.setLayoutManager(new StaggeredGridLayoutManager(1,
                HORIZONTAL));
        String url = "https://wuye.kylinlaw.com/case/show?caseId=" + id + "&token=" + token;
        xiangqing(url);

        tender_xq_toubiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String srjine = shuru.getText().toString().trim();
                String xqfangan = tender_xq_fangan.getText().toString().trim();
                if(srjine.length()<1){
                    Toast.makeText(TenderXingQing.this,"请输入金额",Toast.LENGTH_SHORT).show();
                }else if(xqfangan.length()<1){
                    Toast.makeText(TenderXingQing.this,"请输入方案",Toast.LENGTH_SHORT).show();
                }else{
                final AlertDialog alertDialog = new AlertDialog.Builder(TenderXingQing.this).create();
                alertDialog.setMessage(
                        "尊敬律师，如果您中标了，您不能提供 正常的服务，平台将会给予相对的惩罚,您是否要继续？");
                alertDialog.setButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String jine = shuru.getText().toString().trim();
                        String fangan = tender_xq_fangan.getText().toString().trim();
                        int id = body.getId();
                        String url = "https://wuye.kylinlaw.com/case/lawyer/sure/mark?token="+token;
                        HashMap<String,Object> map = new HashMap<String, Object>();
                        map.put("caseId",id);
                        map.put("price",jine);
                        map.put("cntn",fangan);
                        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
                            @Override
                            public void fanhui(String s) {

                                Gson gson = new Gson();
                                FanMang mang = gson.fromJson(s, FanMang.class);
                                if(mang.getStatus()==200){
                                    Toast.makeText(TenderXingQing.this,"提交成功",Toast.LENGTH_SHORT).show();
                                }
                                finish();
                            }
                        });
                        alertDialog.dismiss();
                    }
                });

                alertDialog.setButton2("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();

                }
            }
        });

    }

    private void xiangqing(String url) {
        HttpOkGo.okgoget(url, TenderXqBean.class, new HttpOkGo.okget<TenderXqBean>() {
            @Override
            public void shuju(ArrayList<TenderXqBean> list) {
                body = list.get(0).getBody();

                Glide.with(TenderXingQing.this)
                        .load(body.getUser().getHeadUrl())
                        .bitmapTransform(new RoundedCornersTransformation(TenderXingQing.this, 30, 0, RoundedCornersTransformation.CornerType.ALL))
                        .crossFade(1000)
                        .into(tender_xq_touxiang);
                tender_xq_name.setText(body.getUser().getName());
                tender_xq_time.setText("发布时间:"+body.getCreatTm());
                tender_xq_message.setText("发布内容:"+body.getCntn());
                tender_xq_diqu.setText(body.getAddress());
                tender_xq_leixing.setText("案例类型:"+body.getTypeName());
                tender_xq_baojia.setText("委托报价: ￥"+body.getOfferStrt()+"-"+body.getOfferEnd());
                tender_xq_baozhengjin.setText("委托保证金: ￥50");
                if(body.getFileUrls().length()>0){
                    String urls = body.getFileUrls();
                    split = urls.split("[,]");
                    tender_xq_recycle.setAdapter(new TuPianAdapter(split,TenderXingQing.this));
                }
            }
        });
    }

    private void initView() {
        tender_xq_touxiang = (ImageView) findViewById(R.id.tender_xq_touxiang);
        tender_xq_name = (TextView) findViewById(R.id.tender_xq_name);
        tender_xq_time = (TextView) findViewById(R.id.tender_xq_time);
        tender_xq_message = (TextView) findViewById(R.id.tender_xq_message);
        tender_xq_diqu = (TextView) findViewById(R.id.tender_xq_diqu);
        tender_xq_leixing = (TextView) findViewById(R.id.tender_xq_leixing);
        tender_xq_recycle = (RecyclerView) findViewById(R.id.tender_xq_recycle);
        tender_xq_baojia = (TextView) findViewById(R.id.tender_xq_baojia);
        tender_xq_baozhengjin = (TextView) findViewById(R.id.tender_xq_baozhengjin);
        tender_xq_jingbiaojia = (TextView) findViewById(R.id.tender_xq_jingbiaojia);
        tender_xq_fangan = (EditText) findViewById(R.id.tender_xq_fangan);
        tender_xq_toubiao = (Button) findViewById(R.id.tender_xq_toubiao);
        shuru = (EditText) findViewById(R.id.tender_xq_shuru);
        fanhui = (ImageView) findViewById(R.id.jingbiaoxiangqing_fanhui);
    }
}

package com.zll.wuye.lvshi.fragment.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.bean.TixianBean;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.HashMap;

public class TiXian extends AppCompatActivity{

    private ImageView tixian_fanhui;
    private EditText tixian_name;
    private EditText tixian_zhanghao;
    private EditText tixian_jine;
    private Button tixian_tijiao;
    private String token;
    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti_xian);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        price = intent.getStringExtra("price");
        initView();
        initdata();
    }

    private void initdata() {
        tixian_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tixian_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tixian_name.getText().toString().trim();
                String zhanghao = tixian_zhanghao.getText().toString().trim();
                String jine = tixian_jine.getText().toString().trim();
                if(name.equals("")&&name.length()<1){
                    Toast.makeText(TiXian.this,"名字不能为空",Toast.LENGTH_SHORT).show();
                }else if(zhanghao.equals("")&&zhanghao.length()<1){
                    Toast.makeText(TiXian.this,"支付宝账号不能为空",Toast.LENGTH_SHORT).show();
                }else if(jine.equals("")&&jine.length()<1){
                    Toast.makeText(TiXian.this,"提现金额不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    int p = Integer.parseInt(jine);
                    if(p>=100){
                        tixian(name,zhanghao,jine);
                    }else{
                        Toast.makeText(TiXian.this,"每次提现不能小于100",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void tixian(String name, String zhanghao, String jine) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("bank","alipay");
        map.put("cardNo",zhanghao);
        map.put("name",name);
        map.put("money",jine);
        String url = "https://wuye.kylinlaw.com/wthdr/save?token="+token;
        HttpOkGo.okgopost(url,map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                Gson gson = new Gson();
                TixianBean tixianBean = gson.fromJson(s, TixianBean.class);
                Toast.makeText(TiXian.this,tixianBean.getMessage()+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        tixian_fanhui = (ImageView) findViewById(R.id.tixian_fanhui);
        tixian_name = (EditText) findViewById(R.id.tixian_name);
        tixian_zhanghao = (EditText) findViewById(R.id.tixian_zhanghao);
        tixian_jine = (EditText) findViewById(R.id.tixian_jine);
        tixian_tijiao = (Button) findViewById(R.id.tixian_tijiao);
    }

}

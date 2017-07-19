package com.zll.wuye.lvshi.fragment.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.AutoLinearLayout;
import com.zll.wuye.lvshi.R;

public class MyAccount extends AppCompatActivity {

    private ImageView wode_zhanghu_fanhui;
    private TextView wode_zhanghu_yue;
    private AutoLinearLayout wode_zhanghu_tixian;
    private AutoLinearLayout wode_zhanghu_mima;
    private String token;
    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        price = intent.getStringExtra("price");
        initView();
        initdata();

    }

    private void initdata() {
        wode_zhanghu_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wode_zhanghu_yue.setText(price+"元");
        wode_zhanghu_tixian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAccount.this,TiXian.class);
                intent.putExtra("token",token);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        wode_zhanghu_fanhui = (ImageView) findViewById(R.id.wode_zhanghu_fanhui);
        wode_zhanghu_yue = (TextView) findViewById(R.id.wode_zhanghu_yue);
        wode_zhanghu_tixian = (AutoLinearLayout) findViewById(R.id.wode_zhanghu_tixian);
    }
}

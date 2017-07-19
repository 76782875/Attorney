package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.fragment.homepage.fragment.AlreadyTender;
import com.zll.wuye.lvshi.fragment.homepage.fragment.BebeingTender;
import com.zll.wuye.lvshi.fragment.homepage.fragment.NotTender;

public class MyTender extends AppCompatActivity implements View.OnClickListener {

    private String token;
    private ImageView mytender_fanhui;
    private RadioButton mytender_yijing;
    private RadioButton mytender_zhengzai;
    private RadioButton mytender_meiyou;
    private FrameLayout mytender_fragment;
    private RadioGroup rg;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tender);
        mFragmentManager = getSupportFragmentManager();
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initdata();

    }

    private void initdata() {
        mytender_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        AlreadyTender already = new AlreadyTender();
        mFragmentManager.beginTransaction().replace(R.id.mytender_fragment,already).commit();

        mytender_yijing.setTextColor(0xFF2DA2B2);

    }

    private void initView() {
        mytender_fanhui = (ImageView) findViewById(R.id.mytender_fanhui);
        rg = (RadioGroup) findViewById(R.id.mytender_rg);
        mytender_yijing = (RadioButton) findViewById(R.id.mytender_yijing);
        mytender_zhengzai = (RadioButton) findViewById(R.id.mytender_zhengzai);
        mytender_meiyou = (RadioButton) findViewById(R.id.mytender_meiyou);
        mytender_fragment = (FrameLayout) findViewById(R.id.mytender_fragment);

        mytender_yijing.setOnClickListener(this);
        mytender_zhengzai.setOnClickListener(this);
        mytender_meiyou.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mytender_yijing:
                AlreadyTender already = new AlreadyTender();
                mFragmentManager.beginTransaction().replace(R.id.mytender_fragment,already).commit();

                mytender_yijing.setTextColor(0xFF2DA2B2);
                mytender_zhengzai.setTextColor(Color.BLACK);
                mytender_meiyou.setTextColor(Color.BLACK);
                break;
            case R.id.mytender_zhengzai:
                BebeingTender bebeing = new BebeingTender();
                mFragmentManager.beginTransaction().replace(R.id.mytender_fragment,bebeing).commit();

                mytender_zhengzai.setTextColor(0xFF2DA2B2);
                mytender_yijing.setTextColor(Color.BLACK);
                mytender_meiyou.setTextColor(Color.BLACK);
                break;
            case R.id.mytender_meiyou:
                NotTender not = new NotTender();
                mFragmentManager.beginTransaction().replace(R.id.mytender_fragment,not).commit();

                mytender_meiyou.setTextColor(0xFF2DA2B2);
                mytender_zhengzai.setTextColor(Color.BLACK);
                mytender_yijing.setTextColor(Color.BLACK);
                break;
        }
    }
}

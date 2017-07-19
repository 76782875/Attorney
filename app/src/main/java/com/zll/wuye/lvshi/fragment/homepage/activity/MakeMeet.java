package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.fragment.homepage.fragment.MakeFragment;

public class MakeMeet extends AppCompatActivity implements View.OnClickListener {

    private String token;
    private ImageView make_fanhui;
    private RadioButton make_yimeet;
    private RadioButton make_weimeet;
    private RadioButton make_quanbu;
    private FrameLayout make_fragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_meet);
        mFragmentManager = getSupportFragmentManager();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initView();
        initdata();
    }

    private void initdata() {
        make_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        make_fanhui = (ImageView) findViewById(R.id.make_fanhui);
        make_yimeet = (RadioButton) findViewById(R.id.make_yimeet);
        make_weimeet = (RadioButton) findViewById(R.id.make_weimeet);
        make_quanbu = (RadioButton) findViewById(R.id.make_quanbu);
        make_fragment = (FrameLayout) findViewById(R.id.make_fragment);

        make_yimeet.setOnClickListener(this);
        make_weimeet.setOnClickListener(this);
        make_quanbu.setOnClickListener(this);

        MakeFragment make = new MakeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", "https://wuye.kylinlaw.com/order/lawyer/appt/list?token="+token+"&status=1");
        make.setArguments(bundle);
        mFragmentManager.beginTransaction().replace(R.id.make_fragment,make).commit();
        make_yimeet.setTextColor(0xFF2DA2B2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.make_yimeet:
                MakeFragment make = new MakeFragment();
                Bundle bundle = new Bundle();
                bundle.putString("url", "https://wuye.kylinlaw.com/order/lawyer/appt/list?token="+token+"&status=1");
                make.setArguments(bundle);
                mFragmentManager.beginTransaction().replace(R.id.make_fragment,make).commit();
                make_yimeet.setTextColor(0xFF2DA2B2);
                make_weimeet.setTextColor(Color.BLACK);
                make_quanbu.setTextColor(Color.BLACK);
                break;
            case R.id.make_weimeet:
                MakeFragment make1 = new MakeFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString("url", "https://wuye.kylinlaw.com/order/lawyer/appt/list?token="+token+"&status=0");
                make1.setArguments(bundle1);
                mFragmentManager.beginTransaction().replace(R.id.make_fragment,make1).commit();
                make_weimeet.setTextColor(0xFF2DA2B2);
                make_yimeet.setTextColor(Color.BLACK);
                make_quanbu.setTextColor(Color.BLACK);
                break;
            case R.id.make_quanbu:
                MakeFragment make2 = new MakeFragment();
                mFragmentManager.beginTransaction().replace(R.id.make_fragment,make2).commit();
                Bundle bundle2 = new Bundle();
                bundle2.putString("url", "https://wuye.kylinlaw.com/order/lawyer/appt/list?token="+token);
                make2.setArguments(bundle2);
                make_quanbu.setTextColor(0xFF2DA2B2);
                make_weimeet.setTextColor(Color.BLACK);
                make_yimeet.setTextColor(Color.BLACK);
                break;
        }
    }
}

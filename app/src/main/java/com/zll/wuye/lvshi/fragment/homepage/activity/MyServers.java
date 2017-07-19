package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.zhy.autolayout.AutoLinearLayout;
import com.zll.wuye.lvshi.R;

public class MyServers extends AppCompatActivity {

    private ImageView servers_fanhui;
    private AutoLinearLayout servers_dianhuazixun;
    private AutoLinearLayout servers_yuyuemiantan;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_servers);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initView();
        initdata();
    }

    private void initdata() {
        servers_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        servers_dianhuazixun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyServers.this,PhotoMeeth.class);
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });

        servers_yuyuemiantan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyServers.this,MakeMeet.class);
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        servers_fanhui = (ImageView) findViewById(R.id.servers_fanhui);
        servers_dianhuazixun = (AutoLinearLayout) findViewById(R.id.servers_dianhuazixun);
        servers_yuyuemiantan = (AutoLinearLayout) findViewById(R.id.servers_yuyuemiantan);
    }
}

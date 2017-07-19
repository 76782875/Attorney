package com.zll.wuye.lvshi.fragment.mypage.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.zll.wuye.lvshi.R;

public class OpinionActivity extends AppCompatActivity {

    private ImageView yijianfankui_zuo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);
        initView();

    }

    private void initView() {
        yijianfankui_zuo = (ImageView) findViewById(R.id.yijianfankui_zuo);
        yijianfankui_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

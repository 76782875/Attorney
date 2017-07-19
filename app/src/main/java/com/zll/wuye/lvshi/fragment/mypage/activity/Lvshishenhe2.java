package com.zll.wuye.lvshi.fragment.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;

public class Lvshishenhe2 extends AppCompatActivity {

    private ImageView lvshishenhe2_fanhui;
    private TextView lvshishenhe2_message;
    private Button lvshishenhe2_anniu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvshishenhe2);
        initView();
        Intent intent = getIntent();
        int state = Integer.parseInt(intent.getStringExtra("state"));
        if (state == 0) {
            lvshishenhe2_message.setText("提交审核");
        } else if (state == 1) {
            lvshishenhe2_message.setText("审核通过");
        }
    }

    private void initView() {
        lvshishenhe2_fanhui = (ImageView) findViewById(R.id.lvshishenhe2_fanhui);
        lvshishenhe2_message = (TextView) findViewById(R.id.lvshishenhe2_message);
        lvshishenhe2_anniu = (Button) findViewById(R.id.lvshishenhe2_anniu);
        lvshishenhe2_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lvshishenhe2_anniu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lvshishenhe2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}

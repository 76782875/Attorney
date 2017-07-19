package com.zll.wuye.lvshi.fragment.mypage.change;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.HashMap;

public class ChangeSex extends AppCompatActivity {

    private ImageView change_sex_fanhui;
    private TextView change_sex_qd;
    private ImageView xiugaixingbie_iv1;
    private ImageView xiugaixingbie_iv2;
    private String token;
    private int i=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_sex);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initView();
        initdata();

    }

    private void initdata() {
        change_sex_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        xiugaixingbie_iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xiugaixingbie_iv1.setImageResource(R.mipmap.xingbiexianzhong);
                xiugaixingbie_iv2.setImageResource(R.mipmap.xingbiewei);
                i=1;
            }
        });
        xiugaixingbie_iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xiugaixingbie_iv2.setImageResource(R.mipmap.xingbiexianzhong);
                xiugaixingbie_iv1.setImageResource(R.mipmap.xingbiewei);
                i=0;
            }
        });

        change_sex_qd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==2){
                    Toast.makeText(ChangeSex.this,"请选择性别",Toast.LENGTH_SHORT).show();
                }else if(i==0){
                    photomath(i);
                }else if(i==1){
                    photomath(i);
                }
            }
        });

    }

    private void photomath(int i) {
        String url = "https://wuye.kylinlaw.com/lawyer/update?token="+token;;
        HashMap<String,Object> map = new HashMap<>();
        map.put("sex",i);
        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                finish();
                Toast.makeText(ChangeSex.this,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        change_sex_fanhui = (ImageView) findViewById(R.id.change_sex_fanhui);
        change_sex_qd = (TextView) findViewById(R.id.change_sex_qd);
        xiugaixingbie_iv1 = (ImageView) findViewById(R.id.xiugaixingbie_iv1);
        xiugaixingbie_iv2 = (ImageView) findViewById(R.id.xiugaixingbie_iv2);
    }
}

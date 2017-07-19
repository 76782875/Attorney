package com.zll.wuye.lvshi.fragment.mypage.change;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.HashMap;

public class Changenian extends AppCompatActivity {

    private String token;
    private String name;
    private String name2;
    private String panduan;
    private ImageView change_nian_fanhui;
    private TextView change_nian_name;
    private TextView change_nian_qd;
    private EditText change_nian_et;
    private String trim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changenian);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        name = intent.getStringExtra("name");
        name2 = intent.getStringExtra("name2");
        panduan = intent.getStringExtra("panduan");
        initdata();
    }

    private void initdata() {
        change_nian_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        change_nian_name.setText(""+name);
        change_nian_et.setHint(""+name2);
        change_nian_qd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trim = change_nian_et.getText().toString().trim();
                if(panduan.equals("1")){
                    xiugai("period");
                }else if(panduan.equals("2")){
                    xiugai("lawName");
                }else if(panduan.equals("3")){
                    xiugai("lawyerNo");
                }
            }
        });
    }

    private void initView() {
        change_nian_fanhui = (ImageView) findViewById(R.id.change_nian_fanhui);
        change_nian_name = (TextView) findViewById(R.id.change_nian_name);
        change_nian_qd = (TextView) findViewById(R.id.change_nian_qd);
        change_nian_et = (EditText) findViewById(R.id.change_nian_et);
    }

    public void xiugai(String period){
        String url = "https://wuye.kylinlaw.com/lawyer/update?token="+token;;
        HashMap<String,Object> map = new HashMap<>();
        map.put(period,trim);
        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                finish();
                Toast.makeText(Changenian.this,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

}

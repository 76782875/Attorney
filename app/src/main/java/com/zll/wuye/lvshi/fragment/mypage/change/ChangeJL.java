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

public class ChangeJL extends AppCompatActivity {

    private ImageView change_jianli_fanhui;
    private TextView change_jianli_qd;
    private EditText wode_jianli_jianli;
    private String trim;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_jl);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        initView();
        initdata();
    }

    private void initdata() {
        change_jianli_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        change_jianli_qd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trim = wode_jianli_jianli.getText().toString().trim();
                xiugai();
            }
        });
    }

    public void xiugai(){
        String url = "https://wuye.kylinlaw.com/lawyer/update?token="+token;;
        HashMap<String,Object> map = new HashMap<>();
        map.put("cntn",trim);
        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                finish();
                Toast.makeText(ChangeJL.this,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        change_jianli_fanhui = (ImageView) findViewById(R.id.change_jianli_fanhui);
        change_jianli_qd = (TextView) findViewById(R.id.change_jianli_qd);
        wode_jianli_jianli = (EditText) findViewById(R.id.wode_jianli_jianli);
    }

}

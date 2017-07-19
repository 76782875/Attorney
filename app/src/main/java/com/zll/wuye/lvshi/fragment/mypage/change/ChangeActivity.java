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
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.fragment.homepage.activity.ChargeActivity;
import com.zll.wuye.lvshi.fragment.mypage.activity.PerSonMessage;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.HashMap;

public class ChangeActivity extends AppCompatActivity {

    private ImageView change_name_fanhui;
    private TextView change_name_qd;
    private EditText change_name_et;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        initView();

    }

    private void initdata() {
        change_name_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        change_name_qd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = change_name_et.getText().toString().trim();
                if(name.equals("")){
                    Toast.makeText(ChangeActivity.this,"请输入姓名",Toast.LENGTH_SHORT).show();
                }else{
                    String url = "https://wuye.kylinlaw.com/lawyer/update?token="+token;;
                    HashMap<String,Object> map = new HashMap<>();
                    map.put("name",name);
                    HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
                        @Override
                        public void fanhui(String s) {
                            finish();
                            Toast.makeText(ChangeActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private void initView() {
        change_name_fanhui = (ImageView) findViewById(R.id.change_name_fanhui);
        change_name_qd = (TextView) findViewById(R.id.change_name_qd);
        change_name_et = (EditText) findViewById(R.id.change_name_et);
        initdata();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }
}

package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.FanMang;
import com.zll.wuye.lvshi.bean.XiangqingBean;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.HashMap;

public class ConsultHuida extends AppCompatActivity{

    private ImageView consult_huida_fanhui;
    private ImageView consult_huida_touxiang;
    private TextView consult_huida_name;
    private TextView consult_huida_time;
    private TextView consult_huida_message;
    private EditText consult_huida_wenben;
    private Button consult_huida_tijiao;
    private String id;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_huida);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        token = intent.getStringExtra("token");
        initView();
        initdata();
    }

    private void initdata() {
            String url = "https://wuye.kylinlaw.com/ask/detail?askId="+id+"&token="+token;
            HttpOkGo.okgoget(url, XiangqingBean.class, new HttpOkGo.okget<XiangqingBean>() {
                @Override
                public void shuju(ArrayList<XiangqingBean> list) {
                    XiangqingBean.BodyBean body = list.get(0).getBody();

                    if(body!=null){
                        Glide.with(ConsultHuida.this).load(body.getHeadImg()).bitmapTransform(new RoundedCornersTransformation(ConsultHuida.this, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(consult_huida_touxiang);
                        consult_huida_name.setText("用户姓名:"+body.getUserName());
                        consult_huida_time.setText("发布时间:"+body.getQuestTm());
                        consult_huida_message.setText("问题内容:"+body.getQuest());
                    }

                }
            });

        consult_huida_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        consult_huida_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wenben = consult_huida_wenben.getText().toString().trim();
                if(wenben.equals("")){
                   Toast.makeText(ConsultHuida.this,"请输入回答内容",Toast.LENGTH_SHORT).show();
                }else{
                    consult_huida_tijiao.setEnabled(false);
                    post(wenben);
                }
            }
        });
    }

    public void post(String ans){
        String url = "https://wuye.kylinlaw.com/ask/reply?token="+token;
        HashMap<String,Object> map = new HashMap<>();
        map.put("askId",id);
        map.put("ans",ans);
        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                Gson gson = new Gson();
                FanMang mang = gson.fromJson(s, FanMang.class);
                if(mang.getStatus()==200){
                    Toast.makeText(ConsultHuida.this,"提交成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ConsultHuida.this,"请先完善个人信息，审核通过后可以开展相关业务",Toast.LENGTH_SHORT).show();
                }
                consult_huida_tijiao.setEnabled(true);
                finish();
            }
        });
    }

    private void initView() {
        consult_huida_fanhui = (ImageView) findViewById(R.id.consult_huida_fanhui);
        consult_huida_touxiang = (ImageView) findViewById(R.id.consult_huida_touxiang);
        consult_huida_name = (TextView) findViewById(R.id.consult_huida_name);
        consult_huida_time = (TextView) findViewById(R.id.consult_huida_time);
        consult_huida_message = (TextView) findViewById(R.id.consult_huida_message);
        consult_huida_wenben = (EditText) findViewById(R.id.consult_huida_wenben);
        consult_huida_tijiao = (Button) findViewById(R.id.consult_huida_tijiao);

    }

}

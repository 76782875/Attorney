package com.zll.wuye.lvshi.fragment.mypage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.fragment.mypage.regin.Register;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

public class MyShezhi extends AutoLayoutActivity{

    private static final String TAG = "Jpush";
    private ImageView shouye_wodeshezhi_zuo;
    private Button wode_shezhi_tuichu;
    private String token;
    private SharedPreferences sp;
    private LinearLayout yijianfankui;
    private LinearLayout guanyuwomen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shezhi);
        sp = getSharedPreferences("token", MODE_PRIVATE);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initView();
        initdata();
    }

    private void initdata() {
        shouye_wodeshezhi_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wode_shezhi_tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null || token.length()<1){
                    Intent intent = new Intent(MyShezhi.this, Register.class);
                    startActivity(intent);
                    finish();
                }else{
                    sp.edit().clear().commit();
                    Toast.makeText(MyShezhi.this,"退出成功",Toast.LENGTH_SHORT).show();
                    finish();

                    JPushInterface.setAliasAndTags(getApplicationContext(),
                            "", null, mAliasCallback);

                }
            }
        });

        yijianfankui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyShezhi.this,OpinionActivity.class);

                startActivity(intent);
            }
        });

        guanyuwomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyShezhi.this,RegardMy.class);

                startActivity(intent);
            }
        });
    }

    private void initView() {
        shouye_wodeshezhi_zuo = (ImageView) findViewById(R.id.shouye_wodeshezhi_zuo);
        wode_shezhi_tuichu = (Button) findViewById(R.id.wode_shezhi_tuichu);
        yijianfankui = (LinearLayout) findViewById(R.id.yijianfankui);
        guanyuwomen = (LinearLayout) findViewById(R.id.guanyuwomen);
    }

    private Handler mHandler1;
    private final TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs;
            switch (code) {
                case 0:
                    logs = "Set tag and alias success极光推送别名设置成功";
                    Log.i(TAG, logs);
                    break;
                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.极光推送别名设置失败，60秒后重试";
                    Log.i(TAG, logs);
                    break;
                default:
                    logs = "极光推送设置失败，Failed with errorCode = " + code;
                    Log.e(TAG, logs);
                    break;
            }
        }
    };
}

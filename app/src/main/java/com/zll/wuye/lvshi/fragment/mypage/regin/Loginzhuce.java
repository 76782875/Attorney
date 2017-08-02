package com.zll.wuye.lvshi.fragment.mypage.regin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.bean.Authcode;
import com.zll.wuye.lvshi.bean.RegisterBean;
import com.zll.wuye.lvshi.http.Datademand;


import org.json.JSONObject;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import okhttp3.Call;
import okhttp3.Response;

//注册
public class Loginzhuce extends AutoLayoutActivity implements Datademand.CallData<Authcode> {

    private static final String TAG = "Jpush";
    private ImageView mLigin;
    private Button mYanzhengma;
    private Button mZhucedengmu;
    private EditText mShoujihao;
    private EditText mYanzhengma1;
    private EditText mMima;
    private CountDownTimer timer;
    private String mCode;
    private String shoujihao;
    private String yanzhengma;
    private String mima;

    private SharedPreferences mSp;
    private String token;
    private TextView xieyi;
    private ImageView xieyiimage;
    private int p=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginzhuce);
        mSp = getSharedPreferences("token", MODE_PRIVATE);
        token = mSp.getString("token", "");
        initview();
        initdata();

    }

    private void initdata() {
        mLigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mYanzhengma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoujihao = mShoujihao.getText().toString().trim();
                if(shoujihao.equals("")){
                    Toast.makeText(Loginzhuce.this,"手机号不能为空", Toast.LENGTH_SHORT).show();
                }else if(!isPhoneNum(shoujihao)){
                    Toast.makeText(Loginzhuce.this,"手机号格式不正确", Toast.LENGTH_SHORT).show();
                }else{
                    mYanzhengma.setEnabled(false);
                    OkGo.get("https://wuye.kylinlaw.com/validate/code?tel="+shoujihao+"&type=reg")//
                            .tag(this)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {

                                }
                            });
                    timer = new CountDownTimer(60 * 1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            mYanzhengma.setText(millisUntilFinished/1000+"s");
                        }

                        @Override
                        public void onFinish() {
                            mYanzhengma.setText("请重新获取验证码");
                            mYanzhengma.setEnabled(true);
                        }
                    };

                    timer.start();// 开始计时
                    // // 取消
                }
            }
        });



        mZhucedengmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoujihao = mShoujihao.getText().toString().trim();
                yanzhengma = mYanzhengma1.getText().toString().trim();
                mima = mMima.getText().toString().trim();
                if(yanzhengma.equals("")){
                    Toast.makeText(Loginzhuce.this,"验证码不能为空", Toast.LENGTH_SHORT).show();
                }else if(mima.equals("")){
                    Toast.makeText(Loginzhuce.this,"密码不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    if(p==0){
                        okgo();
                    }else if(p==1){
                        Toast.makeText(Loginzhuce.this,"请阅读用户注册协议",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        xieyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Loginzhuce.this, Xieyi.class);

                startActivity(intent);
            }
        });

        xieyiimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p==0){
                    xieyiimage.setImageResource(R.mipmap.kongyuan);
                    p=1;
                }else if( p==1){
                    xieyiimage.setImageResource(R.mipmap.xuanzhongyuan);
                    p=0;
                }
            }
        });

    }
    public static boolean isPhoneNum(String phone_num) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(14[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phone_num);
        return m.matches();
    }

    private void initview() {
        mLigin = (ImageView) findViewById(R.id.ligin_zuo);
        mYanzhengma = (Button) findViewById(R.id.wode_zhuce_yanzhengma);
        mZhucedengmu = (Button) findViewById(R.id.wode_zhuce_dengluanniu);
        mShoujihao = (EditText) findViewById(R.id.wode_zhuce_shoujihao);
        mYanzhengma1 = (EditText) findViewById(R.id.wode_zhuce_yanzhengmaet);
        mMima = (EditText) findViewById(R.id.wode_zhuce_mima);
        xieyi = (TextView) findViewById(R.id.wode_zhuce_xieyi);
        xieyiimage = (ImageView) findViewById(R.id.wode_zhuce_xieyiqueding);
    }

    @Override
    public void call(Authcode authcode) {
        mCode = authcode.getBody().getCode();
    }

    public void okgo(){
        HashMap<String, Object> params = new HashMap<>();
        params.put("uname", shoujihao);
        params.put("pswd", mima);
        params.put("code", yanzhengma);
        params.put("type",1+"");
        params.put("source", "android");
        JSONObject jsonObject = new JSONObject(params);

        OkGo.post("https://wuye.kylinlaw.com/user/register?tokrn="+token)//
                .tag(this)//
                .upJson(jsonObject.toString())//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        Gson gson = new Gson();
                        RegisterBean register = gson.fromJson(s,RegisterBean.class);
                        int status = register.getStatus();
                        if(status==701){
                            Toast.makeText(Loginzhuce.this,"手机格式不正确", Toast.LENGTH_SHORT).show();
                        }else if(status==702){
                            Toast.makeText(Loginzhuce.this,"密码格式不正确", Toast.LENGTH_SHORT).show();
                        }else if(status==709){
                            Toast.makeText(Loginzhuce.this,"用户名已经存在", Toast.LENGTH_SHORT).show();
                        }else{
                            String token = register.getBody().getToken();
                            SharedPreferences.Editor edit = mSp.edit();
                            edit.putString("token",token).commit();
                            finish();
                            JPushInterface.setAliasAndTags(getApplicationContext(),
                                    shoujihao, null, mAliasCallback);
                        }
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                    }
                });
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

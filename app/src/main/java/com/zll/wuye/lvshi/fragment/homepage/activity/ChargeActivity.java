package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.bean.ChargeBean;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

public class ChargeActivity extends AppCompatActivity{

    private TextView shoufeishezhi_dianhua;
    private Button shoufeishezhi_dianhua_shezhi;
    private Button shoufeishezhi_dianhua_kaiqi;
    private TextView shoufeishezhi_yuyue;
    private Button shoufeishezhi_yuyue_shezhi;
    private Button shoufeishezhi_yuyue_kaiqi;
    private String token;
    private int dianhuanum=0;
    private int yuyuenum=0;
    private ImageView fanhui;
    private ChargeBean.BodyBean body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initView();
        initdata();
    }

    private void initdata() {
        String shoufeiurl = "https://wuye.kylinlaw.com/lawyer/bus/show?token="+token;
        HttpOkGo.okgoget(shoufeiurl, ChargeBean.class, new HttpOkGo.okget<ChargeBean>() {
            @Override
            public void shuju(ArrayList<ChargeBean> list) {
                body = list.get(0).getBody();
                shoufeishezhi_dianhua.setText(body.getAskPrice()+"元/次");
                shoufeishezhi_yuyue.setText(body.getMeetPrice()+"元/次");
                int isAsk = body.getIsAsk();
                if(isAsk==0){
                    shoufeishezhi_dianhua_kaiqi.setText("开启");
                    shoufeishezhi_dianhua.setText("已关闭");
                }else{
                    shoufeishezhi_dianhua_kaiqi.setText("关闭");
                }
                int isMeet = body.getIsMeet();
                if(isMeet==0){
                    shoufeishezhi_yuyue_kaiqi.setText("开启");
                    shoufeishezhi_yuyue.setText("已关闭");
                }else{
                    shoufeishezhi_yuyue_kaiqi.setText("关闭");
                }
            }
        });

        shoufeishezhi_dianhua_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(ChargeActivity.this).create();
                alertDialog.show();
                Window window = alertDialog.getWindow();
                window.setContentView(R.layout.dianhuashoufei_alert);
                final EditText text = (EditText) window.findViewById(R.id.shoufeishezhi_et);
                text.setFocusable(true);
                text.setFocusableInTouchMode(true);
                text.requestFocus();
                alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                Button queding = (Button) window.findViewById(R.id.shoufeishezhi_queding);
                Button quxiao = (Button) window.findViewById(R.id.shoufeishezhi_quxiao);
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String trim = text.getText().toString().trim();
                        if(trim.equals("")||trim.length()<1){
                            Toast.makeText(ChargeActivity.this,"请填写收费金额",Toast.LENGTH_SHORT).show();
                        }else{
                            dianhuanum=1;
                            String shoufeiurl = "https://wuye.kylinlaw.com/lawyer/ask?token="+token+"&isAsk="+dianhuanum+"&askPrice="+trim;
                            OkGo.get(shoufeiurl)
                                    .tag(this)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(String s, Call call, Response response) {
                                            alertDialog.dismiss();
                                            shoufeishezhi_dianhua_kaiqi.setText("关闭");
                                            shoufeishezhi_dianhua.setText(trim+"元/次");
                                            initdata();
                                        }

                                        @Override
                                        public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                                            super.upProgress(currentSize, totalSize, progress, networkSpeed);
                                        }
                                    });
                        }
                    }
                });
            }
        });

        shoufeishezhi_dianhua_kaiqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kaiqi = shoufeishezhi_dianhua_kaiqi.getText().toString().trim();
                if(kaiqi.equals("开启")){
                    dianhuanum=1;
                    shoufeishezhi_dianhua_kaiqi.setText("关闭");
                    shoufeishezhi_dianhua.setText(body.getAskPrice()+"元/次");
                    String shoufeiurl = "https://wuye.kylinlaw.com/lawyer/ask?token="+token+"&isAsk="+dianhuanum+"&askPrice="+body.getAskPrice();
                    OkGo.get(shoufeiurl)
                            .tag(this)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                }

                                @Override
                                public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                                    super.upProgress(currentSize, totalSize, progress, networkSpeed);
                                }
                            });

                }else if(kaiqi.equals("关闭")){
                    dianhuanum=0;
                    shoufeishezhi_dianhua_kaiqi.setText("开启");
                    shoufeishezhi_dianhua.setText("已关闭");
                    String shoufeiurl = "https://wuye.kylinlaw.com/lawyer/ask?token="+token+"&isAsk="+dianhuanum+"&askPrice="+body.getAskPrice();
                    OkGo.get(shoufeiurl)
                            .tag(this)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                }

                                @Override
                                public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                                    super.upProgress(currentSize, totalSize, progress, networkSpeed);
                                }
                            });

                }
            }
        });
        shoufeishezhi_yuyue_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(ChargeActivity.this).create();
                alertDialog.show();
                Window window = alertDialog.getWindow();
                window.setContentView(R.layout.yuyueshoufei_alert);
                final EditText text2 = (EditText) window.findViewById(R.id.yuyueshoufei_et);
                text2.setFocusable(true);
                text2.setFocusableInTouchMode(true);
                text2.requestFocus();
                alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                Button queding = (Button) window.findViewById(R.id.yuyueshoufei_queding);
                Button quxiao = (Button) window.findViewById(R.id.yuyueshoufei_quxiao);
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final String trim = text2.getText().toString().trim();
                        if(trim.equals("")||trim.length()<1){
                            Toast.makeText(ChargeActivity.this,"请填写收费金额",Toast.LENGTH_SHORT).show();
                        }else{
                            yuyuenum=1;
                            String shoufeiurl = "https://wuye.kylinlaw.com/lawyer/meet?token="+token+"&isMeet="+yuyuenum+"&meetPrice="+trim;
                            OkGo.get(shoufeiurl)
                                    .tag(this)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(String s, Call call, Response response) {
                                            alertDialog.dismiss();
                                            shoufeishezhi_yuyue_kaiqi.setText("关闭");
                                            shoufeishezhi_yuyue.setText(trim+"元/次");
                                            initdata();
                                        }

                                        @Override
                                        public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                                            super.upProgress(currentSize, totalSize, progress, networkSpeed);
                                        }
                                    });
                        }
                    }
                });

            }
        });


        shoufeishezhi_yuyue_kaiqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kaiqi = shoufeishezhi_yuyue_kaiqi.getText().toString().trim();
                if(kaiqi.equals("开启")){
                    yuyuenum=1;
                    shoufeishezhi_yuyue_kaiqi.setText("关闭");
                    shoufeishezhi_yuyue.setText(body.getMeetPrice()+"元/次");
                    String shoufeiurl = "https://wuye.kylinlaw.com/lawyer/meet?token="+token+"&isMeet="+yuyuenum+"&meetPrice="+body.getMeetPrice();
                    OkGo.get(shoufeiurl)
                            .tag(this)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                }

                                @Override
                                public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                                    super.upProgress(currentSize, totalSize, progress, networkSpeed);
                                }
                            });

                }else if(kaiqi.equals("关闭")){
                    yuyuenum=0;
                    shoufeishezhi_yuyue_kaiqi.setText("开启");
                    shoufeishezhi_yuyue.setText("已关闭");
                    String shoufeiurl = "https://wuye.kylinlaw.com/lawyer/meet?token="+token+"&isMeet="+yuyuenum+"&meetPrice="+body.getMeetPrice();
                    OkGo.get(shoufeiurl)
                            .tag(this)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                }

                                @Override
                                public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                                    super.upProgress(currentSize, totalSize, progress, networkSpeed);
                                }
                            });

                }
            }
        });

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initView() {
        shoufeishezhi_dianhua = (TextView) findViewById(R.id.shoufeishezhi_dianhua);
        shoufeishezhi_dianhua_shezhi = (Button) findViewById(R.id.shoufeishezhi_dianhua_shezhi);
        shoufeishezhi_dianhua_kaiqi = (Button) findViewById(R.id.shoufeishezhi_dianhua_kaiqi);
        shoufeishezhi_yuyue = (TextView) findViewById(R.id.shoufeishezhi_yuyue);
        shoufeishezhi_yuyue_shezhi = (Button) findViewById(R.id.shoufeishezhi_yuyue_shezhi);
        shoufeishezhi_yuyue_kaiqi = (Button) findViewById(R.id.shoufeishezhi_yuyue_kaiqi);
        fanhui = (ImageView) findViewById(R.id.shoufeishezhi_fanhui);
    }

}

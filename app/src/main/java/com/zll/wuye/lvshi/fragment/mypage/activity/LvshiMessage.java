package com.zll.wuye.lvshi.fragment.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhy.autolayout.AutoLinearLayout;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.application.CropCircleTransformation;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.PersonMesageBean;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;

public class LvshiMessage extends AppCompatActivity {

    private ImageView shouye_lvshixinxi_zuo;
    private ImageView lvshixinxi_touxiang;
    private TextView lvshixinxi_name;
    private TextView lvshixinxi_techang;
    private RadioGroup lvshixinxi_rg;
    private TextView lvshixinxi_zhiyezheng;
    private TextView lvshixinxi_zhiyelvsuo;
    private TextView lvshixinxi_gongzuonianxian;
    private TextView lvshixinxi_suozaidi;
    private TextView lvshixinxi_ziwojieshao;
    private TextView lvshixinxi_dianhua;
    private AutoLinearLayout lvshixinxi_dianhuall;
    private TextView lvshixinxi_yuyue;
    private AutoLinearLayout lvshixinxi_yuyuell;
    private TextView lvshixinxi_zhifu;
    private AutoLinearLayout lvshixinxi_zhifull;
    private String token;
    private RadioButton guanzhu;
    private RadioButton fuwu;
    private RadioButton dongtai;
    private RadioButton zan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvshi_message);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initView();
        initdata();
    }

    private void initdata() {
        shouye_lvshixinxi_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        shouye_lvshixinxi_zuo = (ImageView) findViewById(R.id.shouye_lvshixinxi_zuo);
        lvshixinxi_touxiang = (ImageView) findViewById(R.id.lvshixinxi_touxiang);
        lvshixinxi_name = (TextView) findViewById(R.id.lvshixinxi_name);
        lvshixinxi_techang = (TextView) findViewById(R.id.lvshixinxi_techang);
        lvshixinxi_rg = (RadioGroup) findViewById(R.id.lvshixinxi_rg);
        lvshixinxi_zhiyezheng = (TextView) findViewById(R.id.lvshixinxi_zhiyezheng);
        lvshixinxi_zhiyelvsuo = (TextView) findViewById(R.id.lvshixinxi_zhiyelvsuo);
        lvshixinxi_gongzuonianxian = (TextView) findViewById(R.id.lvshixinxi_gongzuonianxian);
        lvshixinxi_suozaidi = (TextView) findViewById(R.id.lvshixinxi_suozaidi);
        lvshixinxi_ziwojieshao = (TextView) findViewById(R.id.lvshixinxi_ziwojieshao);
        lvshixinxi_dianhua = (TextView) findViewById(R.id.lvshixinxi_dianhua);
        lvshixinxi_dianhuall = (AutoLinearLayout) findViewById(R.id.lvshixinxi_dianhuall);
        lvshixinxi_yuyue = (TextView) findViewById(R.id.lvshixinxi_yuyue);
        lvshixinxi_yuyuell = (AutoLinearLayout) findViewById(R.id.lvshixinxi_yuyuell);
        guanzhu = (RadioButton) findViewById(R.id.lvshixinxi_guanzhu);
        fuwu = (RadioButton) findViewById(R.id.lvshixinxi_fuwu);
        dongtai = (RadioButton) findViewById(R.id.lvshixinxi_dongtai);
        zan = (RadioButton) findViewById(R.id.lvshixinxi_zan);
        jiexi();
    }

    private void jiexi() {
        String url2 = "https://wuye.kylinlaw.com/lawyer/info?token="+token;
        HttpOkGo.okgoget(url2, PersonMesageBean.class, new HttpOkGo.okget<PersonMesageBean>() {
            @Override
            public void shuju(ArrayList<PersonMesageBean> list) {
                if(!list.get(0).getMessage().equals("用户尚未登录，请重新登录后在操作")){
                    PersonMesageBean.BodyBean body = list.get(0).getBody();
                    if(body!=null){
                        Glide.with(LvshiMessage.this).load(body.getLawyer().getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(LvshiMessage.this, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(lvshixinxi_touxiang);

                    }
                    guanzhu.setText("关注("+list.get(0).getBody().getLawyerBus().getCareCnt()+")");
                    int mmmm = list.get(0).getBody().getLawyerBus().getAskCnt() + list.get(0).getBody().getLawyerBus().getMeetCnt() + list.get(0).getBody().getLawyerBus().getCaseCnt();
                    fuwu.setText("服务("+mmmm+")");
                    dongtai.setText("动态("+list.get(0).getBody().getLawyerBus().getCommtCnt()+")");
                    zan.setText("赞("+list.get(0).getBody().getLawyerBus().getLikeCnt()+")");
                    lvshixinxi_name.setText(body.getLawyer().getName());
                    lvshixinxi_techang.setText(body.getLawyer().getTypeName());
                    lvshixinxi_zhiyelvsuo.setText(body.getLawyer().getLawName());
                    lvshixinxi_gongzuonianxian.setText(body.getLawyer().getPeriod()+"");
                    lvshixinxi_suozaidi.setText(body.getLawyer().getAddress());
                    lvshixinxi_ziwojieshao.setText(body.getLawyer().getCntn());
                    lvshixinxi_zhiyezheng.setText(body.getLawyer().getLawyerNo());
                    lvshixinxi_dianhua.setText("电话咨询:"+body.getLawyerBus().getAskPrice()+"元");
                    lvshixinxi_yuyue.setText("预约见面:"+body.getLawyerBus().getMeetPrice()+"元");
                }else{
                    Toast.makeText(LvshiMessage.this,"请重新登录",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}

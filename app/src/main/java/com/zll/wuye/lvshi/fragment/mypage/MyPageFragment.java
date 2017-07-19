package com.zll.wuye.lvshi.fragment.mypage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.base.BaseFragment;
import com.zll.wuye.lvshi.bean.PersonMesageBean;
import com.zll.wuye.lvshi.bean.PersonMessageBean;
import com.zll.wuye.lvshi.fragment.homepage.activity.DetailActivity;
import com.zll.wuye.lvshi.fragment.mypage.activity.LvShishenhe;
import com.zll.wuye.lvshi.fragment.mypage.activity.LvshiMessage;
import com.zll.wuye.lvshi.fragment.mypage.activity.Lvshishenhe2;
import com.zll.wuye.lvshi.fragment.mypage.activity.MyAccount;
import com.zll.wuye.lvshi.fragment.mypage.activity.MyPingJia;
import com.zll.wuye.lvshi.fragment.mypage.activity.MyShezhi;
import com.zll.wuye.lvshi.fragment.mypage.activity.PerSonMessage;
import com.zll.wuye.lvshi.fragment.mypage.regin.Register;
import com.zll.wuye.lvshi.http.HttpOkGo;
import com.zll.wuye.lvshi.http.Panduan;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/23 14:44
 */
public class MyPageFragment extends BaseFragment {

    private View mView;
    private LinearLayout mLinearLayout;
    private SharedPreferences mSp;
    private String token;
    private ImageView touxiang;
    private TextView name;
    private TextView dizhi;
    private TextView lvsuo;
    private TextView yue;
    private LinearLayout shezhi;
    private ImageView zhanghu;
    private PersonMessageBean.BodyBean body;
    private ImageView gongshouyi;
    private LinearLayout zhuye;
    private LinearLayout guanzhu;
    private boolean b;

    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.mypagefragment, null);
        return mView;
    }

    @Override
    public void initdata() {
        b = Panduan.isNetworkConnected(getActivity());
        if(!b){
            Toast.makeText(getActivity(),"暂无网络",Toast.LENGTH_SHORT).show();
        }
        mSp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        token = mSp.getString("token", "");
        initView();
        if(token!=null||token.length()>1){
            if(b){
                geren();
            }
        }
        LinearLayout denglu_xinxi = (LinearLayout) mView.findViewById(R.id.wode_denglu_xinxi);
        denglu_xinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b){
                    if(token.equals("")||token.length()<1){
                        Intent intent = new Intent(getActivity(), Register.class);
                        startActivity(intent);
                    }else {
                        if (body.getStatus() == -1 || body.getStatus() == 2) {
                            Intent intent = new Intent(getActivity(), LvShishenhe.class);
                            intent.putExtra("token", token);
                            startActivity(intent);
                        } else{
                            Intent intent = new Intent(getActivity(), PerSonMessage.class);
                            intent.putExtra("token", token);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
        ImageView lvshishenhe = (ImageView) mView.findViewById(R.id.wode_lvshishenhe);
        lvshishenhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token.equals("")||token.length()<1){
                    if(b){
                        Intent intent = new Intent(getActivity(), Register.class);
                        Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }else{
                    if(b){
                        if(body.getStatus()==-1||body.getStatus()==2){
                            Intent intent = new Intent(getActivity(), LvShishenhe.class);
                            intent.putExtra("token",token);
                            startActivity(intent);
                        }else if(body.getStatus()==0||body.getStatus()==1){
                            Intent intent = new Intent(getActivity(), Lvshishenhe2.class);
                            intent.putExtra("state",body.getStatus()+"");
                            startActivity(intent);
                        }
                    }
                }
            }
        });
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyShezhi.class);
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });

        zhanghu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b){
                    if(token.equals("")||token.length()<1){
                        Intent intent = new Intent(getActivity(), Register.class);
                        Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getActivity(), MyAccount.class);
                        intent.putExtra("token",token);
                        intent.putExtra("price",body.getAmount()+"");
                        startActivity(intent);
                    }
                }
            }
        });

        gongshouyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b){
                    if(token.equals("")||token.length()<1){
                        Intent intent = new Intent(getActivity(), Register.class);
                        Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getActivity(), DetailActivity.class);
                        intent.putExtra("token",token);
                        intent.putExtra("price",body.getAmount()+"");
                        startActivity(intent);
                    }
                }
            }
        });

        zhuye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b){
                    if(token.equals("")||token.length()<1){
                        Intent intent = new Intent(getActivity(), Register.class);
                        Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getActivity(), LvshiMessage.class);
                        intent.putExtra("token",token);
                        startActivity(intent);
                    }
                }

            }
        });
        guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b){
                    if(token.equals("")||token.length()<1){
                        Intent intent = new Intent(getActivity(), Register.class);
                        Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getActivity(), MyPingJia.class);
                        intent.putExtra("token",token);
                        startActivity(intent);
                    }
                }

            }
        });

    }

    private void initView() {
        touxiang = (ImageView) mView.findViewById(R.id.wode_touxiang);
        name = (TextView) mView.findViewById(R.id.wode_name);
        dizhi = (TextView) mView.findViewById(R.id.wode_dizhi);
        lvsuo = (TextView) mView.findViewById(R.id.wode_lvsuo);
        yue = (TextView) mView.findViewById(R.id.wode_yue);
        shezhi = (LinearLayout) mView.findViewById(R.id.wode_shezhi);
        zhanghu = (ImageView) mView.findViewById(R.id.wode_zhanghu);
        gongshouyi = (ImageView) mView.findViewById(R.id.wode_gongshouyi);
        zhuye = (LinearLayout) mView.findViewById(R.id.wode_zhuye);
        guanzhu = (LinearLayout) mView.findViewById(R.id.wode_guanzhu);
    }

    public void geren(){

        String url = "https://wuye.kylinlaw.com/lawyer/acct?token="+token;
        HttpOkGo.okgoget(url, PersonMessageBean.class, new HttpOkGo.okget<PersonMessageBean>() {
            @Override
            public void shuju(ArrayList<PersonMessageBean> list) {
                if(!list.get(0).getMessage().equals("用户尚未登录，请重新登录后在操作")){
                    body = list.get(0).getBody();
                    if(body.getHeadUrl()!=null&&body.getHeadUrl().length()>1){
                        Glide.with(getActivity()).load(body.getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(getActivity(), 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(touxiang);
                    }
                    if((body.getName()+"").equals("null")){
                        name.setText("名字 ");
                    }else{
                        name.setText(""+ body.getName()+"");
                    }
                    if((body.getLawName()+"").equals("null")){
                        lvsuo.setText("律所 ");
                    }else{
                        lvsuo.setText(""+ body.getLawName()+"");
                    }

                    yue.setText("当前余额:"+ body.getAmount()+"元");
                }
            }
        });
        String url2 = "https://wuye.kylinlaw.com/lawyer/info?token="+token;
        HttpOkGo.okgoget(url2, PersonMesageBean.class, new HttpOkGo.okget<PersonMesageBean>() {
            @Override
            public void shuju(ArrayList<PersonMesageBean> list) {
                if(!list.get(0).getMessage().equals("用户尚未登录，请重新登录后在操作")){
                    PersonMesageBean.BodyBean body2 = list.get(0).getBody();
                    dizhi.setText(""+body2.getLawyer().getAddress());
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        initdata();
    }
}

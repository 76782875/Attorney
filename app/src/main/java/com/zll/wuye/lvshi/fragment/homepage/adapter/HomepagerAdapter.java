package com.zll.wuye.lvshi.fragment.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.PersonMessageBean;
import com.zll.wuye.lvshi.fragment.homepage.activity.ChargeActivity;
import com.zll.wuye.lvshi.fragment.homepage.activity.ConsultActivity;
import com.zll.wuye.lvshi.fragment.homepage.activity.DetailActivity;
import com.zll.wuye.lvshi.fragment.homepage.activity.MyAnswer;
import com.zll.wuye.lvshi.fragment.homepage.activity.MyServers;
import com.zll.wuye.lvshi.fragment.homepage.activity.MyTender;
import com.zll.wuye.lvshi.fragment.homepage.activity.TeacherActivity;
import com.zll.wuye.lvshi.fragment.homepage.activity.TenderActivity;
import com.zll.wuye.lvshi.fragment.homepage.viewholder.ChargeViewHolder;
import com.zll.wuye.lvshi.fragment.homepage.viewholder.HomePageViewHolder;
import com.zll.wuye.lvshi.fragment.mypage.activity.TiXian;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;


/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/23 15:49
 */
public class HomepagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE0 = 0;
    private static final int ITEM_TYPE1 = 1;
    private static final int ITEM_TYPE2 = 2;
    private final Context context;
    private int type;
    private SharedPreferences mSp;
    private String token;
    private PersonMessageBean.BodyBean body;

    public HomepagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.home_banner, parent, false);
                viewHolder = new HomePageViewHolder(view);
                break;
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.home_charge, parent, false);
                viewHolder = new ChargeViewHolder(view1);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mSp = context.getSharedPreferences("token", Context.MODE_PRIVATE);
        token = mSp.getString("token", "");
        switch (position){
            case 0:
                HomePageViewHolder homePageViewHolder = (HomePageViewHolder) holder;
//                homePageViewHolder.setdata(context);
                break;
            case 1:
                final ChargeViewHolder chargeViewHolder = (ChargeViewHolder) holder;

                if(token!=null&&token.length()>=1){
                    String url = "https://wuye.kylinlaw.com/lawyer/acct?token="+token;
                    HttpOkGo.okgoget(url, PersonMessageBean.class, new HttpOkGo.okget<PersonMessageBean>() {
                        @Override
                        public void shuju(ArrayList<PersonMessageBean> list) {
                            if(!list.get(0).getMessage().equals("用户尚未登录，请重新登录后在操作")){
                                body = list.get(0).getBody();
                                chargeViewHolder.shouyi.setText(""+ body.getIncome()+"元");
                            }else{
                                Toast.makeText(context,"请重新登录",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }

                chargeViewHolder.shoufeishezhi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (token.equals("")|| token.length()<1){
                            Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(context, ChargeActivity.class);
                            intent.putExtra("token", token);
                            context.startActivity(intent);
                        }
                    }
                });

                chargeViewHolder.chakanmingxi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (token.equals("")|| token.length()<1){
                            Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(context, DetailActivity.class);
                            intent.putExtra("token", token);
                            context.startActivity(intent);
                        }
                    }
                });

                chargeViewHolder.zixunpingtai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (token.equals("")|| token.length()<1){
                            Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(context, ConsultActivity.class);
                            intent.putExtra("token", token);
                            context.startActivity(intent);
                        }
                    }
                });

                chargeViewHolder.jingbiaopingtai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (token.equals("")|| token.length()<1){
                            Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(context, TenderActivity.class);
                            intent.putExtra("token", token);
                            context.startActivity(intent);
                        }
                    }
                });

                chargeViewHolder.wodejingbiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (token.equals("")|| token.length()<1){
                            Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(context, MyTender.class);
                            intent.putExtra("token", token);
                            context.startActivity(intent);
                        }
                    }
                });

                chargeViewHolder.huida.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (token.equals("")|| token.length()<1){
                            Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(context, MyAnswer.class);
                            intent.putExtra("token", token);
                            context.startActivity(intent);
                        }
                    }
                });

                chargeViewHolder.wodefuwu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (token.equals("")|| token.length()<1){
                            Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(context, MyServers.class);
                            intent.putExtra("token", token);
                            context.startActivity(intent);
                        }
                    }
                });

                chargeViewHolder.tixian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (token.equals("")|| token.length()<1){
                            Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(context, TiXian.class);
                            intent.putExtra("token", token);
                            intent.putExtra("price", body.getAmount()+"");
                            context.startActivity(intent);
                        }
                    }
                });

                chargeViewHolder.jiangshishenqing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (token.equals("")|| token.length()<1){
                            Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(context, TeacherActivity.class);
                            intent.putExtra("token", token);
                            intent.putExtra("name", body.getName()+"");
                            context.startActivity(intent);
                        }
                    }
                });

                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                type = ITEM_TYPE0;
                break;
            case 1:
                type = ITEM_TYPE1;
                break;

        }
        return type;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

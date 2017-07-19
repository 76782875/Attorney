package com.zll.wuye.lvshi.fragment.homepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.HuiFuBean;
import com.zll.wuye.lvshi.fragment.homepage.activity.ConsultXiangQing;
import com.zll.wuye.lvshi.fragment.homepage.viewholder.HuiFuViewHolder;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/16 10:58
 */
public class HuiFuAdapter extends RecyclerView.Adapter<HuiFuViewHolder> {
    private final ArrayList<HuiFuBean.BodyBean> list;
    private final Context context;

    public HuiFuAdapter(ArrayList<HuiFuBean.BodyBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public HuiFuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.huifu_lvshi, null);
        HuiFuViewHolder holder = new HuiFuViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(HuiFuViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getHeadImg()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.touxiang);
        holder.name.setText("律师姓名:"+list.get(position).getUserName());
        holder.time.setText("发布时间:"+list.get(position).getAnsTm());
        holder.message.setText("回答内容:"+list.get(position).getAns());
        int adopt = list.get(position).getIsAdopt();
        if(adopt==1){
            holder.caina.setVisibility(View.VISIBLE);
        }else{
            holder.caina.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

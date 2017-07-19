package com.zll.wuye.lvshi.fragment.mypage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.Pingjia;
import com.zll.wuye.lvshi.fragment.mypage.activity.MyPingJia;
import com.zll.wuye.lvshi.fragment.mypage.viewholder.PingjiaViewHolder;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/26 16:33
 */
public class PingjiaAdapter extends RecyclerView.Adapter<PingjiaViewHolder> {
    private final Context context;
    private final ArrayList<Pingjia.BodyBean> list;

    public PingjiaAdapter(Context context, ArrayList<Pingjia.BodyBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public PingjiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.moreevaluate_recycle, null);
        PingjiaViewHolder holder = new PingjiaViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PingjiaViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getHeadUrl())
                .bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL))
                .crossFade(1000)
                .into(holder.touxiang);
        holder.name.setText("用户姓名:"+list.get(position).getName());
        holder.message.setText("内容:"+list.get(position).getCntn());
        int score = list.get(position).getScore();
        if(score==0){
            holder.manyi.setText("不满意");
        }else if(score==1){
            holder.manyi.setText("一般");
        }else if(score==2){
            holder.manyi.setText("满意");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

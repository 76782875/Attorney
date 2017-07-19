package com.zll.wuye.lvshi.fragment.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.TenderBean;
import com.zll.wuye.lvshi.fragment.homepage.activity.TenderActivity;
import com.zll.wuye.lvshi.fragment.homepage.activity.TenderXingQing;
import com.zll.wuye.lvshi.fragment.homepage.viewholder.TeanderViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/16 14:13
 */
public class TenderAdapter extends RecyclerView.Adapter<TeanderViewHolder> {

    private final ArrayList<TenderBean.BodyBean> list;
    private final Context context;
    private final String token;

    public TenderAdapter(ArrayList<TenderBean.BodyBean> list, Context context, String token) {
        this.list = list;
        this.context = context;
        this.token = token;
    }

    @Override
    public TeanderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tender_recycle, null);
        TeanderViewHolder holder = new TeanderViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(TeanderViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getUser().getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.touxiang);
        String time = getStrTime(list.get(position).getCreatTm() + "");
        holder.name.setText(""+list.get(position).getUser().getName());
        holder.time.setText("发布时间:"+time);
        final int status = list.get(position).getStatus();
        if(status==1){
            if(list.get(position).getIsMark()==0){
                holder.toubiao.setText("投标");
            }else{
                holder.toubiao.setText("已投标");
            }

        }else{
            holder.toubiao.setText("已成交");
        }
        holder.didian.setText(list.get(position).getAddress());
        holder.message.setText("问题内容:"+list.get(position).getCntn());
        holder.baojia.setText("报价:"+list.get(position).getOfferStrt()+"-"+list.get(position).getOfferEnd()+"元");
        holder.leixing.setText("案例类型:"+list.get(position).getTypeName());
        holder.jige.setText("已有"+list.get(position).getMarkCnt()+"投标");
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(status==1&&list.get(position).getIsMark()==0){
                    Intent intent = new Intent(context, TenderXingQing.class);
                    intent.putExtra("id",list.get(position).getId()+"");
                    intent.putExtra("token",token);
                    context.startActivity(intent);
                }else if (status==1&&list.get(position).getIsMark()!=0){
                    Toast.makeText(context,"您已完成投标",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"投标结束",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //时间戳转时间
    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}

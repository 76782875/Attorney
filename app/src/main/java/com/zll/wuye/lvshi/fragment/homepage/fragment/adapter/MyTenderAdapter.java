package com.zll.wuye.lvshi.fragment.homepage.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.MyTenderBean;
import com.zll.wuye.lvshi.fragment.homepage.fragment.activity.MyTenderXq;
import com.zll.wuye.lvshi.fragment.homepage.fragment.viewholder.MyTenderViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/19 13:26
 */
public class MyTenderAdapter extends RecyclerView.Adapter<MyTenderViewHolder> {

    private final ArrayList<MyTenderBean.BodyBean> list;
    private final Context context;
    private final String token;
    private final int p;

    public MyTenderAdapter(ArrayList<MyTenderBean.BodyBean> mlist, Context context, String token, int p) {
        this.list = mlist;
        this.context = context;
        this.token = token;
        this.p = p;
    }

    @Override
    public MyTenderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tender_recycle, null);
        MyTenderViewHolder holder = new MyTenderViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyTenderViewHolder holder, final int position) {
        Glide.with(context)
                .load(list.get(position).getUser().getHeadUrl())
                .bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL))
                .crossFade(1000)
                .into(holder.touxiang);
        holder.name.setText(""+list.get(position).getUser().getName());
        String time = getStrTime(list.get(position).getCreatTm() + "");
        holder.time.setText("发布时间:"+time);
        if(p==1){
            holder.toubiao.setText("已有"+list.get(position).getMarkCnt()+"人投标");
        }else if(p==2){
            holder.toubiao.setText("已中标");
        }else if(p==3){
            holder.toubiao.setText("未中标");
        }
        holder.message.setText("问题内容:"+list.get(position).getCntn());
        holder.didian.setText(""+list.get(position).getAddress());
        holder.baojia.setText("报价:"+list.get(position).getOfferStrt()+"-"+list.get(position).getOfferEnd());
        holder.leixing.setText("案件类型:"+list.get(position).getTypeName());
        holder.jige.setText("");

        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(context, MyTenderXq.class);
                    intent.putExtra("id",list.get(position).getId()+"");
                    intent.putExtra("token",token);
                    intent.putExtra("p",p+"");
                    context.startActivity(intent);

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

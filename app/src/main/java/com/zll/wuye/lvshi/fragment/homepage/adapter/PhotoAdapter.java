package com.zll.wuye.lvshi.fragment.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.PhotoBean;
import com.zll.wuye.lvshi.fragment.homepage.activity.Alot;
import com.zll.wuye.lvshi.fragment.homepage.activity.PhotoMeeth;
import com.zll.wuye.lvshi.fragment.homepage.viewholder.PhotoViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/22 15:28
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
    private final Context context;
    private final ArrayList<PhotoBean.BodyBean> list;
    private final String token;

    public PhotoAdapter(Context context, ArrayList<PhotoBean.BodyBean> list, String token) {
        this.context = context;
        this.list = list;
        this.token = token;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.photo_recycle, null);
        PhotoViewHolder photoViewHolder = new PhotoViewHolder(view);
        return photoViewHolder;
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getAttr().getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.mTouxiang);

        holder.mName.setText(list.get(position).getAttr().getName());
        holder.mPhoto.setText("手机号:"+list.get(position).getAttr().getTel());
        String time = getStrTime(list.get(position).getCreatTm() + "");
        holder.mTime.setText(time+"");
        if(list.get(position).getOrderStatus()==0){
            holder.mQueren.setText("联系客户");
            holder.mQueren.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Alot().dadianhua(context,list.get(position).getAttr().getTel());
                }
            });
        }else{
            holder.mQueren.setText("完成服务");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //时间戳转时间
    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}

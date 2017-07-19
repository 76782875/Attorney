package com.zll.wuye.lvshi.fragment.homepage.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.MakeBean;
import com.zll.wuye.lvshi.fragment.homepage.viewholder.MakeViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/22 17:28
 */
public class MakeAdapter extends RecyclerView.Adapter<MakeViewHolder> {
    private final Context context;
    private final ArrayList<MakeBean.BodyBean> list;

    public MakeAdapter(Context context, ArrayList<MakeBean.BodyBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.make_recycle, null);
        MakeViewHolder makeViewHolder = new MakeViewHolder(inflate);
        return makeViewHolder;
    }

    @Override
    public void onBindViewHolder(MakeViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getAttr().getHeadUrl())
                .bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL))
                .crossFade(1000)
                .into(holder.mTouxiang);
        holder.mName.setText(list.get(position).getAttr().getName());
        String time = getStrTime(list.get(position).getCreatTm() + "");
        holder.mTime.setText("发布时间:"+time);
        int s = list.get(position).getOrderStatus();
        if(s==0){
            holder.mJianmian.setText("未见面");
        }else if(s==0){
            holder.mJianmian.setText("已见面");
        }
        holder.mMessage.setText("内容:"+list.get(position).getAttr().getCntn());
        holder.mPhoto.setText("联系方式:"+list.get(position).getAttr().getTel());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //时间戳转时间
    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}

package com.zll.wuye.lvshi.fragment.homepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.bean.DetailBean;
import com.zll.wuye.lvshi.fragment.homepage.activity.DetailActivity;
import com.zll.wuye.lvshi.fragment.homepage.viewholder.DetailViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/15 15:34
 */
public class DetailAdapter extends RecyclerView.Adapter<DetailViewHolder> {
    private final Context context;
    private final ArrayList<DetailBean.BodyBean> list;

    public DetailAdapter(Context context, ArrayList<DetailBean.BodyBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.detailrecycle, null);
        DetailViewHolder holder = new DetailViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        if(list.get(position).getTitle().equals("案件委托第二次付款")){
            holder.name.setText("案件委托费用");
        }else{
            holder.name.setText(list.get(position).getTitle());
        }
        holder.jia.setText("+"+list.get(position).getProfit()+"元");
        holder.bianhao.setText(list.get(position).getTradeNo());
        if(list.get(position).getStatus()==0){
            holder.zhuangtai.setText("未出账");
        }else{
            holder.zhuangtai.setText("已到账");
        }

        holder.kouchu.setText((list.get(position).getRatio()*100)+"%");

        holder.fuwufeizhuhangtai.setText("已扣除");
        String time = getStrTime(list.get(position).getCreatTm() + "");
        holder.time.setText(time+"");
        holder.jine.setText(list.get(position).getAmount()+"元");
        holder.shouyi.setText(list.get(position).getProfit()+"元");
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

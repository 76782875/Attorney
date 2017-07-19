package com.zll.wuye.lvshi.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zll.wuye.lvshi.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/15 15:34
 */
public class DetailViewHolder extends RecyclerView.ViewHolder {

    public final TextView name;
    public final TextView jia;
    public final TextView bianhao;
    public final TextView zhuangtai;
    public final TextView fuwufeizhuhangtai;
    public final TextView kouchu;
    public final TextView time;
    public final TextView jine;
    public final TextView shouyi;

    public DetailViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.detail_name);
        jia = (TextView) itemView.findViewById(R.id.detail_jia);
        bianhao = (TextView) itemView.findViewById(R.id.detail_bianhao);
        zhuangtai = (TextView) itemView.findViewById(R.id.detail_zhuangtai);
        fuwufeizhuhangtai = (TextView) itemView.findViewById(R.id.detail_fuwufeizhuhangtai);
        kouchu = (TextView) itemView.findViewById(R.id.detail_kouchu);
        time = (TextView) itemView.findViewById(R.id.detail_time);
        jine = (TextView) itemView.findViewById(R.id.detail_jine);
        shouyi = (TextView) itemView.findViewById(R.id.detail_shouyi);


    }
}

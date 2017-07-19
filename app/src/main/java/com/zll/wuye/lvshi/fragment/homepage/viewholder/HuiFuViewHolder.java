package com.zll.wuye.lvshi.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zll.wuye.lvshi.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/16 10:56
 */
public class HuiFuViewHolder extends RecyclerView.ViewHolder {

    public final ImageView touxiang;
    public final TextView name;
    public final TextView time;
    public final TextView message;
    public final TextView caina;

    public HuiFuViewHolder(View itemView) {
        super(itemView);
        touxiang = (ImageView) itemView.findViewById(R.id.consult_hd_touxiang);
        name = (TextView) itemView.findViewById(R.id.consult_hd_name);
        time = (TextView) itemView.findViewById(R.id.consult_hd_time);
        message = (TextView) itemView.findViewById(R.id.consult_hd_message);
        caina = (TextView) itemView.findViewById(R.id.zixun_yicaina);

    }

}

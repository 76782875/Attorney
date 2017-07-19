package com.zll.wuye.lvshi.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.AutoLinearLayout;
import com.zll.wuye.lvshi.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/16 14:13
 */
public class TeanderViewHolder extends RecyclerView.ViewHolder {

    public final ImageView touxiang;
    public final TextView name;
    public final TextView time;
    public final Button toubiao;
    public final TextView didian;
    public final TextView baojia;
    public final TextView leixing;
    public final TextView jige;
    public final AutoLinearLayout ll;
    public final TextView message;

    public TeanderViewHolder(View itemView) {
        super(itemView);
        touxiang = (ImageView) itemView.findViewById(R.id.tender_touxiang);
        name = (TextView) itemView.findViewById(R.id.tender_name);
        time = (TextView) itemView.findViewById(R.id.tender_time);
        toubiao = (Button) itemView.findViewById(R.id.tender_toubiao);
        message = (TextView) itemView.findViewById(R.id.consult_huida_message);
        didian = (TextView) itemView.findViewById(R.id.tender_didian);
        baojia = (TextView) itemView.findViewById(R.id.tender_baojia);
        leixing = (TextView) itemView.findViewById(R.id.tender_leixing);
        jige = (TextView) itemView.findViewById(R.id.tender_jige);
        ll = (AutoLinearLayout) itemView.findViewById(R.id.tender_ll);
    }
}

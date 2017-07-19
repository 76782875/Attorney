package com.zll.wuye.lvshi.fragment.mypage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.fragment.mypage.regin.Register;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/26 16:33
 */
public class PingjiaViewHolder extends RecyclerView.ViewHolder {

    public final ImageView touxiang;
    public final TextView name;
    public final TextView message;
    public final TextView manyi;

    public PingjiaViewHolder(View itemView) {
        super(itemView);
        touxiang = (ImageView) itemView.findViewById(R.id.wode_pingjia_touxiang);
        name = (TextView) itemView.findViewById(R.id.wode_pingjia_name);
        message = (TextView) itemView.findViewById(R.id.wode_pingjia_message);
        manyi = (TextView) itemView.findViewById(R.id.wode_pingjia_manyi);
    }
}

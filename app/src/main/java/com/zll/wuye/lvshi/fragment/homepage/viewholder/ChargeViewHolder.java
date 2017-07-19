package com.zll.wuye.lvshi.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zll.wuye.lvshi.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/15 09:31
 */
public class ChargeViewHolder extends RecyclerView.ViewHolder {

    public final LinearLayout zixunpingtai;
    public final LinearLayout jingbiaopingtai;
    public final LinearLayout jiangshishenqing;
    public final LinearLayout huida;
    public final LinearLayout wodejingbiao;
    public final LinearLayout wodefuwu;
    public final LinearLayout shoufeishezhi;
    public final LinearLayout tixian;
    public final TextView chakanmingxi;
    public final TextView shouyi;

    public ChargeViewHolder(View itemView) {
        super(itemView);
        shoufeishezhi = (LinearLayout) itemView.findViewById(R.id.shouye_shoufeishezhi);
        tixian = (LinearLayout) itemView.findViewById(R.id.shouye_tixian);
        chakanmingxi = (TextView) itemView.findViewById(R.id.shouye_chakanmingxi);
        shouyi = (TextView) itemView.findViewById(R.id.shouye_zongshouyi);

        zixunpingtai = (LinearLayout) itemView.findViewById(R.id.shouye_zixunpingtai);
        jingbiaopingtai = (LinearLayout) itemView.findViewById(R.id.shouye_jingbiaopingtai);
        jiangshishenqing = (LinearLayout) itemView.findViewById(R.id.shouye_jiangshishenqing);
        huida = (LinearLayout) itemView.findViewById(R.id.shouye_wode_huida);
        wodejingbiao = (LinearLayout) itemView.findViewById(R.id.shouye_wodejingbiao);
        wodefuwu = (LinearLayout) itemView.findViewById(R.id.shouye_wodefuwu);


    }
}

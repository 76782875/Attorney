package com.zll.wuye.lvshi.fragment.mypage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zll.wuye.lvshi.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/10 11:16
 */
public class PersonViewholder extends RecyclerView.ViewHolder {

    public final TextView tv;

    public PersonViewholder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.person_recycle_tv);
    }
}

package com.zll.wuye.lvshi.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zll.wuye.lvshi.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/22 17:25
 */
public class MakeViewHolder extends RecyclerView.ViewHolder {

    public final ImageView mTouxiang;
    public final Button mJianmian;
    public final TextView mName;
    public final TextView mTime;
    public final TextView mMessage;
    public final TextView mPhoto;

    public MakeViewHolder(View itemView) {
        super(itemView);
        mTouxiang = (ImageView) itemView.findViewById(R.id.make_recyc_touxiang);
        mJianmian = (Button) itemView.findViewById(R.id.make_recyc_jianmian);
        mName = (TextView) itemView.findViewById(R.id.make_recyc_name);
        mTime = (TextView) itemView.findViewById(R.id.make_recyc_time);
        mMessage = (TextView) itemView.findViewById(R.id.make_recyc_message);
        mPhoto = (TextView) itemView.findViewById(R.id.make_recyc_lianxi);

    }
}

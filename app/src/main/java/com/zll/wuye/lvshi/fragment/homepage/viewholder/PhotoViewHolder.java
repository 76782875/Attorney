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
 * 3. @date 2017/6/22 15:28
 */
public class PhotoViewHolder extends RecyclerView.ViewHolder {

    public final ImageView mTouxiang;
    public final TextView mName;
    public final TextView mPhoto;
    public final TextView mTime;
    public final Button mQueren;

    public PhotoViewHolder(View itemView) {
        super(itemView);
        mTouxiang = (ImageView) itemView.findViewById(R.id.photo_touxiang);
        mName = (TextView) itemView.findViewById(R.id.photo_name);
        mPhoto = (TextView) itemView.findViewById(R.id.photo_photo);
        mTime = (TextView) itemView.findViewById(R.id.photo_time);
        mQueren = (Button) itemView.findViewById(R.id.photo_queren);
    }
}

package com.zll.wuye.lvshi.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zll.wuye.lvshi.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/19 10:06
 */
public class TuPian extends RecyclerView.ViewHolder {

    public final ImageView ziliao;

    public TuPian(View itemView) {
        super(itemView);
        ziliao = (ImageView) itemView.findViewById(R.id.wode_weituoxq_ziliao);
    }
}

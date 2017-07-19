package com.zll.wuye.lvshi.fragment.homepage.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.fragment.homepage.activity.TenderXingQing;
import com.zll.wuye.lvshi.fragment.homepage.viewholder.TuPian;
import com.zll.wuye.lvshi.image.ImageBDInfo;
import com.zll.wuye.lvshi.image.ImageInfo;
import com.zll.wuye.lvshi.image.PreviewImage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/19 10:06
 */
public class TuPianAdapter extends RecyclerView.Adapter<TuPian> {
    private final String[] split;
    private final Context context;
    private ImageBDInfo bdInfo;
    private ArrayList<ImageInfo> data = new ArrayList<>();
    public TuPianAdapter(String[] split, Context context) {
        this.split = split;
        this.context = context;
    }

    @Override
    public TuPian onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wode_weituoxq_recycle_ziliao, null);
        TuPian tuPian = new TuPian(inflate);
        return tuPian;
    }

    @Override
    public void onBindViewHolder(final TuPian holder, final int position) {
        Glide.with(context).load(split[position]).into(holder.ziliao);

        bdInfo = new ImageBDInfo();
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.width = 1280;
        imageInfo.height = 720;
        imageInfo.url=split[position];
        data.add(imageInfo);
        holder.ziliao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdInfo.x = holder.ziliao.getLeft();
                bdInfo.y = holder.ziliao.getTop();
                bdInfo.width = holder.ziliao.getLayoutParams().width;
                bdInfo.height = holder.ziliao.getLayoutParams().height;
                Intent intent = new Intent(context, PreviewImage.class);
                intent.putExtra("data", (Serializable) data);
                intent.putExtra("bdinfo", bdInfo);
                intent.putExtra("index",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return split.length;
    }
}

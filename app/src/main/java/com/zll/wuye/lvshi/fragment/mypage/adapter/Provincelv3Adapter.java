package com.zll.wuye.lvshi.fragment.mypage.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.bean.AnliLeixing;
import com.zll.wuye.lvshi.bean.ProvinceBean;

import java.util.List;


/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/1 10:40
 */
public class Provincelv3Adapter extends BaseAdapter {
    private final Context context;
    private final int num;
    private final List<AnliLeixing.BodyBean> body;
    private int mData;

    public Provincelv3Adapter(Context context, List<AnliLeixing.BodyBean> body, int num) {
        this.context = context;
        this.body = body;
        this.num=num;
    }

    @Override
    public int getCount() {
        return body.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = View.inflate(context, R.layout.provincelvtest, null);
        TextView shengfen = (TextView) inflate.findViewById(R.id.diqu_shengfen_text);
        shengfen.setText(body.get(position).getName());
        if(mData==position){
            shengfen.setTextColor(context.getResources().getColor(R.color.text_color));
        }else{
            shengfen.setTextColor(context.getResources().getColor(R.color.text_color2));
        }
        return inflate;
    }

    public void setdata(int data) {
        this.mData = data;
    }
}

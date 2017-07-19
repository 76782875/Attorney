package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.bean.AnliLeixing;
import com.zll.wuye.lvshi.bean.ZaixianZixun;
import com.zll.wuye.lvshi.fragment.homepage.adapter.HomepagezixunHolder;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import okhttp3.Call;

public class ConsultActivity extends AutoLayoutActivity {

    private String token;
    private RecyclerView recycler;
    private MaterialRefreshLayout mRefreshLayout;
    ArrayList<ZaixianZixun.BodyBean> list = new ArrayList();
    private int p=1;
    private HomepagezixunHolder adapter;
    private boolean isLoadMore = true;
    private int size;
    private ImageView caidan;
    private PopupWindow popwnd;
    private ListView listView;
    private List<AnliLeixing.BodyBean> body2;
    private TextView zaixian;
    private List<ZaixianZixun.BodyBean> body;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initView();
        qingqiu("https://wuye.kylinlaw.com/ask/list?token="+token);

        initdata();
    }

    private void initdata() {
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.shouye_zaixianzixun_mater);
        mRefreshLayout.setLoadMore(isLoadMore);
        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {

            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                tv.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();

            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if(list.size()>0){
                    size = list.size();
                    qingqiu("https://wuye.kylinlaw.com/ask/list?token="+token+"&lastId="+list.get(size-1).getId());
                }else{
                    tv.setVisibility(View.VISIBLE);
                    mRefreshLayout.finishRefreshLoadMore();
                }
            }
        });

        caidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View contentView = LayoutInflater.from(ConsultActivity.this).inflate(R.layout.consult_popup, null);
                popwnd = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
                popwnd.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                popwnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popwnd.showAsDropDown(zaixian);
                listView = (ListView) contentView.findViewById(R.id.consult_popup_listview);
                leixing();
                LinearLayout ll  = (LinearLayout) contentView.findViewById(R.id.consult_popup_ll);

                //显示PopupWindow
                View rootview = LayoutInflater.from(ConsultActivity.this).inflate(R.layout.activity_main, null);
                popwnd.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);

                ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwnd.dismiss();
                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        list.clear();
                        qingqiu("https://wuye.kylinlaw.com/ask/list?token="+token+"&typeId="+body2.get(position).getId());
                        popwnd.dismiss();
                        if(body !=null&& body.size()>=1){
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        });
    }



    private void qingqiu(String url) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        ZaixianZixun zaixianZixun = gson.fromJson(s, ZaixianZixun.class);
                        body = zaixianZixun.getBody();
                        if(body !=null&& body.size()>=1){
                            if(p==1){
                                list.addAll(body);
                                adapter = new HomepagezixunHolder(ConsultActivity.this, list, token);
                                recycler.setAdapter(adapter);
                                p++;
                            }else{
                                if(body.size()>=10){
                                    list.addAll(body);
                                    adapter.notifyItemRangeChanged(size-1,list.size()-1);
                                }else{
                                    tv.setVisibility(View.VISIBLE);
                                }
                            }
                        }else{
                            tv.setVisibility(View.VISIBLE);
                        }

                        mRefreshLayout.finishRefreshLoadMore();
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private void initView() {
        recycler = (RecyclerView) findViewById(R.id.shouye_zaixianzixun_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        ImageView zuo = (ImageView) findViewById(R.id.shouye_zaixianzixun_zuo);
        zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        caidan = (ImageView) findViewById(R.id.zixunliebiao_caidan);
        zaixian = (TextView) findViewById(R.id.zixunpingtai);
        tv = (TextView) findViewById(R.id.shouye_zaixianzixun_shangla);
    }

    private void leixing() {
        String url = "https://wuye.kylinlaw.com/dict/code/list?code=askType&token="+token;
        HttpOkGo.okgoget(url, AnliLeixing.class, new HttpOkGo.okget<AnliLeixing>() {
            @Override
            public void shuju(ArrayList<AnliLeixing> list) {
                body2 = list.get(0).getBody();
                listView.setAdapter(new MyAdapter());
            }
        });

    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return body2.size();
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
            View inflate = View.inflate(ConsultActivity.this, R.layout.listview_adapter, null);
            TextView tv = (TextView) inflate.findViewById(R.id.listview_tv);
            tv.setText(body2.get(position).getName());
            return inflate;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
        qingqiu("https://wuye.kylinlaw.com/ask/list?token="+token);
        initdata();
    }
}

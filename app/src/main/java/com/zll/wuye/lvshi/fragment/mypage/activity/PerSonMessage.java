package com.zll.wuye.lvshi.fragment.mypage.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.AutoLinearLayout;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.application.DividerItemDecoration;
import com.zll.wuye.lvshi.application.RoundedCornersTransformation;
import com.zll.wuye.lvshi.bean.AnliLeixing;
import com.zll.wuye.lvshi.bean.AnliLeixing2;
import com.zll.wuye.lvshi.bean.PersonMesageBean;
import com.zll.wuye.lvshi.bean.PhotoBeanfore;
import com.zll.wuye.lvshi.bean.ProvinceBean;
import com.zll.wuye.lvshi.bean.RegionBean;
import com.zll.wuye.lvshi.fragment.mypage.adapter.Provincelv1Adapter;
import com.zll.wuye.lvshi.fragment.mypage.adapter.Provincelv2Adapter;
import com.zll.wuye.lvshi.fragment.mypage.change.ChangeActivity;
import com.zll.wuye.lvshi.fragment.mypage.change.ChangeJL;
import com.zll.wuye.lvshi.fragment.mypage.change.ChangeSex;
import com.zll.wuye.lvshi.fragment.mypage.change.Changenian;
import com.zll.wuye.lvshi.fragment.mypage.viewholder.PersonViewholder;
import com.zll.wuye.lvshi.http.HttpOkGo;
import com.zll.wuye.lvshi.interfacee.Renovation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

import okhttp3.Call;
import okhttp3.Response;

public class PerSonMessage extends AutoLayoutActivity {

    private String token;
    private ImageView wode_xinxi_fanhui;
    private ImageView wode_message_touxiang;
    private AutoLinearLayout wode_message_lltouxiang;
    private TextView wode_message_name;
    private AutoLinearLayout wode_message_llname;
    private TextView wode_message_sex;
    private AutoLinearLayout wode_message_llsex;
    private TextView wode_message_dequ;
    private AutoLinearLayout wode_message_lldiqu;
    private TextView wode_message_nianxian;
    private AutoLinearLayout wode_message_llnianxian;
    private TextView wode_message_lvsuo;
    private AutoLinearLayout wode_message_lllvsuo;
    private TextView wode_message_zhizhao;
    private AutoLinearLayout wode_message_llzhizhao;
    private TextView wode_message_leixing;
    private AutoLinearLayout wode_message_llleixing;
    private TextView wode_message_jianli;
    private String imagepath;
    private PopupWindow popWnd;
    private ListView lvsheng;
    private ListView lvshi;
    private String shengid;
    private String shiid;
    private  int  num=0;
    private  int p=0;
    private List<AnliLeixing2.BodyBean> body;
    private GridView gv;
    private int a=0;
    private String lxname="";
    private String lxid="";
    private int b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_son_message);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initdata();
        shuju();

    }

    private void shuju() {
        String url2 = "https://wuye.kylinlaw.com/lawyer/info?token="+token;
        HttpOkGo.okgoget(url2, PersonMesageBean.class, new HttpOkGo.okget<PersonMesageBean>() {
            @Override
            public void shuju(ArrayList<PersonMesageBean> list) {
                PersonMesageBean.BodyBean body = list.get(0).getBody();
                if(body.getLawyer().getHeadUrl()!=null||body.getLawyer().getHeadUrl().length()<1){
                    Glide.with(PerSonMessage.this).load(body.getLawyer().getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(PerSonMessage.this, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(wode_message_touxiang);
                }
                if(body!=null){
                    if(body.getLawyer().getName()!=null){
                        wode_message_name.setText(body.getLawyer().getName()+"");
                    }
                    if(body.getLawyer().getSex()==0){
                        wode_message_sex.setText("女");
                    }else{
                        wode_message_sex.setText("男");
                    }
                    wode_message_nianxian.setText(body.getLawyer().getPeriod()+"年");

                    if(body.getLawyer().getAddress()!=null){
                        wode_message_dequ.setText(body.getLawyer().getAddress()+"");
                    }

                    if(body.getLawyer().getLawName()!=null){
                        wode_message_lvsuo.setText(body.getLawyer().getLawName()+"");
                    }

                    if(body.getLawyer().getLawyerNo()!=null){
                        wode_message_zhizhao.setText(body.getLawyer().getLawyerNo()+"");
                    }
                    if(body.getLawyer().getTypeName()!=null){
                        wode_message_leixing.setText(body.getLawyer().getTypeName()+"");
                    }

                    if(body.getLawyer().getCntn()!=null){
                        wode_message_jianli.setText(body.getLawyer().getCntn()+"");
                    }
                }

            }
        });
    }

    private void initdata() {
        wode_xinxi_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wode_message_lltouxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                /* 开启Pictures画面Type设定为image */
                intent.setType("image/*");
                /* 使用Intent.ACTION_GET_CONTENT这个Action */
                intent.setAction(Intent.ACTION_GET_CONTENT);
                /* 取得相片后返回本画面 */
                startActivityForResult(intent, 1);
            }
        });

        wode_message_llname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(PerSonMessage.this, ChangeActivity.class);
//                intent.putExtra("token",token);
//                startActivity(intent);
                Toast.makeText(PerSonMessage.this,"此信息不可随意更改，确需修改请联系客服",Toast.LENGTH_SHORT).show();
            }
        });

        wode_message_llsex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(PerSonMessage.this, ChangeSex.class);
//                intent.putExtra("token",token);
//                startActivity(intent);
                Toast.makeText(PerSonMessage.this,"此信息不可随意更改，确需修改请联系客服",Toast.LENGTH_SHORT).show();
            }
        });
        wode_message_lldiqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupwindow();
            }
        });
        wode_message_llnianxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(PerSonMessage.this, Changenian.class);
//                intent.putExtra("token",token);
//                intent.putExtra("name","修改年限");
//                intent.putExtra("name2","请输入职业年限");
//                intent.putExtra("panduan","1");
//                startActivity(intent);
                Toast.makeText(PerSonMessage.this,"此信息不可随意更改，确需修改请联系客服",Toast.LENGTH_SHORT).show();
            }
        });

        wode_message_lllvsuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerSonMessage.this, Changenian.class);
                intent.putExtra("token",token);
                intent.putExtra("name","修改律所");
                intent.putExtra("name2","请输入律所名称");
                intent.putExtra("panduan","2");
                startActivity(intent);
            }
        });

        wode_message_jianli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerSonMessage.this, ChangeJL.class);
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });
        wode_message_llzhizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PerSonMessage.this,"此信息不可随意更改，确需修改请联系客服",Toast.LENGTH_SHORT).show();
            }
        });

        wode_message_llleixing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(PerSonMessage.this).create();
                dialog.show();
                dialog.setTitle("请选择您的专长");
                Window window = dialog.getWindow();
                window.setContentView(R.layout.personleixing);
                gv = (GridView) window.findViewById(R.id.person_gv);
                TextView quxiao = (TextView) window.findViewById(R.id.person_quxiao);
                TextView queding = (TextView) window.findViewById(R.id.person_queding);

                leixingshuju();
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        a=0;
                    }
                });
                queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a=0;
                        for (int i = 0; i < body.size(); i++) {
                            if( body.get(i).isFlag()){
                                if(b==0){
                                    lxname = body.get(i).getName();
                                    lxid = ""+body.get(i).getId();
                                    b++;
                                }else{
                                    lxname = lxname+","+body.get(i).getName();
                                    lxid = lxid+","+body.get(i).getId();
                                }
                            }
                        }
                        wode_message_leixing.setText(lxname);
                        xiugaileixing();
                        dialog.dismiss();
                    }
                });
            }
        });

    }

    private void xiugaileixing() {
        String url = "https://wuye.kylinlaw.com/lawyer/update?token="+token;
        HashMap<String,Object> map = new HashMap<>();
        map.put("typeIds",lxid);
        HttpOkGo.okgopost(url,map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                Toast.makeText(PerSonMessage.this,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void leixingshuju() {
        String url= "https://wuye.kylinlaw.com/dict/code/list?code=askType";
        HttpOkGo.okgoget(url, AnliLeixing2.class, new HttpOkGo.okget<AnliLeixing2>() {
            @Override
            public void shuju(ArrayList<AnliLeixing2> list) {
                body = list.get(0).getBody();
                final MyAdapter myAdapter = new MyAdapter();
                gv.setAdapter(myAdapter);
                gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        for (int i = 0; i < body.size(); i++) {
                            if(body.get(i).isFlag()==true){
                                a+=1;
                            }
                        }
                        if( body.get(position).isFlag()){
                            body.get(position).setFlag(false);
                            a--;
                        }else{
                            if(a<3){
                                body.get(position).setFlag(true);
                            }
                        }
                        a=0;
                        myAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

    }

    public void scdiqu(){
        String url = "https://wuye.kylinlaw.com/lawyer/update?token="+token;;
        HashMap<String,Object> map = new HashMap<>();
        map.put("prvcId",shengid);
        map.put("cityId",shiid);
        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                Toast.makeText(PerSonMessage.this,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        wode_xinxi_fanhui = (ImageView) findViewById(R.id.wode_xinxi_fanhui);
        wode_message_touxiang = (ImageView) findViewById(R.id.wode_message_touxiang);
        wode_message_lltouxiang = (AutoLinearLayout) findViewById(R.id.wode_message_lltouxiang);
        wode_message_name = (TextView) findViewById(R.id.wode_message_name);
        wode_message_llname = (AutoLinearLayout) findViewById(R.id.wode_message_llname);
        wode_message_sex = (TextView) findViewById(R.id.wode_message_sex);
        wode_message_llsex = (AutoLinearLayout) findViewById(R.id.wode_message_llsex);
        wode_message_dequ = (TextView) findViewById(R.id.wode_message_dequ);
        wode_message_lldiqu = (AutoLinearLayout) findViewById(R.id.wode_message_lldiqu);
        wode_message_nianxian = (TextView) findViewById(R.id.wode_message_nianxian);
        wode_message_llnianxian = (AutoLinearLayout) findViewById(R.id.wode_message_llnianxian);
        wode_message_lvsuo = (TextView) findViewById(R.id.wode_message_lvsuo);
        wode_message_lllvsuo = (AutoLinearLayout) findViewById(R.id.wode_message_lllvsuo);
        wode_message_zhizhao = (TextView) findViewById(R.id.wode_message_zhizhao);
        wode_message_llzhizhao = (AutoLinearLayout) findViewById(R.id.wode_message_llzhizhao);
        wode_message_leixing = (TextView) findViewById(R.id.wode_message_leixing);
        wode_message_llleixing = (AutoLinearLayout) findViewById(R.id.wode_message_llleixing);
        wode_message_jianli = (TextView) findViewById(R.id.wode_message_jianli);
    }


    private void popupwindow() {
        View contentView = LayoutInflater.from(PerSonMessage.this).inflate(R.layout.popuplayoutdiqu, null);
        popWnd = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);

        popWnd.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.showAsDropDown(wode_message_dequ);

        lvsheng = (ListView) contentView.findViewById(R.id.diqu_lv_sheng);
        lvshi = (ListView) contentView.findViewById(R.id.diqu_lv_shi);
        LinearLayout ll = (LinearLayout) contentView.findViewById(R.id.guanbipop);

        diyu();
        //显示PopupWindow
        View rootview = LayoutInflater.from(PerSonMessage.this).inflate(R.layout.activity_main, null);
        popWnd.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWnd.dismiss();
                if(!shengid.equals("")){
                    scdiqu();
                }
            }
        });
    }


    public void diyu() {
        OkGo.get("https://wuye.kylinlaw.com/dict/parId/list?parId=100000&token="+token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        final ProvinceBean provinceBean = gson.fromJson(s, ProvinceBean.class);
                        lvsheng.setAdapter(new Provincelv1Adapter(PerSonMessage.this, provinceBean,num));
                        lvsheng.setSelection(0);
                        diyuqu("https://wuye.kylinlaw.com/dict/parId/list?parId="+110000+"&token="+token);
                        wode_message_dequ.setText(provinceBean.getBody().get(0).getName());
                        shengid = String.valueOf(provinceBean.getBody().get(0).getId());
                        lvsheng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String parid = String.valueOf(provinceBean.getBody().get(position).getId());
                                diyuqu("https://wuye.kylinlaw.com/dict/parId/list?parId="+parid+"&token="+token);
                                wode_message_dequ.setText(provinceBean.getBody().get(position).getName());
                                shengid = String.valueOf(provinceBean.getBody().get(position).getId());
                            }
                        });
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    public void diyuqu(String url) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        RegionBean regionBean = gson.fromJson(s, RegionBean.class);
                        final List<RegionBean.BodyBean> body = regionBean.getBody();
                        lvshi.setAdapter(new Provincelv2Adapter(PerSonMessage.this, body,num));
                        lvshi.setSelection(0);
                        shiid = String.valueOf(body.get(0).getId());
                        lvshi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                popWnd.dismiss();
                                String trim = wode_message_dequ.getText().toString().trim();
                                wode_message_dequ.setText(trim + "/" + body.get(position).getName());
                                shiid = String.valueOf(body.get(position).getId());
                                scdiqu();
                            }
                        });

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }


    public void sctouxiang(){
        String url = "https://wuye.kylinlaw.com/lawyer/update?token="+token;;
        HashMap<String,Object> map = new HashMap<>();
        map.put("headUrl",imagepath);
        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                Toast.makeText(PerSonMessage.this,"上传成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            String path = Lujing.getPath(PerSonMessage.this, uri);
            photomath(path);
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                /* 将Bitmap设定到ImageView */
                wode_message_touxiang.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(),e);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void photomath(String url) {

        OkGo.post("https://wuye.kylinlaw.com/file/upload?token="+token)//
                .tag(this)//
                .isMultipart(true)       // 强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .params("headUrl", new File(url)) 	// 支持多文件同时添加上传
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        PhotoBeanfore json = gson.fromJson(s, PhotoBeanfore.class);
                        imagepath = json.getBody().get(0).getPath();
                        sctouxiang();
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
        initdata();
        shuju();
    }
    class MyAdapter extends BaseAdapter{

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
            View view = View.inflate(PerSonMessage.this, R.layout.leixinggv, null);
            TextView tv = (TextView) view.findViewById(R.id.gv_tv);
            tv.setText(body.get(position).getName());
            if(body.get(position).isFlag()){
                tv.setTextColor(Color.WHITE);
                tv.setBackgroundColor(Color.RED);
            }else{
                tv.setTextColor(Color.BLACK);
                tv.setBackgroundColor(Color.WHITE);
            }

            return view;
        }
    }
}

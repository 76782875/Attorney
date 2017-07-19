package com.zll.wuye.lvshi.fragment.mypage.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.bean.AnliLeixing;
import com.zll.wuye.lvshi.bean.PhotoBeanfore;
import com.zll.wuye.lvshi.bean.ProvinceBean;
import com.zll.wuye.lvshi.bean.RegionBean;
import com.zll.wuye.lvshi.fragment.mypage.adapter.Provincelv1Adapter;
import com.zll.wuye.lvshi.fragment.mypage.adapter.Provincelv2Adapter;
import com.zll.wuye.lvshi.fragment.mypage.adapter.Provincelv3Adapter;
import com.zll.wuye.lvshi.http.HttpOkGo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class LvShishenhe extends AppCompatActivity implements View.OnClickListener {

    private EditText lvshishenhe_name;
    private ImageView lvshishenhe_sex_nan;
    private ImageView lvshishenhe_name_nv;
    private EditText lvshishenhe_lvsuo;
    private EditText lvshishenhe_zhengjianhao;
    private ImageView lvshishenhe_touxiang;
    private Button lvshishenhe_tijiao;
    private int sex=2;
    private String token;
    private String imagepath;
    private ImageView fanhui;
    private LinearLayout didianll;
    private TextView didian;
    private LinearLayout leixingll;
    private TextView leixing;
    private EditText jianjie;
    private PopupWindow popWnd;
    private ListView lvsheng;
    private ListView lvshi;
    private  int  num=0;
    private String shengid;
    private String shiid;
    private PopupWindow mPopWnd2;
    private ListView mLeixing;
    private Provincelv3Adapter mAdapter;
    private List<AnliLeixing.BodyBean> mBodyleixing;
    private String h1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_shishenhe);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        initView();
        initdata();

    }

    private void initdata() {

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lvshishenhe_sex_nan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvshishenhe_sex_nan.setImageResource(R.mipmap.shixinyuan);
                lvshishenhe_name_nv.setImageResource(R.mipmap.kongxinyuan);
                sex=1;
            }
        });

        lvshishenhe_name_nv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvshishenhe_name_nv.setImageResource(R.mipmap.shixinyuan);
                lvshishenhe_sex_nan.setImageResource(R.mipmap.kongxinyuan);
                sex=0;
            }
        });
        lvshishenhe_touxiang.setOnClickListener(new View.OnClickListener() {
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

        lvshishenhe_tijiao.setOnClickListener(this);

        didianll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupwindow();
            }
        });

    }

    private void initView() {
        lvshishenhe_name = (EditText) findViewById(R.id.lvshishenhe_name);
        lvshishenhe_sex_nan = (ImageView) findViewById(R.id.lvshishenhe_sex_nan);
        lvshishenhe_name_nv = (ImageView) findViewById(R.id.lvshishenhe_name_nv);
        lvshishenhe_lvsuo = (EditText) findViewById(R.id.lvshishenhe_lvsuo);
        lvshishenhe_zhengjianhao = (EditText) findViewById(R.id.lvshishenhe_zhengjianhao);
        lvshishenhe_touxiang = (ImageView) findViewById(R.id.lvshishenhe_touxiang);
        lvshishenhe_tijiao = (Button) findViewById(R.id.lvshishenhe_tijiao);
        fanhui = (ImageView) findViewById(R.id.lvshishenhe_fanhui);

        didianll = (LinearLayout) findViewById(R.id.lvshishenhe_didianll);
        didian = (TextView) findViewById(R.id.lvshishenhe_didian);
        leixingll = (LinearLayout) findViewById(R.id.lvshishenhe_leixingll);
        leixing = (TextView) findViewById(R.id.lvshishenhe_leixing);
        jianjie = (EditText) findViewById(R.id.lvshishenhe_jianjies);
        leixingll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populeixing();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            String path = Lujing.getPath(LvShishenhe.this, uri);
            photomath(path);
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                /* 将Bitmap设定到ImageView */
                lvshishenhe_touxiang.setImageBitmap(bitmap);

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

                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

    @Override
    public void onClick(View v) {
        String name = lvshishenhe_name.getText().toString().trim();
        String lvsuo = lvshishenhe_lvsuo.getText().toString().trim();
        String zhengjianhao = lvshishenhe_zhengjianhao.getText().toString().trim();
        String jianjie2 = jianjie.getText().toString().trim();
        if(name.equals("")||name.length()<1){
            Toast.makeText(LvShishenhe.this,"请填写姓名",Toast.LENGTH_SHORT).show();
        }else if(sex==2){
            Toast.makeText(LvShishenhe.this,"请选择性别",Toast.LENGTH_SHORT).show();
        }else if(lvsuo.equals("")||lvsuo.length()<1){
            Toast.makeText(LvShishenhe.this,"请填写律所",Toast.LENGTH_SHORT).show();
        }else if(zhengjianhao.equals("")||zhengjianhao.length()<1){
            Toast.makeText(LvShishenhe.this,"请填写证件号",Toast.LENGTH_SHORT).show();
        }else if(imagepath.equals("")||imagepath.length()<1){
            Toast.makeText(LvShishenhe.this,"请上传头像",Toast.LENGTH_SHORT).show();
        }else{
            HashMap<String, Object> params = new HashMap<>();
            params.put("status", 0);
            params.put("name", name);
            params.put("period","");
            params.put("headUrl", imagepath);
            params.put("sex", sex);
            params.put("lawName", lvsuo);
            params.put("lawyerNo", zhengjianhao);
            params.put("prvcId", shengid);
            params.put("cityId", shiid);
            params.put("cntn", jianjie2);
            params.put("typeIds",h1);
            String url = "https://wuye.kylinlaw.com/lawyer/update?token="+token;
            HttpOkGo.okgopost(url,params, new HttpOkGo.okpost() {
                @Override
                public void fanhui(String s) {
                    finish();
                    Toast.makeText(LvShishenhe.this,"提交成功!",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void populeixing() {
        View contentView = LayoutInflater.from(LvShishenhe.this).inflate(R.layout.populeixing, null);
        mPopWnd2 = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);

        mPopWnd2.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWnd2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWnd2.showAsDropDown(leixing);
        jiexileixing();
        mLeixing = (ListView) contentView.findViewById(R.id.popleixing_list);
        LinearLayout ll = (LinearLayout) contentView.findViewById(R.id.popleixing_ll);
        //显示PopupWindow
        View rootview = LayoutInflater.from(LvShishenhe.this).inflate(R.layout.activity_main, null);
        mPopWnd2.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopWnd2.dismiss();
            }
        });

        mLeixing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mAdapter.setdata(position);
                mAdapter.notifyDataSetChanged();
                if(leixing.getText().toString().trim().equals("请选择1-3个类型，如同和纠纷，债务纠纷")){
                    leixing.setText(mBodyleixing.get(position).getName());
                    h1=mBodyleixing.get(position).getId()+"";
                }else{
                    leixing.setText(leixing.getText().toString().trim()+","+mBodyleixing.get(position).getName());
                    h1=h1+","+mBodyleixing.get(position).getId();
                }
                mPopWnd2.dismiss();
            }
        });
    }

    public void jiexileixing(){
        String url = "https://wuye.kylinlaw.com/dict/code/list?code=askType";
        HttpOkGo.okgoget(url, AnliLeixing.class, new HttpOkGo.okget<AnliLeixing>() {
            @Override
            public void shuju(ArrayList<AnliLeixing> list) {
                mBodyleixing = list.get(0).getBody();
                mAdapter = new Provincelv3Adapter(LvShishenhe.this, mBodyleixing, num);
                mLeixing.setAdapter(mAdapter);
            }
        });
    }

    private void popupwindow() {
        View contentView = LayoutInflater.from(LvShishenhe.this).inflate(R.layout.popuplayoutdiqu, null);
        popWnd = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);

        popWnd.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.showAsDropDown(didianll);

        lvsheng = (ListView) contentView.findViewById(R.id.diqu_lv_sheng);
        lvshi = (ListView) contentView.findViewById(R.id.diqu_lv_shi);
        LinearLayout ll = (LinearLayout) contentView.findViewById(R.id.guanbipop);

        diyu();
        //显示PopupWindow
        View rootview = LayoutInflater.from(LvShishenhe.this).inflate(R.layout.activity_main, null);
        popWnd.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWnd.dismiss();
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
                        lvsheng.setAdapter(new Provincelv1Adapter(LvShishenhe.this, provinceBean,num));
                        lvsheng.setSelection(0);
                        diyuqu("https://wuye.kylinlaw.com/dict/parId/list?parId="+110000+"&token="+token);
                        didian.setText(provinceBean.getBody().get(0).getName());
                        shengid = String.valueOf(provinceBean.getBody().get(0).getId());
                        lvsheng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String parid = String.valueOf(provinceBean.getBody().get(position).getId());
                                diyuqu("https://wuye.kylinlaw.com/dict/parId/list?parId="+parid+"&token="+token);
                                didian.setText(provinceBean.getBody().get(position).getName());
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
                        lvshi.setAdapter(new Provincelv2Adapter(LvShishenhe.this, body,num));
                        lvshi.setSelection(0);
                        shiid = String.valueOf(body.get(0).getId());
                        lvshi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                popWnd.dismiss();
                                String trim = didian.getText().toString().trim();
                                didian.setText(trim + "/" + body.get(position).getName());
                                shiid = String.valueOf(body.get(position).getId());
                            }
                        });

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

}

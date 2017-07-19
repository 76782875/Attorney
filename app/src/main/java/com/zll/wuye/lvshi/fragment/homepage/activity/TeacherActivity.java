package com.zll.wuye.lvshi.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.lvshi.R;
import com.zll.wuye.lvshi.activity.MainActivity;
import com.zll.wuye.lvshi.bean.FanMang;
import com.zll.wuye.lvshi.bean.PhotoBeanfore;
import com.zll.wuye.lvshi.http.HttpOkGo;
import com.zll.wuye.lvshi.local.ImgFileListActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Response;

public class TeacherActivity extends AutoLayoutActivity{

    private ImageView jiangshishenqing_fanhui;
    private EditText jiangshishenqing_name;
    private EditText jiangshishenqing_dagang;
    private ImageView jiangshishenqing_shangchuan;
    private EditText jiangshishenqing_xname;
    private EditText jiangshishenqing_photo;
    private Button jiangshishenqing_tijiao;
    private String token;
    private String lvname;
    ArrayList<String> listfile=new ArrayList<String>();
    private boolean b=false;
    private String zongurl="";
    private String kjname;
    private String dagang;
    private String xname;
    private String photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        lvname = intent.getStringExtra("name");
        initdata();
    }

    private void initdata() {
        jiangshishenqing_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        jiangshishenqing_shangchuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherActivity.this,ImgFileListActivity.class);
                startActivity(intent);

            }
        });

        Bundle bundle= getIntent().getExtras();

        if (bundle!=null) {
            if (bundle.getStringArrayList("files")!=null) {
                listfile= bundle.getStringArrayList("files");
            }
        }

        if(listfile!=null){
            for (int i = 0; i < listfile.size(); i++) {
                String s = listfile.get(i);
                if(i!=listfile.size()-1){
                    b=true;
                }else{
                    b=false;
                }
                photomath(s,b);

            }
        }

        jiangshishenqing_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kjname = jiangshishenqing_name.getText().toString().trim();
                dagang = jiangshishenqing_dagang.getText().toString().trim();
                xname = jiangshishenqing_xname.getText().toString().trim();
                photo = jiangshishenqing_photo.getText().toString().trim();

                if(xname.length()<1){
                    Toast.makeText(TeacherActivity.this,"姓名不能为空",Toast.LENGTH_SHORT).show();
                }else if(photo.length()<1){
                    Toast.makeText(TeacherActivity.this,"姓名不能为空",Toast.LENGTH_SHORT).show();
                }else if(!isPhoneNum(photo)){
                    Toast.makeText(TeacherActivity.this,"您输入的手机号不合法",Toast.LENGTH_SHORT).show();
                }else{
                    tijiao();
                }
            }
        });

    }

    public static boolean isPhoneNum(String phone_num) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(14[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phone_num);
        return m.matches();
    }

    private void tijiao() {
        String url = "https://wuye.kylinlaw.com/course/create?token="+token;
        HashMap<String,Object> map =new HashMap<>();
        map.put("title",kjname);
        map.put("cntn",dagang);
        map.put("files",zongurl);
        map.put("name",xname);
        map.put("tel",photo);
        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                Gson gson = new Gson();
                FanMang mang = gson.fromJson(s, FanMang.class);
                if(mang.getStatus()==200){
                    Toast.makeText(TeacherActivity.this,"提交成功,我们会尽快审核",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(TeacherActivity.this,"请先完善个人信息，审核通过后可以开展相关业务",Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    private void initView() {
        jiangshishenqing_fanhui = (ImageView) findViewById(R.id.jiangshishenqing_fanhui);
        jiangshishenqing_name = (EditText) findViewById(R.id.jiangshishenqing_name);
        jiangshishenqing_dagang = (EditText) findViewById(R.id.jiangshishenqing_dagang);
        jiangshishenqing_shangchuan = (ImageView) findViewById(R.id.jiangshishenqing_shangchuan);
        jiangshishenqing_xname = (EditText) findViewById(R.id.jiangshishenqing_xname);
        jiangshishenqing_photo = (EditText) findViewById(R.id.jiangshishenqing_photo);
        jiangshishenqing_tijiao = (Button) findViewById(R.id.jiangshishenqing_tijiao);

    }

    private void photomath(String url, final boolean big) {

        OkGo.post("https://wuye.kylinlaw.com/file/upload")//
                .tag(this)//
                .isMultipart(true)       // 强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .params("token", token)
                .params("headUrl", new File(url)) 	// 支持多文件同时添加上传
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        PhotoBeanfore json = gson.fromJson(s, PhotoBeanfore.class);
                        List<PhotoBeanfore.BodyBean> body = json.getBody();
                        if(big){
                            zongurl+=body.get(0).getPath()+",";
                        }else{
                            zongurl+=body.get(0).getPath();
                        }

                    }


                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }
}

package com.zll.wuye.lvshi.fragment.mypage.regin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.zll.wuye.lvshi.R;

public class Xieyi extends AppCompatActivity {

    private WebView xieyiwv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xieyi);
        initView();
    }

    private void initView() {
        xieyiwv = (WebView) findViewById(R.id.xieyiwv);
        xieyiwv.loadUrl("http://wuye.kylinlaw.com/xieyi/index.html");
    }
}

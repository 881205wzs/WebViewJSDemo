package com.davis.webviewjs.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class JSCallAndroid1 extends AppCompatActivity {

    private Button btn;
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        init();
    }

    private void init() {
        btn = (Button)findViewById(R.id.btn);
        btn.setVisibility(View.GONE);

        webview = (WebView)findViewById(R.id.webview);

        WebSettings webSettings = webview.getSettings();

        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // 通过addJavascriptInterface()将Java对象映射到JS对象
        //参数1：Javascript对象名
        //参数2：Java对象名
        webview.addJavascriptInterface(new AndroidtoJs(), "test");//AndroidtoJS类对象映射到js的test对象

        // 先载入JS代码
        // 格式规定为:file:///android_asset/文件名.html
        webview.loadUrl("file:///android_asset/jscallandroid.html");
    }
}

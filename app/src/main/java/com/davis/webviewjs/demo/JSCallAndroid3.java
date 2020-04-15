package com.davis.webviewjs.demo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;

public class JSCallAndroid3 extends AppCompatActivity {

    private Button btn;
    private WebView webview;
    private LinearLayout layout;
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

        // 先载入JS代码
        // 格式规定为:file:///android_asset/文件名.html
        webview.loadUrl("file:///android_asset/jscallandroid3.html");

        webview.setWebChromeClient(new WebChromeClient(){

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                // 根据协议的参数，判断是否是所需要的url(原理同方式2)
                // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
                //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）

                Log.i("WEBVIEW_JS", "message : " + message);
                Uri uri = Uri.parse(message);
                // 如果url的协议 = 预先约定的 js 协议
                // 就解析往下解析参数
                if ( uri.getScheme().equals("js")) {

                    // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
                    // 所以拦截url,下面JS开始调用Android需要的方法
                    if (uri.getAuthority().equals("webview")) {
                        //
                        Log.i("WEBVIEW_JS", "js调用了Android的方法");
                        // 拦截alert()之后必须调用result.confirm()方法，否则会出现白屏
                        result.confirm();
                        return true;
                    }
                }

                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                // 根据协议的参数，判断是否是所需要的url(原理同方式2)
                // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
                //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）

                Log.i("WEBVIEW_JS", "message : " + message);
                Uri uri = Uri.parse(message);
                // 如果url的协议 = 预先约定的 js 协议
                // 就解析往下解析参数
                if ( uri.getScheme().equals("js")) {

                    // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
                    // 所以拦截url,下面JS开始调用Android需要的方法
                    if (uri.getAuthority().equals("webview")) {
                        //
                        Log.i("WEBVIEW_JS", "js调用了Android的方法");
                        // 拦截alert()之后必须调用result.confirm()方法，否则会出现白屏
                        result.confirm("js调用了Android的方法");
                        return true;
                    }
                }
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (webview != null) {
            webview.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            webview.clearHistory();

            ((ViewGroup) webview.getParent()).removeView(webview);
            webview.destroy();
            webview = null;
        }
        super.onDestroy();
    }
}

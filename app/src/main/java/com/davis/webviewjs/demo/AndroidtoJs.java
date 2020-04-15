package com.davis.webviewjs.demo;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class AndroidtoJs extends Object {

    // 定义JS需要调用的方法
    // 被JS调用的方法必须加入@JavascriptInterface注解
    @JavascriptInterface
    public void hello(String msg) {
        Log.i("WEBVIEW_JS", "JS调用了Android的hello方法");
    }
}

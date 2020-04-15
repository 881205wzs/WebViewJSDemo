# WebViewJSDemo
Android WebView与JS互调

# 交互方式
- Android调用JS代码
  - 通过WebView的loadUrl()方式；
  - 通过WebVeiw的evaluateJavascript()方式；
- JS调用Android代码
  - 通过WebView的addJavascriptInterface()进行对象映射；
  - 通过WebViewClient的shouldOverrideUrlLoading()方法回调拦截url；
  - 通过WebChromeClient的onJsAlert()、onJsConfirm()、onJsPrompt()方法回调拦截JS对话框消息；

# 效果图

<img src="https://github.com/881205wzs/WebViewJSDemo/raw/master/default_1.jpg" height="360" width="200"/>&nbsp;&nbsp;<img src="https://github.com/881205wzs/WebViewJSDemo/raw/master/default_2.jpg" height="360" width="200"/>


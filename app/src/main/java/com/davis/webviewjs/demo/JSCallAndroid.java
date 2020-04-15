package com.davis.webviewjs.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class JSCallAndroid extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jscallandroid);
        init();
    }

    private void init() {
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);

        btn_1 = (Button) findViewById(R.id.btn_2);
        btn_1.setOnClickListener(this);

        btn_1 = (Button) findViewById(R.id.btn_3);
        btn_1.setOnClickListener(this);
    }

    private void go(Class clazz){
        Intent intent = new Intent(JSCallAndroid.this, clazz);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                go(JSCallAndroid1.class);
                break;
            case R.id.btn_2:
                go(JSCallAndroid2.class);
                break;
            case R.id.btn_3:
                go(JSCallAndroid3.class);
                break;
        }
    }
}

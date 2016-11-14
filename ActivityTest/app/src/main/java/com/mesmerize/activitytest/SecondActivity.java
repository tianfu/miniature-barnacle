package com.mesmerize.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by mesmerize on 16/9/16.
 */
public class SecondActivity extends Activity implements View.OnClickListener {

    private Button btn_finish;
    private EditText et_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        initListener();
    }

    private void initView() {

        et_input = (EditText) findViewById(R.id.et_input);
        btn_finish = (Button) findViewById(R.id.btn_finish);
    }

    private void initListener() {

        btn_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_finish:

                passbackResult();
                break;
        }
    }

    /**
     * 点击按钮,将输入的文字回传到上个Activity中去
     */
    private void passbackResult() {

        // 获取EditText中所输入的内容
        String content = et_input.getText().toString();

        // 数据使用Intent进行回传
        Intent intent = new Intent();

        // 将输入的内容放入intent中去
        intent.putExtra("result", content);

        // 设置返回数据 RESULT_OK是一个int值 除此之外 还有RESULT_CANCELED / RESULT_FIRST_USER
        setResult(RESULT_OK,intent);

        // 关闭当前Activity
        finish();

    }
}

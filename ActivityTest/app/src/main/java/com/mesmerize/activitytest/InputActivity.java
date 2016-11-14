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
public class InputActivity extends Activity implements View.OnClickListener {

    private EditText et_input;
    private String inputContent;
    private Button btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        initView();
        initListener();
    }

    /**
     * 初始化View控件
     */
    private void initView() {

        et_input = (EditText) findViewById(R.id.et_input);
        btn_click = (Button) findViewById(R.id.btn_click);
    }

    /**
     * 获取用户输入的文字信息
     */
    private void fillData() {

        inputContent = et_input.getText().toString();
    }

    private void initListener() {

        btn_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_click:

                skipActivity();
                break;
        }
    }

    private void skipActivity() {

        fillData();

        Intent intent = new Intent(InputActivity.this,AcceptActivity.class);
        intent.putExtra("transfer", inputContent);
        startActivity(intent);
    }
}

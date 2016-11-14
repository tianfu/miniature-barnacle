package com.mesmerize.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mesmerize on 16/9/16.
 */
public class FirstActivity extends Activity implements View.OnClickListener {

    private TextView tv_result;
    private Button btn_skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initView();
        initListener();
    }

    /**
     * 初始化View控件
     */
    private void initView(){

        tv_result = (TextView) findViewById(R.id.tv_result);
        btn_skip = (Button) findViewById(R.id.btn_skip);
    }

    private void initListener(){

        btn_skip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_skip:

                skipActivity();
                break;
        }
    }

    /**
     * 开启下一个Activity
     */
    private void skipActivity(){

        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

        // param2 意味请求码,是一个int值
        startActivityForResult(intent,1);
    }


    /**
     * Activity数据的回传 为了拿到传回的数据  必须在源Activity中重写onActivityResult
     * @param requestCode  请求码
     * @param resultCode   结果码
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {

            switch (requestCode) {

                case 1:

                    String result = data.getStringExtra("result");

                    tv_result.setText("回传的数据是: "+ result);
                    break;
            }
        }
    }
}

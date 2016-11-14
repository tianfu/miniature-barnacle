package com.mesmerize.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by mesmerize on 16/9/16.
 */
public class AcceptActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept);

        String data = getData();
        TextView tv_accept = (TextView) findViewById(R.id.tv_accept);

        tv_accept.setText(data);
    }

    /**
     * 获取上个页面传递过来的数据
     */
    private String getData() {

        String transfer = getIntent().getStringExtra("transfer");

        return transfer;
    }


}

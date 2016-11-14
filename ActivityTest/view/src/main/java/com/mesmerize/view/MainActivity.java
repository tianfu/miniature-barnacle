package com.mesmerize.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = ((ListView) findViewById(R.id.rlv_listview));

        List<String> dataList = new ArrayList<>();

        for (int i = 0; i < 150; i++) {

            dataList.add("嘿嘿嘿 :: " + i);
        }

        mListView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,dataList));

    }


}

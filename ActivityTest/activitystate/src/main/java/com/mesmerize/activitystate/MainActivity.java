package com.mesmerize.activitystate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("MainActivity.onCreate");

        if (savedInstanceState != null) {

            String test_result = savedInstanceState.getString("test_result");
            System.out.println("[MainActivity.onCreate] :: test_result = " + test_result);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        System.out.println("MainActivity.onSaveInstanceState");

        outState.putString("test_result","且随疾风前行,身后一许流星.");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String test_result = savedInstanceState.getString("test_result");

        System.out.println("[MainActivity.onRestoreInstanceState] :: test_result = " + test_result);
    }



    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("MainActivity.onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("MainActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("MainActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("MainActivity.onDestroy");
    }
}

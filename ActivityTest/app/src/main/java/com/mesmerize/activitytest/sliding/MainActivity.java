package com.mesmerize.activitytest.sliding;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.mesmerize.activitytest.R;

@SuppressLint("All")
public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		System.out.println("MainActivity.onCreate");



	}

	@Override
	protected void onStart() {
		super.onStart();

		System.out.println("MainActivity.onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();

		System.out.println("MainActivity.onResume");
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

	@Override
	protected void onRestart() {
		super.onRestart();

		System.out.println("MainActivity.onRestart");
	}
}

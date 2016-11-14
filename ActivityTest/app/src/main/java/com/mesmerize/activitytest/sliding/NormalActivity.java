package com.mesmerize.activitytest.sliding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.mesmerize.activitytest.R;
import com.mesmerize.activitytest.view.GuideTextView;
import com.mesmerize.activitytest.view.SildingFinishLayout;


public class NormalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_normal);

		SildingFinishLayout mSildingFinishLayout = (SildingFinishLayout) findViewById(R.id.sildingFinishLayout);
		mSildingFinishLayout
				.setOnSildingFinishListener(new SildingFinishLayout.OnSildingFinishListener() {

					@Override
					public void onSildingFinish() {
						NormalActivity.this.finish();
					}
				});

		mSildingFinishLayout.setTouchView(mSildingFinishLayout);

		GuideTextView gtv = (GuideTextView) findViewById(R.id.gtv);

		View[] views = {gtv,gtv,gtv};
		Spannable[] spannables = {new Spannable.Factory().newSpannable("嘿嘿"),new Spannable.Factory().newSpannable("嘻嘻"),new Spannable.Factory().newSpannable("哈哈")};
		String[] strings = {" "," "," "};
		int[] ints = {1,2,3};


		startActivityForResult(new Intent(this,MainActivity.class),0);
		startActivityForResult(new Intent(this,NormalActivity.class),1);

//		Spannable.Factory factory = new Spannable.Factory();
//		factory.newSpannable("哈哈");
//		factory.newSpannable("哈哈");
//		factory.newSpannable("哈哈");
//
//		for (int i = 0; i < views.length; i++) {
//
//			views[i] = gtv;
//			strings[i] = i + "aaaaaaaa";
//			ints[i] = i;
//		}

//		GuideUtil.getInstance().showGuides(this,views,spannables,ints,null);
//		gtv.setMode(1);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (resultCode){

			case 0:

				String success = data.getStringExtra("Success");

				Toast.makeText(NormalActivity.this, "返回的内容是::"+success, Toast.LENGTH_SHORT).show();
				break;

			case 1:

				break;
		}
	}

	// Press the back button in mobile phone
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(0, R.anim.base_slide_right_out);
	}

}

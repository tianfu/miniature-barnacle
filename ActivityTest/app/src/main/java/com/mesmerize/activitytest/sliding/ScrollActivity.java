package com.mesmerize.activitytest.sliding;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ScrollView;

import com.mesmerize.activitytest.R;
import com.mesmerize.activitytest.view.SildingFinishLayout;


public class ScrollActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scroll);

		ScrollView mScrollView = (ScrollView) findViewById(R.id.scrollView1);

		SildingFinishLayout mSildingFinishLayout = (SildingFinishLayout) findViewById(R.id.sildingFinishLayout);
		mSildingFinishLayout
				.setOnSildingFinishListener(new SildingFinishLayout.OnSildingFinishListener() {

					@Override
					public void onSildingFinish() {
						ScrollActivity.this.finish();
					}
				});

		// 设置touchView到ScrollView上面
		mSildingFinishLayout.setTouchView(mScrollView);
	}


	// Press the back button in mobile phone
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(0, R.anim.base_slide_right_out);
	}

}


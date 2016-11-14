package com.mesmerize.activitytest.util;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.mesmerize.activitytest.R;
import com.mesmerize.activitytest.view.GuideTextView;

/**
 * Created by Just.T on 16/6/11.
 */
public class GuideUtil {


    private static GuideUtil guideUtil;
    private static int screenWidth;
    private static int screenHeight;

    public static int MODE_RIGHT = 0;
    public static int MODE_TOP = 1;
    public static int MODE_LEFT = 2;
    public static int MODE_BOTTOM = 3;
    public static int MODE_RIGHT_BOTTOM = 4;
    public static int MODE_LEFT_BOTTOM = 5;
    public static int MODE_RIGHT_TOP = 6;
    public static int MODE_LEFT_TOP = 7;
    public static int MODE_CENTER = 8;

    public static GuideUtil getInstance() {
        if (guideUtil == null) {
            synchronized (GuideUtil.class) {
                if (guideUtil == null) {
                    guideUtil = new GuideUtil();
                }
            }
        }
        return guideUtil;
    }


    public void showGuide(Activity activity, View view, Spannable sp, int mode) {
        showGuide(activity, view, sp, mode, null);
    }

    public void showGuide(Activity activity, View view, Spannable sp, int mode, String guideName) {
        showGuide(activity, view, sp, mode, guideName, null);
    }


    public void showGuide(final Activity activity, final View view, final Spannable sp, final int mode, final String guideName, final PopupWindow.OnDismissListener listener) {
        if (!TextUtils.isEmpty(guideName) && !GuideSpUtil.getInstance(activity).getFlag(guideName)) {
            return;
        }

        if (screenHeight == 0 || screenWidth == 0) {
            screenHeight = activity.getWindowManager().getDefaultDisplay().getHeight();
            screenWidth = activity.getWindowManager().getDefaultDisplay().getWidth();
        }
        view.post(new Runnable() {
            @Override
            public void run() {
                int location[] = new int[2];
                view.getLocationOnScreen(location);
                int height = view.getHeight();
                int width = view.getWidth();
                View contentView = activity.getLayoutInflater().inflate(R.layout.pop_guide, null);
                final PopupWindow popupWindow = new PopupWindow(contentView, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT, true);
                popupWindow.setTouchable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x60000000));
                if (listener != null) {
                    popupWindow.setOnDismissListener(listener);
                }
                GuideTextView gtv_content = (GuideTextView) contentView.findViewById(R.id.gtv_content);
                gtv_content.setText(sp);
                gtv_content.setMode(mode);
                gtv_content.measure(0, 0);
                int measuredHeight = gtv_content.getMeasuredHeight();
                int measuredWidth = gtv_content.getMeasuredWidth();
                int x = 0;
                int y = 0;
                int paddingLeft = gtv_content.getPaddingLeft();
                int paddingTop = gtv_content.getPaddingTop();
                int paddingRight = gtv_content.getPaddingRight();
                int paddingBottom = gtv_content.getPaddingBottom();
                switch (mode) {
                    case 0:
                        gtv_content.setPadding(paddingLeft * 2, paddingTop, paddingRight, paddingBottom);
                        x = location[0] + width + 10;
                        y = location[1] + (height - measuredHeight) / 2;
                        break;
                    case 1:
                        gtv_content.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom * 2);
                        x = location[0] + (width - measuredWidth) / 2;
                        y = location[1] - measuredHeight - 10;
                        break;
                    case 2:
                        gtv_content.setPadding(paddingLeft, paddingTop, paddingRight * 2, paddingBottom);
                        x = location[0] - measuredWidth - 10;
                        y = location[1] + (height - measuredHeight) / 2;

                        break;
                    case 3:
                        gtv_content.setPadding(paddingLeft, paddingTop * 2, paddingRight, paddingBottom);
                        x = location[0] + (width - measuredWidth) / 2;
                        y = location[1] + height + 10;
                        break;
                    case 4:
                        gtv_content.setPadding(paddingLeft, paddingTop * 2, paddingRight, paddingBottom);
                        x = location[0] + width / 2 - 30;
                        y = location[1] + height + 10;
                        break;
                    case 5:
                        gtv_content.setPadding(paddingLeft, paddingTop * 2, paddingRight, paddingBottom);
                        x = location[0] + width / 2 - measuredWidth + 30;
                        y = location[1] + height + 10;
                        break;
                    case 6:
                        gtv_content.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom * 2);
                        x = location[0] + width / 2 - 30;
                        y = location[1] - measuredHeight - 10;
                        break;
                    case 7:
                        gtv_content.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom * 2);
                        x = location[0] + width / 2 - measuredWidth + 30;
                        y = location[1] - measuredHeight - 10;
                        break;
                    case 8:
                        gtv_content.setPadding(paddingLeft, paddingTop * 2, paddingRight, paddingBottom);
                        x = location[0] + width / 2 - measuredWidth / 2;
                        y = location[1] + height / 2;
                        break;
                }

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gtv_content.getLayoutParams();
                layoutParams.setMargins(x, y, 0, 0);
                gtv_content.setLayoutParams(layoutParams);
                gtv_content.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (popupWindow != null && popupWindow.isShowing()) {
                            popupWindow.dismiss();
                        }
                    }
                });
                popupWindow.showAtLocation(view, 0, 0, 0);
                if (!TextUtils.isEmpty(guideName))
                    GuideSpUtil.getInstance(activity).setFlag(guideName);

            }
        });

    }

    int index;

    public void showGuides(final Activity activity, final View[] views, final Spannable[] sps, final int[] modes, final String[] guideNames) {
        int size = views.length;
        if (index < size) {
            showGuide(activity, views[index], sps[index], modes[index], guideNames[index], new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    index++;
                    showGuides(activity, views, sps, modes, guideNames);
                }
            });
        } else {
            index = 0;
            return;
        }

    }

}

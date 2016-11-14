package com.mesmerize.activitytest.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Just.T on 16/6/12.
 */
public class GuideSpUtil {


    private static GuideSpUtil guideSpUtil;
    private static SharedPreferences sharedPreferences;

    private GuideSpUtil() {
    }

    ;

    public static GuideSpUtil getInstance(Context context) {
        if (guideSpUtil == null) {
            synchronized (GuideSpUtil.class) {
                if (guideSpUtil == null) {
                    guideSpUtil = new GuideSpUtil();
                }
            }
        }
        sharedPreferences = context.getSharedPreferences("_guide", Context.MODE_PRIVATE);
        return guideSpUtil;
    }

    /**
     * 标记已经显示过的引导
     *
     * @param flag
     */
    public void setFlag(String flag) {
        sharedPreferences.edit().putBoolean(flag, false).commit();
    }

    /**
     * 获取该引导是否需要显示
     *
     * @param flag
     * @return
     */
    public boolean getFlag(String flag) {
        return sharedPreferences.getBoolean(flag, true);
    }
}

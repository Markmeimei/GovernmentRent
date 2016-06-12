package com.zxkj.governmentrent.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 林炜智 on 2015/8/27.
 * 用于完全退出程序
 */
public final class ExitApplicationUtil extends Application {
    private List<Activity> list = new ArrayList<Activity>();
    private static ExitApplicationUtil ea;

    private ExitApplicationUtil() {

    }

    public static ExitApplicationUtil getInstance() {
        if (ea == null) {
            ea = new ExitApplicationUtil();
        }
        return ea;
    }

    public void addActivity(Activity activity) {
        list.add(activity);
    }

    public void exit(Context context) {
        for (Activity activity : list) {
            activity.finish();
        }
        System.exit(0);
    }
}
package com.zxkj.governmentrent.widget.toast_control;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by 林炜智 on 2015-10-17.
 */
public class Toast_Common {

    public static void DefaultToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static void CenterToast(Context context, String content) {
        Toast toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}

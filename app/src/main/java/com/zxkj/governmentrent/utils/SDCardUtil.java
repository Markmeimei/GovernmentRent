package com.zxkj.governmentrent.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by 林炜智 on 2015-12-3.
 */
public final class SDCardUtil {

    /**
     * Don't let anyone instantiate this class.
     */
    private SDCardUtil() {
        throw new Error("Do not need instantiate!");
    }

    public static final File createFolder() {
        File file = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            //得到一个路径，sdcard/zxkj
            String path = Environment.getExternalStorageDirectory().getPath() + "/zxkj";
            file = new File(path);
            if (!file.exists()) {
                //若不存在，创建目录
                file.mkdirs();
            }
        }
        return file;
    }
}

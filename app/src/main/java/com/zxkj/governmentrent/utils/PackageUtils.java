package com.zxkj.governmentrent.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 林炜智 on 2016/4/12.
 * 手机App信息类
 */
public final class PackageUtils {

    /**
     * Don't let anyone instantiate this class.
     */
    private PackageUtils() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 查询手机内非系统应用
     *
     * @param context
     * @return
     */
    public static List<PackageInfo> getAllApps(Context context) {
        List<PackageInfo> apps = new ArrayList<>();
        PackageManager pManager = context.getPackageManager();
        //获取手机内所有应用
        List<PackageInfo> paklist = pManager.getInstalledPackages(0);
        for (int i = 0; i < paklist.size(); i++) {
            PackageInfo pak = (PackageInfo) paklist.get(i);
            //判断是否为非系统预装的应用程序
            if ((pak.applicationInfo.flags & pak.applicationInfo.FLAG_SYSTEM) <= 0) {
                // customs applications
                apps.add(pak);
            }
        }
        return apps;
    }

    /**
     * 查询手机内系统应用
     *
     * @param context
     * @return
     */
    public static List<PackageInfo> getAllSystemApps(Context context) {
        List<PackageInfo> apps = new ArrayList<>();
        PackageManager pManager = context.getPackageManager();
        //获取手机内所有应用
        List<PackageInfo> paklist = pManager.getInstalledPackages(0);
        for (int i = 0; i < paklist.size(); i++) {
            PackageInfo pak = (PackageInfo) paklist.get(i);
            //判断是否为非系统预装的应用程序
            if ((pak.applicationInfo.flags & pak.applicationInfo.FLAG_SYSTEM) <= 0) {
                // customs applications
            }else{
                apps.add(pak);
            }
        }
        return apps;
    }

    /**
     * 查询手机内所有支持分享的应用
     * @param context
     * @return
     */
    public static List<ResolveInfo> getShareApps(Context context){
        List<ResolveInfo> mApps = new ArrayList<>();
        Intent intent=new Intent(Intent.ACTION_SEND,null);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setType("text/plain");
        PackageManager pManager = context.getPackageManager();
        mApps = pManager.queryIntentActivities(intent,PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
        return mApps;
    }
}

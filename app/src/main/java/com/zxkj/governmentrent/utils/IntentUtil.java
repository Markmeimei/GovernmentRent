package com.zxkj.governmentrent.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;

import java.io.File;
import java.io.Serializable;

/**
 * Created by 林炜智 on 2015-11-9.
 * Intent常用工具类
 */
public final class IntentUtil {
    public static final String PHOTO_FILE_NAME = "Temp_Photo.jpg"; //头像名称
    private static final int output_X = 450;    //裁剪后图片的宽(X)
    private static final int output_Y = 450;    //裁剪后图片的高(Y)

    public static final int PHOTO_REQUEST_CAMERA = 1;   //照相机
    public static final int PHOTO_REQUEST_GALLERY = 2;   //相册
    public static final int PHOTO_REQUEST_CROP = 3;     //裁剪图片

    /**
     * Don't let anyone instantiate this class.
     */
    private IntentUtil() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 普通跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext) {
        Intent intent = new Intent(thisContext, toContext);
        thisContext.startActivity(intent);
    }

    /**
     * 传递Parcelable对象的跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext, String Key, Parcelable value) {
        Intent intent = new Intent(thisContext, toContext);
        intent.putExtra(Key, value);
        thisContext.startActivity(intent);
    }

    /**
     * 传递Serializable对象的跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext, String Key, Serializable value) {
        Intent intent = new Intent(thisContext, toContext);
        intent.putExtra(Key, value);
        thisContext.startActivity(intent);
    }

    /**
     * 传递String的跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext, String Key, String value) {
        Intent intent = new Intent(thisContext, toContext);
        intent.putExtra(Key, value);
        thisContext.startActivity(intent);
    }

    /**
     * 传递boolean的跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext, String Key, boolean value) {
        Intent intent = new Intent(thisContext, toContext);
        intent.putExtra(Key, value);
        thisContext.startActivity(intent);
    }

    /**
     * 传递int的跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext, String Key, int value) {
        Intent intent = new Intent(thisContext, toContext);
        intent.putExtra(Key, value);
        thisContext.startActivity(intent);
    }

    /**
     * 传递char的跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext, String Key, char value) {
        Intent intent = new Intent(thisContext, toContext);
        intent.putExtra(Key, value);
        thisContext.startActivity(intent);
    }

    /**
     * 传递byte的跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext, String Key, byte value) {
        Intent intent = new Intent(thisContext, toContext);
        intent.putExtra(Key, value);
        thisContext.startActivity(intent);
    }

    /**
     * 传递long的跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext, String Key, long value) {
        Intent intent = new Intent(thisContext, toContext);
        intent.putExtra(Key, value);
        thisContext.startActivity(intent);
    }

    /**
     * 传递float的跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext, String Key, float value) {
        Intent intent = new Intent(thisContext, toContext);
        intent.putExtra(Key, value);
        thisContext.startActivity(intent);
    }

    /**
     * 传递float的跳转
     */
    public static void goToContext(Context thisContext, Class<?> toContext, String Key, double value) {
        Intent intent = new Intent(thisContext, toContext);
        intent.putExtra(Key, value);
        thisContext.startActivity(intent);
    }

    /**
     * 跳转到应用
     */
    public static void goToContext(Context thisContext, String pkg, String cls) {
        Intent intent = new Intent();
        ComponentName componet = new ComponentName(pkg, cls);
        intent.setComponent(componet);
        thisContext.startActivity(intent);
    }


    /**
     * 调用系统发短信界面
     *
     * @param activity    Activity
     * @param phoneNumber 手机号码
     * @param smsContent  短信内容
     */
    public static void sendMessage(Context activity, String phoneNumber, String smsContent) {
        if (phoneNumber == null || phoneNumber.length() < 1) {
            return;
        }
        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", smsContent);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(it);
    }

    /**
     * 调用系统打电话界面，直接打电话
     *
     * @param context     上下文
     * @param phoneNumber 手机号码
     */
    public static void callPhone(Context context, String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() < 1) {
            return;
        }
        Uri uri = Uri.parse("tel:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 调用系统打电话界面
     *
     * @param context     上下文
     * @param phoneNumber 手机号码
     */
    public static void dialPhones(Context context, String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() < 3) {
            return;
        }
        Uri uri = Uri.parse("tel:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 调用系统相册
     */
    public static void openGallery(Activity context) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        context.startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
    }

    /**
     * 调用系统相机
     */
    public static void openCamera(Activity context) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //判断SD卡是否可用
        if (NetUtil.hasSDcard()) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME)));
        }
        context.startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }

    /**
     * 裁剪原始的图片
     */
    public static void cropPhoto(Activity context, Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");   //裁剪图片意图
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");    // 设置裁剪
        intent.putExtra("aspectX", 1);  //aspectX 宽 的比例
        intent.putExtra("aspectY", 1);  //aspectY 高 的比例
        intent.putExtra("outputX", output_X);   //outputX裁剪图片 宽
        intent.putExtra("outputY", output_Y);   //outputY裁剪图片 高
        intent.putExtra("outputFormat", "JPEG");    //图片格式
        intent.putExtra("noFaceDetection", true);   //取消人脸识别
        intent.putExtra("return-data", true);   //true:不返回uri, false:返回uri
        context.startActivityForResult(intent, PHOTO_REQUEST_CROP);
    }
}

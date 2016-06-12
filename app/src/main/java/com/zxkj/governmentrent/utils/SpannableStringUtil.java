package com.zxkj.governmentrent.utils;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;

/**
 * Created by 林炜智 on 2015-11-9.
 */
public final class SpannableStringUtil {

    /**
     * Don't let anyone instantiate this class.
     */
    private SpannableStringUtil() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 设置字体(1:default;  2:default-bold;  3:monospace;  4:serif;  5:sans-serif)
     * 默认：default；
     */
    public static CharSequence getTypeface(CharSequence value, int Typeface) {
        SpannableString spannableString = new SpannableString(value);
        String type = "default";
        if (Typeface == 1)
            type = "default";
        else if (Typeface == 2)
            type = "default-bold";
        else if (Typeface == 3)
            type = "monospace";
        else if (Typeface == 4)
            type = "serif";
        else if (Typeface == 5)
            type = "sans-serif";
        spannableString.setSpan(new TypefaceSpan(type), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 设置字体大小（绝对值,单位：px）
     * 第三个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素。
     */
    public static CharSequence getAbsoluteSize(CharSequence value, int size, boolean dip) {
        SpannableString spannableString = new SpannableString(value);
        spannableString.setSpan(new AbsoluteSizeSpan(size, dip), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 设置字体大小（相对值,单位：px） 参数表示为默认字体大小的多少倍
     * 0.5f表示默认字体大小的一半;  2.0f表示默认字体大小的两倍
     */
    public static CharSequence getRelativeSize(CharSequence value, float size) {
        SpannableString spannableString = new SpannableString(value);
        spannableString.setSpan(new RelativeSizeSpan(size), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 设置字体前景色
     */
    public static CharSequence getForegroundColor(CharSequence value, int color, int start, int over) {
        SpannableString spannableString = new SpannableString(value);
        spannableString.setSpan(new ForegroundColorSpan(color), start, over, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 设置字体背景色
     */
    public static CharSequence getBackgroundColor(CharSequence value, int color) {
        SpannableString spannableString = new SpannableString(value);
        spannableString.setSpan(new BackgroundColorSpan(color), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 设置字体样式(1:正常，2:粗体，3:斜体，4:粗斜体)
     */
    public static CharSequence getStyle(CharSequence value, int Typeface) {
        SpannableString spannableString = new SpannableString(value);
        int style = android.graphics.Typeface.NORMAL;
        if (Typeface == 1)
            style = android.graphics.Typeface.NORMAL;
        else if (Typeface == 2)
            style = android.graphics.Typeface.BOLD;
        else if (Typeface == 3)
            style = android.graphics.Typeface.ITALIC;
        else if (Typeface == 4)
            style = android.graphics.Typeface.BOLD_ITALIC;
        spannableString.setSpan(new StyleSpan(style), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 设置下划线
     */
    public static CharSequence getUnderline(CharSequence value) {
        SpannableString spannableString = new SpannableString(value);
        spannableString.setSpan(new UnderlineSpan(), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 设置删除线
     */
    public static CharSequence getStrikethrough(CharSequence value) {
        SpannableString spannableString = new SpannableString(value);
        spannableString.setSpan(new StrikethroughSpan(), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 设置下标
     */
    public static CharSequence getSubscript(CharSequence value) {
        SpannableString spannableString = new SpannableString(value);
        spannableString.setSpan(new SubscriptSpan(), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 设置上标
     */
    public static CharSequence getSuperscript(CharSequence value) {
        SpannableString spannableString = new SpannableString(value);
        spannableString.setSpan(new SuperscriptSpan(), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 设置字体大小（相对值,单位：px） 参数表示为默认字体宽度的多少倍
     */
    public static CharSequence getScaleX(CharSequence value, float size) {
        SpannableString spannableString = new SpannableString(value);
        spannableString.setSpan(new ScaleXSpan(size), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}

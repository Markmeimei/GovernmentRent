package com.zxkj.governmentrent.utils;

import java.text.DecimalFormat;

/**
 * Created by 林炜智 on 2015-11-6.
 * 保留小数点
 */
public final class DecimalFormatUtil {

    /**
     * Don't let anyone instantiate this class.
     */
    private DecimalFormatUtil() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * double 保留两位小数点
     */
    public static double setNum(double v) {
        DecimalFormat format = new DecimalFormat("##0.00");
        double Num = Double.valueOf(format.format(v)).doubleValue();
        return Num;
    }
}

package com.application.sxm.revie.util;

import android.os.Build;
import android.text.TextUtils;

import java.util.UUID;

/**
 * 用户信息辅助类
 * Created by shixiaoming on 18/9/7.
 */
public class UserInfoUtil {

    private static String deviceId = "";

    /**
     * 设备ID
     * @return
     */
    public static String getDeviceId(){

        if (!TextUtils.isEmpty(deviceId)){
            return deviceId;
        }
        String serial;
        String mDevShort = "35" +
                Build.BOARD.length()%10 + Build.BRAND.length()%10 +
                Build.CPU_ABI.length()%10 + Build.DEVICE.length()%10 +
                Build.DISPLAY.length()%10 + Build.HOST.length()%10 +
                Build.ID.length()%10 + Build.MANUFACTURER.length()%10 +
                Build.MODEL.length()%10 + Build.PRODUCT.length()%10 +
                Build.TAGS.length()%10 + Build.TYPE.length()%10 +
                Build.USER.length()%10;

        try {
            serial = Build.class.getField("SERIAL").get(null).toString();
            return deviceId = new UUID(mDevShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception e){
            serial = "serial";
        }

        return deviceId = new UUID(mDevShort.hashCode(), serial.hashCode()).toString();
    }

    /**
     * 手机品牌
     */
    public static String getDeviceBrand(){
        return Build.BRAND;
    }

    /**
     * 手机型号
     */
    public static String getDeviceModel(){
        return Build.MODEL;
    }

    /**
     * 系统版本
     */
    public static String getOsVersion(){
        return Build.VERSION.RELEASE;
    }
}

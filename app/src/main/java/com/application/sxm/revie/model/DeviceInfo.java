package com.application.sxm.revie.model;

import java.io.Serializable;

/**
 * 设备信息
 * Created by shixiaoming on 18/9/7.
 */
public class DeviceInfo  implements Serializable{
    private String deviceId;//设备ID
    private String deviceBrand;//手机品牌
    private String deviceModel;//手机型号
    private String osVersion;//android系统版本

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "deviceBrand=" + deviceBrand +
                ", deviceModel=" + deviceModel +
                ", osVersion=" + osVersion +
                ", deviceId=" + deviceId +
                "}";
    }
}

package com.avg.toolkit.zen.pojo;

public class DeviceReportsWrapper {
    private static final String PLATFORM = "android";
    public Object[] apps;
    public String hw_id;
    public String platform;
    public SharedData shared_data;

    public DeviceReportsWrapper() {
        this.platform = PLATFORM;
    }
}

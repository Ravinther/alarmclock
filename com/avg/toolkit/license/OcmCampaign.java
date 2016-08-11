package com.avg.toolkit.license;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.avg.toolkit.p049e.C0970a;
import java.io.Serializable;
import java.util.Calendar;

public class OcmCampaign implements Serializable {
    public static final Integer CDTD_MIN_VALUE;
    public static final String CYC_DEFUALT = "010000";
    public static final int EDA_NEVER = -2;
    public static final int ONE_DAY = 86400000;
    public static final Integer PER_DEFUALT;
    public static final int UNSUPPORTED_VERSION = -1;
    private static final long serialVersionUID = 1299775083056520854L;
    public long aie;
    public long ais;
    public String analytics;
    public Integer bee;
    public Integer bes;
    public CampaignState campaignState;
    public Integer cdtd;
    public String cyc;
    public long cycleStateStartTimeStamp;
    public String dden_text;
    public String dden_ticker;
    public long dden_time;
    public String dden_title;
    public Integer ebn;
    public long eda;
    public String evt;
    public int id;
    public boolean isDdeEvent;
    public long lastAppearence;
    public Integer lit;
    public String overlay_uri;
    public String[] ovl_evt;
    public Integer per;
    public Integer prd;
    public Integer sbn;
    public long sda;
    private String target;
    private TargetType targetType;
    public Integer var;

    public enum CampaignState {
        ACTIVE,
        DISABLED,
        NEED_TO_DELETE
    }

    public enum TargetType {
        UNDEFINED(0, "undefined"),
        OVERLAY(1, "ovr_scrn"),
        NOTIFICATION(2, "notification"),
        AD_MOB(3, "ad_mob");
        
        private int id;
        private String value;

        private TargetType(int id, String value) {
            this.id = id;
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public OcmCampaign() {
        this.dden_text = "";
        this.dden_time = -1;
        this.isDdeEvent = false;
        this.dden_title = "";
        this.dden_ticker = "";
    }

    static {
        PER_DEFUALT = Integer.valueOf(34);
        CDTD_MIN_VALUE = Integer.valueOf(2);
    }

    public static long getCurrentTimeInMillis() {
        return Calendar.getInstance().getTimeInMillis();
    }

    @SuppressLint({"NewApi"})
    public static long getAppFirstInstallTime(Context context) {
        try {
            if (VERSION.SDK_INT > 8) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            }
            return -1;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return 0;
        }
    }

    public void setTarget(TargetType target) {
        this.targetType = target;
    }

    public TargetType getTarget() {
        if (!TextUtils.isEmpty(this.target)) {
            if (TargetType.OVERLAY.getValue().equals(this.target)) {
                this.targetType = TargetType.OVERLAY;
            } else if (TargetType.AD_MOB.getValue().equals(this.target)) {
                this.targetType = TargetType.AD_MOB;
            } else if (TargetType.NOTIFICATION.getValue().equals(this.target)) {
                this.targetType = TargetType.NOTIFICATION;
            } else {
                this.targetType = TargetType.UNDEFINED;
            }
            this.target = null;
        }
        return this.targetType;
    }
}

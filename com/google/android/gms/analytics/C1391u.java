package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

/* renamed from: com.google.android.gms.analytics.u */
class C1391u {
    private static final C1391u tH;
    private SortedSet tE;
    private StringBuilder tF;
    private boolean tG;

    /* renamed from: com.google.android.gms.analytics.u.a */
    public enum C1390a {
        MAP_BUILDER_SET,
        MAP_BUILDER_SET_ALL,
        MAP_BUILDER_GET,
        MAP_BUILDER_SET_CAMPAIGN_PARAMS,
        BLANK_04,
        BLANK_05,
        BLANK_06,
        BLANK_07,
        BLANK_08,
        GET,
        SET,
        SEND,
        BLANK_12,
        BLANK_13,
        BLANK_14,
        BLANK_15,
        BLANK_16,
        BLANK_17,
        BLANK_18,
        BLANK_19,
        BLANK_20,
        BLANK_21,
        BLANK_22,
        BLANK_23,
        BLANK_24,
        BLANK_25,
        BLANK_26,
        BLANK_27,
        BLANK_28,
        BLANK_29,
        SET_EXCEPTION_PARSER,
        GET_EXCEPTION_PARSER,
        CONSTRUCT_TRANSACTION,
        CONSTRUCT_EXCEPTION,
        CONSTRUCT_RAW_EXCEPTION,
        CONSTRUCT_TIMING,
        CONSTRUCT_SOCIAL,
        BLANK_37,
        BLANK_38,
        GET_TRACKER,
        GET_DEFAULT_TRACKER,
        SET_DEFAULT_TRACKER,
        SET_APP_OPT_OUT,
        GET_APP_OPT_OUT,
        DISPATCH,
        SET_DISPATCH_PERIOD,
        BLANK_46,
        REPORT_UNCAUGHT_EXCEPTIONS,
        SET_AUTO_ACTIVITY_TRACKING,
        SET_SESSION_TIMEOUT,
        CONSTRUCT_EVENT,
        CONSTRUCT_ITEM,
        BLANK_52,
        BLANK_53,
        SET_DRY_RUN,
        GET_DRY_RUN,
        SET_LOGGER,
        SET_FORCE_LOCAL_DISPATCH,
        GET_TRACKER_NAME,
        CLOSE_TRACKER,
        EASY_TRACKER_ACTIVITY_START,
        EASY_TRACKER_ACTIVITY_STOP,
        CONSTRUCT_APP_VIEW
    }

    static {
        tH = new C1391u();
    }

    private C1391u() {
        this.tE = new TreeSet();
        this.tF = new StringBuilder();
        this.tG = false;
    }

    public static C1391u cy() {
        return tH;
    }

    public synchronized void m6035a(C1390a c1390a) {
        if (!this.tG) {
            this.tE.add(c1390a);
            this.tF.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(c1390a.ordinal()));
        }
    }

    public synchronized String cA() {
        String stringBuilder;
        if (this.tF.length() > 0) {
            this.tF.insert(0, ".");
        }
        stringBuilder = this.tF.toString();
        this.tF = new StringBuilder();
        return stringBuilder;
    }

    public synchronized String cz() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        int i = 6;
        int i2 = 0;
        while (this.tE.size() > 0) {
            C1390a c1390a = (C1390a) this.tE.first();
            this.tE.remove(c1390a);
            int ordinal = c1390a.ordinal();
            while (ordinal >= i) {
                stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
                i += 6;
                i2 = 0;
            }
            i2 += 1 << (c1390a.ordinal() % 6);
        }
        if (i2 > 0 || stringBuilder.length() == 0) {
            stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
        }
        this.tE.clear();
        return stringBuilder.toString();
    }

    public synchronized void m6036t(boolean z) {
        this.tG = z;
    }
}

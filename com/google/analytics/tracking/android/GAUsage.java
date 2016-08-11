package com.google.analytics.tracking.android;

import java.util.SortedSet;
import java.util.TreeSet;

class GAUsage {
    private static final GAUsage f4187d;
    private SortedSet f4188a;
    private StringBuilder f4189b;
    private boolean f4190c;

    public enum Field {
        TRACK_VIEW,
        TRACK_VIEW_WITH_APPSCREEN,
        TRACK_EVENT,
        TRACK_TRANSACTION,
        TRACK_EXCEPTION_WITH_DESCRIPTION,
        TRACK_EXCEPTION_WITH_THROWABLE,
        BLANK_06,
        TRACK_TIMING,
        TRACK_SOCIAL,
        GET,
        SET,
        SEND,
        SET_START_SESSION,
        BLANK_13,
        SET_APP_NAME,
        BLANK_15,
        SET_APP_VERSION,
        BLANK_17,
        SET_APP_SCREEN,
        GET_TRACKING_ID,
        SET_ANONYMIZE_IP,
        GET_ANONYMIZE_IP,
        SET_SAMPLE_RATE,
        GET_SAMPLE_RATE,
        SET_USE_SECURE,
        GET_USE_SECURE,
        SET_REFERRER,
        SET_CAMPAIGN,
        SET_APP_ID,
        GET_APP_ID,
        SET_EXCEPTION_PARSER,
        GET_EXCEPTION_PARSER,
        CONSTRUCT_TRANSACTION,
        CONSTRUCT_EXCEPTION,
        CONSTRUCT_RAW_EXCEPTION,
        CONSTRUCT_TIMING,
        CONSTRUCT_SOCIAL,
        SET_DEBUG,
        GET_DEBUG,
        GET_TRACKER,
        GET_DEFAULT_TRACKER,
        SET_DEFAULT_TRACKER,
        SET_APP_OPT_OUT,
        REQUEST_APP_OPT_OUT,
        DISPATCH,
        SET_DISPATCH_PERIOD,
        BLANK_48,
        REPORT_UNCAUGHT_EXCEPTIONS,
        SET_AUTO_ACTIVITY_TRACKING,
        SET_SESSION_TIMEOUT,
        CONSTRUCT_EVENT,
        CONSTRUCT_ITEM,
        SET_APP_INSTALLER_ID,
        GET_APP_INSTALLER_ID
    }

    static {
        f4187d = new GAUsage();
    }

    public static GAUsage m5726a() {
        return f4187d;
    }

    private GAUsage() {
        this.f4188a = new TreeSet();
        this.f4189b = new StringBuilder();
        this.f4190c = false;
    }

    public synchronized void m5728a(boolean disableUsage) {
        this.f4190c = disableUsage;
    }

    public synchronized void m5727a(Field field) {
        if (!this.f4190c) {
            this.f4188a.add(field);
            this.f4189b.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(field.ordinal()));
        }
    }

    public synchronized String m5729b() {
        StringBuilder result;
        result = new StringBuilder();
        int spot = 0;
        int nextBoundary = 6;
        while (this.f4188a.size() > 0) {
            Field f = (Field) this.f4188a.first();
            this.f4188a.remove(f);
            int nextLoc = f.ordinal();
            while (nextLoc >= nextBoundary) {
                result.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(spot));
                spot = 0;
                nextBoundary += 6;
            }
            spot += 1 << (f.ordinal() % 6);
        }
        if (spot > 0 || result.length() == 0) {
            result.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(spot));
        }
        this.f4188a.clear();
        return result.toString();
    }

    public synchronized String m5730c() {
        String result;
        if (this.f4189b.length() > 0) {
            this.f4189b.insert(0, ".");
        }
        result = this.f4189b.toString();
        this.f4189b = new StringBuilder();
        return result;
    }
}

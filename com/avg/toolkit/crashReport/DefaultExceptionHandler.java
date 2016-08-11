package com.avg.toolkit.crashReport;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;

public class DefaultExceptionHandler implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler f2920a;
    private Context f2921b;

    public static void setAsDefault(Context context) {
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof DefaultExceptionHandler)) {
            Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(context));
        }
    }

    public DefaultExceptionHandler(Context context) {
        this.f2920a = Thread.getDefaultUncaughtExceptionHandler();
        this.f2921b = context;
    }

    public void uncaughtException(Thread t, Throwable e) {
        CrashReport.reportCrash(this.f2921b, e);
        if (this.f2920a != null) {
            this.f2920a.uncaughtException(t, e);
        }
    }
}

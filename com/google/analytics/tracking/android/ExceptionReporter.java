package com.google.analytics.tracking.android;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler f4060a;
    private final Tracker f4061b;
    private final ServiceManager f4062c;
    private ExceptionParser f4063d;

    public void uncaughtException(Thread t, Throwable e) {
        String description = "";
        if (this.f4063d == null) {
            description = e.getMessage();
        } else {
            description = this.f4063d.m5637a(t != null ? t.getName() : null, e);
        }
        Log.m5755e("Tracking Exception: " + description);
        this.f4061b.m5608a(description, true);
        this.f4062c.m5642c();
        if (this.f4060a != null) {
            Log.m5755e("Passing exception to original handler.");
            this.f4060a.uncaughtException(t, e);
        }
    }
}

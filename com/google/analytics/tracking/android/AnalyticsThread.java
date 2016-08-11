package com.google.analytics.tracking.android;

import com.google.analytics.tracking.android.GoogleAnalytics.AppOptOutCallback;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

interface AnalyticsThread {

    public interface ClientIdCallback {
        void m5586a(String str);
    }

    void m5587a();

    void m5588a(ClientIdCallback clientIdCallback);

    void m5589a(AppOptOutCallback appOptOutCallback);

    void m5590a(Map map);

    LinkedBlockingQueue m5591b();

    Thread m5592c();
}

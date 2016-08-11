package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

public class EasyTracker {
    private boolean f4052a;
    private int f4053b;
    private boolean f4054c;
    private int f4055d;
    private final Map f4056e;
    private Tracker f4057f;
    private Clock f4058g;
    private boolean f4059h;

    /* renamed from: com.google.analytics.tracking.android.EasyTracker.1 */
    class C13151 implements Clock {
        final /* synthetic */ EasyTracker f4041a;

        C13151(EasyTracker easyTracker) {
            this.f4041a = easyTracker;
        }

        public long m5596a() {
            return System.currentTimeMillis();
        }
    }

    class NoopTracker extends Tracker {
        private double f4050a;

        public void m5623a(String appName) {
        }

        public void m5632b(String appVersion) {
        }

        public void m5633c(String appScreen) {
        }

        public void m5625a(String category, String action, String label, Long value) {
        }

        public void m5622a(Transaction transaction) {
        }

        public void m5626a(String description, boolean fatal) {
        }

        public void m5624a(String category, long intervalInMilliseconds, String name, String label) {
        }

        public void m5619a(double sampleRate) {
            this.f4050a = sampleRate;
        }

        public void m5634d(String referrer) {
        }

        public void m5635e(String campaign) {
        }

        public Map m5630b(String category, String action, String label, Long value) {
            return new HashMap();
        }

        public Map m5628b(Transaction trans) {
            return new HashMap();
        }

        public Map m5631b(String exceptionDescription, boolean fatal) {
            return new HashMap();
        }

        public Map m5629b(String category, long intervalInMilliseconds, String name, String label) {
            return new HashMap();
        }

        public void m5621a(int slot, String value) {
        }

        public void m5620a(int slot, Long value) {
        }

        public void m5627a(Map dimensions, Map metrics) {
        }
    }

    private class NotInForegroundTimerTask extends TimerTask {
        final /* synthetic */ EasyTracker f4051a;

        public void run() {
            this.f4051a.f4059h = false;
        }
    }

    private EasyTracker() {
        this.f4052a = false;
        this.f4053b = 1800;
        this.f4054c = false;
        this.f4055d = 0;
        this.f4056e = new HashMap();
        this.f4057f = null;
        this.f4059h = false;
        this.f4058g = new C13151(this);
    }
}

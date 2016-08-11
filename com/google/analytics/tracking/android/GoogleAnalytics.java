package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.analytics.tracking.android.AnalyticsThread.ClientIdCallback;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GoogleAnalytics implements TrackerHandler {
    private static GoogleAnalytics f4193i;
    private AnalyticsThread f4194a;
    private Context f4195b;
    private Tracker f4196c;
    private AdHitIdGenerator f4197d;
    private volatile String f4198e;
    private volatile Boolean f4199f;
    private final Map f4200g;
    private String f4201h;

    public interface AppOptOutCallback {
        void m5731a(boolean z);
    }

    /* renamed from: com.google.analytics.tracking.android.GoogleAnalytics.1 */
    class C13261 implements AppOptOutCallback {
        final /* synthetic */ GoogleAnalytics f4191a;

        C13261(GoogleAnalytics googleAnalytics) {
            this.f4191a = googleAnalytics;
        }

        public void m5732a(boolean optOut) {
            this.f4191a.f4199f = Boolean.valueOf(optOut);
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GoogleAnalytics.2 */
    class C13272 implements ClientIdCallback {
        final /* synthetic */ GoogleAnalytics f4192a;

        C13272(GoogleAnalytics googleAnalytics) {
            this.f4192a = googleAnalytics;
        }

        public void m5733a(String clientId) {
            this.f4192a.f4198e = clientId;
        }
    }

    @VisibleForTesting
    GoogleAnalytics() {
        this.f4200g = new HashMap();
    }

    private GoogleAnalytics(Context context) {
        this(context, GAThread.m5691a(context));
    }

    private GoogleAnalytics(Context context, AnalyticsThread thread) {
        this.f4200g = new HashMap();
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.f4195b = context.getApplicationContext();
        this.f4194a = thread;
        this.f4197d = new AdHitIdGenerator();
        this.f4194a.m5589a(new C13261(this));
        this.f4194a.m5588a(new C13272(this));
    }

    public static GoogleAnalytics m5735a(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (f4193i == null) {
                f4193i = new GoogleAnalytics(context);
            }
            googleAnalytics = f4193i;
        }
        return googleAnalytics;
    }

    public Tracker m5738a(String trackingId) {
        Tracker tracker;
        synchronized (this) {
            if (trackingId == null) {
                throw new IllegalArgumentException("trackingId cannot be null");
            }
            tracker = (Tracker) this.f4200g.get(trackingId);
            if (tracker == null) {
                tracker = new Tracker(trackingId, this);
                this.f4200g.put(trackingId, tracker);
                if (this.f4196c == null) {
                    this.f4196c = tracker;
                }
            }
            GAUsage.m5726a().m5727a(Field.GET_TRACKER);
        }
        return tracker;
    }

    public void m5739a(Map hit) {
        synchronized (this) {
            if (hit == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            hit.put("language", Utils.m5843a(Locale.getDefault()));
            hit.put("adSenseAdMobHitId", Integer.toString(this.f4197d.m5557a()));
            hit.put("screenResolution", this.f4195b.getResources().getDisplayMetrics().widthPixels + "x" + this.f4195b.getResources().getDisplayMetrics().heightPixels);
            hit.put("usage", GAUsage.m5726a().m5730c());
            GAUsage.m5726a().m5729b();
            this.f4194a.m5590a(hit);
            this.f4201h = (String) hit.get("trackingId");
        }
    }
}

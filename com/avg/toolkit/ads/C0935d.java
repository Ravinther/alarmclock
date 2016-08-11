package com.avg.toolkit.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.View.OnClickListener;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import java.util.Locale;

/* renamed from: com.avg.toolkit.ads.d */
public class C0935d extends C0924a {
    WebViewAdsManager f2778c;
    Activity f2779d;
    private final String f2780e;
    private final String f2781f;

    /* renamed from: com.avg.toolkit.ads.d.1 */
    class C09331 implements Runnable {
        final /* synthetic */ C0935d f2775a;

        /* renamed from: com.avg.toolkit.ads.d.1.1 */
        class C09321 implements Runnable {
            final /* synthetic */ C09331 f2774a;

            C09321(C09331 c09331) {
                this.f2774a = c09331;
            }

            public void run() {
                if (this.f2774a.f2775a.a) {
                    this.f2774a.f2775a.m4226a(true);
                }
            }
        }

        C09331(C0935d c0935d) {
            this.f2775a = c0935d;
        }

        public void run() {
            this.f2775a.f2779d.runOnUiThread(new C09321(this));
        }
    }

    /* renamed from: com.avg.toolkit.ads.d.2 */
    class C09342 implements OnClickListener {
        final /* synthetic */ String f2776a;
        final /* synthetic */ C0935d f2777b;

        C09342(C0935d c0935d, String str) {
            this.f2777b = c0935d;
            this.f2776a = str;
        }

        public void onClick(View v) {
            GoogleAnalyticsWrapper.trackEvent(this.f2777b.f2779d, "AdsManager_avg", AdsManager.ANALYTICS_ACTION_CLICK, this.f2776a, 0);
        }
    }

    public C0935d() {
        this.f2780e = "_avg";
        this.f2781f = "avg";
    }

    public void m4242a(Activity activity, AdsManager manager, String providerId, String adId, String lng, boolean showAdsInLandscape) {
        this.f2779d = activity;
        this.f2778c = new WebViewAdsManager(activity);
        this.f2778c.setAdLoadedListener(new C09331(this));
        m4222a(manager, this.f2778c);
        this.f2778c.initAds(activity, Locale.getDefault().getDisplayName(), adId, null, showAdsInLandscape);
        this.f2778c.setOnClickListener(new C09342(this, adId));
        GoogleAnalyticsWrapper.trackEvent((Context) activity, "AdsManager_avg", AdsManager.ANALYTICS_ACTION_IMPRESSION, adId, 0);
        C0931c.m4240a(activity, "avg", adId);
    }

    public void m4243a(Context context, Configuration newConfig) {
        this.f2778c.onConfigurationChanged(this.f2779d, newConfig);
    }

    protected void m4241a() {
        if (this.f2778c != null) {
            this.f2778c.stop();
        }
    }

    protected void m4244b() {
    }

    protected void m4245c() {
    }
}

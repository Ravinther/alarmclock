package com.avg.toolkit.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/* renamed from: com.avg.toolkit.ads.b */
public class C0929b extends C0924a {
    private final String f2765c;
    private final String f2766d;
    private AdView f2767e;
    private Activity f2768f;
    private String f2769g;
    private long f2770h;

    /* renamed from: com.avg.toolkit.ads.b.a */
    private class C0928a extends AdListener {
        final /* synthetic */ C0929b f2764a;

        /* renamed from: com.avg.toolkit.ads.b.a.1 */
        class C09261 implements Runnable {
            final /* synthetic */ C0928a f2762a;

            C09261(C0928a c0928a) {
                this.f2762a = c0928a;
            }

            public void run() {
                if (this.f2762a.f2764a.a) {
                    this.f2762a.f2764a.f2767e.setVisibility(0);
                    this.f2762a.f2764a.m4226a(true);
                    GoogleAnalyticsWrapper.trackEvent(this.f2762a.f2764a.f2768f, "AdsManager_admob", AdsManager.ANALYTICS_ACTION_IMPRESSION, this.f2762a.f2764a.f2769g, 0);
                    C0931c.m4240a(this.f2762a.f2764a.f2768f, "admob", this.f2762a.f2764a.f2769g);
                    if (this.f2762a.f2764a.f2770h != 0) {
                        long timing = SystemClock.elapsedRealtime() - this.f2762a.f2764a.f2770h;
                        this.f2762a.f2764a.f2770h = 0;
                        GoogleAnalyticsWrapper.sendTiming(this.f2762a.f2764a.f2768f, AdsManager.ANALYTICS_CATEGORY, "admob", "", Long.valueOf(timing), null, null);
                    }
                }
            }
        }

        /* renamed from: com.avg.toolkit.ads.b.a.2 */
        class C09272 implements Runnable {
            final /* synthetic */ C0928a f2763a;

            C09272(C0928a c0928a) {
                this.f2763a = c0928a;
            }

            public void run() {
                if (this.f2763a.f2764a.a) {
                    this.f2763a.f2764a.m4226a(false);
                }
            }
        }

        private C0928a(C0929b c0929b) {
            this.f2764a = c0929b;
        }

        public void onAdLeftApplication() {
        }

        public void onAdOpened() {
            GoogleAnalyticsWrapper.trackEvent(this.f2764a.f2768f, "AdsManager_admob", AdsManager.ANALYTICS_ACTION_CLICK + (TextUtils.isEmpty(this.f2764a.b) ? "" : "_" + this.f2764a.b), this.f2764a.f2769g, 0);
        }

        public void onAdLoaded() {
            this.f2764a.f2768f.runOnUiThread(new C09261(this));
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f2764a.f2768f.runOnUiThread(new C09272(this));
        }
    }

    public C0929b() {
        this.f2765c = "_admob";
        this.f2766d = "admob";
        this.f2770h = 0;
    }

    public void m4236a(Activity activity, AdsManager manager, String providerId, String adId, String lng, boolean showAdsInLandscape) {
        if (VERSION.SDK_INT > 8) {
            this.f2768f = activity;
            this.f2769g = adId;
            this.f2770h = SystemClock.elapsedRealtime();
            this.f2767e = new AdView(activity);
            this.f2767e.setAdSize(AdSize.SMART_BANNER);
            this.f2767e.setAdUnitId(adId);
            this.f2767e.setAdListener(new C0928a());
            this.f2767e.setVisibility(8);
            m4222a(manager, this.f2767e);
            this.f2767e.loadAd(new Builder().build());
        }
    }

    public void m4237a(Context context, Configuration newConfig) {
    }

    protected void m4235a() {
        if (this.f2767e != null) {
            this.f2767e.destroy();
        }
    }

    public void m4238b() {
        if (this.f2767e != null) {
            this.f2767e.pause();
        }
    }

    public void m4239c() {
        if (this.f2767e != null) {
            this.f2767e.resume();
        }
    }
}

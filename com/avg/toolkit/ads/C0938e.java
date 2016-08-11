package com.avg.toolkit.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout.LayoutParams;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;

/* renamed from: com.avg.toolkit.ads.e */
public class C0938e extends C0924a implements BannerAdListener {
    private final String f2784c;
    private final String f2785d;
    private MoPubView f2786e;
    private Activity f2787f;
    private String f2788g;
    private long f2789h;

    /* renamed from: com.avg.toolkit.ads.e.1 */
    class C09361 implements Runnable {
        final /* synthetic */ C0938e f2782a;

        C09361(C0938e c0938e) {
            this.f2782a = c0938e;
        }

        public void run() {
            if (this.f2782a.a) {
                this.f2782a.m4226a(false);
            }
        }
    }

    /* renamed from: com.avg.toolkit.ads.e.2 */
    class C09372 implements Runnable {
        final /* synthetic */ C0938e f2783a;

        C09372(C0938e c0938e) {
            this.f2783a = c0938e;
        }

        public void run() {
            if (this.f2783a.a) {
                this.f2783a.f2786e.setVisibility(0);
                this.f2783a.m4226a(true);
                GoogleAnalyticsWrapper.trackEvent(this.f2783a.f2787f, "AdsManager_mopub", AdsManager.ANALYTICS_ACTION_IMPRESSION, this.f2783a.f2788g, 0);
                C0931c.m4240a(this.f2783a.f2787f, "mopub", this.f2783a.f2788g);
                if (this.f2783a.f2789h != 0) {
                    long timing = SystemClock.elapsedRealtime() - this.f2783a.f2789h;
                    this.f2783a.f2789h = 0;
                    GoogleAnalyticsWrapper.sendTiming(this.f2783a.f2787f, AdsManager.ANALYTICS_CATEGORY, "mopub", "", Long.valueOf(timing), null, null);
                }
            }
        }
    }

    public C0938e() {
        this.f2784c = "_mopub";
        this.f2785d = "mopub";
        this.f2789h = 0;
    }

    public void m4252a(Activity activity, AdsManager manager, String providerId, String adId, String lng, boolean showAdsInLandscape) {
        this.f2787f = activity;
        this.f2788g = adId;
        this.f2789h = SystemClock.elapsedRealtime();
        this.f2786e = new MoPubView(activity);
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        this.f2786e.setVisibility(8);
        this.f2786e.setAdUnitId(adId);
        this.f2786e.setBannerAdListener(this);
        LayoutParams flp = new LayoutParams((int) (320.0d * (((double) metrics.densityDpi) / 160.0d)), (int) (50.0d * (((double) metrics.densityDpi) / 160.0d)));
        flp.gravity = 1;
        m4223a(manager, this.f2786e, flp);
        this.f2786e.loadAd();
    }

    public void m4253a(Context context, Configuration newConfig) {
    }

    protected void m4251a() {
        this.f2786e.destroy();
    }

    public void onBannerClicked(MoPubView arg0) {
        GoogleAnalyticsWrapper.trackEvent(this.f2787f, "AdsManager_mopub", AdsManager.ANALYTICS_ACTION_CLICK + (TextUtils.isEmpty(this.b) ? "" : "_" + this.b), this.f2788g, 0);
    }

    public void onBannerCollapsed(MoPubView arg0) {
    }

    public void onBannerExpanded(MoPubView arg0) {
    }

    public void onBannerFailed(MoPubView arg0, MoPubErrorCode arg1) {
        this.f2787f.runOnUiThread(new C09361(this));
    }

    public void onBannerLoaded(MoPubView view) {
        this.f2787f.runOnUiThread(new C09372(this));
    }

    protected void m4254b() {
    }

    protected void m4255c() {
    }
}

package com.avg.toolkit.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

/* renamed from: com.avg.toolkit.ads.a */
public abstract class C0924a {
    protected boolean f2759a;
    protected String f2760b;
    private C0910a f2761c;

    /* renamed from: com.avg.toolkit.ads.a.a */
    public interface C0910a {
        void m4170a(boolean z);
    }

    protected abstract void m4219a();

    public abstract void m4220a(Activity activity, AdsManager adsManager, String str, String str2, String str3, boolean z);

    public abstract void m4221a(Context context, Configuration configuration);

    protected abstract void m4227b();

    protected abstract void m4228c();

    public C0924a() {
        this.f2759a = true;
    }

    public void m4229d() {
        m4219a();
        this.f2759a = false;
    }

    protected void m4222a(AdsManager manager, View ad) {
        m4223a(manager, ad, null);
    }

    protected void m4223a(AdsManager manager, View ad, LayoutParams layoutParams) {
        if (layoutParams == null) {
            manager.addView(ad, 0);
        } else {
            manager.addView(ad, 0, layoutParams);
        }
    }

    public void m4224a(C0910a adProviderChangeListener) {
        this.f2761c = adProviderChangeListener;
    }

    protected void m4226a(boolean adDisplayed) {
        if (this.f2761c != null) {
            this.f2761c.m4170a(adDisplayed);
        }
    }

    public void m4225a(String screen) {
        this.f2760b = screen;
    }
}

package com.anglelabs.alarmclock.redesign.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.views.AdsContaienrView;
import com.avg.toolkit.ads.AdsManager;
import com.avg.toolkit.ads.AdsManager.C0792a;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.b */
public final class C0794b {

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.b.1 */
    static class C07931 implements C0792a {
        final /* synthetic */ boolean f2104a;
        final /* synthetic */ AdsContaienrView f2105b;

        C07931(boolean z, AdsContaienrView adsContaienrView) {
            this.f2104a = z;
            this.f2105b = adsContaienrView;
        }

        public void m3777a(boolean adDisplayed) {
            if (this.f2104a) {
                if (adDisplayed) {
                    this.f2105b.m4070a();
                } else {
                    this.f2105b.m4071b();
                }
            } else if (adDisplayed) {
                if (this.f2105b.getVisibility() != 0) {
                    this.f2105b.setVisibility(0);
                }
                this.f2105b.m4070a();
            }
        }
    }

    public static void m3779a(Activity activity, int categoryResId, boolean showOnLandscape) {
        C0794b.m3781a(activity, activity.getString(categoryResId), showOnLandscape);
    }

    public static void m3778a(Activity activity) {
        try {
            C0794b.m3790g(activity).setVisibility(8);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void m3785b(Activity activity) {
        try {
            C0794b.m3790g(activity).setVisibility(0);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void m3781a(Activity activity, String category, boolean showOnLandscape) {
        C0794b.m3782a(activity, category, showOnLandscape, true);
    }

    public static void m3782a(Activity activity, String category, boolean showOnLandscape, boolean showPlaceholder) {
        if (TextUtils.isEmpty(category)) {
            C0970a.m4325b("category is empty, aborting!");
            return;
        }
        try {
            AdsContaienrView adsContaienrView = C0794b.m3790g(activity);
            AdsManager manager = adsContaienrView.getAdsManager();
            C0794b.m3786c(activity);
            manager.init(activity, category, showOnLandscape, new C07931(showPlaceholder, adsContaienrView));
        } catch (NoSuchFieldException e) {
        }
    }

    public static void m3786c(Activity activity) {
        try {
            C0794b.m3789f(activity).resume();
            C0794b.m3783a((Context) activity);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void m3787d(Activity activity) {
        try {
            ViewGroup adsManager = C0794b.m3789f(activity);
            C0794b.m3784a(adsManager);
            adsManager.pause();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void m3788e(Activity activity) {
        try {
            ViewGroup adsManager = C0794b.m3789f(activity);
            C0794b.m3784a(adsManager);
            adsManager.stop();
        } catch (NoSuchFieldException e) {
        }
    }

    public static void m3780a(Activity activity, String ownerName) {
        try {
            C0794b.m3789f(activity).setOwnerScreen(ownerName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void m3784a(ViewGroup v) {
        for (int i = 0; i < v.getChildCount(); i++) {
            View child = v.getChildAt(i);
            if (child instanceof WebView) {
                ((WebView) child).pauseTimers();
            }
            try {
                C0794b.m3784a((ViewGroup) child);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void m3783a(Context context) {
        new WebView(context).resumeTimers();
    }

    private static AdsManager m3789f(Activity activity) {
        return C0794b.m3790g(activity).getAdsManager();
    }

    private static AdsContaienrView m3790g(Activity activity) {
        AdsContaienrView adsContaienrView = (AdsContaienrView) activity.findViewById(R.id.adsContainerView);
        if (adsContaienrView != null) {
            return adsContaienrView;
        }
        C0970a.m4325b("AdsContaienrView is null, aborting! \n make sure you have it on the layout with id:adsContainerView. ");
        throw new NoSuchFieldException("");
    }
}

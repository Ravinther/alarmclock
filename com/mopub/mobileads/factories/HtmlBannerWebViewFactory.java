package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdConfiguration;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.HtmlBannerWebView;

public class HtmlBannerWebViewFactory {
    protected static HtmlBannerWebViewFactory instance;

    static {
        instance = new HtmlBannerWebViewFactory();
    }

    public static HtmlBannerWebView create(Context context, CustomEventBannerListener customEventBannerListener, boolean isScrollable, String redirectUrl, String clickthroughUrl, AdConfiguration adConfiguration) {
        return instance.internalCreate(context, customEventBannerListener, isScrollable, redirectUrl, clickthroughUrl, adConfiguration);
    }

    public HtmlBannerWebView internalCreate(Context context, CustomEventBannerListener customEventBannerListener, boolean isScrollable, String redirectUrl, String clickthroughUrl, AdConfiguration adConfiguration) {
        HtmlBannerWebView htmlBannerWebView = new HtmlBannerWebView(context, adConfiguration);
        htmlBannerWebView.init(customEventBannerListener, isScrollable, redirectUrl, clickthroughUrl);
        return htmlBannerWebView;
    }

    @Deprecated
    public static void setInstance(HtmlBannerWebViewFactory factory) {
        instance = factory;
    }
}

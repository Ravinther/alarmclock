package com.mopub.mobileads;

import android.content.Context;
import android.net.Uri;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.MraidView.MraidListener;
import com.mopub.mobileads.MraidView.ViewState;
import com.mopub.mobileads.factories.MraidViewFactory;
import java.util.Map;

class MraidBanner extends CustomEventBanner {
    private CustomEventBannerListener mBannerListener;
    private MraidView mMraidView;

    /* renamed from: com.mopub.mobileads.MraidBanner.1 */
    class C26101 implements MraidListener {
        C26101() {
        }

        public void onReady(MraidView view) {
            MraidBanner.this.onReady();
        }

        public void onFailure(MraidView view) {
            MraidBanner.this.onFail();
        }

        public void onExpand(MraidView view) {
            MraidBanner.this.onExpand();
        }

        public void onOpen(MraidView view) {
            MraidBanner.this.onOpen();
        }

        public void onClose(MraidView view, ViewState newViewState) {
            MraidBanner.this.onClose();
        }
    }

    MraidBanner() {
    }

    protected void loadBanner(Context context, CustomEventBannerListener customEventBannerListener, Map localExtras, Map serverExtras) {
        this.mBannerListener = customEventBannerListener;
        if (extrasAreValid(serverExtras)) {
            String htmlData = Uri.decode((String) serverExtras.get(AdFetcher.HTML_RESPONSE_BODY_KEY));
            this.mMraidView = MraidViewFactory.create(context, AdConfiguration.extractFromMap(localExtras));
            this.mMraidView.loadHtmlData(htmlData);
            initMraidListener();
            return;
        }
        this.mBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
    }

    protected void onInvalidate() {
        if (this.mMraidView != null) {
            resetMraidListener();
            this.mMraidView.destroy();
        }
    }

    private void onReady() {
        this.mBannerListener.onBannerLoaded(this.mMraidView);
    }

    private void onFail() {
        this.mBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
    }

    private void onExpand() {
        this.mBannerListener.onBannerExpanded();
        this.mBannerListener.onBannerClicked();
    }

    private void onOpen() {
        this.mBannerListener.onBannerClicked();
    }

    private void onClose() {
        this.mBannerListener.onBannerCollapsed();
    }

    private boolean extrasAreValid(Map serverExtras) {
        return serverExtras.containsKey(AdFetcher.HTML_RESPONSE_BODY_KEY);
    }

    private void initMraidListener() {
        this.mMraidView.setMraidListener(new C26101());
    }

    private void resetMraidListener() {
        this.mMraidView.setMraidListener(null);
    }
}

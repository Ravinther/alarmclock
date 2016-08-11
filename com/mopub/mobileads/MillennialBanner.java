package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMBroadcastReceiver;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import java.util.Map;

class MillennialBanner extends CustomEventBanner {
    public static final String AD_HEIGHT_KEY = "adHeight";
    public static final String AD_WIDTH_KEY = "adWidth";
    public static final String APID_KEY = "adUnitID";
    private CustomEventBannerListener mBannerListener;
    private MillennialBroadcastReceiver mBroadcastReceiver;
    private MMAdView mMillennialAdView;

    class MillennialBroadcastReceiver extends MMBroadcastReceiver {
        private Context mContext;

        MillennialBroadcastReceiver() {
        }

        public void getAdSuccess(MMAd ad) {
            super.getAdSuccess(ad);
            Log.d("MoPub", "Millennial banner ad loaded successfully. Showing ad...");
            MillennialBanner.this.mBannerListener.onBannerLoaded(MillennialBanner.this.mMillennialAdView);
        }

        public void getAdFailure(MMAd ad) {
            super.getAdFailure(ad);
            Log.d("MoPub", "Millennial banner ad failed to load.");
            MillennialBanner.this.mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }

        public void intentStarted(MMAd ad, String intent) {
            super.intentStarted(ad, intent);
            Log.d("MoPub", "Millennial banner ad clicked.");
            MillennialBanner.this.mBannerListener.onBannerClicked();
        }

        void register(Context context) {
            this.mContext = context;
            context.registerReceiver(this, MMBroadcastReceiver.createIntentFilter());
        }

        void unregister() {
            try {
                this.mContext.unregisterReceiver(this);
            } catch (Exception exception) {
                Log.d("MoPub", "Unable to unregister MMBroadcastReceiver", exception);
            } finally {
                this.mContext = null;
            }
        }
    }

    MillennialBanner() {
    }

    protected void loadBanner(Context context, CustomEventBannerListener customEventBannerListener, Map localExtras, Map serverExtras) {
        this.mBannerListener = customEventBannerListener;
        if (extrasAreValid(serverExtras)) {
            String apid = (String) serverExtras.get(APID_KEY);
            int width = Integer.parseInt((String) serverExtras.get(AD_WIDTH_KEY));
            int height = Integer.parseInt((String) serverExtras.get(AD_HEIGHT_KEY));
            MMSDK.initialize(context);
            MMSDK.setBroadcastEvents(true);
            this.mBroadcastReceiver = new MillennialBroadcastReceiver();
            this.mBroadcastReceiver.register(context);
            this.mMillennialAdView = new MMAdView(context);
            this.mMillennialAdView.setApid(apid);
            this.mMillennialAdView.setWidth(width);
            this.mMillennialAdView.setHeight(height);
            Location location = (Location) localExtras.get("location");
            if (location != null) {
                MMRequest.setUserLocation(location);
            }
            this.mMillennialAdView.setMMRequest(new MMRequest());
            this.mMillennialAdView.setId(MMSDK.getDefaultAdId());
            AdViewController.setShouldHonorServerDimensions(this.mMillennialAdView);
            this.mMillennialAdView.getAd();
            return;
        }
        this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    private boolean extrasAreValid(Map serverExtras) {
        try {
            Integer.parseInt((String) serverExtras.get(AD_WIDTH_KEY));
            Integer.parseInt((String) serverExtras.get(AD_HEIGHT_KEY));
            return serverExtras.containsKey(APID_KEY);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected void onInvalidate() {
        this.mMillennialAdView.setListener(null);
        this.mBroadcastReceiver.unregister();
    }

    @Deprecated
    MMAdView getMMAdView() {
        return this.mMillennialAdView;
    }
}

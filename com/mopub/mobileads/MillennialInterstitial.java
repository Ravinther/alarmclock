package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMBroadcastReceiver;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

class MillennialInterstitial extends CustomEventInterstitial {
    public static final String APID_KEY = "adUnitID";
    private MillennialBroadcastReceiver mBroadcastReceiver;
    private CustomEventInterstitialListener mInterstitialListener;
    private MMInterstitial mMillennialInterstitial;

    class MillennialBroadcastReceiver extends MMBroadcastReceiver {
        private Context mContext;

        MillennialBroadcastReceiver() {
        }

        public void fetchFinishedCaching(MMAd ad) {
            super.fetchFinishedCaching(ad);
            fetchFinished(MoPubErrorCode.NETWORK_INVALID_STATE);
        }

        public void getAdFailure(MMAd ad) {
            super.getAdFailure(ad);
            Log.d("MoPub", "Millennial interstitial ad failed to load.");
            MillennialInterstitial.this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }

        public void intentStarted(MMAd ad, String intent) {
            super.intentStarted(ad, intent);
            Log.d("MoPub", "Millennial interstitial ad clicked.");
            MillennialInterstitial.this.mInterstitialListener.onInterstitialClicked();
        }

        public void fetchFailure(MMAd ad) {
            super.fetchFailure(ad);
            fetchFinished(MoPubErrorCode.NETWORK_NO_FILL);
        }

        public void displayStarted(MMAd ad) {
            super.displayStarted(ad);
            Log.d("MoPub", "Showing Millennial interstitial ad.");
            MillennialInterstitial.this.mInterstitialListener.onInterstitialShown();
        }

        public void overlayClosed(MMAd ad) {
            super.overlayClosed(ad);
            Log.d("MoPub", "Millennial interstitial ad dismissed.");
            MillennialInterstitial.this.mInterstitialListener.onInterstitialDismissed();
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

        private void fetchFinished(MoPubErrorCode errorToReport) {
            if (MillennialInterstitial.this.mMillennialInterstitial.isAdAvailable()) {
                Log.d("MoPub", "Millennial interstitial ad loaded successfully.");
                MillennialInterstitial.this.mInterstitialListener.onInterstitialLoaded();
                return;
            }
            Log.d("MoPub", "Millennial interstitial ad failed to load.");
            MillennialInterstitial.this.mInterstitialListener.onInterstitialFailed(errorToReport);
        }
    }

    MillennialInterstitial() {
    }

    protected void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map localExtras, Map serverExtras) {
        this.mInterstitialListener = customEventInterstitialListener;
        if (extrasAreValid(serverExtras)) {
            String apid = (String) serverExtras.get(APID_KEY);
            MMSDK.initialize(context);
            MMSDK.setBroadcastEvents(true);
            this.mBroadcastReceiver = new MillennialBroadcastReceiver();
            this.mBroadcastReceiver.register(context);
            Location location = (Location) localExtras.get("location");
            if (location != null) {
                MMRequest.setUserLocation(location);
            }
            this.mMillennialInterstitial = new MMInterstitial(context);
            if (this.mMillennialInterstitial.isAdAvailable()) {
                Log.d("MoPub", "Millennial interstitial ad already loaded.");
                this.mInterstitialListener.onInterstitialLoaded();
                return;
            }
            this.mMillennialInterstitial.setMMRequest(new MMRequest());
            this.mMillennialInterstitial.setApid(apid);
            this.mMillennialInterstitial.fetch();
            return;
        }
        this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    protected void showInterstitial() {
        if (this.mMillennialInterstitial.isAdAvailable()) {
            this.mMillennialInterstitial.display();
        } else {
            Log.d("MoPub", "Tried to show a Millennial interstitial ad before it finished loading. Please try again.");
        }
    }

    protected void onInvalidate() {
        this.mMillennialInterstitial.setListener(null);
        this.mBroadcastReceiver.unregister();
    }

    private boolean extrasAreValid(Map serverExtras) {
        return serverExtras.containsKey(APID_KEY);
    }
}

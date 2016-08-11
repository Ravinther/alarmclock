package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.util.MoPubLog;
import com.mopub.nativeads.MoPubNative.MoPubNativeListener;
import java.lang.ref.WeakReference;

public final class AdapterHelper {
    private final WeakReference mActivity;
    private final Context mApplicationContext;
    private final int mInterval;
    private final int mStart;

    public AdapterHelper(Context context, int start, int interval) {
        if (context == null) {
            throw new IllegalArgumentException("Illegal argument: Context was null.");
        } else if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("Illegal argument: Context must be instance of Activity.");
        } else if (start < 0) {
            throw new IllegalArgumentException("Illegal argument: negative starting position.");
        } else if (interval < 2) {
            throw new IllegalArgumentException("Illegal argument: interval must be at least 2.");
        } else {
            this.mActivity = new WeakReference((Activity) context);
            this.mApplicationContext = context.getApplicationContext();
            this.mStart = start;
            this.mInterval = interval;
        }
    }

    public View getAdView(View convertView, ViewGroup parent, NativeResponse nativeResponse, ViewBinder viewBinder, MoPubNativeListener moPubNativeListener) {
        Activity activity = (Activity) this.mActivity.get();
        if (activity != null) {
            return NativeAdViewHelper.getAdView(convertView, parent, activity, nativeResponse, viewBinder, moPubNativeListener);
        }
        MoPubLog.m9729d("Weak reference to Activity Context in AdapterHelper became null. Returning empty view.");
        return new View(this.mApplicationContext);
    }

    public int shiftedCount(int originalCount) {
        return numberOfAdsThatCouldFitWithContent(originalCount) + originalCount;
    }

    public int shiftedPosition(int position) {
        return position - numberOfAdsSeenUpToPosition(position);
    }

    public boolean isAdPosition(int position) {
        if (position >= this.mStart && (position - this.mStart) % this.mInterval == 0) {
            return true;
        }
        return false;
    }

    private int numberOfAdsSeenUpToPosition(int position) {
        if (position <= this.mStart) {
            return 0;
        }
        return ((int) Math.floor(((double) (position - this.mStart)) / ((double) this.mInterval))) + 1;
    }

    private int numberOfAdsThatCouldFitWithContent(int contentRowCount) {
        if (contentRowCount <= this.mStart) {
            return 0;
        }
        int spacesBetweenAds = this.mInterval - 1;
        if ((contentRowCount - this.mStart) % spacesBetweenAds == 0) {
            return (contentRowCount - this.mStart) / spacesBetweenAds;
        }
        return ((int) Math.floor(((double) (contentRowCount - this.mStart)) / ((double) spacesBetweenAds))) + 1;
    }

    @Deprecated
    void clearActivityContext() {
        this.mActivity.clear();
    }
}

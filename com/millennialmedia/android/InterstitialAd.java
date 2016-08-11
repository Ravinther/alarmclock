package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class InterstitialAd extends CachedAd implements Parcelable, Externalizable {
    public static final Creator CREATOR;
    static final String EXTRA_AD_URL = "EXTRA_AD_URL";
    static final String EXTRA_CONTENT = "EXTRA_CONTENT";
    static final long serialVersionUID = 5158660334173309853L;
    String adUrl;
    String content;
    HttpMMHeaders mmHeaders;

    /* renamed from: com.millennialmedia.android.InterstitialAd.1 */
    static class C24741 implements Creator {
        C24741() {
        }

        public InterstitialAd createFromParcel(Parcel in) {
            return new InterstitialAd(in);
        }

        public InterstitialAd[] newArray(int size) {
            return new InterstitialAd[size];
        }
    }

    InterstitialAd(Parcel in) {
        super(in);
        try {
            this.content = in.readString();
            this.adUrl = in.readString();
            this.mmHeaders = (HttpMMHeaders) in.readParcelable(HttpMMHeaders.class.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int getType() {
        return 2;
    }

    String getTypeString() {
        return "Interstitial";
    }

    boolean saveAssets(Context context) {
        return true;
    }

    boolean download(Context context) {
        return true;
    }

    boolean isOnDisk(Context context) {
        return true;
    }

    boolean canShow(Context context, MMAdImpl adImpl, boolean checkDeferredViewStart) {
        if (checkDeferredViewStart) {
            if (this.content == null || this.content.length() <= 0 || this.adUrl == null || this.adUrl.length() <= 0 || !HandShake.sharedHandShake(context).canDisplayCachedAd(adImpl.adType, this.deferredViewStart)) {
                return false;
            }
            return true;
        } else if (this.content == null || this.content.length() <= 0 || this.adUrl == null || this.adUrl.length() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    void show(Context context, long adImplInternalId) {
        IntentUtils.startAdViewOverlayActivity(context, getExpandExtrasIntent(context, adImplInternalId));
    }

    private Intent getExpandExtrasIntent(Context context, long adImplInternalId) {
        Intent intent = new Intent();
        OverlaySettings settings = new OverlaySettings();
        settings.creatorAdImplId = adImplInternalId;
        settings.content = this.content;
        settings.adUrl = this.adUrl;
        settings.setWebMMHeaders(this.mmHeaders);
        settings.isFromInterstitial = true;
        intent.putExtra("settings", settings);
        intent.putExtra("internalId", adImplInternalId);
        return intent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.content);
        dest.writeString(this.adUrl);
        dest.writeParcelable(this.mmHeaders, flags);
    }

    static {
        CREATOR = new C24741();
    }

    public void readExternal(ObjectInput input) {
        super.readExternal(input);
        this.content = (String) input.readObject();
        this.adUrl = (String) input.readObject();
        this.mmHeaders = (HttpMMHeaders) input.readObject();
    }

    public void writeExternal(ObjectOutput output) {
        super.writeExternal(output);
        output.writeObject(this.content);
        output.writeObject(this.adUrl);
        output.writeObject(this.mmHeaders);
    }
}

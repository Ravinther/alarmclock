package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.location.b */
public class C2051b implements SafeParcelable {
    public static final C2052c CREATOR;
    int Oh;
    int Oi;
    long Oj;
    private final int xH;

    static {
        CREATOR = new C2052c();
    }

    C2051b(int i, int i2, int i3, long j) {
        this.xH = i;
        this.Oh = i2;
        this.Oi = i3;
        this.Oj = j;
    }

    private String by(int i) {
        switch (i) {
            case Base64.DEFAULT /*0*/:
                return "STATUS_SUCCESSFUL";
            case Base64.NO_WRAP /*2*/:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return "STATUS_NO_INFO_IN_DATABASE";
            case Base64.CRLF /*4*/:
                return "STATUS_INVALID_SCAN";
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case Base64.URL_SAFE /*8*/:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C2051b)) {
            return false;
        }
        C2051b c2051b = (C2051b) other;
        return this.Oh == c2051b.Oh && this.Oi == c2051b.Oi && this.Oj == c2051b.Oj;
    }

    int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(Integer.valueOf(this.Oh), Integer.valueOf(this.Oi), Long.valueOf(this.Oj));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(by(this.Oh));
        stringBuilder.append(", wifi status: ").append(by(this.Oi));
        stringBuilder.append(", elapsed realtime ns: ").append(this.Oj);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C2052c.m9029a(this, parcel, flags);
    }
}

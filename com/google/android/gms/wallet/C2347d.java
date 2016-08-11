package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.d */
public final class C2347d implements SafeParcelable {
    public static final Creator CREATOR;
    LoyaltyWalletObject abg;
    private final int xH;

    static {
        CREATOR = new C2348e();
    }

    C2347d() {
        this.xH = 1;
    }

    C2347d(int i, LoyaltyWalletObject loyaltyWalletObject) {
        this.xH = i;
        this.abg = loyaltyWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2348e.m9620a(this, dest, flags);
    }
}

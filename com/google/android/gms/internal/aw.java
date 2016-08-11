package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.millennialmedia.android.C2513R;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class aw implements Creator {
    static void m7882a(av avVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, avVar.versionCode);
        C1488b.m6378c(parcel, 2, avVar.mq);
        C1488b.m6378c(parcel, 3, avVar.backgroundColor);
        C1488b.m6378c(parcel, 4, avVar.mr);
        C1488b.m6378c(parcel, 5, avVar.ms);
        C1488b.m6378c(parcel, 6, avVar.mt);
        C1488b.m6378c(parcel, 7, avVar.mu);
        C1488b.m6378c(parcel, 8, avVar.mv);
        C1488b.m6378c(parcel, 9, avVar.mw);
        C1488b.m6366a(parcel, 10, avVar.mx, false);
        C1488b.m6378c(parcel, 11, avVar.my);
        C1488b.m6366a(parcel, 12, avVar.mz, false);
        C1488b.m6378c(parcel, 13, avVar.mA);
        C1488b.m6378c(parcel, 14, avVar.mB);
        C1488b.m6366a(parcel, 15, avVar.mC, false);
        C1488b.m6355F(parcel, p);
    }

    public av m7883c(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i4 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    i5 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    i6 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i7 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    i8 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    i9 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    i10 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    i11 = C1487a.m6331g(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    i12 = C1487a.m6331g(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_width /*15*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new av(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m7883c(x0);
    }

    public av[] m7884e(int i) {
        return new av[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m7884e(x0);
    }
}

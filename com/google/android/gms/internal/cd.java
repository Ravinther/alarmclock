package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.millennialmedia.android.C2513R;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class cd implements Creator {
    static void m8031a(ce ceVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, ceVar.versionCode);
        C1488b.m6363a(parcel, 2, ceVar.og, i, false);
        C1488b.m6361a(parcel, 3, ceVar.aO(), false);
        C1488b.m6361a(parcel, 4, ceVar.aP(), false);
        C1488b.m6361a(parcel, 5, ceVar.aQ(), false);
        C1488b.m6361a(parcel, 6, ceVar.aR(), false);
        C1488b.m6366a(parcel, 7, ceVar.ol, false);
        C1488b.m6369a(parcel, 8, ceVar.om);
        C1488b.m6366a(parcel, 9, ceVar.on, false);
        C1488b.m6361a(parcel, 10, ceVar.aT(), false);
        C1488b.m6378c(parcel, 11, ceVar.orientation);
        C1488b.m6378c(parcel, 12, ceVar.op);
        C1488b.m6366a(parcel, 13, ceVar.nO, false);
        C1488b.m6363a(parcel, 14, ceVar.kK, i, false);
        C1488b.m6361a(parcel, 15, ceVar.aS(), false);
        C1488b.m6366a(parcel, 16, ceVar.or, false);
        C1488b.m6355F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8032e(x0);
    }

    public ce m8032e(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        cb cbVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        dx dxVar = null;
        IBinder iBinder6 = null;
        String str4 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    cbVar = (cb) C1487a.m6320a(parcel, n, cb.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    iBinder = C1487a.m6341o(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    iBinder2 = C1487a.m6341o(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    iBinder3 = C1487a.m6341o(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    iBinder4 = C1487a.m6341o(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    iBinder5 = C1487a.m6341o(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    dxVar = (dx) C1487a.m6320a(parcel, n, dx.CREATOR);
                    break;
                case C2513R.styleable.MMAdView_width /*15*/:
                    iBinder6 = C1487a.m6341o(parcel, n);
                    break;
                case Base64.NO_CLOSE /*16*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ce(i, cbVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, dxVar, iBinder6, str4);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ce[] m8033i(int i) {
        return new ce[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8033i(x0);
    }
}

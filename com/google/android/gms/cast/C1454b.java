package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.List;

/* renamed from: com.google.android.gms.cast.b */
public class C1454b implements Creator {
    static void m6203a(CastDevice castDevice, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, castDevice.getVersionCode());
        C1488b.m6366a(parcel, 2, castDevice.getDeviceId(), false);
        C1488b.m6366a(parcel, 3, castDevice.yb, false);
        C1488b.m6366a(parcel, 4, castDevice.getFriendlyName(), false);
        C1488b.m6366a(parcel, 5, castDevice.getModelName(), false);
        C1488b.m6366a(parcel, 6, castDevice.getDeviceVersion(), false);
        C1488b.m6378c(parcel, 7, castDevice.getServicePort());
        C1488b.m6377b(parcel, 8, castDevice.getIcons(), false);
        C1488b.m6355F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6204k(x0);
    }

    public CastDevice m6204k(Parcel parcel) {
        int i = 0;
        List list = null;
        int o = C1487a.m6340o(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str5 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    list = C1487a.m6326c(parcel, n, WebImage.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CastDevice(i2, str5, str4, str3, str2, str, i, list);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m6205y(x0);
    }

    public CastDevice[] m6205y(int i) {
        return new CastDevice[i];
    }
}

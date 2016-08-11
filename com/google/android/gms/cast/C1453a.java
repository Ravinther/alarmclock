package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.List;

/* renamed from: com.google.android.gms.cast.a */
public class C1453a implements Creator {
    static void m6200a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, applicationMetadata.getVersionCode());
        C1488b.m6366a(parcel, 2, applicationMetadata.getApplicationId(), false);
        C1488b.m6366a(parcel, 3, applicationMetadata.getName(), false);
        C1488b.m6377b(parcel, 4, applicationMetadata.getImages(), false);
        C1488b.m6367a(parcel, 5, applicationMetadata.xK, false);
        C1488b.m6366a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        C1488b.m6363a(parcel, 7, applicationMetadata.dz(), i, false);
        C1488b.m6355F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6201j(x0);
    }

    public ApplicationMetadata m6201j(Parcel parcel) {
        Uri uri = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    list2 = C1487a.m6326c(parcel, n, WebImage.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    list = C1487a.m6315A(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    uri = (Uri) C1487a.m6320a(parcel, n, Uri.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m6202w(x0);
    }

    public ApplicationMetadata[] m6202w(int i) {
        return new ApplicationMetadata[i];
    }
}

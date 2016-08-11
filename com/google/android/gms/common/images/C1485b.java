package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.common.images.b */
public class C1485b implements Creator {
    static void m6312a(WebImage webImage, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, webImage.getVersionCode());
        C1488b.m6363a(parcel, 2, webImage.getUrl(), i, false);
        C1488b.m6378c(parcel, 3, webImage.getWidth());
        C1488b.m6378c(parcel, 4, webImage.getHeight());
        C1488b.m6355F(parcel, p);
    }

    public WebImage[] m6313K(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6314l(x0);
    }

    public WebImage m6314l(Parcel parcel) {
        int i = 0;
        int o = C1487a.m6340o(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            Uri uri2;
            int g;
            int n = C1487a.m6338n(parcel);
            int i4;
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    g = C1487a.m6331g(parcel, n);
                    n = i4;
                    break;
                case Base64.NO_WRAP /*2*/:
                    g = i3;
                    i4 = i2;
                    uri2 = (Uri) C1487a.m6320a(parcel, n, Uri.CREATOR);
                    n = i;
                    i = i4;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    uri2 = uri;
                    g = i3;
                    i4 = i;
                    i = C1487a.m6331g(parcel, n);
                    n = i4;
                    break;
                case Base64.CRLF /*4*/:
                    n = C1487a.m6331g(parcel, n);
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    n = i;
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
            }
            i3 = g;
            uri = uri2;
            i2 = i;
            i = n;
        }
        if (parcel.dataPosition() == o) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m6313K(x0);
    }
}

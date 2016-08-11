package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.Contents;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.internal.e */
public class C1506e implements Creator {
    static void m6448a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, closeContentsRequest.xH);
        C1488b.m6363a(parcel, 2, closeContentsRequest.EX, i, false);
        C1488b.m6364a(parcel, 3, closeContentsRequest.EY, false);
        C1488b.m6355F(parcel, p);
    }

    public CloseContentsRequest m6449F(Parcel parcel) {
        Boolean bool = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < o) {
            Contents contents2;
            int g;
            Boolean bool2;
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    Boolean bool3 = bool;
                    contents2 = contents;
                    g = C1487a.m6331g(parcel, n);
                    bool2 = bool3;
                    break;
                case Base64.NO_WRAP /*2*/:
                    g = i;
                    Contents contents3 = (Contents) C1487a.m6320a(parcel, n, Contents.CREATOR);
                    bool2 = bool;
                    contents2 = contents3;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    bool2 = C1487a.m6328d(parcel, n);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    bool2 = bool;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            bool = bool2;
        }
        if (parcel.dataPosition() == o) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public CloseContentsRequest[] aj(int i) {
        return new CloseContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6449F(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aj(x0);
    }
}

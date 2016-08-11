package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.Contents;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.internal.z */
public class C1575z implements Creator {
    static void m6629a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, onContentsResponse.xH);
        C1488b.m6363a(parcel, 2, onContentsResponse.EA, i, false);
        C1488b.m6355F(parcel, p);
    }

    public OnContentsResponse m6630N(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    contents = (Contents) C1487a.m6320a(parcel, n, Contents.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnContentsResponse(i, contents);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public OnContentsResponse[] ar(int i) {
        return new OnContentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6630N(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ar(x0);
    }
}

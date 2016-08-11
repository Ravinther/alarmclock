package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

public class InvitationClusterCreator implements Creator {
    static void m7713a(ZInvitationCluster zInvitationCluster, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6377b(parcel, 1, zInvitationCluster.ho(), false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, zInvitationCluster.getVersionCode());
        C1488b.m6355F(parcel, p);
    }

    public ZInvitationCluster as(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    arrayList = C1487a.m6326c(parcel, n, InvitationEntity.CREATOR);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ZInvitationCluster(i, arrayList);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ZInvitationCluster[] bi(int i) {
        return new ZInvitationCluster[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return as(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bi(x0);
    }
}

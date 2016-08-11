package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator {
    static void m7717a(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6377b(parcel, 1, gameRequestCluster.hz(), false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, gameRequestCluster.getVersionCode());
        C1488b.m6355F(parcel, p);
    }

    public GameRequestCluster at(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    arrayList = C1487a.m6326c(parcel, n, GameRequestEntity.CREATOR);
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
            return new GameRequestCluster(i, arrayList);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public GameRequestCluster[] bl(int i) {
        return new GameRequestCluster[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return at(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bl(x0);
    }
}

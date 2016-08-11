package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class GameBadgeEntityCreator implements Creator {
    static void m7708a(GameBadgeEntity gameBadgeEntity, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, gameBadgeEntity.getType());
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, gameBadgeEntity.getVersionCode());
        C1488b.m6366a(parcel, 2, gameBadgeEntity.getTitle(), false);
        C1488b.m6366a(parcel, 3, gameBadgeEntity.getDescription(), false);
        C1488b.m6363a(parcel, 4, gameBadgeEntity.getIconImageUri(), i, false);
        C1488b.m6355F(parcel, p);
    }

    public GameBadgeEntity ar(Parcel parcel) {
        int i = 0;
        Uri uri = null;
        int o = C1487a.m6340o(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    uri = (Uri) C1487a.m6320a(parcel, n, Uri.CREATOR);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GameBadgeEntity(i2, i, str2, str, uri);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public GameBadgeEntity[] bg(int i) {
        return new GameBadgeEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ar(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bg(x0);
    }
}

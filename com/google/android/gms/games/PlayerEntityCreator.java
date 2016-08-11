package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class PlayerEntityCreator implements Creator {
    static void m6754a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6366a(parcel, 1, playerEntity.getPlayerId(), false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, playerEntity.getVersionCode());
        C1488b.m6366a(parcel, 2, playerEntity.getDisplayName(), false);
        C1488b.m6363a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        C1488b.m6363a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        C1488b.m6359a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C1488b.m6378c(parcel, 6, playerEntity.gh());
        C1488b.m6359a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        C1488b.m6366a(parcel, 8, playerEntity.getIconImageUrl(), false);
        C1488b.m6366a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        C1488b.m6355F(parcel, p);
    }

    public PlayerEntity[] aT(int i) {
        return new PlayerEntity[i];
    }

    public PlayerEntity ao(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    uri = (Uri) C1487a.m6320a(parcel, n, Uri.CREATOR);
                    break;
                case Base64.CRLF /*4*/:
                    uri2 = (Uri) C1487a.m6320a(parcel, n, Uri.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    j2 = C1487a.m6333i(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str4 = C1487a.m6339n(parcel, n);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ao(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aT(x0);
    }
}

package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator {
    static void m7703a(ExtendedGameEntity extendedGameEntity, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6363a(parcel, 1, extendedGameEntity.hf(), i, false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, extendedGameEntity.getVersionCode());
        C1488b.m6378c(parcel, 2, extendedGameEntity.gX());
        C1488b.m6369a(parcel, 3, extendedGameEntity.gY());
        C1488b.m6378c(parcel, 4, extendedGameEntity.gZ());
        C1488b.m6359a(parcel, 5, extendedGameEntity.ha());
        C1488b.m6359a(parcel, 6, extendedGameEntity.hb());
        C1488b.m6366a(parcel, 7, extendedGameEntity.hc(), false);
        C1488b.m6359a(parcel, 8, extendedGameEntity.hd());
        C1488b.m6366a(parcel, 9, extendedGameEntity.he(), false);
        C1488b.m6377b(parcel, 10, extendedGameEntity.gW(), false);
        C1488b.m6355F(parcel, p);
    }

    public ExtendedGameEntity aq(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        long j3 = 0;
        String str2 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    gameEntity = (GameEntity) C1487a.m6320a(parcel, n, GameEntity.CREATOR);
                    break;
                case Base64.NO_WRAP /*2*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    j2 = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    j3 = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    arrayList = C1487a.m6326c(parcel, n, GameBadgeEntity.CREATOR);
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
            return new ExtendedGameEntity(i, gameEntity, i2, z, i3, j, j2, str, j3, str2, arrayList);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ExtendedGameEntity[] be(int i) {
        return new ExtendedGameEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return be(x0);
    }
}

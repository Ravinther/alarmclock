package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator {
    static void m7745a(RoomEntity roomEntity, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6366a(parcel, 1, roomEntity.getRoomId(), false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, roomEntity.getVersionCode());
        C1488b.m6366a(parcel, 2, roomEntity.getCreatorId(), false);
        C1488b.m6359a(parcel, 3, roomEntity.getCreationTimestamp());
        C1488b.m6378c(parcel, 4, roomEntity.getStatus());
        C1488b.m6366a(parcel, 5, roomEntity.getDescription(), false);
        C1488b.m6378c(parcel, 6, roomEntity.getVariant());
        C1488b.m6360a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C1488b.m6377b(parcel, 8, roomEntity.getParticipants(), false);
        C1488b.m6378c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C1488b.m6355F(parcel, p);
    }

    public RoomEntity ax(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int o = C1487a.m6340o(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    bundle = C1487a.m6342p(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    arrayList = C1487a.m6326c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i4 = C1487a.m6331g(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public RoomEntity[] bq(int i) {
        return new RoomEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ax(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bq(x0);
    }
}

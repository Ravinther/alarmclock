package com.google.android.gms.games.multiplayer;

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

public class InvitationEntityCreator implements Creator {
    static void m7732a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6363a(parcel, 1, invitationEntity.getGame(), i, false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, invitationEntity.getVersionCode());
        C1488b.m6366a(parcel, 2, invitationEntity.getInvitationId(), false);
        C1488b.m6359a(parcel, 3, invitationEntity.getCreationTimestamp());
        C1488b.m6378c(parcel, 4, invitationEntity.getInvitationType());
        C1488b.m6363a(parcel, 5, invitationEntity.getInviter(), i, false);
        C1488b.m6377b(parcel, 6, invitationEntity.getParticipants(), false);
        C1488b.m6378c(parcel, 7, invitationEntity.getVariant());
        C1488b.m6378c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        C1488b.m6355F(parcel, p);
    }

    public InvitationEntity au(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int o = C1487a.m6340o(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    gameEntity = (GameEntity) C1487a.m6320a(parcel, n, GameEntity.CREATOR);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    participantEntity = (ParticipantEntity) C1487a.m6320a(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    arrayList = C1487a.m6326c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
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
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public InvitationEntity[] bn(int i) {
        return new InvitationEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return au(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bn(x0);
    }
}

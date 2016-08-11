package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class ParticipantEntityCreator implements Creator {
    static void m7737a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6366a(parcel, 1, participantEntity.getParticipantId(), false);
        C1488b.m6366a(parcel, 2, participantEntity.getDisplayName(), false);
        C1488b.m6363a(parcel, 3, participantEntity.getIconImageUri(), i, false);
        C1488b.m6363a(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        C1488b.m6378c(parcel, 5, participantEntity.getStatus());
        C1488b.m6366a(parcel, 6, participantEntity.gi(), false);
        C1488b.m6369a(parcel, 7, participantEntity.isConnectedToRoom());
        C1488b.m6363a(parcel, 8, participantEntity.getPlayer(), i, false);
        C1488b.m6378c(parcel, 9, participantEntity.getCapabilities());
        C1488b.m6363a(parcel, 10, participantEntity.getResult(), i, false);
        C1488b.m6366a(parcel, 11, participantEntity.getIconImageUrl(), false);
        C1488b.m6366a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, participantEntity.getVersionCode());
        C1488b.m6355F(parcel, p);
    }

    public ParticipantEntity av(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    playerEntity = (PlayerEntity) C1487a.m6320a(parcel, n, PlayerEntity.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    participantResult = (ParticipantResult) C1487a.m6320a(parcel, n, ParticipantResult.CREATOR);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    str5 = C1487a.m6339n(parcel, n);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ParticipantEntity[] bo(int i) {
        return new ParticipantEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return av(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bo(x0);
    }
}

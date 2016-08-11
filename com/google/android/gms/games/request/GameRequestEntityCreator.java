package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m7769a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6363a(parcel, 1, gameRequestEntity.getGame(), i, false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, gameRequestEntity.getVersionCode());
        C1488b.m6363a(parcel, 2, gameRequestEntity.getSender(), i, false);
        C1488b.m6370a(parcel, 3, gameRequestEntity.getData(), false);
        C1488b.m6366a(parcel, 4, gameRequestEntity.getRequestId(), false);
        C1488b.m6377b(parcel, 5, gameRequestEntity.getRecipients(), false);
        C1488b.m6378c(parcel, 7, gameRequestEntity.getType());
        C1488b.m6359a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        C1488b.m6359a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        C1488b.m6360a(parcel, 11, gameRequestEntity.hK(), false);
        C1488b.m6378c(parcel, 12, gameRequestEntity.getStatus());
        C1488b.m6355F(parcel, p);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    gameEntity = (GameEntity) C1487a.m6320a(parcel, n, GameEntity.CREATOR);
                    break;
                case Base64.NO_WRAP /*2*/:
                    playerEntity = (PlayerEntity) C1487a.m6320a(parcel, n, PlayerEntity.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    bArr = C1487a.m6343q(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    arrayList = C1487a.m6326c(parcel, n, PlayerEntity.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    j2 = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    bundle = C1487a.m6342p(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    i3 = C1487a.m6331g(parcel, n);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public GameRequestEntity[] newArray(int size) {
        return new GameRequestEntity[size];
    }
}

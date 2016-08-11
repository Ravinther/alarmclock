package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.avg.ui.general.C1091c.C1087k;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.millennialmedia.android.C2513R;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m7763a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6363a(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        C1488b.m6366a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        C1488b.m6366a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        C1488b.m6359a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        C1488b.m6366a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        C1488b.m6359a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        C1488b.m6366a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        C1488b.m6378c(parcel, 8, turnBasedMatchEntity.getStatus());
        C1488b.m6378c(parcel, 10, turnBasedMatchEntity.getVariant());
        C1488b.m6378c(parcel, 11, turnBasedMatchEntity.getVersion());
        C1488b.m6370a(parcel, 12, turnBasedMatchEntity.getData(), false);
        C1488b.m6377b(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        C1488b.m6366a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        C1488b.m6370a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        C1488b.m6360a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        C1488b.m6378c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, turnBasedMatchEntity.getVersionCode());
        C1488b.m6369a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        C1488b.m6378c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        C1488b.m6366a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        C1488b.m6366a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        C1488b.m6355F(parcel, p);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
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
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    j2 = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    i4 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    bArr = C1487a.m6343q(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    arrayList = C1487a.m6326c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    str5 = C1487a.m6339n(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_width /*15*/:
                    bArr2 = C1487a.m6343q(parcel, n);
                    break;
                case Base64.NO_CLOSE /*16*/:
                    i5 = C1487a.m6331g(parcel, n);
                    break;
                case MMException.CACHE_NOT_EMPTY /*17*/:
                    bundle = C1487a.m6342p(parcel, n);
                    break;
                case C1087k.ActionBar_itemPadding /*18*/:
                    i6 = C1487a.m6331g(parcel, n);
                    break;
                case Encoder.LINE_GROUPS /*19*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case MMException.DISPLAY_AD_NOT_READY /*20*/:
                    str6 = C1487a.m6339n(parcel, n);
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    str7 = C1487a.m6339n(parcel, n);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int size) {
        return new TurnBasedMatchEntity[size];
    }
}

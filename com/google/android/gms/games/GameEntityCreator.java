package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.avg.ui.general.C1091c.C1087k;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationStatusCodes;
import com.millennialmedia.android.C2513R;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class GameEntityCreator implements Creator {
    static void m6740a(GameEntity gameEntity, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6366a(parcel, 1, gameEntity.getApplicationId(), false);
        C1488b.m6366a(parcel, 2, gameEntity.getDisplayName(), false);
        C1488b.m6366a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C1488b.m6366a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C1488b.m6366a(parcel, 5, gameEntity.getDescription(), false);
        C1488b.m6366a(parcel, 6, gameEntity.getDeveloperName(), false);
        C1488b.m6363a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        C1488b.m6363a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        C1488b.m6363a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        C1488b.m6369a(parcel, 10, gameEntity.gb());
        C1488b.m6369a(parcel, 11, gameEntity.gd());
        C1488b.m6366a(parcel, 12, gameEntity.ge(), false);
        C1488b.m6378c(parcel, 13, gameEntity.gf());
        C1488b.m6378c(parcel, 14, gameEntity.getAchievementTotalCount());
        C1488b.m6378c(parcel, 15, gameEntity.getLeaderboardCount());
        C1488b.m6369a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        C1488b.m6369a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, gameEntity.getVersionCode());
        C1488b.m6366a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        C1488b.m6366a(parcel, 18, gameEntity.getIconImageUrl(), false);
        C1488b.m6369a(parcel, 21, gameEntity.isMuted());
        C1488b.m6366a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        C1488b.m6369a(parcel, 22, gameEntity.gc());
        C1488b.m6355F(parcel, p);
    }

    public GameEntity[] aS(int i) {
        return new GameEntity[i];
    }

    public GameEntity an(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
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
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str5 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str6 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    uri = (Uri) C1487a.m6320a(parcel, n, Uri.CREATOR);
                    break;
                case Base64.URL_SAFE /*8*/:
                    uri2 = (Uri) C1487a.m6320a(parcel, n, Uri.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    uri3 = (Uri) C1487a.m6320a(parcel, n, Uri.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    z2 = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    str7 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_width /*15*/:
                    i4 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_CLOSE /*16*/:
                    z3 = C1487a.m6327c(parcel, n);
                    break;
                case MMException.CACHE_NOT_EMPTY /*17*/:
                    z4 = C1487a.m6327c(parcel, n);
                    break;
                case C1087k.ActionBar_itemPadding /*18*/:
                    str8 = C1487a.m6339n(parcel, n);
                    break;
                case Encoder.LINE_GROUPS /*19*/:
                    str9 = C1487a.m6339n(parcel, n);
                    break;
                case MMException.DISPLAY_AD_NOT_READY /*20*/:
                    str10 = C1487a.m6339n(parcel, n);
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    z5 = C1487a.m6327c(parcel, n);
                    break;
                case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                    z6 = C1487a.m6327c(parcel, n);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return an(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aS(x0);
    }
}

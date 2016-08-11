package com.p044c.p045a;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.c.a.k */
class C1279k extends C1270g {
    C1279k(Context context, C1295r picasso, C1276i dispatcher, C1266d cache, C1307x stats, C1252a action) {
        super(context, picasso, dispatcher, cache, stats, action);
    }

    Bitmap m5470a(C1300u data) {
        m5408a(C1279k.m5469a(data.f3944c));
        return super.m5441a(data);
    }

    static int m5469a(Uri uri) {
        switch (new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1)) {
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return 180;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return 90;
            case Base64.URL_SAFE /*8*/:
                return 270;
            default:
                return 0;
        }
    }
}

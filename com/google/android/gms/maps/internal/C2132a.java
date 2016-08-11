package com.google.android.gms.maps.internal;

import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.maps.internal.a */
public final class C2132a {
    public static Boolean m9066a(byte b) {
        switch (b) {
            case Base64.DEFAULT /*0*/:
                return Boolean.FALSE;
            case Base64.NO_PADDING /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte m9067c(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}

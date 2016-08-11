package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.cast.Cast;

public final class eo {
    public static void m8363W(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        } else if (str.length() > Cast.MAX_NAMESPACE_LENGTH) {
            throw new IllegalArgumentException("Invalid namespace length");
        } else if (!str.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        } else if (str.length() == "urn:x-cast:".length()) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    public static String m8364X(String str) {
        return "urn:x-cast:" + str;
    }

    public static boolean m8365a(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || !(obj == null || obj2 == null || !obj.equals(obj2));
    }

    public static long m8366b(double d) {
        return (long) (1000.0d * d);
    }

    public static double m8367m(long j) {
        return ((double) j) / 1000.0d;
    }
}

package com.avg.toolkit.p050f;

import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.avg.toolkit.p049e.C0970a;
import com.p015a.p016a.p017a.C0494a;

/* renamed from: com.avg.toolkit.f.a */
public class C0971a {
    private static final byte[] f2929a;

    static {
        f2929a = new byte[]{(byte) -46, (byte) 65, (byte) 33, (byte) -118, (byte) -103, (byte) -57, (byte) 74, (byte) -62, (byte) 56, (byte) 88, (byte) -95, (byte) -55, (byte) 77, (byte) -113, (byte) -36, (byte) -123, (byte) -111, (byte) 22, (byte) -94, (byte) 29};
    }

    public static void m4330a(Context context, String key, String value) {
        System.putString(context.getContentResolver(), key, new C0494a(f2929a, "com.avg.zen.perferences", C0971a.m4328a(context)).m2355a(value));
    }

    public static String m4329a(Context context, String key) {
        String value = System.getString(context.getContentResolver(), key);
        if (value == null) {
            value = "";
        }
        if ("".equals(value)) {
            return value;
        }
        try {
            return new C0494a(f2929a, "com.avg.zen.perferences", C0971a.m4328a(context)).m2356b(value);
        } catch (Exception e) {
            value = "";
            C0970a.m4325b("Data integrity check failed. cannot retrieve data");
            C0970a.m4322a(e);
            return value;
        }
    }

    private static String m4328a(Context appContext) {
        String deviceId = null;
        try {
            deviceId = Secure.getString(appContext.getContentResolver(), "android_id");
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
        if (deviceId == null) {
            deviceId = "noid";
        }
        return deviceId + String.valueOf(65);
    }
}

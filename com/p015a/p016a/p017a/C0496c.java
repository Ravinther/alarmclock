package com.p015a.p016a.p017a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.a.a.a.c */
public class C0496c {
    private SharedPreferences f1320a;
    private Editor f1321b;
    private C0493d f1322c;

    public C0496c(Context context, String name, int mode, boolean isLiteEncryption) {
        this.f1322c = null;
        if (context == null) {
            C0970a.m4325b("context == null");
            this.f1320a = null;
            this.f1321b = null;
            return;
        }
        this.f1320a = context.getSharedPreferences(name, mode);
        if (this.f1320a == null) {
            C0970a.m4325b("SharedPreferences == null");
            this.f1321b = null;
            return;
        }
        this.f1321b = this.f1320a.edit();
        byte[] SALT = new byte[]{(byte) -46, (byte) 65, (byte) 33, (byte) -118, (byte) -103, (byte) -57, (byte) 74, (byte) -62, (byte) 56, (byte) 88, (byte) -95, (byte) -55, (byte) 77, (byte) -113, (byte) -36, (byte) -123, (byte) -111, (byte) 22, (byte) -94, (byte) 29};
        String packageName = context.getPackageName();
        String deviceId = null;
        try {
            deviceId = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
        if (deviceId == null) {
            deviceId = "noid";
        }
        deviceId = deviceId + String.valueOf(65);
        if (isLiteEncryption) {
            this.f1322c = new C0495b(SALT, packageName, deviceId);
        } else {
            this.f1322c = new C0494a(SALT, packageName, deviceId);
        }
    }

    public boolean m2363a(String key, boolean defValue) {
        if (this.f1320a != null) {
            return this.f1320a.getBoolean(key, defValue);
        }
        C0970a.m4325b("SharedPreferences == null");
        return false;
    }

    public int m2360a(String key, int defValue) {
        if (this.f1320a != null) {
            return this.f1320a.getInt(key, defValue);
        }
        C0970a.m4325b("SharedPreferences == null");
        return -1;
    }

    public long m2361a(String key, long defValue) {
        if (this.f1320a != null) {
            return this.f1320a.getLong(key, defValue);
        }
        C0970a.m4325b("SharedPreferences == null");
        return -1;
    }

    public String m2362a(String key, String defValue) {
        if (this.f1320a == null) {
            C0970a.m4325b("SharedPreferences == null");
            return "Error";
        }
        String result = "";
        String value = this.f1320a.getString(key, null);
        if (value == null) {
            return defValue;
        }
        try {
            return this.f1322c.m2354b(value);
        } catch (C0497e e) {
            C0970a.m4325b("Can't unobfuscate from the key: " + key + " Error: " + e.getMessage());
            return defValue;
        }
    }

    public Editor m2367b(String key, boolean value) {
        if (this.f1321b != null) {
            return this.f1321b.putBoolean(key, value);
        }
        C0970a.m4325b("SharedPreferencesEditor == null");
        return null;
    }

    public Editor m2364b(String key, int value) {
        if (this.f1321b != null) {
            return this.f1321b.putInt(key, value);
        }
        C0970a.m4325b("SharedPreferencesEditor == null");
        return null;
    }

    public Editor m2365b(String key, long value) {
        if (this.f1321b != null) {
            return this.f1321b.putLong(key, value);
        }
        C0970a.m4325b("SharedPreferencesEditor == null");
        return null;
    }

    public synchronized Editor m2366b(String key, String value) {
        Editor editor;
        if (this.f1321b == null) {
            C0970a.m4325b("SharedPreferencesEditor == null");
            editor = null;
        } else {
            editor = this.f1321b.putString(key, this.f1322c.m2353a(value));
        }
        return editor;
    }
}

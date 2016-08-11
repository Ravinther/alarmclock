package com.google.analytics.tracking.android;

public class Log {
    private static boolean f4206a;

    private Log() {
    }

    public static boolean m5751a() {
        return f4206a;
    }

    public static int m5750a(String msg) {
        return android.util.Log.d("GAV2", m5760j(msg));
    }

    public static int m5752b(String msg) {
        if (f4206a) {
            return m5750a(msg);
        }
        return 0;
    }

    public static int m5753c(String msg) {
        return android.util.Log.e("GAV2", m5760j(msg));
    }

    public static int m5754d(String msg) {
        return android.util.Log.i("GAV2", m5760j(msg));
    }

    public static int m5755e(String msg) {
        if (f4206a) {
            return m5754d(msg);
        }
        return 0;
    }

    public static int m5756f(String msg) {
        return android.util.Log.v("GAV2", m5760j(msg));
    }

    public static int m5757g(String msg) {
        if (f4206a) {
            return m5756f(msg);
        }
        return 0;
    }

    public static int m5758h(String msg) {
        return android.util.Log.w("GAV2", m5760j(msg));
    }

    public static int m5759i(String msg) {
        if (f4206a) {
            return m5758h(msg);
        }
        return 0;
    }

    private static String m5760j(String msg) {
        return Thread.currentThread().toString() + ": " + msg;
    }
}

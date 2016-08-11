package com.google.android.gms.games.internal;

import com.google.android.gms.internal.fj;

public final class GamesLog {
    private static final fj JH;

    static {
        JH = new fj("Games");
    }

    private GamesLog() {
    }

    public static void m7098a(String str, String str2, Throwable th) {
        JH.m8444a(str, str2, th);
    }

    public static void m7099f(String str, String str2) {
        JH.m8445f(str, str2);
    }

    public static void m7100g(String str, String str2) {
        JH.m8446g(str, str2);
    }

    public static void m7101h(String str, String str2) {
        JH.m8447h(str, str2);
    }
}

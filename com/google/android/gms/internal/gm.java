package com.google.android.gms.internal;

import android.database.CharArrayBuffer;

public final class gm {
    public static void m8605b(String str, CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer.data == null || charArrayBuffer.data.length < str.length()) {
            charArrayBuffer.data = str.toCharArray();
        } else {
            str.getChars(0, str.length(), charArrayBuffer.data, 0);
        }
        charArrayBuffer.sizeCopied = str.length();
    }
}

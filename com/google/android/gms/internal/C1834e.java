package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.e */
class C1834e implements C1833n {
    C1834e() {
    }

    public String m8236a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    public byte[] m8237a(String str, boolean z) {
        return Base64.decode(str, z ? 11 : 2);
    }
}

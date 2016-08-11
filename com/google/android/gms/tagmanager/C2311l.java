package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.tagmanager.l */
class C2311l {
    final C2288a WH;

    /* renamed from: com.google.android.gms.tagmanager.l.a */
    public interface C2288a {
        int sizeOf(Object obj, Object obj2);
    }

    /* renamed from: com.google.android.gms.tagmanager.l.1 */
    class C23101 implements C2288a {
        final /* synthetic */ C2311l WI;

        C23101(C2311l c2311l) {
            this.WI = c2311l;
        }

        public int sizeOf(Object key, Object value) {
            return 1;
        }
    }

    public C2311l() {
        this.WH = new C23101(this);
    }

    public C2263k m9553a(int i, C2288a c2288a) {
        if (i > 0) {
            return jZ() < 12 ? new cz(i, c2288a) : new bb(i, c2288a);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int jZ() {
        return VERSION.SDK_INT;
    }
}

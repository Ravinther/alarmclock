package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.C2311l.C2288a;

class bb implements C2263k {
    private LruCache Yu;

    /* renamed from: com.google.android.gms.tagmanager.bb.1 */
    class C22621 extends LruCache {
        final /* synthetic */ C2288a Yv;
        final /* synthetic */ bb Yw;

        C22621(bb bbVar, int i, C2288a c2288a) {
            this.Yw = bbVar;
            this.Yv = c2288a;
            super(i);
        }

        protected int sizeOf(Object key, Object value) {
            return this.Yv.sizeOf(key, value);
        }
    }

    bb(int i, C2288a c2288a) {
        this.Yu = new C22621(this, i, c2288a);
    }

    public void m9364e(Object obj, Object obj2) {
        this.Yu.put(obj, obj2);
    }

    public Object get(Object key) {
        return this.Yu.get(key);
    }
}

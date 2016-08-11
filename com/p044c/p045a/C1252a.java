package com.p044c.p045a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.p044c.p045a.C1295r.C1292d;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.c.a.a */
abstract class C1252a {
    final C1295r f3800a;
    final C1300u f3801b;
    final WeakReference f3802c;
    final boolean f3803d;
    final boolean f3804e;
    final int f3805f;
    final Drawable f3806g;
    final String f3807h;
    boolean f3808i;
    boolean f3809j;

    /* renamed from: com.c.a.a.a */
    static class C1251a extends WeakReference {
        final C1252a f3799a;

        public C1251a(C1252a action, Object referent, ReferenceQueue q) {
            super(referent, q);
            this.f3799a = action;
        }
    }

    abstract void m5359a();

    abstract void m5360a(Bitmap bitmap, C1292d c1292d);

    C1252a(C1295r picasso, Object target, C1300u request, boolean skipCache, boolean noFade, int errorResId, Drawable errorDrawable, String key) {
        this.f3800a = picasso;
        this.f3801b = request;
        this.f3802c = new C1251a(this, target, picasso.f3914i);
        this.f3803d = skipCache;
        this.f3804e = noFade;
        this.f3805f = errorResId;
        this.f3806g = errorDrawable;
        this.f3807h = key;
    }

    void m5361b() {
        this.f3809j = true;
    }

    C1300u m5362c() {
        return this.f3801b;
    }

    Object m5363d() {
        return this.f3802c.get();
    }

    String m5364e() {
        return this.f3807h;
    }

    boolean m5365f() {
        return this.f3809j;
    }

    boolean m5366g() {
        return this.f3808i;
    }

    C1295r m5367h() {
        return this.f3800a;
    }
}

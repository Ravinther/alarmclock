package com.p044c.p045a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.p044c.p045a.C1295r.C1292d;

/* renamed from: com.c.a.l */
class C1280l extends C1252a {
    C0881e f3864k;

    C1280l(C1295r picasso, ImageView imageView, C1300u data, boolean skipCache, boolean noFade, int errorResId, Drawable errorDrawable, String key, C0881e callback) {
        super(picasso, imageView, data, skipCache, noFade, errorResId, errorDrawable, key);
        this.f3864k = callback;
    }

    public void m5472a(Bitmap result, C1292d from) {
        if (result == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ImageView target = (ImageView) this.c.get();
        if (target != null) {
            Bitmap bitmap = result;
            C1292d c1292d = from;
            C1296s.m5511a(target, this.a.f3908c, bitmap, c1292d, this.e, this.a.f3915j);
            if (this.f3864k != null) {
                this.f3864k.m4096a();
            }
        }
    }

    public void m5471a() {
        ImageView target = (ImageView) this.c.get();
        if (target != null) {
            if (this.f != 0) {
                target.setImageResource(this.f);
            } else if (this.g != null) {
                target.setImageDrawable(this.g);
            }
            if (this.f3864k != null) {
                this.f3864k.m4097b();
            }
        }
    }

    void m5473b() {
        super.m5361b();
        if (this.f3864k != null) {
            this.f3864k = null;
        }
    }
}

package com.p044c.p045a;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* renamed from: com.c.a.h */
class C1271h implements OnPreDrawListener {
    final C1303v f3839a;
    final WeakReference f3840b;
    C0881e f3841c;

    C1271h(C1303v creator, ImageView target, C0881e callback) {
        this.f3839a = creator;
        this.f3840b = new WeakReference(target);
        this.f3841c = callback;
        target.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        ImageView target = (ImageView) this.f3840b.get();
        if (target != null) {
            ViewTreeObserver vto = target.getViewTreeObserver();
            if (vto.isAlive()) {
                int width = target.getWidth();
                int height = target.getHeight();
                if (width > 0 && height > 0) {
                    vto.removeOnPreDrawListener(this);
                    this.f3839a.m5528a().m5529a(width, height).m5530a(target, this.f3841c);
                }
            }
        }
        return true;
    }

    void m5444a() {
        this.f3841c = null;
        ImageView target = (ImageView) this.f3840b.get();
        if (target != null) {
            ViewTreeObserver vto = target.getViewTreeObserver();
            if (vto.isAlive()) {
                vto.removeOnPreDrawListener(this);
            }
        }
    }
}

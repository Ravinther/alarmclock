package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.ex;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fa;
import com.google.android.gms.internal.fa.C1888a;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fo;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public abstract class C1482a {
    final C1481a Cm;
    protected int Cn;
    protected int Co;
    private boolean Cp;
    private boolean Cq;
    protected int Cr;

    /* renamed from: com.google.android.gms.common.images.a.a */
    static final class C1481a {
        public final Uri uri;

        public C1481a(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1481a) {
                return this == obj ? true : fo.equal(((C1481a) obj).uri, this.uri);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return fo.hashCode(this.uri);
        }
    }

    /* renamed from: com.google.android.gms.common.images.a.b */
    public static final class C1483b extends C1482a {
        private WeakReference Cs;

        public C1483b(ImageView imageView, int i) {
            super(null, i);
            fb.m8419d(imageView);
            this.Cs = new WeakReference(imageView);
        }

        public C1483b(ImageView imageView, Uri uri) {
            super(uri, 0);
            fb.m8419d(imageView);
            this.Cs = new WeakReference(imageView);
        }

        private void m6309a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof ez)) {
                int eB = ((ez) imageView).eB();
                if (this.Co != 0 && eB == this.Co) {
                    return;
                }
            }
            boolean b = m6308b(z, z2);
            Drawable a = b ? m6303a(imageView.getDrawable(), drawable) : drawable;
            imageView.setImageDrawable(a);
            if (imageView instanceof ez) {
                ez ezVar = (ez) imageView;
                ezVar.m8403e(z3 ? this.Cm.uri : null);
                ezVar.m8402L(obj != null ? this.Co : 0);
            }
            if (b) {
                ((ex) a).startTransition(250);
            }
        }

        protected void m6310a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.Cs.get();
            if (imageView != null) {
                m6309a(imageView, drawable, z, z2, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1483b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.Cs.get();
            ImageView imageView2 = (ImageView) ((C1483b) obj).Cs.get();
            boolean z = (imageView2 == null || imageView == null || !fo.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.common.images.a.c */
    public static final class C1484c extends C1482a {
        private WeakReference Ct;

        public C1484c(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            fb.m8419d(onImageLoadedListener);
            this.Ct = new WeakReference(onImageLoadedListener);
        }

        protected void m6311a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.Ct.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.Cm.uri, drawable, z3);
                }
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1484c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1484c c1484c = (C1484c) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.Ct.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) c1484c.Ct.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && fo.equal(onImageLoadedListener2, onImageLoadedListener) && fo.equal(c1484c.Cm, this.Cm);
            return z;
        }

        public int hashCode() {
            return fo.hashCode(this.Cm);
        }
    }

    public C1482a(Uri uri, int i) {
        this.Cn = 0;
        this.Co = 0;
        this.Cp = true;
        this.Cq = false;
        this.Cm = new C1481a(uri);
        this.Co = i;
    }

    private Drawable m6300a(Context context, fa faVar, int i) {
        Resources resources = context.getResources();
        if (this.Cr <= 0) {
            return resources.getDrawable(i);
        }
        C1888a c1888a = new C1888a(i, this.Cr);
        Drawable drawable = (Drawable) faVar.get(c1888a);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.Cr & 1) != 0) {
            drawable = m6302a(resources, drawable);
        }
        faVar.put(c1888a, drawable);
        return drawable;
    }

    public void m6301J(int i) {
        this.Co = i;
    }

    protected Drawable m6302a(Resources resources, Drawable drawable) {
        return ey.m8401a(resources, drawable);
    }

    protected ex m6303a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof ex) {
            drawable = ((ex) drawable).ez();
        }
        return new ex(drawable, drawable2);
    }

    void m6304a(Context context, Bitmap bitmap, boolean z) {
        fb.m8419d(bitmap);
        if ((this.Cr & 1) != 0) {
            bitmap = ey.m8399a(bitmap);
        }
        m6307a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    void m6305a(Context context, fa faVar) {
        Drawable drawable = null;
        if (this.Cn != 0) {
            drawable = m6300a(context, faVar, this.Cn);
        }
        m6307a(drawable, false, true, false);
    }

    void m6306a(Context context, fa faVar, boolean z) {
        Drawable drawable = null;
        if (this.Co != 0) {
            drawable = m6300a(context, faVar, this.Co);
        }
        m6307a(drawable, z, false, false);
    }

    protected abstract void m6307a(Drawable drawable, boolean z, boolean z2, boolean z3);

    protected boolean m6308b(boolean z, boolean z2) {
        return this.Cp && !z2 && (!z || this.Cq);
    }
}

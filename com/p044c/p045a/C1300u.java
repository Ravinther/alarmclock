package com.p044c.p045a;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.c.a.u */
public final class C1300u {
    private static final long f3941o;
    int f3942a;
    long f3943b;
    public final Uri f3944c;
    public final int f3945d;
    public final List f3946e;
    public final int f3947f;
    public final int f3948g;
    public final boolean f3949h;
    public final boolean f3950i;
    public final float f3951j;
    public final float f3952k;
    public final float f3953l;
    public final boolean f3954m;
    public final Config f3955n;

    /* renamed from: com.c.a.u.a */
    public static final class C1299a {
        private Uri f3929a;
        private int f3930b;
        private int f3931c;
        private int f3932d;
        private boolean f3933e;
        private boolean f3934f;
        private float f3935g;
        private float f3936h;
        private float f3937i;
        private boolean f3938j;
        private List f3939k;
        private Config f3940l;

        C1299a(Uri uri, int resourceId) {
            this.f3929a = uri;
            this.f3930b = resourceId;
        }

        boolean m5515a() {
            return (this.f3929a == null && this.f3930b == 0) ? false : true;
        }

        boolean m5516b() {
            return this.f3931c != 0;
        }

        public C1299a m5514a(int targetWidth, int targetHeight) {
            if (targetWidth <= 0) {
                throw new IllegalArgumentException("Width must be positive number.");
            } else if (targetHeight <= 0) {
                throw new IllegalArgumentException("Height must be positive number.");
            } else {
                this.f3931c = targetWidth;
                this.f3932d = targetHeight;
                return this;
            }
        }

        public C1300u m5517c() {
            if (this.f3934f && this.f3933e) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f3933e && this.f3931c == 0) {
                throw new IllegalStateException("Center crop requires calling resize.");
            } else if (!this.f3934f || this.f3931c != 0) {
                return new C1300u(this.f3930b, this.f3939k, this.f3931c, this.f3932d, this.f3933e, this.f3934f, this.f3935g, this.f3936h, this.f3937i, this.f3938j, this.f3940l, null);
            } else {
                throw new IllegalStateException("Center inside requires calling resize.");
            }
        }
    }

    static {
        f3941o = TimeUnit.SECONDS.toNanos(5);
    }

    private C1300u(Uri uri, int resourceId, List transformations, int targetWidth, int targetHeight, boolean centerCrop, boolean centerInside, float rotationDegrees, float rotationPivotX, float rotationPivotY, boolean hasRotationPivot, Config config) {
        this.f3944c = uri;
        this.f3945d = resourceId;
        if (transformations == null) {
            this.f3946e = null;
        } else {
            this.f3946e = Collections.unmodifiableList(transformations);
        }
        this.f3947f = targetWidth;
        this.f3948g = targetHeight;
        this.f3949h = centerCrop;
        this.f3950i = centerInside;
        this.f3951j = rotationDegrees;
        this.f3952k = rotationPivotX;
        this.f3953l = rotationPivotY;
        this.f3954m = hasRotationPivot;
        this.f3955n = config;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        if (this.f3945d > 0) {
            sb.append(this.f3945d);
        } else {
            sb.append(this.f3944c);
        }
        if (!(this.f3946e == null || this.f3946e.isEmpty())) {
            for (C1309z transformation : this.f3946e) {
                sb.append(' ').append(transformation.m5549a());
            }
        }
        if (this.f3947f > 0) {
            sb.append(" resize(").append(this.f3947f).append(',').append(this.f3948g).append(')');
        }
        if (this.f3949h) {
            sb.append(" centerCrop");
        }
        if (this.f3950i) {
            sb.append(" centerInside");
        }
        if (this.f3951j != 0.0f) {
            sb.append(" rotation(").append(this.f3951j);
            if (this.f3954m) {
                sb.append(" @ ").append(this.f3952k).append(',').append(this.f3953l);
            }
            sb.append(')');
        }
        if (this.f3955n != null) {
            sb.append(' ').append(this.f3955n);
        }
        sb.append('}');
        return sb.toString();
    }

    String m5518a() {
        long delta = System.nanoTime() - this.f3943b;
        if (delta > f3941o) {
            return m5519b() + '+' + TimeUnit.NANOSECONDS.toSeconds(delta) + 's';
        }
        return m5519b() + '+' + TimeUnit.NANOSECONDS.toMillis(delta) + "ms";
    }

    String m5519b() {
        return "[R" + this.f3942a + ']';
    }

    String m5520c() {
        if (this.f3944c != null) {
            return String.valueOf(this.f3944c.getPath());
        }
        return Integer.toHexString(this.f3945d);
    }

    public boolean m5521d() {
        return this.f3947f != 0;
    }

    boolean m5522e() {
        return m5523f() || m5524g();
    }

    boolean m5523f() {
        return (this.f3947f == 0 && this.f3951j == 0.0f) ? false : true;
    }

    boolean m5524g() {
        return this.f3946e != null;
    }
}

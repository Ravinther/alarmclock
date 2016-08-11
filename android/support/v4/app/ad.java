package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.af.C0052a;
import android.support.v4.app.af.C0052a.C0046a;

public class ad extends C0052a {
    public static final C0046a f119a;
    private static final C0048a f120g;
    private final String f121b;
    private final CharSequence f122c;
    private final CharSequence[] f123d;
    private final boolean f124e;
    private final Bundle f125f;

    /* renamed from: android.support.v4.app.ad.1 */
    static class C00471 implements C0046a {
        C00471() {
        }
    }

    /* renamed from: android.support.v4.app.ad.a */
    interface C0048a {
    }

    /* renamed from: android.support.v4.app.ad.b */
    static class C0049b implements C0048a {
        C0049b() {
        }
    }

    /* renamed from: android.support.v4.app.ad.c */
    static class C0050c implements C0048a {
        C0050c() {
        }
    }

    /* renamed from: android.support.v4.app.ad.d */
    static class C0051d implements C0048a {
        C0051d() {
        }
    }

    public String m158a() {
        return this.f121b;
    }

    public CharSequence m159b() {
        return this.f122c;
    }

    public CharSequence[] m160c() {
        return this.f123d;
    }

    public boolean m161d() {
        return this.f124e;
    }

    public Bundle m162e() {
        return this.f125f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f120g = new C0049b();
        } else if (VERSION.SDK_INT >= 16) {
            f120g = new C0051d();
        } else {
            f120g = new C0050c();
        }
        f119a = new C00471();
    }
}

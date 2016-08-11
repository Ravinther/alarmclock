package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0121v.C0120a;
import android.support.v4.app.C0123w.C0122a;
import android.support.v4.app.C0124x.C0103a;
import android.support.v4.app.C0124x.C0103a.C0101a;
import android.support.v4.app.ab.C0044a;
import android.support.v4.app.ac.C0045a;
import android.support.v4.app.af.C0052a;
import android.widget.RemoteViews;
import com.google.android.gms.cast.Cast;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.app.u */
public class C0119u {
    private static final C0110f f330a;

    /* renamed from: android.support.v4.app.u.a */
    public static class C0104a extends C0103a {
        public static final C0101a f287d;
        public int f288a;
        public CharSequence f289b;
        public PendingIntent f290c;
        private final Bundle f291e;
        private final ad[] f292f;

        /* renamed from: android.support.v4.app.u.a.1 */
        static class C01021 implements C0101a {
            C01021() {
            }
        }

        public /* synthetic */ C0052a[] m456f() {
            return m455e();
        }

        public C0104a(int icon, CharSequence title, PendingIntent intent) {
            this(icon, title, intent, new Bundle(), null);
        }

        private C0104a(int icon, CharSequence title, PendingIntent intent, Bundle extras, ad[] remoteInputs) {
            this.f288a = icon;
            this.f289b = C0108d.m458c(title);
            this.f290c = intent;
            if (extras == null) {
                extras = new Bundle();
            }
            this.f291e = extras;
            this.f292f = remoteInputs;
        }

        protected int m451a() {
            return this.f288a;
        }

        protected CharSequence m452b() {
            return this.f289b;
        }

        protected PendingIntent m453c() {
            return this.f290c;
        }

        public Bundle m454d() {
            return this.f291e;
        }

        public ad[] m455e() {
            return this.f292f;
        }

        static {
            f287d = new C01021();
        }
    }

    /* renamed from: android.support.v4.app.u.o */
    public static abstract class C0105o {
        CharSequence f293d;
        CharSequence f294e;
        boolean f295f;

        public C0105o() {
            this.f295f = false;
        }
    }

    /* renamed from: android.support.v4.app.u.b */
    public static class C0106b extends C0105o {
        Bitmap f296a;
        Bitmap f297b;
        boolean f298c;
    }

    /* renamed from: android.support.v4.app.u.c */
    public static class C0107c extends C0105o {
        CharSequence f299a;
    }

    /* renamed from: android.support.v4.app.u.d */
    public static class C0108d {
        Notification f300A;
        Notification f301B;
        public ArrayList f302C;
        Context f303a;
        CharSequence f304b;
        CharSequence f305c;
        PendingIntent f306d;
        PendingIntent f307e;
        RemoteViews f308f;
        Bitmap f309g;
        CharSequence f310h;
        int f311i;
        int f312j;
        boolean f313k;
        boolean f314l;
        C0105o f315m;
        CharSequence f316n;
        int f317o;
        int f318p;
        boolean f319q;
        String f320r;
        boolean f321s;
        String f322t;
        ArrayList f323u;
        boolean f324v;
        String f325w;
        Bundle f326x;
        int f327y;
        int f328z;

        public C0108d(Context context) {
            this.f313k = true;
            this.f323u = new ArrayList();
            this.f324v = false;
            this.f327y = 0;
            this.f328z = 0;
            this.f301B = new Notification();
            this.f303a = context;
            this.f301B.when = System.currentTimeMillis();
            this.f301B.audioStreamType = -1;
            this.f312j = 0;
            this.f302C = new ArrayList();
        }

        public C0108d m463a(long when) {
            this.f301B.when = when;
            return this;
        }

        public C0108d m460a(int icon) {
            this.f301B.icon = icon;
            return this;
        }

        public C0108d m466a(CharSequence title) {
            this.f304b = C0108d.m458c(title);
            return this;
        }

        public C0108d m470b(CharSequence text) {
            this.f305c = C0108d.m458c(text);
            return this;
        }

        public C0108d m464a(PendingIntent intent) {
            this.f306d = intent;
            return this;
        }

        public C0108d m469b(PendingIntent intent) {
            this.f301B.deleteIntent = intent;
            return this;
        }

        public C0108d m465a(Uri sound) {
            this.f301B.sound = sound;
            this.f301B.audioStreamType = -1;
            return this;
        }

        public C0108d m461a(int argb, int onMs, int offMs) {
            boolean showLights;
            int i = 1;
            this.f301B.ledARGB = argb;
            this.f301B.ledOnMS = onMs;
            this.f301B.ledOffMS = offMs;
            if (this.f301B.ledOnMS == 0 || this.f301B.ledOffMS == 0) {
                showLights = false;
            } else {
                showLights = true;
            }
            Notification notification = this.f301B;
            int i2 = this.f301B.flags & -2;
            if (!showLights) {
                i = 0;
            }
            notification.flags = i | i2;
            return this;
        }

        public C0108d m467a(boolean ongoing) {
            m457a(2, ongoing);
            return this;
        }

        public C0108d m471b(boolean autoCancel) {
            m457a(16, autoCancel);
            return this;
        }

        public C0108d m468b(int defaults) {
            this.f301B.defaults = defaults;
            if ((defaults & 4) != 0) {
                Notification notification = this.f301B;
                notification.flags |= 1;
            }
            return this;
        }

        private void m457a(int mask, boolean value) {
            if (value) {
                Notification notification = this.f301B;
                notification.flags |= mask;
                return;
            }
            notification = this.f301B;
            notification.flags &= mask ^ -1;
        }

        public C0108d m472c(int pri) {
            this.f312j = pri;
            return this;
        }

        public C0108d m462a(int icon, CharSequence title, PendingIntent intent) {
            this.f323u.add(new C0104a(icon, title, intent));
            return this;
        }

        public Notification m459a() {
            return C0119u.f330a.m473a(this);
        }

        protected static CharSequence m458c(CharSequence cs) {
            if (cs != null && cs.length() > 5120) {
                return cs.subSequence(0, 5120);
            }
            return cs;
        }
    }

    /* renamed from: android.support.v4.app.u.e */
    public static class C0109e extends C0105o {
        ArrayList f329a;

        public C0109e() {
            this.f329a = new ArrayList();
        }
    }

    /* renamed from: android.support.v4.app.u.f */
    interface C0110f {
        Notification m473a(C0108d c0108d);
    }

    /* renamed from: android.support.v4.app.u.i */
    static class C0111i implements C0110f {
        C0111i() {
        }

        public Notification m474a(C0108d b) {
            Notification result = b.f301B;
            result.setLatestEventInfo(b.f303a, b.f304b, b.f305c, b.f306d);
            if (b.f312j > 0) {
                result.flags |= Cast.MAX_NAMESPACE_LENGTH;
            }
            return result;
        }
    }

    /* renamed from: android.support.v4.app.u.m */
    static class C0112m extends C0111i {
        C0112m() {
        }

        public Notification m475a(C0108d b) {
            C0043t builder = new C0044a(b.f303a, b.f301B, b.f304b, b.f305c, b.f310h, b.f308f, b.f311i, b.f306d, b.f307e, b.f309g, b.f317o, b.f318p, b.f319q, b.f314l, b.f312j, b.f316n, b.f324v, b.f326x, b.f320r, b.f321s, b.f322t);
            C0119u.m485b((C0042s) builder, b.f323u);
            C0119u.m486b(builder, b.f315m);
            return builder.m143b();
        }
    }

    /* renamed from: android.support.v4.app.u.n */
    static class C0113n extends C0112m {
        C0113n() {
        }

        public Notification m476a(C0108d b) {
            C0043t builder = new C0045a(b.f303a, b.f301B, b.f304b, b.f305c, b.f310h, b.f308f, b.f311i, b.f306d, b.f307e, b.f309g, b.f317o, b.f318p, b.f319q, b.f313k, b.f314l, b.f312j, b.f316n, b.f324v, b.f302C, b.f326x, b.f320r, b.f321s, b.f322t);
            C0119u.m485b((C0042s) builder, b.f323u);
            C0119u.m486b(builder, b.f315m);
            return builder.m152b();
        }
    }

    /* renamed from: android.support.v4.app.u.g */
    static class C0114g extends C0113n {
        C0114g() {
        }

        public Notification m477a(C0108d b) {
            C0043t builder = new C0120a(b.f303a, b.f301B, b.f304b, b.f305c, b.f310h, b.f308f, b.f311i, b.f306d, b.f307e, b.f309g, b.f317o, b.f318p, b.f319q, b.f313k, b.f314l, b.f312j, b.f316n, b.f324v, b.f302C, b.f326x, b.f320r, b.f321s, b.f322t);
            C0119u.m485b((C0042s) builder, b.f323u);
            C0119u.m486b(builder, b.f315m);
            return builder.m489b();
        }
    }

    /* renamed from: android.support.v4.app.u.h */
    static class C0115h extends C0114g {
        C0115h() {
        }

        public Notification m478a(C0108d b) {
            C0043t builder = new C0122a(b.f303a, b.f301B, b.f304b, b.f305c, b.f310h, b.f308f, b.f311i, b.f306d, b.f307e, b.f309g, b.f317o, b.f318p, b.f319q, b.f313k, b.f314l, b.f312j, b.f316n, b.f324v, b.f325w, b.f302C, b.f326x, b.f327y, b.f328z, b.f300A, b.f320r, b.f321s, b.f322t);
            C0119u.m485b((C0042s) builder, b.f323u);
            C0119u.m486b(builder, b.f315m);
            return builder.m493b();
        }
    }

    /* renamed from: android.support.v4.app.u.j */
    static class C0116j extends C0111i {
        C0116j() {
        }

        public Notification m479a(C0108d b) {
            Notification result = b.f301B;
            result.setLatestEventInfo(b.f303a, b.f304b, b.f305c, b.f306d);
            result = C0125y.m494a(result, b.f303a, b.f304b, b.f305c, b.f306d, b.f307e);
            if (b.f312j > 0) {
                result.flags |= Cast.MAX_NAMESPACE_LENGTH;
            }
            return result;
        }
    }

    /* renamed from: android.support.v4.app.u.k */
    static class C0117k extends C0111i {
        C0117k() {
        }

        public Notification m480a(C0108d b) {
            return C0126z.m495a(b.f303a, b.f301B, b.f304b, b.f305c, b.f310h, b.f308f, b.f311i, b.f306d, b.f307e, b.f309g);
        }
    }

    /* renamed from: android.support.v4.app.u.l */
    static class C0118l extends C0111i {
        C0118l() {
        }

        public Notification m481a(C0108d b) {
            return aa.m138a(b.f303a, b.f301B, b.f304b, b.f305c, b.f310h, b.f308f, b.f311i, b.f306d, b.f307e, b.f309g, b.f317o, b.f318p, b.f319q);
        }
    }

    private static void m485b(C0042s builder, ArrayList actions) {
        Iterator i$ = actions.iterator();
        while (i$.hasNext()) {
            builder.m139a((C0104a) i$.next());
        }
    }

    private static void m486b(C0043t builder, C0105o style) {
        if (style == null) {
            return;
        }
        if (style instanceof C0107c) {
            C0107c bigTextStyle = (C0107c) style;
            ab.m148a(builder, bigTextStyle.d, bigTextStyle.f, bigTextStyle.e, bigTextStyle.f299a);
        } else if (style instanceof C0109e) {
            C0109e inboxStyle = (C0109e) style;
            ab.m149a(builder, inboxStyle.d, inboxStyle.f, inboxStyle.e, inboxStyle.f329a);
        } else if (style instanceof C0106b) {
            C0106b bigPictureStyle = (C0106b) style;
            ab.m147a(builder, bigPictureStyle.d, bigPictureStyle.f, bigPictureStyle.e, bigPictureStyle.f296a, bigPictureStyle.f297b, bigPictureStyle.f298c);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f330a = new C0115h();
        } else if (VERSION.SDK_INT >= 20) {
            f330a = new C0114g();
        } else if (VERSION.SDK_INT >= 19) {
            f330a = new C0113n();
        } else if (VERSION.SDK_INT >= 16) {
            f330a = new C0112m();
        } else if (VERSION.SDK_INT >= 14) {
            f330a = new C0118l();
        } else if (VERSION.SDK_INT >= 11) {
            f330a = new C0117k();
        } else if (VERSION.SDK_INT >= 9) {
            f330a = new C0116j();
        } else {
            f330a = new C0111i();
        }
    }
}

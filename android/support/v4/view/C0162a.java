package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.C0215b.C0169a;
import android.support.v4.view.C0217c.C0174a;
import android.support.v4.view.p011a.C0184a;
import android.support.v4.view.p011a.C0196e;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.a */
public class C0162a {
    private static final C0171b f404b;
    private static final Object f405c;
    final Object f406a;

    /* renamed from: android.support.v4.view.a.b */
    interface C0171b {
        C0196e m662a(Object obj, View view);

        Object m663a();

        Object m664a(C0162a c0162a);

        void m665a(Object obj, View view, int i);

        void m666a(Object obj, View view, C0184a c0184a);

        boolean m667a(Object obj, View view, int i, Bundle bundle);

        boolean m668a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean m669a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m670b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void m671c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void m672d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.a.d */
    static class C0172d implements C0171b {
        C0172d() {
        }

        public Object m674a() {
            return null;
        }

        public Object m675a(C0162a listener) {
            return null;
        }

        public boolean m679a(Object delegate, View host, AccessibilityEvent event) {
            return false;
        }

        public void m681b(Object delegate, View host, AccessibilityEvent event) {
        }

        public void m677a(Object delegate, View host, C0184a info) {
        }

        public void m682c(Object delegate, View host, AccessibilityEvent event) {
        }

        public boolean m680a(Object delegate, ViewGroup host, View child, AccessibilityEvent event) {
            return true;
        }

        public void m676a(Object delegate, View host, int eventType) {
        }

        public void m683d(Object delegate, View host, AccessibilityEvent event) {
        }

        public C0196e m673a(Object delegate, View host) {
            return null;
        }

        public boolean m678a(Object delegate, View host, int action, Bundle args) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.a.a */
    static class C0173a extends C0172d {

        /* renamed from: android.support.v4.view.a.a.1 */
        class C01701 implements C0169a {
            final /* synthetic */ C0162a f459a;
            final /* synthetic */ C0173a f460b;

            C01701(C0173a c0173a, C0162a c0162a) {
                this.f460b = c0173a;
                this.f459a = c0162a;
            }

            public boolean m657a(View host, AccessibilityEvent event) {
                return this.f459a.m598b(host, event);
            }

            public void m659b(View host, AccessibilityEvent event) {
                this.f459a.m600d(host, event);
            }

            public void m656a(View host, Object info) {
                this.f459a.m594a(host, new C0184a(info));
            }

            public void m660c(View host, AccessibilityEvent event) {
                this.f459a.m599c(host, event);
            }

            public boolean m658a(ViewGroup host, View child, AccessibilityEvent event) {
                return this.f459a.m597a(host, child, event);
            }

            public void m655a(View host, int eventType) {
                this.f459a.m593a(host, eventType);
            }

            public void m661d(View host, AccessibilityEvent event) {
                this.f459a.m595a(host, event);
            }
        }

        C0173a() {
        }

        public Object m684a() {
            return C0215b.m972a();
        }

        public Object m685a(C0162a compat) {
            return C0215b.m973a(new C01701(this, compat));
        }

        public boolean m688a(Object delegate, View host, AccessibilityEvent event) {
            return C0215b.m976a(delegate, host, event);
        }

        public void m690b(Object delegate, View host, AccessibilityEvent event) {
            C0215b.m978b(delegate, host, event);
        }

        public void m687a(Object delegate, View host, C0184a info) {
            C0215b.m975a(delegate, host, info.m837a());
        }

        public void m691c(Object delegate, View host, AccessibilityEvent event) {
            C0215b.m979c(delegate, host, event);
        }

        public boolean m689a(Object delegate, ViewGroup host, View child, AccessibilityEvent event) {
            return C0215b.m977a(delegate, host, child, event);
        }

        public void m686a(Object delegate, View host, int eventType) {
            C0215b.m974a(delegate, host, eventType);
        }

        public void m692d(Object delegate, View host, AccessibilityEvent event) {
            C0215b.m980d(delegate, host, event);
        }
    }

    /* renamed from: android.support.v4.view.a.c */
    static class C0176c extends C0173a {

        /* renamed from: android.support.v4.view.a.c.1 */
        class C01751 implements C0174a {
            final /* synthetic */ C0162a f461a;
            final /* synthetic */ C0176c f462b;

            C01751(C0176c c0176c, C0162a c0162a) {
                this.f462b = c0176c;
                this.f461a = c0162a;
            }

            public boolean m706a(View host, AccessibilityEvent event) {
                return this.f461a.m598b(host, event);
            }

            public void m708b(View host, AccessibilityEvent event) {
                this.f461a.m600d(host, event);
            }

            public void m704a(View host, Object info) {
                this.f461a.m594a(host, new C0184a(info));
            }

            public void m709c(View host, AccessibilityEvent event) {
                this.f461a.m599c(host, event);
            }

            public boolean m707a(ViewGroup host, View child, AccessibilityEvent event) {
                return this.f461a.m597a(host, child, event);
            }

            public void m703a(View host, int eventType) {
                this.f461a.m593a(host, eventType);
            }

            public void m710d(View host, AccessibilityEvent event) {
                this.f461a.m595a(host, event);
            }

            public Object m702a(View host) {
                C0196e provider = this.f461a.m591a(host);
                return provider != null ? provider.m936a() : null;
            }

            public boolean m705a(View host, int action, Bundle args) {
                return this.f461a.m596a(host, action, args);
            }
        }

        C0176c() {
        }

        public Object m712a(C0162a compat) {
            return C0217c.m981a(new C01751(this, compat));
        }

        public C0196e m711a(Object delegate, View host) {
            Object provider = C0217c.m982a(delegate, host);
            if (provider != null) {
                return new C0196e(provider);
            }
            return null;
        }

        public boolean m713a(Object delegate, View host, int action, Bundle args) {
            return C0217c.m983a(delegate, host, action, args);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f404b = new C0176c();
        } else if (VERSION.SDK_INT >= 14) {
            f404b = new C0173a();
        } else {
            f404b = new C0172d();
        }
        f405c = f404b.m663a();
    }

    public C0162a() {
        this.f406a = f404b.m664a(this);
    }

    Object m592a() {
        return this.f406a;
    }

    public void m593a(View host, int eventType) {
        f404b.m665a(f405c, host, eventType);
    }

    public void m595a(View host, AccessibilityEvent event) {
        f404b.m672d(f405c, host, event);
    }

    public boolean m598b(View host, AccessibilityEvent event) {
        return f404b.m668a(f405c, host, event);
    }

    public void m599c(View host, AccessibilityEvent event) {
        f404b.m671c(f405c, host, event);
    }

    public void m600d(View host, AccessibilityEvent event) {
        f404b.m670b(f405c, host, event);
    }

    public void m594a(View host, C0184a info) {
        f404b.m666a(f405c, host, info);
    }

    public boolean m597a(ViewGroup host, View child, AccessibilityEvent event) {
        return f404b.m669a(f405c, host, child, event);
    }

    public C0196e m591a(View host) {
        return f404b.m662a(f405c, host);
    }

    public boolean m596a(View host, int action, Bundle args) {
        return f404b.m667a(f405c, host, action, args);
    }
}

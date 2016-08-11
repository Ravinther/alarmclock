package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.p007b.p008a.C0128b;
import android.support.v4.view.C0243l.C0236b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.view.j */
public class C0240j {
    static final C0233d f485a;

    /* renamed from: android.support.v4.view.j.d */
    interface C0233d {
        MenuItem m1022a(MenuItem menuItem, C0239e c0239e);

        MenuItem m1023a(MenuItem menuItem, View view);

        View m1024a(MenuItem menuItem);

        void m1025a(MenuItem menuItem, int i);

        MenuItem m1026b(MenuItem menuItem, int i);

        boolean m1027b(MenuItem menuItem);

        boolean m1028c(MenuItem menuItem);
    }

    /* renamed from: android.support.v4.view.j.a */
    static class C0234a implements C0233d {
        C0234a() {
        }

        public void m1032a(MenuItem item, int actionEnum) {
        }

        public MenuItem m1030a(MenuItem item, View view) {
            return item;
        }

        public MenuItem m1033b(MenuItem item, int resId) {
            return item;
        }

        public View m1031a(MenuItem item) {
            return null;
        }

        public boolean m1034b(MenuItem item) {
            return false;
        }

        public boolean m1035c(MenuItem item) {
            return false;
        }

        public MenuItem m1029a(MenuItem item, C0239e listener) {
            return item;
        }
    }

    /* renamed from: android.support.v4.view.j.b */
    static class C0235b implements C0233d {
        C0235b() {
        }

        public void m1039a(MenuItem item, int actionEnum) {
            C0241k.m1062a(item, actionEnum);
        }

        public MenuItem m1037a(MenuItem item, View view) {
            return C0241k.m1060a(item, view);
        }

        public MenuItem m1040b(MenuItem item, int resId) {
            return C0241k.m1063b(item, resId);
        }

        public View m1038a(MenuItem item) {
            return C0241k.m1061a(item);
        }

        public boolean m1041b(MenuItem item) {
            return false;
        }

        public boolean m1042c(MenuItem item) {
            return false;
        }

        public MenuItem m1036a(MenuItem item, C0239e listener) {
            return item;
        }
    }

    /* renamed from: android.support.v4.view.j.c */
    static class C0238c extends C0235b {

        /* renamed from: android.support.v4.view.j.c.1 */
        class C02371 implements C0236b {
            final /* synthetic */ C0239e f483a;
            final /* synthetic */ C0238c f484b;

            C02371(C0238c c0238c, C0239e c0239e) {
                this.f484b = c0238c;
                this.f483a = c0239e;
            }

            public boolean m1045a(MenuItem item) {
                return this.f483a.m1050a(item);
            }

            public boolean m1046b(MenuItem item) {
                return this.f483a.m1051b(item);
            }
        }

        C0238c() {
        }

        public boolean m1048b(MenuItem item) {
            return C0243l.m1065a(item);
        }

        public boolean m1049c(MenuItem item) {
            return C0243l.m1066b(item);
        }

        public MenuItem m1047a(MenuItem item, C0239e listener) {
            if (listener == null) {
                return C0243l.m1064a(item, null);
            }
            return C0243l.m1064a(item, new C02371(this, listener));
        }
    }

    /* renamed from: android.support.v4.view.j.e */
    public interface C0239e {
        boolean m1050a(MenuItem menuItem);

        boolean m1051b(MenuItem menuItem);
    }

    static {
        int version = VERSION.SDK_INT;
        if (version >= 14) {
            f485a = new C0238c();
        } else if (version >= 11) {
            f485a = new C0235b();
        } else {
            f485a = new C0234a();
        }
    }

    public static void m1056a(MenuItem item, int actionEnum) {
        if (item instanceof C0128b) {
            ((C0128b) item).setShowAsAction(actionEnum);
        } else {
            f485a.m1025a(item, actionEnum);
        }
    }

    public static MenuItem m1054a(MenuItem item, View view) {
        if (item instanceof C0128b) {
            return ((C0128b) item).setActionView(view);
        }
        return f485a.m1023a(item, view);
    }

    public static MenuItem m1057b(MenuItem item, int resId) {
        if (item instanceof C0128b) {
            return ((C0128b) item).setActionView(resId);
        }
        return f485a.m1026b(item, resId);
    }

    public static View m1055a(MenuItem item) {
        if (item instanceof C0128b) {
            return ((C0128b) item).getActionView();
        }
        return f485a.m1024a(item);
    }

    public static MenuItem m1052a(MenuItem item, C0220d provider) {
        if (item instanceof C0128b) {
            return ((C0128b) item).m496a(provider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return item;
    }

    public static boolean m1058b(MenuItem item) {
        if (item instanceof C0128b) {
            return ((C0128b) item).expandActionView();
        }
        return f485a.m1027b(item);
    }

    public static boolean m1059c(MenuItem item) {
        if (item instanceof C0128b) {
            return ((C0128b) item).isActionViewExpanded();
        }
        return f485a.m1028c(item);
    }

    public static MenuItem m1053a(MenuItem item, C0239e listener) {
        if (item instanceof C0128b) {
            return ((C0128b) item).m497a(listener);
        }
        return f485a.m1022a(item, listener);
    }
}

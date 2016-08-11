package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import com.google.android.gms.cast.Cast;

/* renamed from: android.support.v4.view.g */
public class C0230g {
    static final C0226d f482a;

    /* renamed from: android.support.v4.view.g.d */
    interface C0226d {
        void m1003a(KeyEvent keyEvent);

        boolean m1004a(int i, int i2);

        boolean m1005b(int i);
    }

    /* renamed from: android.support.v4.view.g.a */
    static class C0227a implements C0226d {
        C0227a() {
        }

        private static int m1006a(int metaState, int modifiers, int basic, int left, int right) {
            boolean wantBasic;
            boolean wantLeftOrRight = true;
            if ((modifiers & basic) != 0) {
                wantBasic = true;
            } else {
                wantBasic = false;
            }
            int directional = left | right;
            if ((modifiers & directional) == 0) {
                wantLeftOrRight = false;
            }
            if (wantBasic) {
                if (!wantLeftOrRight) {
                    return metaState & (directional ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            } else if (wantLeftOrRight) {
                return metaState & (basic ^ -1);
            } else {
                return metaState;
            }
        }

        public int m1007a(int metaState) {
            if ((metaState & 192) != 0) {
                metaState |= 1;
            }
            if ((metaState & 48) != 0) {
                metaState |= 2;
            }
            return metaState & 247;
        }

        public boolean m1009a(int metaState, int modifiers) {
            if (C0227a.m1006a(C0227a.m1006a(m1007a(metaState) & 247, modifiers, 1, 64, Cast.MAX_NAMESPACE_LENGTH), modifiers, 2, 16, 32) == modifiers) {
                return true;
            }
            return false;
        }

        public boolean m1010b(int metaState) {
            return (m1007a(metaState) & 247) == 0;
        }

        public void m1008a(KeyEvent event) {
        }
    }

    /* renamed from: android.support.v4.view.g.b */
    static class C0228b extends C0227a {
        C0228b() {
        }

        public void m1011a(KeyEvent event) {
            C0231h.m1018a(event);
        }
    }

    /* renamed from: android.support.v4.view.g.c */
    static class C0229c extends C0228b {
        C0229c() {
        }

        public int m1012a(int metaState) {
            return C0232i.m1019a(metaState);
        }

        public boolean m1013a(int metaState, int modifiers) {
            return C0232i.m1020a(metaState, modifiers);
        }

        public boolean m1014b(int metaState) {
            return C0232i.m1021b(metaState);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f482a = new C0229c();
        } else {
            f482a = new C0227a();
        }
    }

    public static boolean m1016a(KeyEvent event, int modifiers) {
        return f482a.m1004a(event.getMetaState(), modifiers);
    }

    public static boolean m1015a(KeyEvent event) {
        return f482a.m1005b(event.getMetaState());
    }

    public static void m1017b(KeyEvent event) {
        f482a.m1003a(event);
    }
}

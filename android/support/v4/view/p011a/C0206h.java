package android.support.v4.view.p011a;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.view.a.h */
public class C0206h {
    private static final C0201c f473a;
    private final Object f474b;

    /* renamed from: android.support.v4.view.a.h.c */
    interface C0201c {
        Object m942a();

        void m943a(Object obj, int i);

        void m944a(Object obj, boolean z);

        void m945b(Object obj, int i);

        void m946c(Object obj, int i);
    }

    /* renamed from: android.support.v4.view.a.h.e */
    static class C0202e implements C0201c {
        C0202e() {
        }

        public Object m947a() {
            return null;
        }

        public void m948a(Object record, int fromIndex) {
        }

        public void m950b(Object record, int itemCount) {
        }

        public void m949a(Object record, boolean scrollable) {
        }

        public void m951c(Object record, int toIndex) {
        }
    }

    /* renamed from: android.support.v4.view.a.h.a */
    static class C0203a extends C0202e {
        C0203a() {
        }

        public Object m952a() {
            return C0207i.m962a();
        }

        public void m953a(Object record, int fromIndex) {
            C0207i.m963a(record, fromIndex);
        }

        public void m955b(Object record, int itemCount) {
            C0207i.m965b(record, itemCount);
        }

        public void m954a(Object record, boolean scrollable) {
            C0207i.m964a(record, scrollable);
        }

        public void m956c(Object record, int toIndex) {
            C0207i.m966c(record, toIndex);
        }
    }

    /* renamed from: android.support.v4.view.a.h.b */
    static class C0204b extends C0203a {
        C0204b() {
        }
    }

    /* renamed from: android.support.v4.view.a.h.d */
    static class C0205d extends C0204b {
        C0205d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f473a = new C0205d();
        } else if (VERSION.SDK_INT >= 15) {
            f473a = new C0204b();
        } else if (VERSION.SDK_INT >= 14) {
            f473a = new C0203a();
        } else {
            f473a = new C0202e();
        }
    }

    public C0206h(Object record) {
        this.f474b = record;
    }

    public static C0206h m957a() {
        return new C0206h(f473a.m942a());
    }

    public void m959a(boolean scrollable) {
        f473a.m944a(this.f474b, scrollable);
    }

    public void m958a(int itemCount) {
        f473a.m945b(this.f474b, itemCount);
    }

    public void m960b(int fromIndex) {
        f473a.m943a(this.f474b, fromIndex);
    }

    public void m961c(int toIndex) {
        f473a.m946c(this.f474b, toIndex);
    }

    public int hashCode() {
        return this.f474b == null ? 0 : this.f474b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0206h other = (C0206h) obj;
        if (this.f474b == null) {
            if (other.f474b != null) {
                return false;
            }
            return true;
        } else if (this.f474b.equals(other.f474b)) {
            return true;
        } else {
            return false;
        }
    }
}

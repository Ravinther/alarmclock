package android.support.v4.p006a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.a.f */
public class C0016f {
    private static final C0012a f45a;

    /* renamed from: android.support.v4.a.f.a */
    interface C0012a {
        Intent m102a(ComponentName componentName);
    }

    /* renamed from: android.support.v4.a.f.b */
    static class C0013b implements C0012a {
        C0013b() {
        }

        public Intent m103a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    /* renamed from: android.support.v4.a.f.c */
    static class C0014c extends C0013b {
        C0014c() {
        }

        public Intent m104a(ComponentName componentName) {
            return C0017g.m106a(componentName);
        }
    }

    /* renamed from: android.support.v4.a.f.d */
    static class C0015d extends C0014c {
        C0015d() {
        }
    }

    static {
        int version = VERSION.SDK_INT;
        if (version >= 15) {
            f45a = new C0015d();
        } else if (version >= 11) {
            f45a = new C0014c();
        } else {
            f45a = new C0013b();
        }
    }

    public static Intent m105a(ComponentName mainActivity) {
        return f45a.m102a(mainActivity);
    }
}

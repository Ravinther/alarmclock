package android.support.v7.internal.view.menu;

import android.support.v4.view.C0220d;
import android.support.v4.view.C0220d.C0219b;
import android.support.v7.internal.view.menu.C0405i.C0401a;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.j */
class C0407j extends C0405i {

    /* renamed from: android.support.v7.internal.view.menu.j.a */
    class C0406a extends C0401a implements C0219b {
        VisibilityListener f920c;
        final /* synthetic */ C0407j f921d;

        public C0406a(C0407j c0407j, C0220d inner) {
            this.f921d = c0407j;
            super(c0407j, inner);
        }

        public View onCreateActionView(MenuItem forItem) {
            return this.a.m987a(forItem);
        }

        public boolean overridesItemVisibility() {
            return this.a.m993c();
        }

        public boolean isVisible() {
            return this.a.m994d();
        }

        public void refreshVisibility() {
            this.a.m995e();
        }

        public void setVisibilityListener(VisibilityListener listener) {
            C0219b c0219b;
            this.f920c = listener;
            C0220d c0220d = this.a;
            if (listener == null) {
                c0219b = null;
            }
            c0220d.m989a(c0219b);
        }

        public void m1962a(boolean isVisible) {
            if (this.f920c != null) {
                this.f920c.onActionProviderVisibilityChanged(isVisible);
            }
        }
    }

    C0407j(MenuItem object) {
        super(object, false);
    }

    C0401a m1963b(C0220d provider) {
        return new C0406a(this, provider);
    }
}

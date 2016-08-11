package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v4.view.d */
public abstract class C0220d {
    private final Context f478a;
    private C0218a f479b;
    private C0219b f480c;

    /* renamed from: android.support.v4.view.d.a */
    public interface C0218a {
        void m984a(boolean z);
    }

    /* renamed from: android.support.v4.view.d.b */
    public interface C0219b {
        void m985a(boolean z);
    }

    public abstract View m992b();

    public C0220d(Context context) {
        this.f478a = context;
    }

    public Context m986a() {
        return this.f478a;
    }

    public View m987a(MenuItem forItem) {
        return m992b();
    }

    public boolean m993c() {
        return false;
    }

    public boolean m994d() {
        return true;
    }

    public void m995e() {
        if (this.f480c != null && m993c()) {
            this.f480c.m985a(m994d());
        }
    }

    public boolean m996f() {
        return false;
    }

    public boolean m997g() {
        return false;
    }

    public void m990a(SubMenu subMenu) {
    }

    public void m991a(boolean isVisible) {
        if (this.f479b != null) {
            this.f479b.m984a(isVisible);
        }
    }

    public void m988a(C0218a listener) {
        this.f479b = listener;
    }

    public void m989a(C0219b listener) {
        if (!(this.f480c == null || listener == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f480c = listener;
    }
}

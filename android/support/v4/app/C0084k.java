package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.C0083o;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.app.k */
public abstract class C0084k extends C0083o {
    private final C0075i f240a;
    private C0066l f241b;
    private Fragment f242c;

    public abstract Fragment m367a(int i);

    public C0084k(C0075i fm) {
        this.f241b = null;
        this.f242c = null;
        this.f240a = fm;
    }

    public void m370a(ViewGroup container) {
    }

    public Object m368a(ViewGroup container, int position) {
        if (this.f241b == null) {
            this.f241b = this.f240a.m262a();
        }
        long itemId = m373b(position);
        Fragment fragment = this.f240a.m261a(C0084k.m365a(container.getId(), itemId));
        if (fragment != null) {
            this.f241b.m192c(fragment);
        } else {
            fragment = m367a(position);
            this.f241b.m184a(container.getId(), fragment, C0084k.m365a(container.getId(), itemId));
        }
        if (fragment != this.f242c) {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        }
        return fragment;
    }

    public void m371a(ViewGroup container, int position, Object object) {
        if (this.f241b == null) {
            this.f241b = this.f240a.m262a();
        }
        this.f241b.m190b((Fragment) object);
    }

    public void m375b(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment) object;
        if (fragment != this.f242c) {
            if (this.f242c != null) {
                this.f242c.setMenuVisibility(false);
                this.f242c.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f242c = fragment;
        }
    }

    public void m374b(ViewGroup container) {
        if (this.f241b != null) {
            this.f241b.m191c();
            this.f241b = null;
            this.f240a.m268b();
        }
    }

    public boolean m372a(View view, Object object) {
        return ((Fragment) object).getView() == view;
    }

    public Parcelable m366a() {
        return null;
    }

    public void m369a(Parcelable state, ClassLoader loader) {
    }

    public long m373b(int position) {
        return (long) position;
    }

    private static String m365a(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }
}

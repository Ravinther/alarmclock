package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.C0373d;
import android.support.v7.internal.view.menu.C0384l.C0335a;
import android.support.v7.internal.view.menu.C0385k;
import android.support.v7.internal.view.menu.C0397f;
import android.support.v7.internal.view.menu.C0397f.C0334a;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.widget.a */
public class C0483a implements C0334a, C0335a {
    private Context f1276a;
    private C0397f f1277b;
    private View f1278c;
    private C0385k f1279d;
    private C0482b f1280e;
    private C0481a f1281f;

    /* renamed from: android.support.v7.widget.a.a */
    public interface C0481a {
        void m2300a(C0483a c0483a);
    }

    /* renamed from: android.support.v7.widget.a.b */
    public interface C0482b {
        boolean m2301a(MenuItem menuItem);
    }

    public C0483a(Context context, View anchor) {
        this.f1276a = context;
        this.f1277b = new C0397f(context);
        this.f1277b.m1889a((C0334a) this);
        this.f1278c = anchor;
        this.f1279d = new C0385k(context, this.f1277b, anchor);
        this.f1279d.m1772a((C0335a) this);
    }

    public Menu m2302a() {
        return this.f1277b;
    }

    public MenuInflater m2308b() {
        return new C0373d(this.f1276a);
    }

    public void m2310c() {
        this.f1279d.m1769a();
    }

    public void m2306a(C0482b listener) {
        this.f1280e = listener;
    }

    public void m2305a(C0481a listener) {
        this.f1281f = listener;
    }

    public boolean m2307a(C0397f menu, MenuItem item) {
        if (this.f1280e != null) {
            return this.f1280e.m2301a(item);
        }
        return false;
    }

    public void m2304a(C0397f menu, boolean allMenusAreClosing) {
        if (this.f1281f != null) {
            this.f1281f.m2300a(this);
        }
    }

    public boolean m2309b(C0397f subMenu) {
        if (subMenu == null) {
            return false;
        }
        if (!subMenu.hasVisibleItems()) {
            return true;
        }
        new C0385k(this.f1276a, subMenu, this.f1278c).m1769a();
        return true;
    }

    public void m2303a(C0397f menu) {
    }
}

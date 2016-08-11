package android.support.v7.p012a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0098p;
import android.support.v7.internal.view.C0373d;
import android.support.v7.p013c.C0342a;
import android.support.v7.p013c.C0342a.C0332a;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.cast.Cast;

/* renamed from: android.support.v7.a.c */
abstract class C0330c {
    final C0329b f613a;
    boolean f614b;
    boolean f615c;
    private C0328a f616d;
    private MenuInflater f617e;
    private boolean f618f;

    abstract C0328a m1490a();

    abstract C0342a m1491a(C0332a c0332a);

    abstract void m1492a(int i);

    abstract void m1493a(Configuration configuration);

    abstract void m1495a(View view);

    abstract void m1496a(View view, LayoutParams layoutParams);

    abstract void m1497a(CharSequence charSequence);

    abstract boolean m1498a(int i, Menu menu);

    abstract boolean m1499a(int i, MenuItem menuItem);

    abstract boolean m1500a(int i, View view, Menu menu);

    abstract View m1503b(int i);

    abstract void m1504b(View view, LayoutParams layoutParams);

    abstract void m1506d();

    abstract void m1507e();

    abstract void m1508f();

    abstract boolean m1509g();

    abstract void m1510h();

    static C0330c m1489a(C0329b activity) {
        if (VERSION.SDK_INT >= 18) {
            return new C0341h(activity);
        }
        if (VERSION.SDK_INT >= 16) {
            return new C0340g(activity);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0339f(activity);
        }
        if (VERSION.SDK_INT >= 11) {
            return new C0337e(activity);
        }
        return new C0336d(activity);
    }

    C0330c(C0329b activity) {
        this.f613a = activity;
    }

    final C0328a m1502b() {
        if (!this.f614b && !this.f615c) {
            this.f616d = null;
        } else if (this.f616d == null) {
            this.f616d = m1490a();
            if (this.f618f) {
                this.f616d.m1461c(true);
            }
        }
        return this.f616d;
    }

    MenuInflater m1505c() {
        if (this.f617e == null) {
            this.f617e = new C0373d(m1512j());
        }
        return this.f617e;
    }

    void m1494a(Bundle savedInstanceState) {
        TypedArray a = this.f613a.obtainStyledAttributes(C0363j.ActionBarWindow);
        if (a.hasValue(0)) {
            this.f614b = a.getBoolean(0, false);
            this.f615c = a.getBoolean(1, false);
            a.recycle();
            if (C0098p.m438b(this.f613a) == null) {
                return;
            }
            if (this.f616d == null) {
                this.f618f = true;
                return;
            } else {
                this.f616d.m1461c(true);
                return;
            }
        }
        a.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    boolean m1501a(View view, Menu menu) {
        if (VERSION.SDK_INT < 16) {
            return this.f613a.onPrepareOptionsMenu(menu);
        }
        return this.f613a.m1484b(view, menu);
    }

    protected final String m1511i() {
        try {
            ActivityInfo info = this.f613a.getPackageManager().getActivityInfo(this.f613a.getComponentName(), Cast.MAX_NAMESPACE_LENGTH);
            if (info.metaData != null) {
                return info.metaData.getString("android.support.UI_OPTIONS");
            }
            return null;
        } catch (NameNotFoundException e) {
            Log.e("ActionBarActivityDelegate", "getUiOptionsFromMetadata: Activity '" + this.f613a.getClass().getSimpleName() + "' not in manifest");
            return null;
        }
    }

    protected final Context m1512j() {
        Context context = this.f613a;
        C0328a ab = m1502b();
        if (ab != null) {
            return ab.m1466f();
        }
        return context;
    }
}

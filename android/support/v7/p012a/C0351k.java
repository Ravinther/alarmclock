package android.support.v7.p012a;

import android.app.ActionBar;
import android.app.ActionBar.OnMenuVisibilityListener;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.C0066l;
import android.support.v7.p012a.C0328a.C0322a;
import android.support.v7.p012a.C0328a.C0324c;
import android.support.v7.p012a.C0328a.C0326e;
import android.support.v7.p012a.C0328a.C0327f;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: android.support.v7.a.k */
class C0351k extends C0328a {
    final Activity f687a;
    final C0322a f688b;
    final ActionBar f689c;
    C0066l f690d;
    private ArrayList f691e;

    /* renamed from: android.support.v7.a.k.a */
    static class C0349a implements OnMenuVisibilityListener {
        final C0324c f681a;

        public C0349a(C0324c l) {
            this.f681a = l;
        }

        public void onMenuVisibilityChanged(boolean isVisible) {
            this.f681a.m1435a(isVisible);
        }
    }

    /* renamed from: android.support.v7.a.k.b */
    class C0350b extends C0326e implements TabListener {
        final Tab f682a;
        final /* synthetic */ C0351k f683b;
        private Object f684c;
        private CharSequence f685d;
        private C0327f f686e;

        public C0350b(C0351k c0351k, Tab tab) {
            this.f683b = c0351k;
            this.f682a = tab;
        }

        public int m1654a() {
            return this.f682a.getPosition();
        }

        public Drawable m1657b() {
            return this.f682a.getIcon();
        }

        public CharSequence m1658c() {
            return this.f682a.getText();
        }

        public C0326e m1655a(int resId) {
            this.f682a.setIcon(resId);
            return this;
        }

        public View m1659d() {
            return this.f682a.getCustomView();
        }

        public C0326e m1656a(Object obj) {
            this.f684c = obj;
            return this;
        }

        public Object m1660e() {
            return this.f684c;
        }

        public void m1661f() {
            this.f682a.select();
        }

        public CharSequence m1662g() {
            return this.f685d;
        }

        public void onTabSelected(Tab tab, FragmentTransaction ft) {
            this.f686e.m1446a(this, ft != null ? this.f683b.m1683g() : null);
            this.f683b.m1684h();
        }

        public void onTabUnselected(Tab tab, FragmentTransaction ft) {
            this.f686e.m1447b(this, ft != null ? this.f683b.m1683g() : null);
        }

        public void onTabReselected(Tab tab, FragmentTransaction ft) {
            this.f686e.m1448c(this, ft != null ? this.f683b.m1683g() : null);
            this.f683b.m1684h();
        }
    }

    public C0351k(Activity activity, C0322a callback) {
        this(activity, callback, true);
    }

    C0351k(Activity activity, C0322a callback, boolean checkHomeAsUpOption) {
        this.f691e = new ArrayList();
        this.f687a = activity;
        this.f688b = callback;
        this.f689c = activity.getActionBar();
        if (checkHomeAsUpOption && (m1669b() & 4) != 0) {
            m1682f(true);
        }
    }

    private C0349a m1663c(C0324c compatListener) {
        int i = 0;
        while (i < this.f691e.size()) {
            C0349a wrapper = (C0349a) ((WeakReference) this.f691e.get(i)).get();
            if (wrapper == null) {
                int i2 = i - 1;
                this.f691e.remove(i);
                i = i2;
            } else if (wrapper.f681a == compatListener) {
                this.f691e.remove(i);
                return wrapper;
            }
            i++;
        }
        return null;
    }

    public void m1665a(int resId) {
        this.f689c.setCustomView(resId);
    }

    public void m1670b(int resId) {
        this.f689c.setIcon(resId);
    }

    public void m1675c(int resId) {
        this.f689c.setLogo(resId);
    }

    public void m1667a(CharSequence title) {
        this.f689c.setTitle(title);
    }

    public void m1672b(CharSequence subtitle) {
        this.f689c.setSubtitle(subtitle);
    }

    public void m1668a(boolean useLogo) {
        this.f689c.setDisplayUseLogoEnabled(useLogo);
    }

    public void m1673b(boolean showHome) {
        this.f689c.setDisplayShowHomeEnabled(showHome);
    }

    public void m1676c(boolean showHomeAsUp) {
        this.f689c.setDisplayHomeAsUpEnabled(showHomeAsUp);
    }

    public void m1678d(boolean showTitle) {
        this.f689c.setDisplayShowTitleEnabled(showTitle);
    }

    public void m1680e(boolean showCustom) {
        this.f689c.setDisplayShowCustomEnabled(showCustom);
    }

    public View m1664a() {
        return this.f689c.getCustomView();
    }

    public int m1669b() {
        return this.f689c.getDisplayOptions();
    }

    public C0326e m1674c() {
        Tab realTab = this.f689c.newTab();
        C0350b result = new C0350b(this, realTab);
        realTab.setTag(result);
        return result;
    }

    public Context m1681f() {
        return this.f689c.getThemedContext();
    }

    public void m1677d() {
        this.f689c.show();
    }

    public void m1679e() {
        this.f689c.hide();
    }

    public void m1666a(C0324c listener) {
        if (listener != null) {
            C0349a w = new C0349a(listener);
            this.f691e.add(new WeakReference(w));
            this.f689c.addOnMenuVisibilityListener(w);
        }
    }

    public void m1671b(C0324c listener) {
        this.f689c.removeOnMenuVisibilityListener(m1663c(listener));
    }

    public void m1682f(boolean enabled) {
        this.f689c.setHomeButtonEnabled(enabled);
    }

    C0066l m1683g() {
        if (this.f690d == null) {
            this.f690d = this.f688b.m1434g().m262a().m181a();
        }
        return this.f690d;
    }

    void m1684h() {
        if (!(this.f690d == null || this.f690d.m193e())) {
            this.f690d.m188b();
        }
        this.f690d = null;
    }
}

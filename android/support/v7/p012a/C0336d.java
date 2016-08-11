package android.support.v7.p012a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.internal.view.menu.C0384l.C0335a;
import android.support.v7.internal.view.menu.C0391m;
import android.support.v7.internal.view.menu.C0396e;
import android.support.v7.internal.view.menu.C0397f;
import android.support.v7.internal.view.menu.C0397f.C0334a;
import android.support.v7.internal.view.menu.C0409n;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.p013c.C0342a;
import android.support.v7.p013c.C0342a.C0332a;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0356c;
import android.support.v7.p014b.C0364a.C0358e;
import android.support.v7.p014b.C0364a.C0360g;
import android.support.v7.p014b.C0364a.C0362i;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.a.d */
class C0336d extends C0330c implements C0334a, C0335a {
    private static final int[] f622d;
    private ActionBarView f623e;
    private C0396e f624f;
    private C0397f f625g;
    private C0342a f626h;
    private boolean f627i;
    private CharSequence f628j;
    private boolean f629k;
    private boolean f630l;
    private boolean f631m;
    private boolean f632n;
    private boolean f633o;
    private Bundle f634p;

    /* renamed from: android.support.v7.a.d.1 */
    class C03311 implements Runnable {
        final /* synthetic */ C0336d f619a;

        C03311(C0336d c0336d) {
            this.f619a = c0336d;
        }

        public void run() {
            this.f619a.m1549f();
        }
    }

    /* renamed from: android.support.v7.a.d.a */
    private class C0333a implements C0332a {
        final /* synthetic */ C0336d f620a;
        private C0332a f621b;

        public C0333a(C0336d c0336d, C0332a wrapped) {
            this.f620a = c0336d;
            this.f621b = wrapped;
        }

        public boolean m1518a(C0342a mode, Menu menu) {
            return this.f621b.m1514a(mode, menu);
        }

        public boolean m1520b(C0342a mode, Menu menu) {
            return this.f621b.m1516b(mode, menu);
        }

        public boolean m1519a(C0342a mode, MenuItem item) {
            return this.f621b.m1515a(mode, item);
        }

        public void m1517a(C0342a mode) {
            this.f621b.m1513a(mode);
            this.f620a.a.m1482b(mode);
            this.f620a.f626h = null;
        }
    }

    static {
        f622d = new int[]{C0355b.homeAsUpIndicator};
    }

    C0336d(C0329b activity) {
        super(activity);
    }

    public C0328a m1531a() {
        m1552k();
        return new C0345i(this.a, this.a);
    }

    public void m1534a(Configuration newConfig) {
        if (this.b && this.f627i) {
            ((C0345i) m1502b()).m1620a(newConfig);
        }
    }

    public void m1547d() {
        C0345i ab = (C0345i) m1502b();
        if (ab != null) {
            ab.m1643h(false);
        }
    }

    public void m1548e() {
        C0345i ab = (C0345i) m1502b();
        if (ab != null) {
            ab.m1643h(true);
        }
    }

    public void m1537a(View v) {
        m1552k();
        ViewGroup contentParent = (ViewGroup) this.a.findViewById(16908290);
        contentParent.removeAllViews();
        contentParent.addView(v);
        this.a.m1488j();
    }

    public void m1533a(int resId) {
        m1552k();
        ViewGroup contentParent = (ViewGroup) this.a.findViewById(16908290);
        contentParent.removeAllViews();
        this.a.getLayoutInflater().inflate(resId, contentParent);
        this.a.m1488j();
    }

    public void m1538a(View v, LayoutParams lp) {
        m1552k();
        ViewGroup contentParent = (ViewGroup) this.a.findViewById(16908290);
        contentParent.removeAllViews();
        contentParent.addView(v, lp);
        this.a.m1488j();
    }

    public void m1545b(View v, LayoutParams lp) {
        m1552k();
        ((ViewGroup) this.a.findViewById(16908290)).addView(v, lp);
        this.a.m1488j();
    }

    public void m1551h() {
    }

    final void m1552k() {
        if (!this.f627i) {
            if (this.b) {
                boolean splitActionBar;
                if (this.c) {
                    this.a.m1470a(C0360g.abc_action_bar_decor_overlay);
                } else {
                    this.a.m1470a(C0360g.abc_action_bar_decor);
                }
                this.f623e = (ActionBarView) this.a.findViewById(C0358e.action_bar);
                this.f623e.setWindowCallback(this.a);
                if (this.f629k) {
                    this.f623e.m2083g();
                }
                if (this.f630l) {
                    this.f623e.m2084h();
                }
                boolean splitWhenNarrow = "splitActionBarWhenNarrow".equals(m1511i());
                if (splitWhenNarrow) {
                    splitActionBar = this.a.getResources().getBoolean(C0356c.abc_split_action_bar_is_narrow);
                } else {
                    TypedArray a = this.a.obtainStyledAttributes(C0363j.ActionBarWindow);
                    splitActionBar = a.getBoolean(2, false);
                    a.recycle();
                }
                ActionBarContainer splitView = (ActionBarContainer) this.a.findViewById(C0358e.split_action_bar);
                if (splitView != null) {
                    this.f623e.setSplitView(splitView);
                    this.f623e.setSplitActionBar(splitActionBar);
                    this.f623e.setSplitWhenNarrow(splitWhenNarrow);
                    ActionBarContextView cab = (ActionBarContextView) this.a.findViewById(C0358e.action_context_bar);
                    cab.setSplitView(splitView);
                    cab.setSplitActionBar(splitActionBar);
                    cab.setSplitWhenNarrow(splitWhenNarrow);
                }
            } else {
                this.a.m1470a(C0360g.abc_simple_decor);
            }
            this.a.findViewById(16908290).setId(-1);
            this.a.findViewById(C0358e.action_bar_activity_content).setId(16908290);
            if (this.f628j != null) {
                this.f623e.setWindowTitle(this.f628j);
                this.f628j = null;
            }
            m1528l();
            this.f627i = true;
            this.a.getWindow().getDecorView().post(new C03311(this));
        }
    }

    private void m1528l() {
        TypedValue tvw;
        TypedValue tvh;
        TypedArray a = this.a.obtainStyledAttributes(C0363j.ActionBarWindow);
        TypedValue mFixedWidthMajor = null;
        TypedValue mFixedWidthMinor = null;
        TypedValue mFixedHeightMajor = null;
        TypedValue mFixedHeightMinor = null;
        if (a.hasValue(3)) {
            if (null == null) {
                mFixedWidthMajor = new TypedValue();
            }
            a.getValue(3, mFixedWidthMajor);
        }
        if (a.hasValue(5)) {
            if (null == null) {
                mFixedWidthMinor = new TypedValue();
            }
            a.getValue(5, mFixedWidthMinor);
        }
        if (a.hasValue(6)) {
            if (null == null) {
                mFixedHeightMajor = new TypedValue();
            }
            a.getValue(6, mFixedHeightMajor);
        }
        if (a.hasValue(4)) {
            if (null == null) {
                mFixedHeightMinor = new TypedValue();
            }
            a.getValue(4, mFixedHeightMinor);
        }
        DisplayMetrics metrics = this.a.getResources().getDisplayMetrics();
        boolean isPortrait = metrics.widthPixels < metrics.heightPixels;
        int w = -1;
        int h = -1;
        if (isPortrait) {
            tvw = mFixedWidthMinor;
        } else {
            tvw = mFixedWidthMajor;
        }
        if (!(tvw == null || tvw.type == 0)) {
            if (tvw.type == 5) {
                w = (int) tvw.getDimension(metrics);
            } else if (tvw.type == 6) {
                w = (int) tvw.getFraction((float) metrics.widthPixels, (float) metrics.widthPixels);
            }
        }
        if (isPortrait) {
            tvh = mFixedHeightMajor;
        } else {
            tvh = mFixedHeightMinor;
        }
        if (!(tvh == null || tvh.type == 0)) {
            if (tvh.type == 5) {
                h = (int) tvh.getDimension(metrics);
            } else if (tvh.type == 6) {
                h = (int) tvh.getFraction((float) metrics.heightPixels, (float) metrics.heightPixels);
            }
        }
        if (!(w == -1 && h == -1)) {
            this.a.getWindow().setLayout(w, h);
        }
        a.recycle();
    }

    public void m1539a(CharSequence title) {
        if (this.f623e != null) {
            this.f623e.setWindowTitle(title);
        } else {
            this.f628j = title;
        }
    }

    public View m1544b(int featureId) {
        if (featureId == 0 && m1530n()) {
            return (View) m1526a(this.a, (C0335a) this);
        }
        return null;
    }

    public boolean m1540a(int featureId, Menu menu) {
        if (featureId != 0) {
            return this.a.m1475a(featureId, menu);
        }
        return false;
    }

    public boolean m1542a(int featureId, View view, Menu menu) {
        if (featureId != 0) {
            return this.a.m1477a(featureId, view, menu);
        }
        return false;
    }

    public boolean m1541a(int featureId, MenuItem item) {
        if (featureId == 0) {
            item = C0409n.m1969a(item);
        }
        return this.a.m1476a(featureId, item);
    }

    public boolean m1543a(C0397f menu, MenuItem item) {
        return this.a.onMenuItemSelected(0, item);
    }

    public void m1535a(C0397f menu) {
        m1527b(menu, true);
    }

    public void m1536a(C0397f menu, boolean allMenusAreClosing) {
        if (!this.f631m) {
            this.f631m = true;
            this.a.closeOptionsMenu();
            this.f623e.m2082f();
            this.f631m = false;
        }
    }

    public boolean m1546b(C0397f subMenu) {
        return false;
    }

    public C0342a m1532a(C0332a callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f626h != null) {
            this.f626h.m1584c();
        }
        C0332a wrappedCallback = new C0333a(this, callback);
        C0345i ab = (C0345i) m1502b();
        if (ab != null) {
            this.f626h = ab.m1616a(wrappedCallback);
        }
        if (this.f626h != null) {
            this.a.m1472a(this.f626h);
        }
        return this.f626h;
    }

    public void m1549f() {
        if (this.f625g != null) {
            Bundle savedActionViewStates = new Bundle();
            this.f625g.m1888a(savedActionViewStates);
            if (savedActionViewStates.size() > 0) {
                this.f634p = savedActionViewStates;
            }
            this.f625g.m1910g();
            this.f625g.clear();
        }
        this.f633o = true;
        if (this.f623e != null) {
            this.f632n = false;
            m1530n();
        }
    }

    private void m1527b(C0397f menu, boolean toggleMenuMode) {
        if (this.f623e == null || !this.f623e.m2081e()) {
            menu.close();
        } else if (this.f623e.m2080d() && toggleMenuMode) {
            this.f623e.m2079c();
        } else if (this.f623e.getVisibility() == 0) {
            this.f623e.m2077a();
        }
    }

    private C0391m m1526a(Context context, C0335a cb) {
        if (this.f625g == null) {
            return null;
        }
        if (this.f624f == null) {
            TypedArray a = context.obtainStyledAttributes(C0363j.Theme);
            int listPresenterTheme = a.getResourceId(4, C0362i.Theme_AppCompat_CompactMenu);
            a.recycle();
            this.f624f = new C0396e(C0360g.abc_list_menu_item_layout, listPresenterTheme);
            this.f624f.m1867a(cb);
            this.f625g.m1891a(this.f624f);
        } else {
            this.f624f.m1871d(false);
        }
        return this.f624f.m1863a(new FrameLayout(context));
    }

    public boolean m1550g() {
        if (this.f626h != null) {
            this.f626h.m1584c();
            return true;
        } else if (this.f623e == null || !this.f623e.m2087k()) {
            return false;
        } else {
            this.f623e.m2088l();
            return true;
        }
    }

    private boolean m1529m() {
        this.f625g = new C0397f(m1512j());
        this.f625g.m1889a((C0334a) this);
        return true;
    }

    private boolean m1530n() {
        if (this.f632n) {
            return true;
        }
        if (this.f625g == null || this.f633o) {
            if (this.f625g == null && (!m1529m() || this.f625g == null)) {
                return false;
            }
            if (this.f623e != null) {
                this.f623e.m2076a(this.f625g, this);
            }
            this.f625g.m1910g();
            if (this.a.m1475a(0, this.f625g)) {
                this.f633o = false;
            } else {
                this.f625g = null;
                if (this.f623e != null) {
                    this.f623e.m2076a(null, this);
                }
                return false;
            }
        }
        this.f625g.m1910g();
        if (this.f634p != null) {
            this.f625g.m1898b(this.f634p);
            this.f634p = null;
        }
        if (this.a.m1477a(0, null, this.f625g)) {
            this.f625g.m1911h();
            this.f632n = true;
            return true;
        }
        if (this.f623e != null) {
            this.f623e.m2076a(null, this);
        }
        this.f625g.m1911h();
        return false;
    }
}

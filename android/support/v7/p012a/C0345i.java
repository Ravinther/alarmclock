package android.support.v7.p012a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.C0066l;
import android.support.v7.internal.view.C0366a;
import android.support.v7.internal.view.C0373d;
import android.support.v7.internal.view.menu.C0397f;
import android.support.v7.internal.view.menu.C0397f.C0334a;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.p012a.C0328a.C0322a;
import android.support.v7.p012a.C0328a.C0324c;
import android.support.v7.p012a.C0328a.C0326e;
import android.support.v7.p012a.C0328a.C0327f;
import android.support.v7.p013c.C0342a;
import android.support.v7.p013c.C0342a.C0332a;
import android.support.v7.p014b.C0364a.C0354a;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0358e;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

/* renamed from: android.support.v7.a.i */
class C0345i extends C0328a {
    private boolean f649A;
    private C0322a f650B;
    C0343a f651a;
    C0342a f652b;
    C0332a f653c;
    final Handler f654d;
    private Context f655e;
    private Context f656f;
    private C0329b f657g;
    private ActionBarOverlayLayout f658h;
    private ActionBarContainer f659i;
    private ViewGroup f660j;
    private ActionBarView f661k;
    private ActionBarContextView f662l;
    private ActionBarContainer f663m;
    private ScrollingTabContainerView f664n;
    private ArrayList f665o;
    private C0344b f666p;
    private int f667q;
    private boolean f668r;
    private ArrayList f669s;
    private int f670t;
    private boolean f671u;
    private int f672v;
    private boolean f673w;
    private boolean f674x;
    private boolean f675y;
    private boolean f676z;

    /* renamed from: android.support.v7.a.i.a */
    class C0343a extends C0342a implements C0334a {
        final /* synthetic */ C0345i f638a;
        private C0332a f639b;
        private C0397f f640c;

        public C0343a(C0345i c0345i, C0332a callback) {
            this.f638a = c0345i;
            this.f639b = callback;
            this.f640c = new C0397f(c0345i.m1638f()).m1882a(1);
            this.f640c.m1889a((C0334a) this);
        }

        public MenuInflater m1586a() {
            return new C0373d(this.f638a.m1638f());
        }

        public Menu m1590b() {
            return this.f640c;
        }

        public void m1591c() {
            if (this.f638a.f651a == this) {
                if (C0345i.m1609b(this.f638a.f673w, this.f638a.f674x, false)) {
                    this.f639b.m1513a(this);
                } else {
                    this.f638a.f652b = this;
                    this.f638a.f653c = this.f639b;
                }
                this.f639b = null;
                this.f638a.m1641g(false);
                this.f638a.f662l.m2039g();
                this.f638a.f661k.sendAccessibilityEvent(32);
                this.f638a.f651a = null;
            }
        }

        public void m1592d() {
            this.f640c.m1910g();
            try {
                this.f639b.m1516b(this, this.f640c);
            } finally {
                this.f640c.m1911h();
            }
        }

        public boolean m1593e() {
            this.f640c.m1910g();
            try {
                boolean a = this.f639b.m1514a((C0342a) this, this.f640c);
                return a;
            } finally {
                this.f640c.m1911h();
            }
        }

        public void m1588a(CharSequence title) {
            this.f638a.f662l.setTitle(title);
        }

        public boolean m1589a(C0397f menu, MenuItem item) {
            if (this.f639b != null) {
                return this.f639b.m1515a((C0342a) this, item);
            }
            return false;
        }

        public void m1587a(C0397f menu) {
            if (this.f639b != null) {
                m1592d();
                this.f638a.f662l.m2033a();
            }
        }
    }

    /* renamed from: android.support.v7.a.i.b */
    public class C0344b extends C0326e {
        final /* synthetic */ C0345i f641a;
        private C0327f f642b;
        private Object f643c;
        private Drawable f644d;
        private CharSequence f645e;
        private CharSequence f646f;
        private int f647g;
        private View f648h;

        public C0344b(C0345i c0345i) {
            this.f641a = c0345i;
            this.f647g = -1;
        }

        public Object m1601e() {
            return this.f643c;
        }

        public C0326e m1597a(Object tag) {
            this.f643c = tag;
            return this;
        }

        public C0327f m1604h() {
            return this.f642b;
        }

        public View m1600d() {
            return this.f648h;
        }

        public Drawable m1598b() {
            return this.f644d;
        }

        public int m1594a() {
            return this.f647g;
        }

        public CharSequence m1599c() {
            return this.f645e;
        }

        public C0326e m1596a(Drawable icon) {
            this.f644d = icon;
            if (this.f647g >= 0) {
                this.f641a.f664n.m2119b(this.f647g);
            }
            return this;
        }

        public C0326e m1595a(int resId) {
            return m1596a(this.f641a.f655e.getResources().getDrawable(resId));
        }

        public void m1602f() {
            this.f641a.m1622a((C0326e) this);
        }

        public CharSequence m1603g() {
            return this.f646f;
        }
    }

    public C0345i(C0329b activity, C0322a callback) {
        this.f665o = new ArrayList();
        this.f667q = -1;
        this.f669s = new ArrayList();
        this.f654d = new Handler();
        this.f672v = 0;
        this.f676z = true;
        this.f657g = activity;
        this.f655e = activity;
        this.f650B = callback;
        m1606a(this.f657g);
    }

    private void m1606a(C0329b activity) {
        boolean z = false;
        this.f658h = (ActionBarOverlayLayout) activity.findViewById(C0358e.action_bar_overlay_layout);
        if (this.f658h != null) {
            this.f658h.setActionBar(this);
        }
        this.f661k = (ActionBarView) activity.findViewById(C0358e.action_bar);
        this.f662l = (ActionBarContextView) activity.findViewById(C0358e.action_context_bar);
        this.f659i = (ActionBarContainer) activity.findViewById(C0358e.action_bar_container);
        this.f660j = (ViewGroup) activity.findViewById(C0358e.top_action_bar);
        if (this.f660j == null) {
            this.f660j = this.f659i;
        }
        this.f663m = (ActionBarContainer) activity.findViewById(C0358e.split_action_bar);
        if (this.f661k == null || this.f662l == null || this.f659i == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        int i;
        boolean homeAsUp;
        this.f661k.setContextView(this.f662l);
        if (this.f661k.m2085i()) {
            i = 1;
        } else {
            i = 0;
        }
        this.f670t = i;
        if ((this.f661k.getDisplayOptions() & 4) != 0) {
            homeAsUp = true;
        } else {
            homeAsUp = false;
        }
        if (homeAsUp) {
            this.f668r = true;
        }
        C0366a abp = C0366a.m1706a(this.f655e);
        if (abp.m1712f() || homeAsUp) {
            z = true;
        }
        m1639f(z);
        m1614k(abp.m1710d());
        m1624a(this.f657g.getTitle());
    }

    public void m1620a(Configuration newConfig) {
        m1614k(C0366a.m1706a(this.f655e).m1710d());
    }

    private void m1614k(boolean hasEmbeddedTabs) {
        boolean isInTabMode;
        boolean z = true;
        this.f671u = hasEmbeddedTabs;
        if (this.f671u) {
            this.f659i.setTabContainer(null);
            this.f661k.setEmbeddedTabView(this.f664n);
        } else {
            this.f661k.setEmbeddedTabView(null);
            this.f659i.setTabContainer(this.f664n);
        }
        if (m1640g() == 2) {
            isInTabMode = true;
        } else {
            isInTabMode = false;
        }
        if (this.f664n != null) {
            if (isInTabMode) {
                this.f664n.setVisibility(0);
            } else {
                this.f664n.setVisibility(8);
            }
        }
        ActionBarView actionBarView = this.f661k;
        if (this.f671u || !isInTabMode) {
            z = false;
        }
        actionBarView.setCollapsable(z);
    }

    public void m1623a(View view) {
        this.f661k.setCustomNavigationView(view);
    }

    public void m1618a(int resId) {
        m1623a(LayoutInflater.from(m1638f()).inflate(resId, this.f661k, false));
    }

    public void m1627b(int resId) {
        this.f661k.setIcon(resId);
    }

    public void m1632c(int resId) {
        this.f661k.setLogo(resId);
    }

    public void m1624a(CharSequence title) {
        this.f661k.setTitle(title);
    }

    public void m1629b(CharSequence subtitle) {
        this.f661k.setSubtitle(subtitle);
    }

    public void m1619a(int options, int mask) {
        int current = this.f661k.getDisplayOptions();
        if ((mask & 4) != 0) {
            this.f668r = true;
        }
        this.f661k.setDisplayOptions((options & mask) | ((mask ^ -1) & current));
    }

    public void m1625a(boolean useLogo) {
        m1619a(useLogo ? 1 : 0, 1);
    }

    public void m1630b(boolean showHome) {
        m1619a(showHome ? 2 : 0, 2);
    }

    public void m1633c(boolean showHomeAsUp) {
        m1619a(showHomeAsUp ? 4 : 0, 4);
    }

    public void m1635d(boolean showTitle) {
        m1619a(showTitle ? 8 : 0, 8);
    }

    public void m1637e(boolean showCustom) {
        m1619a(showCustom ? 16 : 0, 16);
    }

    public void m1639f(boolean enable) {
        this.f661k.setHomeButtonEnabled(enable);
    }

    public View m1617a() {
        return this.f661k.getCustomNavigationView();
    }

    public int m1640g() {
        return this.f661k.getNavigationMode();
    }

    public int m1626b() {
        return this.f661k.getDisplayOptions();
    }

    public C0326e m1631c() {
        return new C0344b(this);
    }

    public void m1622a(C0326e tab) {
        int i = -1;
        if (m1640g() != 2) {
            if (tab != null) {
                i = tab.m1437a();
            }
            this.f667q = i;
            return;
        }
        C0066l trans = this.f657g.m258g().m262a().m181a();
        if (this.f666p != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.f664n;
            if (tab != null) {
                i = tab.m1437a();
            }
            scrollingTabContainerView.setTabSelected(i);
            if (this.f666p != null) {
                this.f666p.m1604h().m1447b(this.f666p, trans);
            }
            this.f666p = (C0344b) tab;
            if (this.f666p != null) {
                this.f666p.m1604h().m1446a(this.f666p, trans);
            }
        } else if (this.f666p != null) {
            this.f666p.m1604h().m1448c(this.f666p, trans);
            this.f664n.m2117a(tab.m1437a());
        }
        if (!trans.m193e()) {
            trans.m188b();
        }
    }

    public Context m1638f() {
        if (this.f656f == null) {
            TypedValue outValue = new TypedValue();
            this.f655e.getTheme().resolveAttribute(C0355b.actionBarWidgetTheme, outValue, true);
            int targetThemeRes = outValue.resourceId;
            if (targetThemeRes != 0) {
                this.f656f = new ContextThemeWrapper(this.f655e, targetThemeRes);
            } else {
                this.f656f = this.f655e;
            }
        }
        return this.f656f;
    }

    public void m1634d() {
        if (this.f673w) {
            this.f673w = false;
            m1615l(false);
        }
    }

    void m1642h() {
        if (!this.f675y) {
            this.f675y = true;
            m1615l(false);
        }
    }

    public void m1636e() {
        if (!this.f673w) {
            this.f673w = true;
            m1615l(false);
        }
    }

    void m1644i() {
        if (this.f675y) {
            this.f675y = false;
            m1615l(false);
        }
    }

    public void m1621a(C0324c listener) {
        this.f669s.add(listener);
    }

    public void m1628b(C0324c listener) {
        this.f669s.remove(listener);
    }

    public C0342a m1616a(C0332a callback) {
        if (this.f651a != null) {
            this.f651a.m1591c();
        }
        this.f662l.m2040h();
        C0342a mode = new C0343a(this, callback);
        if (!mode.m1593e()) {
            return null;
        }
        mode.m1592d();
        this.f662l.m2032a(mode);
        m1641g(true);
        if (!(this.f663m == null || this.f670t != 1 || this.f663m.getVisibility() == 0)) {
            this.f663m.setVisibility(0);
        }
        this.f662l.sendAccessibilityEvent(32);
        this.f651a = mode;
        return mode;
    }

    void m1641g(boolean toActionMode) {
        int i;
        int i2 = 8;
        if (toActionMode) {
            m1642h();
        } else {
            m1644i();
        }
        ActionBarView actionBarView = this.f661k;
        if (toActionMode) {
            i = 4;
        } else {
            i = 0;
        }
        actionBarView.m2075a(i);
        ActionBarContextView actionBarContextView = this.f662l;
        if (toActionMode) {
            i = 0;
        } else {
            i = 8;
        }
        actionBarContextView.m2031a(i);
        if (this.f664n != null && !this.f661k.m2086j() && this.f661k.m2089m()) {
            ScrollingTabContainerView scrollingTabContainerView = this.f664n;
            if (!toActionMode) {
                i2 = 0;
            }
            scrollingTabContainerView.setVisibility(i2);
        }
    }

    private static boolean m1609b(boolean hiddenByApp, boolean hiddenBySystem, boolean showingForMode) {
        if (showingForMode) {
            return true;
        }
        if (hiddenByApp || hiddenBySystem) {
            return false;
        }
        return true;
    }

    private void m1615l(boolean fromSystem) {
        if (C0345i.m1609b(this.f673w, this.f674x, this.f675y)) {
            if (!this.f676z) {
                this.f676z = true;
                m1645i(fromSystem);
            }
        } else if (this.f676z) {
            this.f676z = false;
            m1646j(fromSystem);
        }
    }

    public void m1643h(boolean enabled) {
        this.f649A = enabled;
        if (!enabled) {
            this.f660j.clearAnimation();
            if (this.f663m != null) {
                this.f663m.clearAnimation();
            }
        }
    }

    public void m1645i(boolean fromSystem) {
        this.f660j.clearAnimation();
        if (this.f660j.getVisibility() != 0) {
            boolean animate;
            if (m1647j() || fromSystem) {
                animate = true;
            } else {
                animate = false;
            }
            if (animate) {
                this.f660j.startAnimation(AnimationUtils.loadAnimation(this.f655e, C0354a.abc_slide_in_top));
            }
            this.f660j.setVisibility(0);
            if (this.f663m != null && this.f663m.getVisibility() != 0) {
                if (animate) {
                    this.f663m.startAnimation(AnimationUtils.loadAnimation(this.f655e, C0354a.abc_slide_in_bottom));
                }
                this.f663m.setVisibility(0);
            }
        }
    }

    public void m1646j(boolean fromSystem) {
        this.f660j.clearAnimation();
        if (this.f660j.getVisibility() != 8) {
            boolean animate = m1647j() || fromSystem;
            if (animate) {
                this.f660j.startAnimation(AnimationUtils.loadAnimation(this.f655e, C0354a.abc_slide_out_top));
            }
            this.f660j.setVisibility(8);
            if (this.f663m != null && this.f663m.getVisibility() != 8) {
                if (animate) {
                    this.f663m.startAnimation(AnimationUtils.loadAnimation(this.f655e, C0354a.abc_slide_out_bottom));
                }
                this.f663m.setVisibility(8);
            }
        }
    }

    boolean m1647j() {
        return this.f649A;
    }
}

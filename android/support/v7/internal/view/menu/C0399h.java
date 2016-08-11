package android.support.v7.internal.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p007b.p008a.C0128b;
import android.support.v4.view.C0220d;
import android.support.v4.view.C0220d.C0219b;
import android.support.v4.view.C0240j.C0239e;
import android.support.v7.internal.view.menu.C0391m.C0377a;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import com.google.ads.AdSize;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: android.support.v7.internal.view.menu.h */
public final class C0399h implements C0128b {
    private static String f884w;
    private static String f885x;
    private static String f886y;
    private static String f887z;
    private final int f888a;
    private final int f889b;
    private final int f890c;
    private final int f891d;
    private CharSequence f892e;
    private CharSequence f893f;
    private Intent f894g;
    private char f895h;
    private char f896i;
    private Drawable f897j;
    private int f898k;
    private C0397f f899l;
    private C0411p f900m;
    private Runnable f901n;
    private OnMenuItemClickListener f902o;
    private int f903p;
    private int f904q;
    private View f905r;
    private C0220d f906s;
    private C0239e f907t;
    private boolean f908u;
    private ContextMenuInfo f909v;

    /* renamed from: android.support.v7.internal.view.menu.h.1 */
    class C03981 implements C0219b {
        final /* synthetic */ C0399h f883a;

        C03981(C0399h c0399h) {
            this.f883a = c0399h;
        }

        public void m1922a(boolean isVisible) {
            this.f883a.f899l.m1890a(this.f883a);
        }
    }

    public /* synthetic */ MenuItem setActionView(int x0) {
        return m1924a(x0);
    }

    public /* synthetic */ MenuItem setActionView(View x0) {
        return m1927a(x0);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int x0) {
        return m1934b(x0);
    }

    C0399h(C0397f menu, int group, int id, int categoryOrder, int ordering, CharSequence title, int showAsAction) {
        this.f898k = 0;
        this.f903p = 16;
        this.f904q = 0;
        this.f908u = false;
        this.f899l = menu;
        this.f888a = id;
        this.f889b = group;
        this.f890c = categoryOrder;
        this.f891d = ordering;
        this.f892e = title;
        this.f904q = showAsAction;
    }

    public boolean m1932a() {
        if ((this.f902o != null && this.f902o.onMenuItemClick(this)) || this.f899l.m1895a(this.f899l.m1919p(), (MenuItem) this)) {
            return true;
        }
        if (this.f901n != null) {
            this.f901n.run();
            return true;
        }
        if (this.f894g != null) {
            try {
                this.f899l.m1908e().startActivity(this.f894g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f906s == null || !this.f906s.m996f()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f903p & 16) != 0;
    }

    public MenuItem setEnabled(boolean enabled) {
        if (enabled) {
            this.f903p |= 16;
        } else {
            this.f903p &= -17;
        }
        this.f899l.m1901b(false);
        return this;
    }

    public int getGroupId() {
        return this.f889b;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f888a;
    }

    public int getOrder() {
        return this.f890c;
    }

    public int m1933b() {
        return this.f891d;
    }

    public Intent getIntent() {
        return this.f894g;
    }

    public MenuItem setIntent(Intent intent) {
        this.f894g = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f896i;
    }

    public MenuItem setAlphabeticShortcut(char alphaChar) {
        if (this.f896i != alphaChar) {
            this.f896i = Character.toLowerCase(alphaChar);
            this.f899l.m1901b(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.f895h;
    }

    public MenuItem setNumericShortcut(char numericChar) {
        if (this.f895h != numericChar) {
            this.f895h = numericChar;
            this.f899l.m1901b(false);
        }
        return this;
    }

    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.f895h = numericChar;
        this.f896i = Character.toLowerCase(alphaChar);
        this.f899l.m1901b(false);
        return this;
    }

    char m1936c() {
        return this.f896i;
    }

    String m1938d() {
        char shortcut = m1936c();
        if (shortcut == '\u0000') {
            return "";
        }
        StringBuilder sb = new StringBuilder(f884w);
        switch (shortcut) {
            case Base64.URL_SAFE /*8*/:
                sb.append(f886y);
                break;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                sb.append(f885x);
                break;
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                sb.append(f887z);
                break;
            default:
                sb.append(shortcut);
                break;
        }
        return sb.toString();
    }

    boolean m1941e() {
        return this.f899l.m1904c() && m1936c() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.f900m;
    }

    public boolean hasSubMenu() {
        return this.f900m != null;
    }

    void m1929a(C0411p subMenu) {
        this.f900m = subMenu;
        subMenu.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f892e;
    }

    CharSequence m1928a(C0377a itemView) {
        return (itemView == null || !itemView.m1743a()) ? getTitle() : getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence title) {
        this.f892e = title;
        this.f899l.m1901b(false);
        if (this.f900m != null) {
            this.f900m.setHeaderTitle(title);
        }
        return this;
    }

    public MenuItem setTitle(int title) {
        return setTitle(this.f899l.m1908e().getString(title));
    }

    public CharSequence getTitleCondensed() {
        return this.f893f != null ? this.f893f : this.f892e;
    }

    public MenuItem setTitleCondensed(CharSequence title) {
        this.f893f = title;
        if (title == null) {
            title = this.f892e;
        }
        this.f899l.m1901b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f897j != null) {
            return this.f897j;
        }
        if (this.f898k == 0) {
            return null;
        }
        Drawable icon = this.f899l.m1906d().getDrawable(this.f898k);
        this.f898k = 0;
        this.f897j = icon;
        return icon;
    }

    public MenuItem setIcon(Drawable icon) {
        this.f898k = 0;
        this.f897j = icon;
        this.f899l.m1901b(false);
        return this;
    }

    public MenuItem setIcon(int iconResId) {
        this.f897j = null;
        this.f898k = iconResId;
        this.f899l.m1901b(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.f903p & 1) == 1;
    }

    public MenuItem setCheckable(boolean checkable) {
        int oldFlags = this.f903p;
        this.f903p = (checkable ? 1 : 0) | (this.f903p & -2);
        if (oldFlags != this.f903p) {
            this.f899l.m1901b(false);
        }
        return this;
    }

    public void m1931a(boolean exclusive) {
        this.f903p = (exclusive ? 4 : 0) | (this.f903p & -5);
    }

    public boolean m1942f() {
        return (this.f903p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f903p & 2) == 2;
    }

    public MenuItem setChecked(boolean checked) {
        if ((this.f903p & 4) != 0) {
            this.f899l.m1892a((MenuItem) this);
        } else {
            m1935b(checked);
        }
        return this;
    }

    void m1935b(boolean checked) {
        int i;
        int oldFlags = this.f903p;
        int i2 = this.f903p & -3;
        if (checked) {
            i = 2;
        } else {
            i = 0;
        }
        this.f903p = i | i2;
        if (oldFlags != this.f903p) {
            this.f899l.m1901b(false);
        }
    }

    public boolean isVisible() {
        if (this.f906s == null || !this.f906s.m993c()) {
            if ((this.f903p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f903p & 8) == 0 && this.f906s.m994d()) {
            return true;
        } else {
            return false;
        }
    }

    boolean m1937c(boolean shown) {
        int oldFlags = this.f903p;
        this.f903p = (shown ? 0 : 8) | (this.f903p & -9);
        if (oldFlags != this.f903p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean shown) {
        if (m1937c(shown)) {
            this.f899l.m1890a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener clickListener) {
        this.f902o = clickListener;
        return this;
    }

    public String toString() {
        return this.f892e.toString();
    }

    void m1930a(ContextMenuInfo menuInfo) {
        this.f909v = menuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f909v;
    }

    public void m1943g() {
        this.f899l.m1899b(this);
    }

    public boolean m1944h() {
        return this.f899l.m1920q();
    }

    public boolean m1945i() {
        return (this.f903p & 32) == 32;
    }

    public boolean m1946j() {
        return (this.f904q & 1) == 1;
    }

    public boolean m1947k() {
        return (this.f904q & 2) == 2;
    }

    public void m1939d(boolean isActionButton) {
        if (isActionButton) {
            this.f903p |= 32;
        } else {
            this.f903p &= -33;
        }
    }

    public boolean m1948l() {
        return (this.f904q & 4) == 4;
    }

    public void setShowAsAction(int actionEnum) {
        switch (actionEnum & 3) {
            case Base64.DEFAULT /*0*/:
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
                this.f904q = actionEnum;
                this.f899l.m1899b(this);
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public C0128b m1927a(View view) {
        this.f905r = view;
        this.f906s = null;
        if (view != null && view.getId() == -1 && this.f888a > 0) {
            view.setId(this.f888a);
        }
        this.f899l.m1899b(this);
        return this;
    }

    public C0128b m1924a(int resId) {
        Context context = this.f899l.m1908e();
        m1927a(LayoutInflater.from(context).inflate(resId, new LinearLayout(context), false));
        return this;
    }

    public View getActionView() {
        if (this.f905r != null) {
            return this.f905r;
        }
        if (this.f906s == null) {
            return null;
        }
        this.f905r = this.f906s.m987a((MenuItem) this);
        return this.f905r;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("Implementation should use setSupportActionProvider!");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("Implementation should use getSupportActionProvider!");
    }

    public C0220d m1949m() {
        return this.f906s;
    }

    public C0128b m1925a(C0220d actionProvider) {
        if (this.f906s != actionProvider) {
            this.f905r = null;
            if (this.f906s != null) {
                this.f906s.m989a(null);
            }
            this.f906s = actionProvider;
            this.f899l.m1901b(true);
            if (actionProvider != null) {
                actionProvider.m989a(new C03981(this));
            }
        }
        return this;
    }

    public C0128b m1934b(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    public boolean expandActionView() {
        if ((this.f904q & 8) == 0 || this.f905r == null) {
            return false;
        }
        if (this.f907t == null || this.f907t.m1050a(this)) {
            return this.f899l.m1905c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f904q & 8) == 0) {
            return false;
        }
        if (this.f905r == null) {
            return true;
        }
        if (this.f907t == null || this.f907t.m1051b(this)) {
            return this.f899l.m1907d(this);
        }
        return false;
    }

    public C0128b m1926a(C0239e listener) {
        this.f907t = listener;
        return this;
    }

    public boolean m1950n() {
        return ((this.f904q & 8) == 0 || this.f905r == null) ? false : true;
    }

    public void m1940e(boolean isExpanded) {
        this.f908u = isExpanded;
        this.f899l.m1901b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f908u;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        throw new UnsupportedOperationException("Implementation should use setSupportOnActionExpandListener!");
    }
}

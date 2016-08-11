package android.support.v7.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p007b.p008a.C0128b;
import android.support.v4.view.C0220d;
import android.support.v4.view.C0220d.C0219b;
import android.support.v4.view.C0240j.C0239e;
import android.support.v7.p013c.C0365b;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.internal.view.menu.i */
public class C0405i extends C0394c implements C0128b {
    private final boolean f917b;
    private boolean f918c;
    private Method f919d;

    /* renamed from: android.support.v7.internal.view.menu.i.a */
    class C0401a extends ActionProvider {
        final C0220d f912a;
        final /* synthetic */ C0405i f913b;

        /* renamed from: android.support.v7.internal.view.menu.i.a.1 */
        class C04001 implements C0219b {
            final /* synthetic */ C0405i f910a;
            final /* synthetic */ C0401a f911b;

            C04001(C0401a c0401a, C0405i c0405i) {
                this.f911b = c0401a;
                this.f910a = c0405i;
            }

            public void m1951a(boolean isVisible) {
                if (this.f911b.f912a.m993c() && this.f911b.f913b.f918c) {
                    this.f911b.f913b.m1960b(isVisible);
                }
            }
        }

        public C0401a(C0405i c0405i, C0220d inner) {
            this.f913b = c0405i;
            super(inner.m986a());
            this.f912a = inner;
            if (c0405i.f917b) {
                this.f912a.m989a(new C04001(this, c0405i));
            }
        }

        public View onCreateActionView() {
            if (this.f913b.f917b) {
                this.f913b.m1961c();
            }
            return this.f912a.m992b();
        }

        public boolean onPerformDefaultAction() {
            return this.f912a.m996f();
        }

        public boolean hasSubMenu() {
            return this.f912a.m997g();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f912a.m990a(this.f913b.m1856a(subMenu));
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.i.b */
    static class C0402b extends FrameLayout implements CollapsibleActionView {
        final C0365b f914a;

        C0402b(View actionView) {
            super(actionView.getContext());
            this.f914a = (C0365b) actionView;
            addView(actionView);
        }

        public void onActionViewExpanded() {
            this.f914a.m1704a();
        }

        public void onActionViewCollapsed() {
            this.f914a.m1705b();
        }

        View m1952a() {
            return (View) this.f914a;
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.i.c */
    private class C0403c extends C0393d implements OnActionExpandListener {
        final /* synthetic */ C0405i f915b;

        C0403c(C0405i c0405i, C0239e object) {
            this.f915b = c0405i;
            super(object);
        }

        public boolean onMenuItemActionExpand(MenuItem item) {
            return ((C0239e) this.a).m1050a(this.f915b.m1855a(item));
        }

        public boolean onMenuItemActionCollapse(MenuItem item) {
            return ((C0239e) this.a).m1051b(this.f915b.m1855a(item));
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.i.d */
    private class C0404d extends C0393d implements OnMenuItemClickListener {
        final /* synthetic */ C0405i f916b;

        C0404d(C0405i c0405i, OnMenuItemClickListener object) {
            this.f916b = c0405i;
            super(object);
        }

        public boolean onMenuItemClick(MenuItem item) {
            return ((OnMenuItemClickListener) this.a).onMenuItemClick(this.f916b.m1855a(item));
        }
    }

    C0405i(MenuItem object, boolean emulateProviderVisibilityOverride) {
        super(object);
        this.f918c = object.isVisible();
        this.f917b = emulateProviderVisibilityOverride;
    }

    C0405i(MenuItem object) {
        this(object, true);
    }

    public int getItemId() {
        return ((MenuItem) this.a).getItemId();
    }

    public int getGroupId() {
        return ((MenuItem) this.a).getGroupId();
    }

    public int getOrder() {
        return ((MenuItem) this.a).getOrder();
    }

    public MenuItem setTitle(CharSequence title) {
        ((MenuItem) this.a).setTitle(title);
        return this;
    }

    public MenuItem setTitle(int title) {
        ((MenuItem) this.a).setTitle(title);
        return this;
    }

    public CharSequence getTitle() {
        return ((MenuItem) this.a).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence title) {
        ((MenuItem) this.a).setTitleCondensed(title);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((MenuItem) this.a).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable icon) {
        ((MenuItem) this.a).setIcon(icon);
        return this;
    }

    public MenuItem setIcon(int iconRes) {
        ((MenuItem) this.a).setIcon(iconRes);
        return this;
    }

    public Drawable getIcon() {
        return ((MenuItem) this.a).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((MenuItem) this.a).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((MenuItem) this.a).getIntent();
    }

    public MenuItem setShortcut(char numericChar, char alphaChar) {
        ((MenuItem) this.a).setShortcut(numericChar, alphaChar);
        return this;
    }

    public MenuItem setNumericShortcut(char numericChar) {
        ((MenuItem) this.a).setNumericShortcut(numericChar);
        return this;
    }

    public char getNumericShortcut() {
        return ((MenuItem) this.a).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char alphaChar) {
        ((MenuItem) this.a).setAlphabeticShortcut(alphaChar);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((MenuItem) this.a).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean checkable) {
        ((MenuItem) this.a).setCheckable(checkable);
        return this;
    }

    public boolean isCheckable() {
        return ((MenuItem) this.a).isCheckable();
    }

    public MenuItem setChecked(boolean checked) {
        ((MenuItem) this.a).setChecked(checked);
        return this;
    }

    public boolean isChecked() {
        return ((MenuItem) this.a).isChecked();
    }

    public MenuItem setVisible(boolean visible) {
        if (this.f917b) {
            this.f918c = visible;
            if (m1961c()) {
                return this;
            }
        }
        return m1960b(visible);
    }

    public boolean isVisible() {
        return ((MenuItem) this.a).isVisible();
    }

    public MenuItem setEnabled(boolean enabled) {
        ((MenuItem) this.a).setEnabled(enabled);
        return this;
    }

    public boolean isEnabled() {
        return ((MenuItem) this.a).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((MenuItem) this.a).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m1856a(((MenuItem) this.a).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        ((MenuItem) this.a).setOnMenuItemClickListener(menuItemClickListener != null ? new C0404d(this, menuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((MenuItem) this.a).getMenuInfo();
    }

    public void setShowAsAction(int actionEnum) {
        ((MenuItem) this.a).setShowAsAction(actionEnum);
    }

    public MenuItem setShowAsActionFlags(int actionEnum) {
        ((MenuItem) this.a).setShowAsActionFlags(actionEnum);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof C0365b) {
            view = new C0402b(view);
        }
        ((MenuItem) this.a).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int resId) {
        ((MenuItem) this.a).setActionView(resId);
        View actionView = ((MenuItem) this.a).getActionView();
        if (actionView instanceof C0365b) {
            ((MenuItem) this.a).setActionView(new C0402b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((MenuItem) this.a).getActionView();
        if (actionView instanceof C0402b) {
            return ((C0402b) actionView).m1952a();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider provider) {
        ((MenuItem) this.a).setActionProvider(provider);
        if (provider != null && this.f917b) {
            m1961c();
        }
        return this;
    }

    public ActionProvider getActionProvider() {
        return ((MenuItem) this.a).getActionProvider();
    }

    public boolean expandActionView() {
        return ((MenuItem) this.a).expandActionView();
    }

    public boolean collapseActionView() {
        return ((MenuItem) this.a).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((MenuItem) this.a).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        ((MenuItem) this.a).setOnActionExpandListener(listener);
        return this;
    }

    public C0128b m1956a(C0239e listener) {
        OnActionExpandListener c0403c;
        MenuItem menuItem = (MenuItem) this.a;
        if (listener != null) {
            c0403c = new C0403c(this, listener);
        } else {
            c0403c = null;
        }
        menuItem.setOnActionExpandListener(c0403c);
        return null;
    }

    public C0128b m1955a(C0220d actionProvider) {
        ((MenuItem) this.a).setActionProvider(actionProvider != null ? m1959b(actionProvider) : null);
        return this;
    }

    public C0220d m1958b() {
        C0401a providerWrapper = (C0401a) ((MenuItem) this.a).getActionProvider();
        return providerWrapper != null ? providerWrapper.f912a : null;
    }

    public void m1957a(boolean checkable) {
        try {
            if (this.f919d == null) {
                this.f919d = ((MenuItem) this.a).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f919d.invoke(this.a, new Object[]{Boolean.valueOf(checkable)});
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    C0401a m1959b(C0220d provider) {
        return new C0401a(this, provider);
    }

    final boolean m1961c() {
        if (!this.f918c) {
            return false;
        }
        C0220d provider = m1958b();
        if (provider == null || !provider.m993c() || provider.m994d()) {
            return false;
        }
        m1960b(false);
        return true;
    }

    final MenuItem m1960b(boolean visible) {
        return ((MenuItem) this.a).setVisible(visible);
    }
}

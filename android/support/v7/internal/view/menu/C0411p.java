package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.C0397f.C0334a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.p */
public class C0411p extends C0397f implements SubMenu {
    private C0397f f925d;
    private C0399h f926e;

    public C0411p(Context context, C0397f parentMenu, C0399h item) {
        super(context);
        this.f925d = parentMenu;
        this.f926e = item;
    }

    public void setQwertyMode(boolean isQwerty) {
        this.f925d.setQwertyMode(isQwerty);
    }

    public boolean m1974b() {
        return this.f925d.m1902b();
    }

    public boolean m1975c() {
        return this.f925d.m1904c();
    }

    public Menu m1979s() {
        return this.f925d;
    }

    public MenuItem getItem() {
        return this.f926e;
    }

    public void m1972a(C0334a callback) {
        this.f925d.m1889a(callback);
    }

    public C0397f m1978p() {
        return this.f925d;
    }

    public boolean m1973a(C0397f menu, MenuItem item) {
        return super.m1895a(menu, item) || this.f925d.m1895a(menu, item);
    }

    public SubMenu setIcon(Drawable icon) {
        this.f926e.setIcon(icon);
        return this;
    }

    public SubMenu setIcon(int iconRes) {
        this.f926e.setIcon(iconRes);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable icon) {
        super.m1883a(icon);
        return this;
    }

    public SubMenu setHeaderIcon(int iconRes) {
        super.m1883a(m1908e().getResources().getDrawable(iconRes));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence title) {
        super.m1885a(title);
        return this;
    }

    public SubMenu setHeaderTitle(int titleRes) {
        super.m1885a(m1908e().getResources().getString(titleRes));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m1884a(view);
        return this;
    }

    public void clearHeader() {
    }

    public boolean m1976c(C0399h item) {
        return this.f925d.m1905c(item);
    }

    public boolean m1977d(C0399h item) {
        return this.f925d.m1907d(item);
    }

    public String m1971a() {
        int itemId = this.f926e != null ? this.f926e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.m1887a() + ":" + itemId;
    }
}

package android.support.v7.internal.view.menu;

import android.graphics.drawable.Drawable;
import android.support.v4.p007b.p008a.C0129c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.q */
class C0412q extends C0410o implements C0129c {
    C0412q(SubMenu subMenu) {
        super(subMenu);
    }

    public SubMenu setHeaderTitle(int titleRes) {
        ((SubMenu) this.a).setHeaderTitle(titleRes);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence title) {
        ((SubMenu) this.a).setHeaderTitle(title);
        return this;
    }

    public SubMenu setHeaderIcon(int iconRes) {
        ((SubMenu) this.a).setHeaderIcon(iconRes);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable icon) {
        ((SubMenu) this.a).setHeaderIcon(icon);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        ((SubMenu) this.a).setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        ((SubMenu) this.a).clearHeader();
    }

    public SubMenu setIcon(int iconRes) {
        ((SubMenu) this.a).setIcon(iconRes);
        return this;
    }

    public SubMenu setIcon(Drawable icon) {
        ((SubMenu) this.a).setIcon(icon);
        return this;
    }

    public MenuItem getItem() {
        return m1855a(((SubMenu) this.a).getItem());
    }
}

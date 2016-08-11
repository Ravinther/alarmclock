package android.support.v7.internal.view.menu;

import android.os.Build.VERSION;
import android.support.v4.p007b.p008a.C0128b;
import android.support.v4.p007b.p008a.C0129c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.internal.view.menu.n */
public final class C0409n {
    public static Menu m1968a(Menu frameworkMenu) {
        if (VERSION.SDK_INT >= 14) {
            return new C0410o(frameworkMenu);
        }
        return frameworkMenu;
    }

    public static MenuItem m1969a(MenuItem frameworkMenuItem) {
        if (VERSION.SDK_INT >= 16) {
            return new C0407j(frameworkMenuItem);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0405i(frameworkMenuItem);
        }
        return frameworkMenuItem;
    }

    public static C0129c m1967a(SubMenu frameworkSubMenu) {
        if (VERSION.SDK_INT >= 14) {
            return new C0412q(frameworkSubMenu);
        }
        throw new UnsupportedOperationException();
    }

    public static C0128b m1970b(MenuItem frameworkMenuItem) {
        if (VERSION.SDK_INT >= 16) {
            return new C0407j(frameworkMenuItem);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0405i(frameworkMenuItem);
        }
        throw new UnsupportedOperationException();
    }
}

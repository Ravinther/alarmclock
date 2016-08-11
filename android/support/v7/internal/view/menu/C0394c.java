package android.support.v7.internal.view.menu;

import android.support.v4.p007b.p008a.C0128b;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: android.support.v7.internal.view.menu.c */
abstract class C0394c extends C0393d {
    private HashMap f846b;
    private HashMap f847c;

    C0394c(Object object) {
        super(object);
    }

    final C0128b m1855a(MenuItem frameworkItem) {
        if (frameworkItem == null) {
            return null;
        }
        if (this.f846b == null) {
            this.f846b = new HashMap();
        }
        C0128b compatItem = (C0128b) this.f846b.get(frameworkItem);
        if (compatItem != null) {
            return compatItem;
        }
        compatItem = C0409n.m1970b(frameworkItem);
        this.f846b.put(frameworkItem, compatItem);
        return compatItem;
    }

    final SubMenu m1856a(SubMenu frameworkSubMenu) {
        if (frameworkSubMenu == null) {
            return null;
        }
        if (this.f847c == null) {
            this.f847c = new HashMap();
        }
        SubMenu compatSubMenu = (SubMenu) this.f847c.get(frameworkSubMenu);
        if (compatSubMenu != null) {
            return compatSubMenu;
        }
        compatSubMenu = C0409n.m1967a(frameworkSubMenu);
        this.f847c.put(frameworkSubMenu, compatSubMenu);
        return compatSubMenu;
    }

    final void m1857a() {
        if (this.f846b != null) {
            this.f846b.clear();
        }
        if (this.f847c != null) {
            this.f847c.clear();
        }
    }

    final void m1858a(int groupId) {
        if (this.f846b != null) {
            Iterator iterator = this.f846b.keySet().iterator();
            while (iterator.hasNext()) {
                if (groupId == ((MenuItem) iterator.next()).getGroupId()) {
                    iterator.remove();
                }
            }
        }
    }

    final void m1859b(int id) {
        if (this.f846b != null) {
            Iterator iterator = this.f846b.keySet().iterator();
            while (iterator.hasNext()) {
                if (id == ((MenuItem) iterator.next()).getItemId()) {
                    iterator.remove();
                    return;
                }
            }
        }
    }
}

package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.p007b.p008a.C0127a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.internal.view.menu.o */
class C0410o extends C0394c implements C0127a {
    C0410o(Menu object) {
        super(object);
    }

    public MenuItem add(CharSequence title) {
        return m1855a(((Menu) this.a).add(title));
    }

    public MenuItem add(int titleRes) {
        return m1855a(((Menu) this.a).add(titleRes));
    }

    public MenuItem add(int groupId, int itemId, int order, CharSequence title) {
        return m1855a(((Menu) this.a).add(groupId, itemId, order, title));
    }

    public MenuItem add(int groupId, int itemId, int order, int titleRes) {
        return m1855a(((Menu) this.a).add(groupId, itemId, order, titleRes));
    }

    public SubMenu addSubMenu(CharSequence title) {
        return m1856a(((Menu) this.a).addSubMenu(title));
    }

    public SubMenu addSubMenu(int titleRes) {
        return m1856a(((Menu) this.a).addSubMenu(titleRes));
    }

    public SubMenu addSubMenu(int groupId, int itemId, int order, CharSequence title) {
        return m1856a(((Menu) this.a).addSubMenu(groupId, itemId, order, title));
    }

    public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
        return m1856a(((Menu) this.a).addSubMenu(groupId, itemId, order, titleRes));
    }

    public int addIntentOptions(int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        MenuItem[] items = null;
        if (outSpecificItems != null) {
            items = new MenuItem[outSpecificItems.length];
        }
        int result = ((Menu) this.a).addIntentOptions(groupId, itemId, order, caller, specifics, intent, flags, items);
        if (items != null) {
            int z = items.length;
            for (int i = 0; i < z; i++) {
                outSpecificItems[i] = m1855a(items[i]);
            }
        }
        return result;
    }

    public void removeItem(int id) {
        m1859b(id);
        ((Menu) this.a).removeItem(id);
    }

    public void removeGroup(int groupId) {
        m1858a(groupId);
        ((Menu) this.a).removeGroup(groupId);
    }

    public void clear() {
        m1857a();
        ((Menu) this.a).clear();
    }

    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        ((Menu) this.a).setGroupCheckable(group, checkable, exclusive);
    }

    public void setGroupVisible(int group, boolean visible) {
        ((Menu) this.a).setGroupVisible(group, visible);
    }

    public void setGroupEnabled(int group, boolean enabled) {
        ((Menu) this.a).setGroupEnabled(group, enabled);
    }

    public boolean hasVisibleItems() {
        return ((Menu) this.a).hasVisibleItems();
    }

    public MenuItem findItem(int id) {
        return m1855a(((Menu) this.a).findItem(id));
    }

    public int size() {
        return ((Menu) this.a).size();
    }

    public MenuItem getItem(int index) {
        return m1855a(((Menu) this.a).getItem(index));
    }

    public void close() {
        ((Menu) this.a).close();
    }

    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        return ((Menu) this.a).performShortcut(keyCode, event, flags);
    }

    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return ((Menu) this.a).isShortcutKey(keyCode, event);
    }

    public boolean performIdentifierAction(int id, int flags) {
        return ((Menu) this.a).performIdentifierAction(id, flags);
    }

    public void setQwertyMode(boolean isQwerty) {
        ((Menu) this.a).setQwertyMode(isQwerty);
    }
}

package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.p007b.p008a.C0127a;
import android.support.v4.view.C0220d;
import android.support.v4.view.C0240j;
import android.support.v7.p014b.C0364a.C0356c;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.google.android.gms.games.request.GameRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v7.internal.view.menu.f */
public class C0397f implements C0127a {
    private static final int[] f859d;
    CharSequence f860a;
    Drawable f861b;
    View f862c;
    private final Context f863e;
    private final Resources f864f;
    private boolean f865g;
    private boolean f866h;
    private C0334a f867i;
    private ArrayList f868j;
    private ArrayList f869k;
    private boolean f870l;
    private ArrayList f871m;
    private ArrayList f872n;
    private boolean f873o;
    private int f874p;
    private ContextMenuInfo f875q;
    private boolean f876r;
    private boolean f877s;
    private boolean f878t;
    private boolean f879u;
    private ArrayList f880v;
    private CopyOnWriteArrayList f881w;
    private C0399h f882x;

    /* renamed from: android.support.v7.internal.view.menu.f.a */
    public interface C0334a {
        void m1521a(C0397f c0397f);

        boolean m1522a(C0397f c0397f, MenuItem menuItem);
    }

    /* renamed from: android.support.v7.internal.view.menu.f.b */
    public interface C0390b {
        boolean m1831a(C0399h c0399h);
    }

    static {
        f859d = new int[]{1, 4, 5, 3, 2, 0};
    }

    public C0397f(Context context) {
        this.f874p = 0;
        this.f876r = false;
        this.f877s = false;
        this.f878t = false;
        this.f879u = false;
        this.f880v = new ArrayList();
        this.f881w = new CopyOnWriteArrayList();
        this.f863e = context;
        this.f864f = context.getResources();
        this.f868j = new ArrayList();
        this.f869k = new ArrayList();
        this.f870l = true;
        this.f871m = new ArrayList();
        this.f872n = new ArrayList();
        this.f873o = true;
        m1880d(true);
    }

    public C0397f m1882a(int defaultShowAsAction) {
        this.f874p = defaultShowAsAction;
        return this;
    }

    public void m1891a(C0384l presenter) {
        this.f881w.add(new WeakReference(presenter));
        presenter.m1758a(this.f863e, this);
        this.f873o = true;
    }

    public void m1900b(C0384l presenter) {
        Iterator i$ = this.f881w.iterator();
        while (i$.hasNext()) {
            WeakReference ref = (WeakReference) i$.next();
            C0384l item = (C0384l) ref.get();
            if (item == null || item == presenter) {
                this.f881w.remove(ref);
            }
        }
    }

    private void m1878c(boolean cleared) {
        if (!this.f881w.isEmpty()) {
            m1910g();
            Iterator i$ = this.f881w.iterator();
            while (i$.hasNext()) {
                WeakReference ref = (WeakReference) i$.next();
                C0384l presenter = (C0384l) ref.get();
                if (presenter == null) {
                    this.f881w.remove(ref);
                } else {
                    presenter.m1763d(cleared);
                }
            }
            m1911h();
        }
    }

    private boolean m1877a(C0411p subMenu) {
        if (this.f881w.isEmpty()) {
            return false;
        }
        boolean result = false;
        Iterator i$ = this.f881w.iterator();
        while (i$.hasNext()) {
            WeakReference ref = (WeakReference) i$.next();
            C0384l presenter = (C0384l) ref.get();
            if (presenter == null) {
                this.f881w.remove(ref);
            } else if (!result) {
                result = presenter.m1761a(subMenu);
            }
        }
        return result;
    }

    public void m1888a(Bundle outStates) {
        SparseArray viewStates = null;
        int itemCount = size();
        for (int i = 0; i < itemCount; i++) {
            MenuItem item = getItem(i);
            View v = C0240j.m1055a(item);
            if (!(v == null || v.getId() == -1)) {
                if (viewStates == null) {
                    viewStates = new SparseArray();
                }
                v.saveHierarchyState(viewStates);
                if (C0240j.m1059c(item)) {
                    outStates.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((C0411p) item.getSubMenu()).m1888a(outStates);
            }
        }
        if (viewStates != null) {
            outStates.putSparseParcelableArray(m1887a(), viewStates);
        }
    }

    public void m1898b(Bundle states) {
        if (states != null) {
            SparseArray viewStates = states.getSparseParcelableArray(m1887a());
            int itemCount = size();
            for (int i = 0; i < itemCount; i++) {
                MenuItem item = getItem(i);
                View v = C0240j.m1055a(item);
                if (!(v == null || v.getId() == -1)) {
                    v.restoreHierarchyState(viewStates);
                }
                if (item.hasSubMenu()) {
                    ((C0411p) item.getSubMenu()).m1898b(states);
                }
            }
            int expandedId = states.getInt("android:menu:expandedactionview");
            if (expandedId > 0) {
                MenuItem itemToExpand = findItem(expandedId);
                if (itemToExpand != null) {
                    C0240j.m1058b(itemToExpand);
                }
            }
        }
    }

    protected String m1887a() {
        return "android:menu:actionviewstates";
    }

    public void m1889a(C0334a cb) {
        this.f867i = cb;
    }

    private MenuItem m1874a(int group, int id, int categoryOrder, CharSequence title) {
        int ordering = C0397f.m1879d(categoryOrder);
        C0399h item = new C0399h(this, group, id, categoryOrder, ordering, title, this.f874p);
        if (this.f875q != null) {
            item.m1930a(this.f875q);
        }
        this.f868j.add(C0397f.m1873a(this.f868j, ordering), item);
        m1901b(true);
        return item;
    }

    public MenuItem add(CharSequence title) {
        return m1874a(0, 0, 0, title);
    }

    public MenuItem add(int titleRes) {
        return m1874a(0, 0, 0, this.f864f.getString(titleRes));
    }

    public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        return m1874a(group, id, categoryOrder, title);
    }

    public MenuItem add(int group, int id, int categoryOrder, int title) {
        return m1874a(group, id, categoryOrder, this.f864f.getString(title));
    }

    public SubMenu addSubMenu(CharSequence title) {
        return addSubMenu(0, 0, 0, title);
    }

    public SubMenu addSubMenu(int titleRes) {
        return addSubMenu(0, 0, 0, this.f864f.getString(titleRes));
    }

    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        C0399h item = (C0399h) m1874a(group, id, categoryOrder, title);
        C0411p subMenu = new C0411p(this.f863e, this, item);
        item.m1929a(subMenu);
        return subMenu;
    }

    public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        return addSubMenu(group, id, categoryOrder, this.f864f.getString(title));
    }

    public int addIntentOptions(int group, int id, int categoryOrder, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        PackageManager pm = this.f863e.getPackageManager();
        List lri = pm.queryIntentActivityOptions(caller, specifics, intent, 0);
        int N = lri != null ? lri.size() : 0;
        if ((flags & 1) == 0) {
            removeGroup(group);
        }
        for (int i = 0; i < N; i++) {
            Intent intent2;
            ResolveInfo ri = (ResolveInfo) lri.get(i);
            if (ri.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = specifics[ri.specificIndex];
            }
            Intent rintent = new Intent(intent2);
            rintent.setComponent(new ComponentName(ri.activityInfo.applicationInfo.packageName, ri.activityInfo.name));
            MenuItem item = add(group, id, categoryOrder, ri.loadLabel(pm)).setIcon(ri.loadIcon(pm)).setIntent(rintent);
            if (outSpecificItems != null && ri.specificIndex >= 0) {
                outSpecificItems[ri.specificIndex] = item;
            }
        }
        return N;
    }

    public void removeItem(int id) {
        m1876a(m1897b(id), true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeGroup(int r6) {
        /*
        r5 = this;
        r0 = r5.m1903c(r6);
        if (r0 < 0) goto L_0x002c;
    L_0x0006:
        r4 = r5.f868j;
        r4 = r4.size();
        r1 = r4 - r0;
        r2 = 0;
        r3 = r2;
    L_0x0010:
        r2 = r3 + 1;
        if (r3 >= r1) goto L_0x0028;
    L_0x0014:
        r4 = r5.f868j;
        r4 = r4.get(r0);
        r4 = (android.support.v7.internal.view.menu.C0399h) r4;
        r4 = r4.getGroupId();
        if (r4 != r6) goto L_0x0028;
    L_0x0022:
        r4 = 0;
        r5.m1876a(r0, r4);
        r3 = r2;
        goto L_0x0010;
    L_0x0028:
        r4 = 1;
        r5.m1901b(r4);
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.view.menu.f.removeGroup(int):void");
    }

    private void m1876a(int index, boolean updateChildrenOnMenuViews) {
        if (index >= 0 && index < this.f868j.size()) {
            this.f868j.remove(index);
            if (updateChildrenOnMenuViews) {
                m1901b(true);
            }
        }
    }

    public void clear() {
        if (this.f882x != null) {
            m1907d(this.f882x);
        }
        this.f868j.clear();
        m1901b(true);
    }

    void m1892a(MenuItem item) {
        int group = item.getGroupId();
        int N = this.f868j.size();
        for (int i = 0; i < N; i++) {
            MenuItem curItem = (C0399h) this.f868j.get(i);
            if (curItem.getGroupId() == group && curItem.m1942f() && curItem.isCheckable()) {
                curItem.m1935b(curItem == item);
            }
        }
    }

    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        int N = this.f868j.size();
        for (int i = 0; i < N; i++) {
            C0399h item = (C0399h) this.f868j.get(i);
            if (item.getGroupId() == group) {
                item.m1931a(exclusive);
                item.setCheckable(checkable);
            }
        }
    }

    public void setGroupVisible(int group, boolean visible) {
        int N = this.f868j.size();
        boolean changedAtLeastOneItem = false;
        for (int i = 0; i < N; i++) {
            C0399h item = (C0399h) this.f868j.get(i);
            if (item.getGroupId() == group && item.m1937c(visible)) {
                changedAtLeastOneItem = true;
            }
        }
        if (changedAtLeastOneItem) {
            m1901b(true);
        }
    }

    public void setGroupEnabled(int group, boolean enabled) {
        int N = this.f868j.size();
        for (int i = 0; i < N; i++) {
            C0399h item = (C0399h) this.f868j.get(i);
            if (item.getGroupId() == group) {
                item.setEnabled(enabled);
            }
        }
    }

    public boolean hasVisibleItems() {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0399h) this.f868j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int id) {
        int size = size();
        for (int i = 0; i < size; i++) {
            C0399h item = (C0399h) this.f868j.get(i);
            if (item.getItemId() == id) {
                return item;
            }
            if (item.hasSubMenu()) {
                MenuItem possibleItem = item.getSubMenu().findItem(id);
                if (possibleItem != null) {
                    return possibleItem;
                }
            }
        }
        return null;
    }

    public int m1897b(int id) {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0399h) this.f868j.get(i)).getItemId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int m1903c(int group) {
        return m1881a(group, 0);
    }

    public int m1881a(int group, int start) {
        int size = size();
        if (start < 0) {
            start = 0;
        }
        for (int i = start; i < size; i++) {
            if (((C0399h) this.f868j.get(i)).getGroupId() == group) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return this.f868j.size();
    }

    public MenuItem getItem(int index) {
        return (MenuItem) this.f868j.get(index);
    }

    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return m1886a(keyCode, event) != null;
    }

    public void setQwertyMode(boolean isQwerty) {
        this.f865g = isQwerty;
        m1901b(false);
    }

    private static int m1879d(int categoryOrder) {
        int index = (-65536 & categoryOrder) >> 16;
        if (index >= 0 && index < f859d.length) {
            return (f859d[index] << 16) | (GameRequest.TYPE_ALL & categoryOrder);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean m1902b() {
        return this.f865g;
    }

    private void m1880d(boolean shortcutsVisible) {
        boolean z = true;
        if (!(shortcutsVisible && this.f864f.getConfiguration().keyboard != 1 && this.f864f.getBoolean(C0356c.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z = false;
        }
        this.f866h = z;
    }

    public boolean m1904c() {
        return this.f866h;
    }

    Resources m1906d() {
        return this.f864f;
    }

    public Context m1908e() {
        return this.f863e;
    }

    boolean m1895a(C0397f menu, MenuItem item) {
        return this.f867i != null && this.f867i.m1522a(menu, item);
    }

    public void m1909f() {
        if (this.f867i != null) {
            this.f867i.m1521a(this);
        }
    }

    private static int m1873a(ArrayList items, int ordering) {
        for (int i = items.size() - 1; i >= 0; i--) {
            if (((C0399h) items.get(i)).m1933b() <= ordering) {
                return i + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        MenuItem item = m1886a(keyCode, event);
        boolean handled = false;
        if (item != null) {
            handled = m1896a(item, flags);
        }
        if ((flags & 2) != 0) {
            m1894a(true);
        }
        return handled;
    }

    void m1893a(List items, int keyCode, KeyEvent event) {
        boolean qwerty = m1902b();
        int metaState = event.getMetaState();
        KeyData possibleChars = new KeyData();
        if (event.getKeyData(possibleChars) || keyCode == 67) {
            int N = this.f868j.size();
            for (int i = 0; i < N; i++) {
                C0399h item = (C0399h) this.f868j.get(i);
                if (item.hasSubMenu()) {
                    ((C0397f) item.getSubMenu()).m1893a(items, keyCode, event);
                }
                char shortcutChar = qwerty ? item.getAlphabeticShortcut() : item.getNumericShortcut();
                if ((metaState & 5) == 0 && shortcutChar != '\u0000' && ((shortcutChar == possibleChars.meta[0] || shortcutChar == possibleChars.meta[2] || (qwerty && shortcutChar == '\b' && keyCode == 67)) && item.isEnabled())) {
                    items.add(item);
                }
            }
        }
    }

    C0399h m1886a(int keyCode, KeyEvent event) {
        ArrayList items = this.f880v;
        items.clear();
        m1893a(items, keyCode, event);
        if (items.isEmpty()) {
            return null;
        }
        int metaState = event.getMetaState();
        KeyData possibleChars = new KeyData();
        event.getKeyData(possibleChars);
        int size = items.size();
        if (size == 1) {
            return (C0399h) items.get(0);
        }
        boolean qwerty = m1902b();
        for (int i = 0; i < size; i++) {
            C0399h item = (C0399h) items.get(i);
            char shortcutChar = qwerty ? item.getAlphabeticShortcut() : item.getNumericShortcut();
            if ((shortcutChar == possibleChars.meta[0] && (metaState & 2) == 0) || ((shortcutChar == possibleChars.meta[2] && (metaState & 2) != 0) || (qwerty && shortcutChar == '\b' && keyCode == 67))) {
                return item;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int id, int flags) {
        return m1896a(findItem(id), flags);
    }

    public boolean m1896a(MenuItem item, int flags) {
        C0399h itemImpl = (C0399h) item;
        if (itemImpl == null || !itemImpl.isEnabled()) {
            return false;
        }
        boolean providerHasSubMenu;
        boolean invoked = itemImpl.m1932a();
        C0220d provider = itemImpl.m1949m();
        if (provider == null || !provider.m997g()) {
            providerHasSubMenu = false;
        } else {
            providerHasSubMenu = true;
        }
        if (itemImpl.m1950n()) {
            invoked |= itemImpl.expandActionView();
            if (!invoked) {
                return invoked;
            }
            m1894a(true);
            return invoked;
        } else if (itemImpl.hasSubMenu() || providerHasSubMenu) {
            m1894a(false);
            if (!itemImpl.hasSubMenu()) {
                itemImpl.m1929a(new C0411p(m1908e(), this, itemImpl));
            }
            C0411p subMenu = (C0411p) itemImpl.getSubMenu();
            if (providerHasSubMenu) {
                provider.m990a((SubMenu) subMenu);
            }
            invoked |= m1877a(subMenu);
            if (invoked) {
                return invoked;
            }
            m1894a(true);
            return invoked;
        } else if ((flags & 1) != 0) {
            return invoked;
        } else {
            m1894a(true);
            return invoked;
        }
    }

    final void m1894a(boolean allMenusAreClosing) {
        if (!this.f879u) {
            this.f879u = true;
            Iterator i$ = this.f881w.iterator();
            while (i$.hasNext()) {
                WeakReference ref = (WeakReference) i$.next();
                C0384l presenter = (C0384l) ref.get();
                if (presenter == null) {
                    this.f881w.remove(ref);
                } else {
                    presenter.m1759a(this, allMenusAreClosing);
                }
            }
            this.f879u = false;
        }
    }

    public void close() {
        m1894a(true);
    }

    void m1901b(boolean structureChanged) {
        if (this.f876r) {
            this.f877s = true;
            return;
        }
        if (structureChanged) {
            this.f870l = true;
            this.f873o = true;
        }
        m1878c(structureChanged);
    }

    public void m1910g() {
        if (!this.f876r) {
            this.f876r = true;
            this.f877s = false;
        }
    }

    public void m1911h() {
        this.f876r = false;
        if (this.f877s) {
            this.f877s = false;
            m1901b(true);
        }
    }

    void m1890a(C0399h item) {
        this.f870l = true;
        m1901b(true);
    }

    void m1899b(C0399h item) {
        this.f873o = true;
        m1901b(true);
    }

    ArrayList m1912i() {
        if (!this.f870l) {
            return this.f869k;
        }
        this.f869k.clear();
        int itemsSize = this.f868j.size();
        for (int i = 0; i < itemsSize; i++) {
            C0399h item = (C0399h) this.f868j.get(i);
            if (item.isVisible()) {
                this.f869k.add(item);
            }
        }
        this.f870l = false;
        this.f873o = true;
        return this.f869k;
    }

    public void m1913j() {
        if (this.f873o) {
            boolean flagged = false;
            Iterator i$ = this.f881w.iterator();
            while (i$.hasNext()) {
                WeakReference ref = (WeakReference) i$.next();
                C0384l presenter = (C0384l) ref.get();
                if (presenter == null) {
                    this.f881w.remove(ref);
                } else {
                    flagged |= presenter.m1764g();
                }
            }
            if (flagged) {
                this.f871m.clear();
                this.f872n.clear();
                ArrayList visibleItems = m1912i();
                int itemsSize = visibleItems.size();
                for (int i = 0; i < itemsSize; i++) {
                    C0399h item = (C0399h) visibleItems.get(i);
                    if (item.m1945i()) {
                        this.f871m.add(item);
                    } else {
                        this.f872n.add(item);
                    }
                }
            } else {
                this.f871m.clear();
                this.f872n.clear();
                this.f872n.addAll(m1912i());
            }
            this.f873o = false;
        }
    }

    ArrayList m1914k() {
        m1913j();
        return this.f871m;
    }

    ArrayList m1915l() {
        m1913j();
        return this.f872n;
    }

    public void clearHeader() {
        this.f861b = null;
        this.f860a = null;
        this.f862c = null;
        m1901b(false);
    }

    private void m1875a(int titleRes, CharSequence title, int iconRes, Drawable icon, View view) {
        Resources r = m1906d();
        if (view != null) {
            this.f862c = view;
            this.f860a = null;
            this.f861b = null;
        } else {
            if (titleRes > 0) {
                this.f860a = r.getText(titleRes);
            } else if (title != null) {
                this.f860a = title;
            }
            if (iconRes > 0) {
                this.f861b = r.getDrawable(iconRes);
            } else if (icon != null) {
                this.f861b = icon;
            }
            this.f862c = null;
        }
        m1901b(false);
    }

    protected C0397f m1885a(CharSequence title) {
        m1875a(0, title, 0, null, null);
        return this;
    }

    protected C0397f m1883a(Drawable icon) {
        m1875a(0, null, 0, icon, null);
        return this;
    }

    protected C0397f m1884a(View view) {
        m1875a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m1916m() {
        return this.f860a;
    }

    public Drawable m1917n() {
        return this.f861b;
    }

    public View m1918o() {
        return this.f862c;
    }

    public C0397f m1919p() {
        return this;
    }

    boolean m1920q() {
        return this.f878t;
    }

    public boolean m1905c(C0399h item) {
        if (this.f881w.isEmpty()) {
            return false;
        }
        boolean expanded = false;
        m1910g();
        Iterator i$ = this.f881w.iterator();
        while (i$.hasNext()) {
            WeakReference ref = (WeakReference) i$.next();
            C0384l presenter = (C0384l) ref.get();
            if (presenter == null) {
                this.f881w.remove(ref);
            } else {
                expanded = presenter.m1760a(this, item);
                if (expanded) {
                    break;
                }
            }
        }
        m1911h();
        if (!expanded) {
            return expanded;
        }
        this.f882x = item;
        return expanded;
    }

    public boolean m1907d(C0399h item) {
        if (this.f881w.isEmpty() || this.f882x != item) {
            return false;
        }
        boolean collapsed = false;
        m1910g();
        Iterator i$ = this.f881w.iterator();
        while (i$.hasNext()) {
            WeakReference ref = (WeakReference) i$.next();
            C0384l presenter = (C0384l) ref.get();
            if (presenter == null) {
                this.f881w.remove(ref);
            } else {
                collapsed = presenter.m1762b(this, item);
                if (collapsed) {
                    break;
                }
            }
        }
        m1911h();
        if (!collapsed) {
            return collapsed;
        }
        this.f882x = null;
        return collapsed;
    }

    public C0399h m1921r() {
        return this.f882x;
    }
}

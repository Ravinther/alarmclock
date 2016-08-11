package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0220d;
import android.support.v4.view.C0220d.C0218a;
import android.support.v7.internal.view.C0366a;
import android.support.v7.internal.view.menu.ActionMenuView.C0376a;
import android.support.v7.internal.view.menu.C0384l.C0335a;
import android.support.v7.internal.view.menu.C0391m.C0377a;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0359f;
import android.support.v7.p014b.C0364a.C0360g;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import java.util.ArrayList;

public class ActionMenuPresenter extends C0388b implements C0218a {
    final C0387e f777a;
    int f778b;
    private View f779i;
    private boolean f780j;
    private boolean f781k;
    private int f782l;
    private int f783m;
    private int f784n;
    private boolean f785o;
    private boolean f786p;
    private boolean f787q;
    private boolean f788r;
    private int f789s;
    private final SparseBooleanArray f790t;
    private View f791u;
    private C0386d f792v;
    private C0381a f793w;
    private C0382b f794x;

    private static class SavedState implements Parcelable {
        public static final Creator CREATOR;
        public int f743a;

        /* renamed from: android.support.v7.internal.view.menu.ActionMenuPresenter.SavedState.1 */
        static class C03791 implements Creator {
            C03791() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m1750a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m1751a(x0);
            }

            public SavedState m1750a(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] m1751a(int size) {
                return new SavedState[size];
            }
        }

        SavedState() {
        }

        SavedState(Parcel in) {
            this.f743a = in.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f743a);
        }

        static {
            CREATOR = new C03791();
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuPresenter.a */
    private class C0381a extends C0380g {
        final /* synthetic */ ActionMenuPresenter f748a;

        public C0381a(ActionMenuPresenter actionMenuPresenter, C0411p subMenu) {
            this.f748a = actionMenuPresenter;
            super(subMenu);
            actionMenuPresenter.m1789a(actionMenuPresenter.f777a);
        }

        public void onDismiss(DialogInterface dialog) {
            super.onDismiss(dialog);
            this.f748a.f793w = null;
            this.f748a.f778b = 0;
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuPresenter.b */
    private class C0382b implements Runnable {
        final /* synthetic */ ActionMenuPresenter f749a;
        private C0386d f750b;

        public C0382b(ActionMenuPresenter actionMenuPresenter, C0386d popup) {
            this.f749a = actionMenuPresenter;
            this.f750b = popup;
        }

        public void run() {
            this.f749a.e.m1909f();
            View menuView = this.f749a.h;
            if (!(menuView == null || menuView.getWindowToken() == null || !this.f750b.m1776b())) {
                this.f749a.f792v = this.f750b;
            }
            this.f749a.f794x = null;
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuPresenter.c */
    private class C0383c extends ImageButton implements C0376a {
        final /* synthetic */ ActionMenuPresenter f751a;

        public C0383c(ActionMenuPresenter actionMenuPresenter, Context context) {
            this.f751a = actionMenuPresenter;
            super(context, null, C0355b.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.f751a.m1813a();
            }
            return true;
        }

        public boolean m1756c() {
            return false;
        }

        public boolean m1757d() {
            return false;
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuPresenter.d */
    private class C0386d extends C0385k {
        final /* synthetic */ ActionMenuPresenter f765a;

        public C0386d(ActionMenuPresenter actionMenuPresenter, Context context, C0397f menu, View anchorView, boolean overflowOnly) {
            this.f765a = actionMenuPresenter;
            super(context, menu, anchorView, overflowOnly);
            m1772a(actionMenuPresenter.f777a);
        }

        public void onDismiss() {
            super.onDismiss();
            this.f765a.e.close();
            this.f765a.f792v = null;
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuPresenter.e */
    private class C0387e implements C0335a {
        final /* synthetic */ ActionMenuPresenter f766a;

        private C0387e(ActionMenuPresenter actionMenuPresenter) {
            this.f766a = actionMenuPresenter;
        }

        public boolean m1783b(C0397f subMenu) {
            if (subMenu != null) {
                this.f766a.f778b = ((C0411p) subMenu).getItem().getItemId();
            }
            return false;
        }

        public void m1782a(C0397f menu, boolean allMenusAreClosing) {
            if (menu instanceof C0411p) {
                ((C0411p) menu).m1978p().m1894a(false);
            }
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0360g.abc_action_menu_layout, C0360g.abc_action_menu_item_layout);
        this.f790t = new SparseBooleanArray();
        this.f777a = new C0387e();
    }

    public void m1808a(Context context, C0397f menu) {
        super.m1786a(context, menu);
        Resources res = context.getResources();
        C0366a abp = C0366a.m1706a(context);
        if (!this.f781k) {
            this.f780j = abp.m1708b();
        }
        if (!this.f787q) {
            this.f782l = abp.m1709c();
        }
        if (!this.f785o) {
            this.f784n = abp.m1707a();
        }
        int width = this.f782l;
        if (this.f780j) {
            if (this.f779i == null) {
                this.f779i = new C0383c(this, this.c);
                int spec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f779i.measure(spec, spec);
            }
            width -= this.f779i.getMeasuredWidth();
        } else {
            this.f779i = null;
        }
        this.f783m = width;
        this.f789s = (int) (56.0f * res.getDisplayMetrics().density);
        this.f791u = null;
    }

    public void m1809a(Configuration newConfig) {
        if (!this.f785o) {
            this.f784n = this.d.getResources().getInteger(C0359f.abc_max_action_buttons);
        }
        if (this.e != null) {
            this.e.m1901b(true);
        }
    }

    public void m1807a(int width, boolean strict) {
        this.f782l = width;
        this.f786p = strict;
        this.f787q = true;
    }

    public void m1817b(boolean reserveOverflow) {
        this.f780j = reserveOverflow;
        this.f781k = true;
    }

    public void m1806a(int itemCount) {
        this.f784n = itemCount;
        this.f785o = true;
    }

    public void m1819c(boolean isExclusive) {
        this.f788r = isExclusive;
    }

    public C0391m m1804a(ViewGroup root) {
        C0391m result = super.m1784a(root);
        ((ActionMenuView) result).setPresenter(this);
        return result;
    }

    public View m1805a(C0399h item, View convertView, ViewGroup parent) {
        View actionView = item.getActionView();
        if (actionView == null || item.m1950n()) {
            if (!(convertView instanceof ActionMenuItemView)) {
                convertView = null;
            }
            actionView = super.m1785a(item, convertView, parent);
        }
        actionView.setVisibility(item.isActionViewExpanded() ? 8 : 0);
        ActionMenuView menuParent = (ActionMenuView) parent;
        LayoutParams lp = actionView.getLayoutParams();
        if (!menuParent.checkLayoutParams(lp)) {
            actionView.setLayoutParams(menuParent.m1837a(lp));
        }
        return actionView;
    }

    public void m1811a(C0399h item, C0377a itemView) {
        itemView.m1742a(item, 0);
        ((ActionMenuItemView) itemView).setItemInvoker(this.h);
    }

    public boolean m1814a(int childIndex, C0399h item) {
        return item.m1945i();
    }

    public void m1821d(boolean cleared) {
        super.m1798d(cleared);
        if (this.h != null) {
            int count;
            if (this.e != null) {
                ArrayList actionItems = this.e.m1914k();
                count = actionItems.size();
                for (int i = 0; i < count; i++) {
                    C0220d provider = ((C0399h) actionItems.get(i)).m1949m();
                    if (provider != null) {
                        provider.m988a((C0218a) this);
                    }
                }
            }
            ArrayList nonActionItems = this.e != null ? this.e.m1915l() : null;
            boolean hasOverflow = false;
            if (this.f780j && nonActionItems != null) {
                count = nonActionItems.size();
                hasOverflow = count == 1 ? !((C0399h) nonActionItems.get(0)).isActionViewExpanded() : count > 0;
            }
            if (hasOverflow) {
                if (this.f779i == null) {
                    this.f779i = new C0383c(this, this.c);
                }
                ViewGroup parent = (ViewGroup) this.f779i.getParent();
                if (parent != this.h) {
                    if (parent != null) {
                        parent.removeView(this.f779i);
                    }
                    ActionMenuView menuView = this.h;
                    menuView.addView(this.f779i, menuView.m1841b());
                }
            } else if (this.f779i != null && this.f779i.getParent() == this.h) {
                ((ViewGroup) this.h).removeView(this.f779i);
            }
            ((ActionMenuView) this.h).setOverflowReserved(this.f780j);
        }
    }

    public boolean m1816a(ViewGroup parent, int childIndex) {
        if (parent.getChildAt(childIndex) == this.f779i) {
            return false;
        }
        return super.m1794a(parent, childIndex);
    }

    public boolean m1815a(C0411p subMenu) {
        if (!subMenu.hasVisibleItems()) {
            return false;
        }
        C0411p topSubMenu = subMenu;
        while (topSubMenu.m1979s() != this.e) {
            topSubMenu = (C0411p) topSubMenu.m1979s();
        }
        if (m1803a(topSubMenu.getItem()) == null) {
            if (this.f779i == null) {
                return false;
            }
            View anchor = this.f779i;
        }
        this.f778b = subMenu.getItem().getItemId();
        this.f793w = new C0381a(this, subMenu);
        this.f793w.m1753a(null);
        super.m1793a(subMenu);
        return true;
    }

    private View m1803a(MenuItem item) {
        ViewGroup parent = this.h;
        if (parent == null) {
            return null;
        }
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = parent.getChildAt(i);
            if ((child instanceof C0377a) && ((C0377a) child).getItemData() == item) {
                return child;
            }
        }
        return null;
    }

    public boolean m1813a() {
        if (!this.f780j || m1823e() || this.e == null || this.h == null || this.f794x != null) {
            return false;
        }
        this.f794x = new C0382b(this, new C0386d(this, this.d, this.e, this.f779i, true));
        ((View) this.h).post(this.f794x);
        super.m1793a(null);
        return true;
    }

    public boolean m1818b() {
        if (this.f794x == null || this.h == null) {
            C0385k popup = this.f792v;
            if (popup == null) {
                return false;
            }
            popup.m1778c();
            return true;
        }
        ((View) this.h).removeCallbacks(this.f794x);
        this.f794x = null;
        return true;
    }

    public boolean m1820c() {
        return m1818b() | m1822d();
    }

    public boolean m1822d() {
        if (this.f793w == null) {
            return false;
        }
        this.f793w.m1752a();
        return true;
    }

    public boolean m1823e() {
        return this.f792v != null && this.f792v.m1780d();
    }

    public boolean m1824f() {
        return this.f780j;
    }

    public boolean m1825g() {
        int i;
        ArrayList visibleItems = this.e.m1912i();
        int itemsSize = visibleItems.size();
        int maxActions = this.f784n;
        int widthLimit = this.f783m;
        int querySpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup parent = (ViewGroup) this.h;
        int requiredItems = 0;
        int requestedItems = 0;
        int firstActionWidth = 0;
        boolean hasOverflow = false;
        for (i = 0; i < itemsSize; i++) {
            C0399h item = (C0399h) visibleItems.get(i);
            if (item.m1947k()) {
                requiredItems++;
            } else if (item.m1946j()) {
                requestedItems++;
            } else {
                hasOverflow = true;
            }
            if (this.f788r && item.isActionViewExpanded()) {
                maxActions = 0;
            }
        }
        if (this.f780j && (hasOverflow || requiredItems + requestedItems > maxActions)) {
            maxActions--;
        }
        maxActions -= requiredItems;
        SparseBooleanArray seenGroups = this.f790t;
        seenGroups.clear();
        int cellSize = 0;
        int cellsRemaining = 0;
        if (this.f786p) {
            cellsRemaining = widthLimit / this.f789s;
            cellSize = this.f789s + ((widthLimit % this.f789s) / cellsRemaining);
        }
        for (i = 0; i < itemsSize; i++) {
            item = (C0399h) visibleItems.get(i);
            View v;
            int measuredWidth;
            int groupId;
            if (item.m1947k()) {
                v = m1805a(item, this.f791u, parent);
                if (this.f791u == null) {
                    this.f791u = v;
                }
                if (this.f786p) {
                    cellsRemaining -= ActionMenuView.m1833a(v, cellSize, cellsRemaining, querySpec, 0);
                } else {
                    v.measure(querySpec, querySpec);
                }
                measuredWidth = v.getMeasuredWidth();
                widthLimit -= measuredWidth;
                if (firstActionWidth == 0) {
                    firstActionWidth = measuredWidth;
                }
                groupId = item.getGroupId();
                if (groupId != 0) {
                    seenGroups.put(groupId, true);
                }
                item.m1939d(true);
            } else if (item.m1946j()) {
                groupId = item.getGroupId();
                boolean inGroup = seenGroups.get(groupId);
                boolean isAction = (maxActions > 0 || inGroup) && widthLimit > 0 && (!this.f786p || cellsRemaining > 0);
                if (isAction) {
                    v = m1805a(item, this.f791u, parent);
                    if (this.f791u == null) {
                        this.f791u = v;
                    }
                    if (this.f786p) {
                        int cells = ActionMenuView.m1833a(v, cellSize, cellsRemaining, querySpec, 0);
                        cellsRemaining -= cells;
                        if (cells == 0) {
                            isAction = false;
                        }
                    } else {
                        v.measure(querySpec, querySpec);
                    }
                    measuredWidth = v.getMeasuredWidth();
                    widthLimit -= measuredWidth;
                    if (firstActionWidth == 0) {
                        firstActionWidth = measuredWidth;
                    }
                    if (this.f786p) {
                        isAction &= widthLimit >= 0 ? 1 : 0;
                    } else {
                        isAction &= widthLimit + firstActionWidth > 0 ? 1 : 0;
                    }
                }
                if (isAction && groupId != 0) {
                    seenGroups.put(groupId, true);
                } else if (inGroup) {
                    seenGroups.put(groupId, false);
                    for (int j = 0; j < i; j++) {
                        C0399h areYouMyGroupie = (C0399h) visibleItems.get(j);
                        if (areYouMyGroupie.getGroupId() == groupId) {
                            if (areYouMyGroupie.m1945i()) {
                                maxActions++;
                            }
                            areYouMyGroupie.m1939d(false);
                        }
                    }
                }
                if (isAction) {
                    maxActions--;
                }
                item.m1939d(isAction);
            }
        }
        return true;
    }

    public void m1810a(C0397f menu, boolean allMenusAreClosing) {
        m1820c();
        super.m1787a(menu, allMenusAreClosing);
    }

    public void m1812a(boolean isVisible) {
        if (isVisible) {
            super.m1793a(null);
        } else {
            this.e.m1894a(false);
        }
    }
}

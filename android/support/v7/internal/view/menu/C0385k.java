package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.view.menu.C0384l.C0335a;
import android.support.v7.internal.view.menu.C0391m.C0377a;
import android.support.v7.internal.widget.C0460f;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0357d;
import android.support.v7.p014b.C0364a.C0360g;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.k */
public class C0385k implements C0384l, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f752b;
    private Context f753a;
    boolean f754c;
    private LayoutInflater f755d;
    private C0460f f756e;
    private C0397f f757f;
    private int f758g;
    private View f759h;
    private boolean f760i;
    private ViewTreeObserver f761j;
    private C0408a f762k;
    private C0335a f763l;
    private ViewGroup f764m;

    /* renamed from: android.support.v7.internal.view.menu.k.a */
    private class C0408a extends BaseAdapter {
        final /* synthetic */ C0385k f922a;
        private C0397f f923b;
        private int f924c;

        public /* synthetic */ Object getItem(int x0) {
            return m1965a(x0);
        }

        public C0408a(C0385k c0385k, C0397f menu) {
            this.f922a = c0385k;
            this.f924c = -1;
            this.f923b = menu;
            m1966a();
        }

        public int getCount() {
            ArrayList items = this.f922a.f760i ? this.f923b.m1915l() : this.f923b.m1912i();
            if (this.f924c < 0) {
                return items.size();
            }
            return items.size() - 1;
        }

        public C0399h m1965a(int position) {
            ArrayList items = this.f922a.f760i ? this.f923b.m1915l() : this.f923b.m1912i();
            if (this.f924c >= 0 && position >= this.f924c) {
                position++;
            }
            return (C0399h) items.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = this.f922a.f755d.inflate(C0385k.f752b, parent, false);
            }
            C0377a itemView = (C0377a) convertView;
            if (this.f922a.f754c) {
                ((ListMenuItemView) convertView).setForceShowIcon(true);
            }
            itemView.m1742a(m1965a(position), 0);
            return convertView;
        }

        void m1966a() {
            C0399h expandedItem = this.f922a.f757f.m1921r();
            if (expandedItem != null) {
                ArrayList items = this.f922a.f757f.m1915l();
                int count = items.size();
                for (int i = 0; i < count; i++) {
                    if (((C0399h) items.get(i)) == expandedItem) {
                        this.f924c = i;
                        return;
                    }
                }
            }
            this.f924c = -1;
        }

        public void notifyDataSetChanged() {
            m1966a();
            super.notifyDataSetChanged();
        }
    }

    static {
        f752b = C0360g.abc_popup_menu_item_layout;
    }

    public C0385k(Context context, C0397f menu, View anchorView) {
        this(context, menu, anchorView, false);
    }

    public C0385k(Context context, C0397f menu, View anchorView, boolean overflowOnly) {
        this.f753a = context;
        this.f755d = LayoutInflater.from(context);
        this.f757f = menu;
        this.f760i = overflowOnly;
        Resources res = context.getResources();
        this.f758g = Math.max(res.getDisplayMetrics().widthPixels / 2, res.getDimensionPixelSize(C0357d.abc_config_prefDialogWidth));
        this.f759h = anchorView;
        menu.m1891a((C0384l) this);
    }

    public void m1773a(boolean forceShow) {
        this.f754c = forceShow;
    }

    public void m1769a() {
        if (!m1776b()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m1776b() {
        boolean addGlobalListener = false;
        this.f756e = new C0460f(this.f753a, null, C0355b.popupMenuStyle);
        this.f756e.m2191a((OnDismissListener) this);
        this.f756e.m2189a((OnItemClickListener) this);
        this.f762k = new C0408a(this, this.f757f);
        this.f756e.m2190a(this.f762k);
        this.f756e.m2192a(true);
        View anchor = this.f759h;
        if (anchor == null) {
            return false;
        }
        if (this.f761j == null) {
            addGlobalListener = true;
        }
        this.f761j = anchor.getViewTreeObserver();
        if (addGlobalListener) {
            this.f761j.addOnGlobalLayoutListener(this);
        }
        this.f756e.m2188a(anchor);
        this.f756e.m2200e(Math.min(m1765a(this.f762k), this.f758g));
        this.f756e.m2201f(2);
        this.f756e.m2195c();
        this.f756e.m2205h().setOnKeyListener(this);
        return true;
    }

    public void m1778c() {
        if (m1780d()) {
            this.f756e.m2197d();
        }
    }

    public void onDismiss() {
        this.f756e = null;
        this.f757f.close();
        if (this.f761j != null) {
            if (!this.f761j.isAlive()) {
                this.f761j = this.f759h.getViewTreeObserver();
            }
            this.f761j.removeGlobalOnLayoutListener(this);
            this.f761j = null;
        }
    }

    public boolean m1780d() {
        return this.f756e != null && this.f756e.m2202f();
    }

    public void onItemClick(AdapterView parent, View view, int position, long id) {
        C0408a adapter = this.f762k;
        adapter.f923b.m1896a(adapter.m1965a(position), 0);
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != 1 || keyCode != 82) {
            return false;
        }
        m1778c();
        return true;
    }

    private int m1765a(ListAdapter adapter) {
        int width = 0;
        View itemView = null;
        int itemType = 0;
        int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            if (this.f764m == null) {
                this.f764m = new FrameLayout(this.f753a);
            }
            itemView = adapter.getView(i, itemView, this.f764m);
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        return width;
    }

    public void onGlobalLayout() {
        if (m1780d()) {
            View anchor = this.f759h;
            if (anchor == null || !anchor.isShown()) {
                m1778c();
            } else if (m1780d()) {
                this.f756e.m2195c();
            }
        }
    }

    public void m1770a(Context context, C0397f menu) {
    }

    public void m1779d(boolean cleared) {
        if (this.f762k != null) {
            this.f762k.notifyDataSetChanged();
        }
    }

    public void m1772a(C0335a cb) {
        this.f763l = cb;
    }

    public boolean m1775a(C0411p subMenu) {
        if (!subMenu.hasVisibleItems()) {
            return false;
        }
        C0385k subPopup = new C0385k(this.f753a, subMenu, this.f759h, false);
        subPopup.m1772a(this.f763l);
        boolean preserveIconSpacing = false;
        int count = subMenu.size();
        for (int i = 0; i < count; i++) {
            MenuItem childItem = subMenu.getItem(i);
            if (childItem.isVisible() && childItem.getIcon() != null) {
                preserveIconSpacing = true;
                break;
            }
        }
        subPopup.m1773a(preserveIconSpacing);
        if (!subPopup.m1776b()) {
            return false;
        }
        if (this.f763l != null) {
            this.f763l.m1524b(subMenu);
        }
        return true;
    }

    public void m1771a(C0397f menu, boolean allMenusAreClosing) {
        if (menu == this.f757f) {
            m1778c();
            if (this.f763l != null) {
                this.f763l.m1523a(menu, allMenusAreClosing);
            }
        }
    }

    public boolean m1781g() {
        return false;
    }

    public boolean m1774a(C0397f menu, C0399h item) {
        return false;
    }

    public boolean m1777b(C0397f menu, C0399h item) {
        return false;
    }
}

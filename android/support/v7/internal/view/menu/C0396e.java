package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.view.menu.C0384l.C0335a;
import android.support.v7.internal.view.menu.C0391m.C0377a;
import android.support.v7.p014b.C0364a.C0360g;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.e */
public class C0396e implements C0384l, OnItemClickListener {
    Context f850a;
    LayoutInflater f851b;
    C0397f f852c;
    ExpandedMenuView f853d;
    int f854e;
    int f855f;
    C0395a f856g;
    private int f857h;
    private C0335a f858i;

    /* renamed from: android.support.v7.internal.view.menu.e.a */
    private class C0395a extends BaseAdapter {
        final /* synthetic */ C0396e f848a;
        private int f849b;

        public /* synthetic */ Object getItem(int x0) {
            return m1860a(x0);
        }

        public C0395a(C0396e c0396e) {
            this.f848a = c0396e;
            this.f849b = -1;
            m1861a();
        }

        public int getCount() {
            int count = this.f848a.f852c.m1915l().size() - this.f848a.f857h;
            return this.f849b < 0 ? count : count - 1;
        }

        public C0399h m1860a(int position) {
            ArrayList items = this.f848a.f852c.m1915l();
            position += this.f848a.f857h;
            if (this.f849b >= 0 && position >= this.f849b) {
                position++;
            }
            return (C0399h) items.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = this.f848a.f851b.inflate(this.f848a.f855f, parent, false);
            }
            ((C0377a) convertView).m1742a(m1860a(position), 0);
            return convertView;
        }

        void m1861a() {
            C0399h expandedItem = this.f848a.f852c.m1921r();
            if (expandedItem != null) {
                ArrayList items = this.f848a.f852c.m1915l();
                int count = items.size();
                for (int i = 0; i < count; i++) {
                    if (((C0399h) items.get(i)) == expandedItem) {
                        this.f849b = i;
                        return;
                    }
                }
            }
            this.f849b = -1;
        }

        public void notifyDataSetChanged() {
            m1861a();
            super.notifyDataSetChanged();
        }
    }

    public C0396e(int itemLayoutRes, int themeRes) {
        this.f855f = itemLayoutRes;
        this.f854e = themeRes;
    }

    public void m1865a(Context context, C0397f menu) {
        if (this.f854e != 0) {
            this.f850a = new ContextThemeWrapper(context, this.f854e);
            this.f851b = LayoutInflater.from(this.f850a);
        } else if (this.f850a != null) {
            this.f850a = context;
            if (this.f851b == null) {
                this.f851b = LayoutInflater.from(this.f850a);
            }
        }
        this.f852c = menu;
        if (this.f856g != null) {
            this.f856g.notifyDataSetChanged();
        }
    }

    public C0391m m1863a(ViewGroup root) {
        if (this.f856g == null) {
            this.f856g = new C0395a(this);
        }
        if (this.f856g.isEmpty()) {
            return null;
        }
        if (this.f853d == null) {
            this.f853d = (ExpandedMenuView) this.f851b.inflate(C0360g.abc_expanded_menu_layout, root, false);
            this.f853d.setAdapter(this.f856g);
            this.f853d.setOnItemClickListener(this);
        }
        return this.f853d;
    }

    public ListAdapter m1864a() {
        if (this.f856g == null) {
            this.f856g = new C0395a(this);
        }
        return this.f856g;
    }

    public void m1871d(boolean cleared) {
        if (this.f856g != null) {
            this.f856g.notifyDataSetChanged();
        }
    }

    public void m1867a(C0335a cb) {
        this.f858i = cb;
    }

    public boolean m1869a(C0411p subMenu) {
        if (!subMenu.hasVisibleItems()) {
            return false;
        }
        new C0380g(subMenu).m1753a(null);
        if (this.f858i != null) {
            this.f858i.m1524b(subMenu);
        }
        return true;
    }

    public void m1866a(C0397f menu, boolean allMenusAreClosing) {
        if (this.f858i != null) {
            this.f858i.m1523a(menu, allMenusAreClosing);
        }
    }

    public void onItemClick(AdapterView parent, View view, int position, long id) {
        this.f852c.m1896a(this.f856g.m1860a(position), 0);
    }

    public boolean m1872g() {
        return false;
    }

    public boolean m1868a(C0397f menu, C0399h item) {
        return false;
    }

    public boolean m1870b(C0397f menu, C0399h item) {
        return false;
    }
}

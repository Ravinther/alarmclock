package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.view.menu.C0384l.C0335a;
import android.support.v7.internal.view.menu.C0391m.C0377a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.b */
public abstract class C0388b implements C0384l {
    private C0335a f767a;
    private int f768b;
    protected Context f769c;
    protected Context f770d;
    protected C0397f f771e;
    protected LayoutInflater f772f;
    protected LayoutInflater f773g;
    protected C0391m f774h;
    private int f775i;
    private int f776j;

    public abstract void m1788a(C0399h c0399h, C0377a c0377a);

    public C0388b(Context context, int menuLayoutRes, int itemLayoutRes) {
        this.f769c = context;
        this.f772f = LayoutInflater.from(context);
        this.f768b = menuLayoutRes;
        this.f775i = itemLayoutRes;
    }

    public void m1786a(Context context, C0397f menu) {
        this.f770d = context;
        this.f773g = LayoutInflater.from(this.f770d);
        this.f771e = menu;
    }

    public C0391m m1784a(ViewGroup root) {
        if (this.f774h == null) {
            this.f774h = (C0391m) this.f772f.inflate(this.f768b, root, false);
            this.f774h.m1832a(this.f771e);
            m1798d(true);
        }
        return this.f774h;
    }

    public void m1798d(boolean cleared) {
        ViewGroup parent = this.f774h;
        if (parent != null) {
            int childIndex = 0;
            if (this.f771e != null) {
                this.f771e.m1913j();
                ArrayList visibleItems = this.f771e.m1912i();
                int itemCount = visibleItems.size();
                for (int i = 0; i < itemCount; i++) {
                    C0399h item = (C0399h) visibleItems.get(i);
                    if (m1791a(childIndex, item)) {
                        View convertView = parent.getChildAt(childIndex);
                        C0399h oldItem = convertView instanceof C0377a ? ((C0377a) convertView).getItemData() : null;
                        View itemView = m1785a(item, convertView, parent);
                        if (item != oldItem) {
                            itemView.setPressed(false);
                        }
                        if (itemView != convertView) {
                            m1790a(itemView, childIndex);
                        }
                        childIndex++;
                    }
                }
            }
            while (childIndex < parent.getChildCount()) {
                if (!m1794a(parent, childIndex)) {
                    childIndex++;
                }
            }
        }
    }

    protected void m1790a(View itemView, int childIndex) {
        ViewGroup currentParent = (ViewGroup) itemView.getParent();
        if (currentParent != null) {
            currentParent.removeView(itemView);
        }
        ((ViewGroup) this.f774h).addView(itemView, childIndex);
    }

    protected boolean m1794a(ViewGroup parent, int childIndex) {
        parent.removeViewAt(childIndex);
        return true;
    }

    public void m1789a(C0335a cb) {
        this.f767a = cb;
    }

    public C0377a m1795b(ViewGroup parent) {
        return (C0377a) this.f772f.inflate(this.f775i, parent, false);
    }

    public View m1785a(C0399h item, View convertView, ViewGroup parent) {
        C0377a itemView;
        if (convertView instanceof C0377a) {
            itemView = (C0377a) convertView;
        } else {
            itemView = m1795b(parent);
        }
        m1788a(item, itemView);
        return (View) itemView;
    }

    public boolean m1791a(int childIndex, C0399h item) {
        return true;
    }

    public void m1787a(C0397f menu, boolean allMenusAreClosing) {
        if (this.f767a != null) {
            this.f767a.m1523a(menu, allMenusAreClosing);
        }
    }

    public boolean m1793a(C0411p menu) {
        if (this.f767a != null) {
            return this.f767a.m1524b(menu);
        }
        return false;
    }

    public boolean m1799g() {
        return false;
    }

    public boolean m1792a(C0397f menu, C0399h item) {
        return false;
    }

    public boolean m1797b(C0397f menu, C0399h item) {
        return false;
    }

    public void m1796b(int id) {
        this.f776j = id;
    }
}

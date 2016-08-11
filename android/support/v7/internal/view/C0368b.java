package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.C0409n;
import android.support.v7.p013c.C0342a;
import android.support.v7.p013c.C0342a.C0332a;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* renamed from: android.support.v7.internal.view.b */
public class C0368b extends C0342a {
    final MenuInflater f696a;
    final ActionMode f697b;

    /* renamed from: android.support.v7.internal.view.b.a */
    public static class C0367a implements Callback {
        final C0332a f693a;
        final Context f694b;
        private C0368b f695c;

        public C0367a(Context context, C0332a supportCallback) {
            this.f694b = context;
            this.f693a = supportCallback;
        }

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return this.f693a.m1514a(m1714a(mode), C0409n.m1968a(menu));
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return this.f693a.m1516b(m1714a(mode), C0409n.m1968a(menu));
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return this.f693a.m1515a(m1714a(mode), C0409n.m1969a(item));
        }

        public void onDestroyActionMode(ActionMode mode) {
            this.f693a.m1513a(m1714a(mode));
        }

        public void m1716a(C0368b modeWrapper) {
            this.f695c = modeWrapper;
        }

        private C0342a m1714a(ActionMode mode) {
            if (this.f695c == null || this.f695c.f697b != mode) {
                return m1715a(this.f694b, mode);
            }
            return this.f695c;
        }

        protected C0368b m1715a(Context context, ActionMode mode) {
            return new C0368b(context, mode);
        }
    }

    public C0368b(Context context, ActionMode frameworkActionMode) {
        this.f697b = frameworkActionMode;
        this.f696a = new C0373d(context);
    }

    public void m1718a(CharSequence title) {
        this.f697b.setTitle(title);
    }

    public void m1721d() {
        this.f697b.invalidate();
    }

    public void m1720c() {
        this.f697b.finish();
    }

    public Menu m1719b() {
        return C0409n.m1968a(this.f697b.getMenu());
    }

    public MenuInflater m1717a() {
        return this.f696a;
    }
}

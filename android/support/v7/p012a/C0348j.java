package android.support.v7.p012a;

import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.support.v7.internal.widget.NativeActionModeAwareLayout.C0347a;
import android.support.v7.p012a.C0328a.C0322a;
import android.support.v7.p014b.C0364a.C0358e;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

/* renamed from: android.support.v7.a.j */
class C0348j extends C0345i implements C0347a {
    final NativeActionModeAwareLayout f679e;
    private ActionMode f680f;

    /* renamed from: android.support.v7.a.j.a */
    private class C0346a implements Callback {
        final /* synthetic */ C0348j f677a;
        private final Callback f678b;

        C0346a(C0348j c0348j, Callback callback) {
            this.f677a = c0348j;
            this.f678b = callback;
        }

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            boolean wrappedResult = this.f678b.onCreateActionMode(mode, menu);
            if (wrappedResult) {
                this.f677a.f680f = mode;
                this.f677a.m1642h();
            }
            return wrappedResult;
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return this.f678b.onPrepareActionMode(mode, menu);
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return this.f678b.onActionItemClicked(mode, item);
        }

        public void onDestroyActionMode(ActionMode mode) {
            this.f678b.onDestroyActionMode(mode);
            this.f677a.m1644i();
            this.f677a.f680f = null;
        }
    }

    public C0348j(C0329b activity, C0322a callback) {
        super(activity, callback);
        this.f679e = (NativeActionModeAwareLayout) activity.findViewById(C0358e.action_bar_root);
        if (this.f679e != null) {
            this.f679e.setActionModeForChildListener(this);
        }
    }

    public Callback m1650a(Callback callback) {
        return new C0346a(this, callback);
    }

    public void m1651d() {
        super.m1634d();
        if (this.f680f != null) {
            this.f680f.finish();
        }
    }

    public void m1652e() {
        super.m1636e();
        if (this.f680f != null) {
            this.f680f.finish();
        }
    }

    boolean m1653j() {
        return this.f680f == null && super.m1647j();
    }
}

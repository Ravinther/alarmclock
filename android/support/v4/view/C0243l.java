package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

/* renamed from: android.support.v4.view.l */
class C0243l {

    /* renamed from: android.support.v4.view.l.b */
    interface C0236b {
        boolean m1043a(MenuItem menuItem);

        boolean m1044b(MenuItem menuItem);
    }

    /* renamed from: android.support.v4.view.l.a */
    static class C0242a implements OnActionExpandListener {
        private C0236b f486a;

        public C0242a(C0236b wrapped) {
            this.f486a = wrapped;
        }

        public boolean onMenuItemActionExpand(MenuItem item) {
            return this.f486a.m1043a(item);
        }

        public boolean onMenuItemActionCollapse(MenuItem item) {
            return this.f486a.m1044b(item);
        }
    }

    public static boolean m1065a(MenuItem item) {
        return item.expandActionView();
    }

    public static boolean m1066b(MenuItem item) {
        return item.isActionViewExpanded();
    }

    public static MenuItem m1064a(MenuItem item, C0236b listener) {
        return item.setOnActionExpandListener(new C0242a(listener));
    }
}

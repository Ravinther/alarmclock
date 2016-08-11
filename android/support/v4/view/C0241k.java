package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.view.k */
class C0241k {
    public static void m1062a(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }

    public static MenuItem m1060a(MenuItem item, View view) {
        return item.setActionView(view);
    }

    public static MenuItem m1063b(MenuItem item, int resId) {
        return item.setActionView(resId);
    }

    public static View m1061a(MenuItem item) {
        return item.getActionView();
    }
}

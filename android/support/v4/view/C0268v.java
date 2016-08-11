package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

/* renamed from: android.support.v4.view.v */
class C0268v {
    public static boolean m1174a(View v, int direction) {
        return v.canScrollHorizontally(direction);
    }

    public static void m1173a(View v, Object delegate) {
        v.setAccessibilityDelegate((AccessibilityDelegate) delegate);
    }
}

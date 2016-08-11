package android.support.v4.view.p011a;

import android.view.accessibility.AccessibilityRecord;

/* renamed from: android.support.v4.view.a.i */
class C0207i {
    public static Object m962a() {
        return AccessibilityRecord.obtain();
    }

    public static void m963a(Object record, int fromIndex) {
        ((AccessibilityRecord) record).setFromIndex(fromIndex);
    }

    public static void m965b(Object record, int itemCount) {
        ((AccessibilityRecord) record).setItemCount(itemCount);
    }

    public static void m964a(Object record, boolean scrollable) {
        ((AccessibilityRecord) record).setScrollable(scrollable);
    }

    public static void m966c(Object record, int toIndex) {
        ((AccessibilityRecord) record).setToIndex(toIndex);
    }
}

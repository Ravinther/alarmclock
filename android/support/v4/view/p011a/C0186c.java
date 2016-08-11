package android.support.v4.view.p011a;

import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.a.c */
class C0186c {
    public static boolean m913a(Object info) {
        return ((AccessibilityNodeInfo) info).isVisibleToUser();
    }

    public static void m912a(Object info, boolean visibleToUser) {
        ((AccessibilityNodeInfo) info).setVisibleToUser(visibleToUser);
    }

    public static boolean m915b(Object info) {
        return ((AccessibilityNodeInfo) info).isAccessibilityFocused();
    }

    public static void m914b(Object info, boolean focused) {
        ((AccessibilityNodeInfo) info).setAccessibilityFocused(focused);
    }
}

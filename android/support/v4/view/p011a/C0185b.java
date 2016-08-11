package android.support.v4.view.p011a;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.a.b */
class C0185b {
    public static Object m877a(Object info) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) info);
    }

    public static void m878a(Object info, int action) {
        ((AccessibilityNodeInfo) info).addAction(action);
    }

    public static void m880a(Object info, View child) {
        ((AccessibilityNodeInfo) info).addChild(child);
    }

    public static int m883b(Object info) {
        return ((AccessibilityNodeInfo) info).getActions();
    }

    public static void m879a(Object info, Rect outBounds) {
        ((AccessibilityNodeInfo) info).getBoundsInParent(outBounds);
    }

    public static void m884b(Object info, Rect outBounds) {
        ((AccessibilityNodeInfo) info).getBoundsInScreen(outBounds);
    }

    public static CharSequence m888c(Object info) {
        return ((AccessibilityNodeInfo) info).getClassName();
    }

    public static CharSequence m893d(Object info) {
        return ((AccessibilityNodeInfo) info).getContentDescription();
    }

    public static CharSequence m896e(Object info) {
        return ((AccessibilityNodeInfo) info).getPackageName();
    }

    public static CharSequence m898f(Object info) {
        return ((AccessibilityNodeInfo) info).getText();
    }

    public static boolean m901g(Object info) {
        return ((AccessibilityNodeInfo) info).isCheckable();
    }

    public static boolean m902h(Object info) {
        return ((AccessibilityNodeInfo) info).isChecked();
    }

    public static boolean m903i(Object info) {
        return ((AccessibilityNodeInfo) info).isClickable();
    }

    public static boolean m904j(Object info) {
        return ((AccessibilityNodeInfo) info).isEnabled();
    }

    public static boolean m905k(Object info) {
        return ((AccessibilityNodeInfo) info).isFocusable();
    }

    public static boolean m906l(Object info) {
        return ((AccessibilityNodeInfo) info).isFocused();
    }

    public static boolean m907m(Object info) {
        return ((AccessibilityNodeInfo) info).isLongClickable();
    }

    public static boolean m908n(Object info) {
        return ((AccessibilityNodeInfo) info).isPassword();
    }

    public static boolean m909o(Object info) {
        return ((AccessibilityNodeInfo) info).isScrollable();
    }

    public static boolean m910p(Object info) {
        return ((AccessibilityNodeInfo) info).isSelected();
    }

    public static void m889c(Object info, Rect bounds) {
        ((AccessibilityNodeInfo) info).setBoundsInParent(bounds);
    }

    public static void m894d(Object info, Rect bounds) {
        ((AccessibilityNodeInfo) info).setBoundsInScreen(bounds);
    }

    public static void m881a(Object info, CharSequence className) {
        ((AccessibilityNodeInfo) info).setClassName(className);
    }

    public static void m882a(Object info, boolean clickable) {
        ((AccessibilityNodeInfo) info).setClickable(clickable);
    }

    public static void m886b(Object info, CharSequence contentDescription) {
        ((AccessibilityNodeInfo) info).setContentDescription(contentDescription);
    }

    public static void m887b(Object info, boolean enabled) {
        ((AccessibilityNodeInfo) info).setEnabled(enabled);
    }

    public static void m892c(Object info, boolean focusable) {
        ((AccessibilityNodeInfo) info).setFocusable(focusable);
    }

    public static void m895d(Object info, boolean focused) {
        ((AccessibilityNodeInfo) info).setFocused(focused);
    }

    public static void m897e(Object info, boolean longClickable) {
        ((AccessibilityNodeInfo) info).setLongClickable(longClickable);
    }

    public static void m891c(Object info, CharSequence packageName) {
        ((AccessibilityNodeInfo) info).setPackageName(packageName);
    }

    public static void m885b(Object info, View parent) {
        ((AccessibilityNodeInfo) info).setParent(parent);
    }

    public static void m899f(Object info, boolean scrollable) {
        ((AccessibilityNodeInfo) info).setScrollable(scrollable);
    }

    public static void m900g(Object info, boolean selected) {
        ((AccessibilityNodeInfo) info).setSelected(selected);
    }

    public static void m890c(Object info, View source) {
        ((AccessibilityNodeInfo) info).setSource(source);
    }

    public static void m911q(Object info) {
        ((AccessibilityNodeInfo) info).recycle();
    }
}

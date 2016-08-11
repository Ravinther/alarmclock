package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.w */
class C0269w {
    public static void m1175a(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m1177a(View view, int left, int top, int right, int bottom) {
        view.postInvalidate(left, top, right, bottom);
    }

    public static void m1178a(View view, Runnable action) {
        view.postOnAnimation(action);
    }

    public static int m1179b(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m1176a(View view, int mode) {
        view.setImportantForAccessibility(mode);
    }

    public static ViewParent m1180c(View view) {
        return view.getParentForAccessibility();
    }

    public static boolean m1181d(View view) {
        return view.getFitsSystemWindows();
    }
}

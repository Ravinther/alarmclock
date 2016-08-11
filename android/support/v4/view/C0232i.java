package android.support.v4.view;

import android.view.KeyEvent;

/* renamed from: android.support.v4.view.i */
class C0232i {
    public static int m1019a(int metaState) {
        return KeyEvent.normalizeMetaState(metaState);
    }

    public static boolean m1020a(int metaState, int modifiers) {
        return KeyEvent.metaStateHasModifiers(metaState, modifiers);
    }

    public static boolean m1021b(int metaState) {
        return KeyEvent.metaStateHasNoModifiers(metaState);
    }
}

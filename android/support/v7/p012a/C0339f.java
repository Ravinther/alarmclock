package android.support.v7.p012a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.internal.view.C0368b;
import android.support.v7.internal.view.C0368b.C0367a;
import android.support.v7.internal.view.menu.C0409n;
import android.support.v7.p013c.C0342a;
import android.support.v7.p013c.C0342a.C0332a;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v7.a.f */
class C0339f extends C0330c {
    Menu f637d;

    /* renamed from: android.support.v7.a.f.a */
    class C0338a implements Callback {
        final Callback f635a;
        final /* synthetic */ C0339f f636b;

        public C0338a(C0339f c0339f, Callback wrapped) {
            this.f636b = c0339f;
            this.f635a = wrapped;
        }

        public boolean dispatchKeyEvent(KeyEvent event) {
            return this.f635a.dispatchKeyEvent(event);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent event) {
            return this.f635a.dispatchKeyShortcutEvent(event);
        }

        public boolean dispatchTouchEvent(MotionEvent event) {
            return this.f635a.dispatchTouchEvent(event);
        }

        public boolean dispatchTrackballEvent(MotionEvent event) {
            return this.f635a.dispatchTrackballEvent(event);
        }

        public boolean dispatchGenericMotionEvent(MotionEvent event) {
            return this.f635a.dispatchGenericMotionEvent(event);
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            return this.f635a.dispatchPopulateAccessibilityEvent(event);
        }

        public View onCreatePanelView(int featureId) {
            return this.f635a.onCreatePanelView(featureId);
        }

        public boolean onCreatePanelMenu(int featureId, Menu menu) {
            return this.f635a.onCreatePanelMenu(featureId, menu);
        }

        public boolean onPreparePanel(int featureId, View view, Menu menu) {
            return this.f635a.onPreparePanel(featureId, view, menu);
        }

        public boolean onMenuOpened(int featureId, Menu menu) {
            return this.f635a.onMenuOpened(featureId, menu);
        }

        public boolean onMenuItemSelected(int featureId, MenuItem item) {
            return this.f635a.onMenuItemSelected(featureId, item);
        }

        public void onWindowAttributesChanged(LayoutParams attrs) {
            this.f635a.onWindowAttributesChanged(attrs);
        }

        public void onContentChanged() {
            this.f635a.onContentChanged();
        }

        public void onWindowFocusChanged(boolean hasFocus) {
            this.f635a.onWindowFocusChanged(hasFocus);
        }

        public void onAttachedToWindow() {
            this.f635a.onAttachedToWindow();
        }

        public void onDetachedFromWindow() {
            this.f635a.onDetachedFromWindow();
        }

        public void onPanelClosed(int featureId, Menu menu) {
            this.f635a.onPanelClosed(featureId, menu);
        }

        public boolean onSearchRequested() {
            return this.f635a.onSearchRequested();
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.f635a.onWindowStartingActionMode(callback);
        }

        public void onActionModeStarted(ActionMode mode) {
            this.f635a.onActionModeStarted(mode);
            this.f636b.m1562a(mode);
        }

        public void onActionModeFinished(ActionMode mode) {
            this.f635a.onActionModeFinished(mode);
            this.f636b.m1570b(mode);
        }
    }

    C0339f(C0329b activity) {
        super(activity);
    }

    public C0328a m1554a() {
        return new C0351k(this.a, this.a);
    }

    public void m1561a(Bundle savedInstanceState) {
        if ("splitActionBarWhenNarrow".equals(m1511i())) {
            this.a.getWindow().setUiOptions(1, 1);
        }
        super.m1494a(savedInstanceState);
        if (this.b) {
            this.a.requestWindowFeature(8);
        }
        if (this.c) {
            this.a.requestWindowFeature(9);
        }
        Window w = this.a.getWindow();
        w.setCallback(m1558a(w.getCallback()));
    }

    Callback m1558a(Callback cb) {
        return new C0338a(this, cb);
    }

    public void m1560a(Configuration newConfig) {
    }

    public void m1572d() {
    }

    public void m1573e() {
    }

    public void m1563a(View v) {
        this.a.m1473a(v);
    }

    public void m1559a(int resId) {
        this.a.m1470a(resId);
    }

    public void m1564a(View v, ViewGroup.LayoutParams lp) {
        this.a.m1474a(v, lp);
    }

    public void m1571b(View v, ViewGroup.LayoutParams lp) {
        this.a.m1483b(v, lp);
    }

    public void m1576h() {
        this.a.m1488j();
    }

    public View m1569b(int featureId) {
        return null;
    }

    public boolean m1566a(int featureId, Menu menu) {
        if (featureId != 0 && featureId != 8) {
            return this.a.m1475a(featureId, menu);
        }
        if (this.f637d == null) {
            this.f637d = C0409n.m1968a(menu);
        }
        return this.a.m1475a(featureId, this.f637d);
    }

    public boolean m1568a(int featureId, View view, Menu menu) {
        if (featureId == 0 || featureId == 8) {
            return this.a.m1477a(featureId, view, this.f637d);
        }
        return this.a.m1477a(featureId, view, menu);
    }

    public boolean m1567a(int featureId, MenuItem item) {
        if (featureId == 0) {
            item = C0409n.m1969a(item);
        }
        return this.a.m1476a(featureId, item);
    }

    public void m1565a(CharSequence title) {
    }

    public C0342a m1555a(C0332a callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        Context context = m1512j();
        C0367a wrappedCallback = m1556a(context, callback);
        ActionMode frameworkMode = this.a.startActionMode(wrappedCallback);
        if (frameworkMode == null) {
            return null;
        }
        C0368b wrappedMode = m1557a(context, frameworkMode);
        wrappedCallback.m1716a(wrappedMode);
        return wrappedMode;
    }

    public void m1562a(ActionMode mode) {
        this.a.m1472a(m1557a(m1512j(), mode));
    }

    public void m1570b(ActionMode mode) {
        this.a.m1482b(m1557a(m1512j(), mode));
    }

    public void m1574f() {
        this.f637d = null;
    }

    public boolean m1575g() {
        return false;
    }

    C0367a m1556a(Context context, C0332a callback) {
        return new C0367a(context, callback);
    }

    C0368b m1557a(Context context, ActionMode frameworkMode) {
        return new C0368b(context, frameworkMode);
    }
}

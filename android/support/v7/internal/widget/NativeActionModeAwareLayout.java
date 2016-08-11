package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;
import android.widget.LinearLayout;

public class NativeActionModeAwareLayout extends LinearLayout {
    private C0347a f1052a;

    /* renamed from: android.support.v7.internal.widget.NativeActionModeAwareLayout.a */
    public interface C0347a {
        Callback m1648a(Callback callback);
    }

    public NativeActionModeAwareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setActionModeForChildListener(C0347a listener) {
        this.f1052a = listener;
    }

    public ActionMode startActionModeForChild(View originalView, Callback callback) {
        if (this.f1052a != null) {
            callback = this.f1052a.m1648a(callback);
        }
        return super.startActionModeForChild(originalView, callback);
    }
}

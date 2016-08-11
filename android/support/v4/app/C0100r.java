package android.support.v4.app;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

/* renamed from: android.support.v4.app.r */
class C0100r extends FrameLayout {
    static ViewGroup m445a(View child) {
        C0100r wrapper = new C0100r(child.getContext());
        LayoutParams childParams = child.getLayoutParams();
        if (childParams != null) {
            wrapper.setLayoutParams(childParams);
        }
        child.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        wrapper.addView(child);
        return wrapper;
    }

    public C0100r(Context context) {
        super(context);
    }

    protected void dispatchSaveInstanceState(SparseArray container) {
        dispatchFreezeSelfOnly(container);
    }

    protected void dispatchRestoreInstanceState(SparseArray container) {
        dispatchThawSelfOnly(container);
    }
}

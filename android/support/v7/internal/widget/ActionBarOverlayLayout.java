package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.p012a.C0328a;
import android.support.v7.p014b.C0364a.C0355b;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ActionBarOverlayLayout extends FrameLayout {
    static final int[] f994a;
    private int f995b;
    private C0328a f996c;
    private final Rect f997d;

    static {
        f994a = new int[]{C0355b.actionBarSize};
    }

    public ActionBarOverlayLayout(Context context) {
        super(context);
        this.f997d = new Rect(0, 0, 0, 0);
        m2041a(context);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f997d = new Rect(0, 0, 0, 0);
        m2041a(context);
    }

    private void m2041a(Context context) {
        TypedArray ta = getContext().getTheme().obtainStyledAttributes(f994a);
        this.f995b = ta.getDimensionPixelSize(0, 0);
        ta.recycle();
    }

    public void setActionBar(C0328a impl) {
        this.f996c = impl;
    }
}

package com.anglelabs.alarmclock.redesign.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.views.C0896b.C0875a;

public class DateListView extends C0874a implements C0875a {
    private Drawable f2519b;
    private int f2520c;

    public DateListView(Context context) {
        super(context);
        m4083c();
    }

    public DateListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m4083c();
    }

    public DateListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m4083c();
    }

    private void m4083c() {
        if (this.f2519b == null) {
            this.f2519b = getContext().getResources().getDrawable(R.drawable.date_items_seperator);
        }
        setOnScrollListener(new C0896b(this, 0));
    }

    public void setSelectionFromTop(int position, int y) {
        if (m4081b() && position < 0) {
            position += this.a.m4132a();
        } else if (m4080a() && position > this.a.getCount()) {
            position %= this.a.m4132a();
        }
        super.setSelectionFromTop(position, y);
    }

    public void setSelection(int position) {
        setSelectionFromTop(position - 1, 0);
    }

    public void setSeparatorResourceID(int resourceId) {
        this.f2519b = getContext().getResources().getDrawable(resourceId);
    }

    public void setInitialSelection(int position) {
        setSelection(position);
    }

    private void m4082a(Canvas canvas) {
        View childView;
        int size = getChildCount();
        int offset = 0;
        int i = 0;
        while (i < size) {
            if (this.f2520c == i) {
                i++;
                break;
            }
            childView = getChildAt(i);
            if (childView != null) {
                offset += childView.getHeight();
            }
            i++;
        }
        this.f2519b.setBounds(0, offset, getWidth(), offset + 2);
        this.f2519b.draw(canvas);
        childView = getChildAt(i);
        if (childView != null) {
            offset += childView.getHeight();
        }
        this.f2519b.setBounds(0, offset, getWidth(), offset + 2);
        this.f2519b.draw(canvas);
    }

    public void setItemSelectedIndex(int itemSelectedIndex) {
        this.f2520c = itemSelectedIndex;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getAdapter() != null && getAdapter().getCount() > 0) {
            m4082a(canvas);
        }
    }

    public ListView getListView() {
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCurrentItem() {
        /*
        r4 = this;
        r1 = 0;
        r3 = r4.getCount();
        if (r3 != 0) goto L_0x0009;
    L_0x0007:
        r3 = 0;
    L_0x0008:
        return r3;
    L_0x0009:
        r0 = r4.getChildAt(r1);
        if (r0 == 0) goto L_0x001f;
    L_0x000f:
        r3 = r0.getTop();
        if (r3 >= 0) goto L_0x001f;
    L_0x0015:
        r3 = r0.getBottom();
        if (r3 < 0) goto L_0x001f;
    L_0x001b:
        r1 = r1 + 1;
        if (r0 != 0) goto L_0x0009;
    L_0x001f:
        r3 = r4.getFirstVisiblePosition();
        r2 = r3 + r1;
        r3 = r4.f2520c;
        r3 = r3 + r2;
        r3 = r4.getItemAtPosition(r3);
        r3 = (java.lang.String) r3;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anglelabs.alarmclock.redesign.views.DateListView.getCurrentItem():java.lang.String");
    }
}

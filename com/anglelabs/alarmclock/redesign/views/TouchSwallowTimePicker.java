package com.anglelabs.alarmclock.redesign.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.TimePicker;

public class TouchSwallowTimePicker extends TimePicker {
    public TouchSwallowTimePicker(Context context) {
        super(context);
    }

    public TouchSwallowTimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchSwallowTimePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getActionMasked() == 0) {
            ViewParent p = getParent();
            if (p != null) {
                p.requestDisallowInterceptTouchEvent(true);
            }
        }
        return false;
    }
}

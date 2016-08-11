package com.anglelabs.alarmclock.preference.base;

import android.content.Context;
import android.preference.DialogPreference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.utils.C0810h;

/* renamed from: com.anglelabs.alarmclock.preference.base.a */
public class C0507a extends DialogPreference {
    public C0507a(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m2422b();
    }

    public C0507a(Context context, AttributeSet attrs) {
        super(context, attrs);
        m2422b();
    }

    void m2422b() {
        SpannableString span = new SpannableString(getTitle());
        span.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.dialog_holo_default_title_color)), 0, span.length(), 0);
        setDialogTitle(span);
    }

    protected TextView m2423c() {
        TextView t = new TextView(getContext());
        t.setTextColor(C0810h.f2130d ? -16777216 : -1);
        return t;
    }
}

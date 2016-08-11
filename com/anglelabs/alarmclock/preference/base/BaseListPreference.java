package com.anglelabs.alarmclock.preference.base;

import android.content.Context;
import android.preference.ListPreference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import com.alarmclock.xtreme.free.R;

public class BaseListPreference extends ListPreference {
    public BaseListPreference(Context context) {
        super(context);
        m2401b();
    }

    public BaseListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        m2401b();
    }

    void m2401b() {
        SpannableString span = new SpannableString(getTitle());
        span.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.dialog_holo_default_title_color)), 0, span.length(), 0);
        setDialogTitle(span);
    }
}

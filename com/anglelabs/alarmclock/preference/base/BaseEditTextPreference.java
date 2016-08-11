package com.anglelabs.alarmclock.preference.base;

import android.content.Context;
import android.preference.EditTextPreference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.alarmclock.xtreme.free.R;

public class BaseEditTextPreference extends EditTextPreference {
    public BaseEditTextPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m2432a();
    }

    public BaseEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        m2432a();
    }

    public BaseEditTextPreference(Context context) {
        super(context);
        m2432a();
    }

    void m2432a() {
        SpannableString span = new SpannableString(getTitle());
        span.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.dialog_holo_default_title_color)), 0, span.length(), 0);
        setDialogTitle(span);
    }

    protected void onAddEditTextToDialogView(View dialogView, EditText editText) {
        editText.setTextColor(-16777216);
        super.onAddEditTextToDialogView(dialogView, editText);
    }
}

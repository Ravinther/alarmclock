package com.anglelabs.alarmclock.redesign.activities.p019a;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.preference.PreferenceActivity;
import android.widget.TimePicker;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.preference.AlarmTimeAndDaysPreference;
import com.anglelabs.alarmclock.redesign.views.DigitalClock;
import com.anglelabs.alarmclock.redesign.views.WeekDaysCheckGroup;

/* renamed from: com.anglelabs.alarmclock.redesign.activities.a.a */
public class C0592a {
    public C0503b m2749a(PreferenceActivity activity, OnTimeSetListener onTimeSetListener) {
        boolean isLandscape;
        boolean isSmallDevice;
        if (activity.findViewById(R.id.time_display_container) != null) {
            isLandscape = true;
        } else {
            isLandscape = false;
        }
        if (activity.findViewById(R.id.clock_layout) != null) {
            isSmallDevice = true;
        } else {
            isSmallDevice = false;
        }
        if (activity == null) {
            throw new NullPointerException("context is null");
        } else if (!isLandscape) {
            C0592a.m2748a((AlarmTimeAndDaysPreference) activity.findPreference("alarm_set_time"));
            return new C0595e((AlarmTimeAndDaysPreference) activity.findPreference("alarm_set_time"));
        } else if (isSmallDevice) {
            DigitalClock digitalClock = (DigitalClock) activity.findViewById(R.id.clock_layout);
            C0592a.m2748a(digitalClock, onTimeSetListener, (WeekDaysCheckGroup) activity.findViewById(R.id.daysGroup));
            return new C0593c(activity, digitalClock, onTimeSetListener, (WeekDaysCheckGroup) activity.findViewById(R.id.daysGroup));
        } else {
            C0592a.m2748a((TimePicker) activity.findViewById(R.id.time_picker), (WeekDaysCheckGroup) activity.findViewById(R.id.daysGroup));
            return new C0594d(activity, (TimePicker) activity.findViewById(R.id.time_picker), (WeekDaysCheckGroup) activity.findViewById(R.id.daysGroup));
        }
    }

    private static void m2748a(Object... v) {
        int count = 0;
        for (Object o : v) {
            if (o == null) {
                throw new NullPointerException("view is empty at index " + count);
            }
            count++;
        }
    }
}

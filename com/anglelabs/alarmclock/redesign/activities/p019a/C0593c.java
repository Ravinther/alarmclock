package com.anglelabs.alarmclock.redesign.activities.p019a;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import com.anglelabs.alarmclock.redesign.model.C0773a;
import com.anglelabs.alarmclock.redesign.views.DigitalClock;
import com.anglelabs.alarmclock.redesign.views.WeekDaysCheckGroup;
import java.util.Calendar;

/* renamed from: com.anglelabs.alarmclock.redesign.activities.a.c */
public class C0593c implements C0503b {
    private final DigitalClock f1636a;
    private final WeekDaysCheckGroup f1637b;

    public C0593c(Context context, DigitalClock clock, OnTimeSetListener onTimeSetListener, WeekDaysCheckGroup weekDaysCheckGroup) {
        this.f1636a = clock;
        this.f1637b = weekDaysCheckGroup;
        this.f1636a.m4094a(context, onTimeSetListener);
    }

    public void m2751a(int hour, int minute) {
        this.f1636a.m4093a(hour, minute);
    }

    public void m2752a(C0773a days) {
        this.f1637b.setEnabledDays(days);
    }

    public Calendar m2750a() {
        return this.f1636a.getClockCurrentTime();
    }

    public C0773a m2753b() {
        return this.f1637b.getDaysOfWeek();
    }
}

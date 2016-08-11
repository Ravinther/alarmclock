package com.anglelabs.alarmclock.redesign.activities.p019a;

import android.content.Context;
import android.widget.TimePicker;
import com.anglelabs.alarmclock.redesign.model.C0773a;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import com.anglelabs.alarmclock.redesign.views.WeekDaysCheckGroup;
import java.util.Calendar;

/* renamed from: com.anglelabs.alarmclock.redesign.activities.a.d */
public class C0594d implements C0503b {
    private final TimePicker f1638a;
    private final WeekDaysCheckGroup f1639b;
    private final Context f1640c;

    public C0594d(Context context, TimePicker timePicker, WeekDaysCheckGroup weekDaysCheckGroup) {
        this.f1638a = timePicker;
        this.f1639b = weekDaysCheckGroup;
        this.f1640c = context;
    }

    public void m2755a(int hour, int minute) {
        this.f1638a.setIs24HourView(Boolean.valueOf(C0860w.m4038b(this.f1640c)));
        this.f1638a.setCurrentHour(Integer.valueOf(hour));
        this.f1638a.setCurrentMinute(Integer.valueOf(minute));
    }

    public void m2756a(C0773a days) {
        this.f1639b.setEnabledDays(days);
    }

    public Calendar m2754a() {
        this.f1638a.clearFocus();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, this.f1638a.getCurrentHour().intValue());
        calendar.set(12, this.f1638a.getCurrentMinute().intValue());
        return calendar;
    }

    public C0773a m2757b() {
        return this.f1639b.getDaysOfWeek();
    }
}

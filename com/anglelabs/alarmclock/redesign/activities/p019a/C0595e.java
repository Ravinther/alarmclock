package com.anglelabs.alarmclock.redesign.activities.p019a;

import com.anglelabs.alarmclock.preference.AlarmTimeAndDaysPreference;
import com.anglelabs.alarmclock.redesign.model.C0773a;
import java.util.Calendar;

/* renamed from: com.anglelabs.alarmclock.redesign.activities.a.e */
public class C0595e implements C0503b {
    private final AlarmTimeAndDaysPreference f1641a;

    public C0595e(AlarmTimeAndDaysPreference preference) {
        this.f1641a = preference;
    }

    public void m2759a(int hour, int minute) {
        this.f1641a.m2392a(hour, minute);
    }

    public void m2760a(C0773a days) {
        this.f1641a.m2393a(days);
    }

    public Calendar m2758a() {
        return this.f1641a.m2391a();
    }

    public C0773a m2761b() {
        return this.f1641a.m2394b();
    }
}

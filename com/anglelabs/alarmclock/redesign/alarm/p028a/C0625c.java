package com.anglelabs.alarmclock.redesign.alarm.p028a;

import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0616b;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0617d;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p031c.C0621a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p031c.C0624b;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.c */
public class C0625c {
    public static C0616b m2883a(RedesignAlarm alarm, C0617d callback, boolean isForDismiss) {
        if (isForDismiss && alarm.f2007h == 4) {
            return new C0621a(callback, true);
        }
        return new C0624b(alarm, callback, isForDismiss ? alarm.f2024y : alarm.f2025z, isForDismiss);
    }
}

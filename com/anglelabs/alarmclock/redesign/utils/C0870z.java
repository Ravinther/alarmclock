package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.model.C0773a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.views.DigitalClock;
import com.avg.toolkit.ITKSvc;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.z */
public class C0870z {

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.z.a */
    public static class C0869a {
        public long f2502a;
        public long f2503b;
        public long f2504c;
        public long f2505d;

        public C0869a(long timeInMillis) {
            long timeDiff = timeInMillis / 1000;
            this.f2503b = timeDiff % 60;
            this.f2504c = (timeDiff / 60) % 60;
            this.f2505d = timeDiff / 3600;
            this.f2502a = (timeInMillis / 10) % 100;
        }
    }

    public static void m4065a(Context context, RedesignAlarm alarm) {
        if (context != null && alarm != null) {
            if (!alarm.f2005f.m3661c() || !C0860w.m4036a(ac.m3774b(context))) {
                if (alarm.f1990C) {
                    C0870z.m4067b(context, alarm);
                } else {
                    C0858u.m4026a(context, C0870z.m4059a(context, alarm.f2009j, alarm.f2023x, alarm.f2005f));
                }
            }
        }
    }

    private static void m4067b(Context context, RedesignAlarm alarm) {
        if (context != null) {
            C0858u.m4026a(context, context.getString(R.string.skipped_alarm_set_toast, new Object[]{C0870z.m4060a(context, alarm.m3619e(context))}));
        }
    }

    public static String m4061a(Context context, Calendar calendar) {
        return new SimpleDateFormat(DigitalClock.m4089a(context), Locale.US).format(calendar.getTime());
    }

    public static C0869a m4057a(long timeInMillis) {
        return new C0869a(timeInMillis);
    }

    public static String m4058a(long timeInMillis, boolean hundredths) {
        return C0870z.m4064a(C0870z.m4057a(timeInMillis), hundredths);
    }

    public static String m4063a(C0869a time) {
        return C0870z.m4064a(time, false);
    }

    public static String m4064a(C0869a time, boolean showHundredths) {
        StringBuilder timeString = new StringBuilder();
        if (time.f2505d < 10) {
            timeString.append(ITKSvc.CODEREVISION).append(time.f2505d);
        } else {
            timeString.append(time.f2505d);
        }
        if (time.f2504c < 10) {
            timeString.append(":0").append(time.f2504c);
        } else {
            timeString.append(":").append(time.f2504c);
        }
        if (time.f2503b < 10) {
            timeString.append(":0").append(time.f2503b);
        } else {
            timeString.append(":").append(time.f2503b);
        }
        if (showHundredths) {
            if (time.f2502a >= 10) {
                timeString.append(".").append(time.f2502a);
            } else if (time.f2502a <= 0 || time.f2502a >= 10) {
                timeString.append(".00");
            } else {
                timeString.append(".0").append(time.f2502a);
            }
        }
        return timeString.toString();
    }

    public static String m4060a(Context context, long timeInMillis) {
        long delta = timeInMillis - System.currentTimeMillis();
        long hours = delta / 3600000;
        long minutes = ((delta / 60000) % 60) + 1;
        if (minutes == 60) {
            hours++;
            minutes = 0;
        }
        long days = hours / 24;
        hours %= 24;
        String daySeq = days == 0 ? "" : days == 1 ? context.getString(R.string.day) : context.getString(R.string.days, new Object[]{Long.toString(days)});
        String minSeq = minutes == 0 ? "" : minutes == 1 ? context.getString(R.string.minute) : context.getString(R.string.minutes, new Object[]{Long.toString(minutes)});
        String hourSeq = hours == 0 ? "" : hours == 1 ? context.getString(R.string.hour) : context.getString(R.string.hours, new Object[]{Long.toString(hours)});
        return String.format(context.getResources().getStringArray(R.array.alarm_set)[(((days > 0 ? 1 : (days == 0 ? 0 : -1)) > 0 ? 1 : 0) | ((hours > 0 ? 1 : (hours == 0 ? 0 : -1)) > 0 ? 2 : 0)) | ((minutes > 0 ? 1 : (minutes == 0 ? 0 : -1)) > 0 ? 4 : 0)], new Object[]{daySeq, hourSeq, minSeq});
    }

    public static String m4062a(Context context, Calendar c, boolean abbrivateDays) {
        StringBuilder patternBuilder = new StringBuilder();
        Locale appLocale = C0810h.m3837b(context);
        if (abbrivateDays) {
            patternBuilder.append("E ").append(DigitalClock.m4089a(context));
            return new SimpleDateFormat(patternBuilder.toString(), appLocale).format(c.getTime());
        }
        patternBuilder.append(new SimpleDateFormat("EEEE", appLocale).format(c.getTime())).append(", ");
        patternBuilder.append(new SimpleDateFormat(DigitalClock.m4089a(context), appLocale).format(c.getTime()));
        return patternBuilder.toString();
    }

    public static String m4066b(Context context, long elapsedTime) {
        String string;
        C0869a unit = new C0869a(elapsedTime);
        StringBuilder builder = new StringBuilder();
        if (unit.f2505d > 0) {
            if (unit.f2505d == 1) {
                string = context.getString(R.string.hour);
            } else {
                string = context.getString(R.string.hours, new Object[]{Long.toString(unit.f2505d)});
            }
            builder.append(string).append(", ");
        }
        if (unit.f2504c == 1) {
            string = context.getString(R.string.minute);
        } else {
            string = context.getString(R.string.minutes, new Object[]{Long.toString(unit.f2504c)});
        }
        builder.append(string).append(", ");
        if (unit.f2503b == 1) {
            string = context.getString(R.string.second);
        } else {
            string = context.getString(R.string.seconds, new Object[]{Long.toString(unit.f2503b)});
        }
        builder.append(string).append(" ");
        return builder.toString();
    }

    public static String m4059a(Context context, int hour, int minute, C0773a daysOfWeek) {
        return new StringBuilder(context.getString(R.string.alarm_set_start)).append(" ").append(C0870z.m4060a(context, C0694b.m3136a(hour, minute, daysOfWeek).getTimeInMillis())).append(" ").append(context.getString(R.string.alarm_set_end)).toString();
    }

    public static String m4068c(Context context, long timeLeft) {
        if (timeLeft < 0) {
            return context.getResources().getString(R.string.timer_times_up);
        }
        C0869a unit = C0870z.m4057a(timeLeft);
        if (unit.f2505d > 99) {
            unit.f2505d = 0;
        }
        if (unit.f2503b == 0 && unit.f2505d == 0 && unit.f2504c == 0) {
            return context.getResources().getString(R.string.timer_times_up);
        }
        String secSeq = unit.f2503b == 0 ? "" : unit.f2503b == 1 ? context.getString(R.string.second) : context.getString(R.string.seconds, new Object[]{Long.toString(unit.f2503b)});
        String hourSeq = unit.f2505d == 0 ? "" : unit.f2505d == 1 ? context.getString(R.string.hour) : context.getString(R.string.hours, new Object[]{Long.toString(unit.f2505d)});
        String minSeq = unit.f2504c == 0 ? "" : unit.f2504c == 1 ? context.getString(R.string.minute) : context.getString(R.string.minutes, new Object[]{Long.toString(unit.f2504c)});
        return String.format(context.getResources().getStringArray(R.array.timer_notifications)[((unit.f2505d > 0 ? 1 : (unit.f2505d == 0 ? 0 : -1)) > 0 ? 1 : 0) | ((unit.f2504c > 0 ? 1 : (unit.f2504c == 0 ? 0 : -1)) > 0 ? 2 : 0)], new Object[]{hourSeq, minSeq, secSeq});
    }
}
